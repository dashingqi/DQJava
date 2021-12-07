package base.innerclass

class InnerClassKotlin {
    fun test() {
        // Kotlin 是可以实现
        // 匿名内部类继承Foo，同时实现Runnable接口
        val runnable = object : Foo(), Runnable {
            override fun run() {
            }
        }
    }
}