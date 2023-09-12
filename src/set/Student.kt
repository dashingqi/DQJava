package set

/**
 * data class 数据类本身重写了equals和hashCode方法
 */
 class Student(val name: String, val age: Int, val classID: String) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Student
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//        if (classID != other.classID) return false
//
//        return true
//    }
//
//    // hashCode当添加对象的数量比较多的情况下，具有一定hash冲突碰撞的概率，需要重写equals方法进行补充；
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        result = 31 * result + classID.hashCode()
//        return result
//    }
}