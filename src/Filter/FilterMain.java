package Filter;

import Pojos.Student;

import java.util.List;

import static Filter.FilterDemo.*;

public class FilterMain {

    public static void main(String[] args) {
//        Fetch all student
        List<Student> studentList = studentsHelper.getStudentList();

        //Find Students who secured First Class .
        firstClassStudents(studentList).forEach(System.out::println);

        //get SchoolName of Topper (hardcoded percentage without conflicting ones)
        System.out.println(getTopperSchoolName(studentList));

//        Fetch SchoolName By id
        getSchoolNameById(101).forEach(System.out::println);
    }
}
