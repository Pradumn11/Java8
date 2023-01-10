package ObjectHelper;

import Pojos.Student;

import java.util.Arrays;
import java.util.List;

public class StudentsListHelper {


    public List<Student> getStudentList() {
        List<Student> studentList = Arrays.asList(
                new Student(1, "Pradumnya", "Patil", "Male", 68, 101),
                new Student(2, "Harry", "Gangai", "Male", 59, 101),
                new Student(3, "Omkar", "Lamde", "Male", 75, 101),
                new Student(4, "Shlok", "Gargate", "Male", 87, 101),
                new Student(5, "Rutuja", "Pandey", "Female", 89, 101),
                new Student(6, "Shashi", "Patil", "Male", 67, 101),
                new Student(7, "Lalit", "More", "Female", 79, 102),
                new Student(8, "Deepa", "Goyal", "Female", 32, 102),
                new Student(9, "Neeraj", "Gaitonde", "Male", 65, 102),
                new Student(10, "Rahul", "Patel", "Male", 74, 102),
                new Student(11, "Anil", "Gupta", "Male", 71, 103),
                new Student(12, "Virat", "Kohli", "Male", 90, 103),
                new Student(12, "Dipti", "Agrawal", "Female", 62, 103),
                new Student(14, "Shristi", "Patidar", "Male", 76, 103)

        );
        return studentList;


    }
}
