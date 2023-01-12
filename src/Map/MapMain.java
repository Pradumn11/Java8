package Map;

import Pojos.Student;

import Exception.*;

import static Map.MapDemo.*;

public class MapMain {
    public static void main(String[] args) throws InvalidSchoolNameException {
        //        Fetch SchoolName By id
        getSchoolNameById(101).forEach(System.out::println);

        //Get students from specific school
        getStudentsNameBySchool("DCU").forEach(System.out::println);

        //Get School Id by school name
        System.out.println(getSchoolIdBySchoolName("DCU"));

    }
}
