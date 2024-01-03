import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
class Student
{
    private String name;
    private int course;
    public Student(String name, int course)
    {
        this.name = name;
        this.course = course;
    }
    public String getName()
    {
        return name;
    }
    public int getCourse()
    {
        return course;
    }
}
public class Main
{
    public static void printStudents(List<Student> students, int targetCourse)
    {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext())
        {
            Student student = iterator.next();
            if (student.getCourse() == targetCourse)
            {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args)
    {
        // Створення десяти об'єктів класу Student
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Скаді", 1));
        studentList.add(new Student("Гладія", 2));
        studentList.add(new Student("Тотер", 1));
        studentList.add(new Student("Хорн", 3));
        studentList.add(new Student("Мадрок", 2));
        studentList.add(new Student("Гавіаль", 1));
        studentList.add(new Student("Чен", 3));
        studentList.add(new Student("Спектр", 2));
        studentList.add(new Student("Техас", 1));
        studentList.add(new Student("Тетяна", 3));
        int targetCourse = 2;
        System.out.println("Студенти на " + targetCourse + " курсі:");
        printStudents(studentList, targetCourse);
    }
}
