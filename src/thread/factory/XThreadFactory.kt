package thread.factory

import java.lang.Thread.UncaughtExceptionHandler
import java.util.concurrent.ThreadFactory

class XThreadFactory : ThreadFactory {

    private var ueh: UncaughtExceptionHandler? = null

    private var name: String = ""

    constructor() : this(LoggingUncaughtExceptionHandler(), "thread")

    constructor(ueh: UncaughtExceptionHandler, name: String) {
        this.ueh = ueh
        this.name = name
    }

    override fun newThread(p0: Runnable): Thread {
        val thread = doMakeThread(p0)
        thread.uncaughtExceptionHandler = ueh
        thread.name = name
        if (thread.isDaemon) {
            thread.isDaemon = false
        }

        if (thread.priority != Thread.NORM_PRIORITY) {
            thread.priority = Thread.NORM_PRIORITY
        }
        return thread
    }

    private fun doMakeThread(runnable: Runnable): Thread {
        return object : Thread(runnable) {
            override fun toString(): String {
                val groupName = if (threadGroup == null) "" else threadGroup.name
                return "${javaClass.simpleName} [$name, $id , $groupName]@ ${hashCode()}"
            }
        }
    }

    class LoggingUncaughtExceptionHandler : UncaughtExceptionHandler {
        override fun uncaughtException(p0: Thread, p1: Throwable) {
            println("name is ${p0.name} message is ${p1.message}")
        }
    }
}