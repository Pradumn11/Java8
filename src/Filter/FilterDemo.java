package Filter;

import static ObjectHelper.PredicateHelper.*;

import ObjectHelper.SchoolListHelper;
import ObjectHelper.StudentsListHelper;
import Pojos.School;
import Pojos.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class FilterDemo {

    public static StudentsListHelper studentsHelper = new StudentsListHelper();
    public static SchoolListHelper schoolHelper = new SchoolListHelper();

    public static List<Student> getMaleStudents(List<Student> studentList) {
        if (studentList.isEmpty()) {
            throw new RuntimeException("Invalid List");
        }
        return studentList.stream().filter(checkMale).collect(Collectors.toList());
    }

    public static List<Student> firstClassStudents(List<Student> students) {
        if (students.isEmpty()) {
            throw new RuntimeException("Invalid List");
        }
        List<Student> firstclass = students.stream().filter(checkFirstclass).collect(Collectors.toList());
        return firstclass;

    }


    public static String getTopperSchoolName(List<Student> students) {
        if (students.isEmpty()) {
            throw new RuntimeException("Invalid List");
        }
        Student student = students.stream().max(Comparator.comparingInt(Student::getPercentage)).get();
        List<School> schoolList = schoolHelper.getSchoolsList();
        return schoolList.stream().filter(school -> isAdultMale.test(school, student)).map(School::getSchoolName).collect(Collectors.joining());
    }
}
