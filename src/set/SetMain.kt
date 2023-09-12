package set

fun main() {
    val student1 = Student("zhangqi", 16, "1")
    val student2 = Student("zhangqi", 16, "1")
    val student3 = Student("zhanglu", 20, "3")
    val studentList = mutableListOf<Student>()
    studentList.apply {
        add(student1)
        add(student2)
        add(student3)
    }

    val studentSet = HashSet<Student>()
    for (student in studentList) {
        studentSet.add(student)
    }
    println("studentList Size = ${studentSet.size}")
}