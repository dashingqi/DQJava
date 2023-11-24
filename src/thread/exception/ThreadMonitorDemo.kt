package thread.exception

import java.lang.RuntimeException
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import kotlin.jvm.Throws

class ThreadMonitorDemo {

    private val channel: BlockingQueue<String> = ArrayBlockingQueue<String>(1000)

    @Volatile
    private var inited: Boolean = false

    private var threadIndex = 0

    @Synchronized
    fun initMethod() {
        if (inited) return

        println("init...")

        val workThread = WorkThread()
        workThread.name = "Worker0-${threadIndex++}"
        workThread.uncaughtExceptionHandler = ThreadMonitor()
        workThread.start()
        inited = true
    }

    @Throws(InterruptedException::class)
    fun service(message: String) {
        channel.put(message)
    }

    inner class ThreadMonitor : Thread.UncaughtExceptionHandler {
        override fun uncaughtException(thread: Thread, p1: Throwable) {
            println("Current thread is ${thread.name} , it is still alive ${thread.isAlive}")
            p1.printStackTrace()
            val name = thread.name
            inited = false
            println("restart thread")
            initMethod()
        }
    }

    inner class WorkThread : Thread() {
        override fun run() {
            println("Do Something important ...")
            var msg = ""
            try {
                while (true) {
                    msg = channel.take()
                    process(msg)
                }
            } catch (exception: InterruptedException) {

            }
        }

        private fun process(message: String) {
            println("message is ----> $message")
            if ((Math.random() * 100) > 2) {
                throw RuntimeException("Exception Test")
            }
        }
    }
}