package Map;

import Pojos.School;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Exception.*;

import static Constants.FilterConstants.schoolIdList;
import static Filter.FilterDemo.schoolHelper;
import static Filter.FilterDemo.studentsHelper;
import static ObjectHelper.PredicateHelper.checkSchoolId;
import static ObjectHelper.PredicateHelper.checkSchoolName;

import ObjectHelper.StudentsListHelper;
import Pojos.Student;

public class MapDemo {
    StudentsListHelper studentsListHelper = new StudentsListHelper();

    public static List<String> getSchoolNameById(Integer schoolid) {
        if (!schoolIdList.contains(schoolid)) {
            throw new RuntimeException("Invalid School Id");
        }
        return schoolHelper.getSchoolsList()
                .stream()
                .filter(school -> checkSchoolId.test(school, schoolid))
                .map(School::getSchoolName)
                .collect(Collectors.toList());
    }

    public static Integer getSchoolIdBySchoolName(String schoolName) throws InvalidSchoolNameException {
        return schoolHelper.getSchoolsList().stream()
                .filter(school -> school.getSchoolName().equalsIgnoreCase(schoolName))
                .map(School::getSchoolId)
                .findFirst().orElseThrow(() -> new InvalidSchoolNameException("InvalidSchool Name"));
    }

    public static List<String> getStudentsNameBySchool(String schoolName) throws InvalidSchoolNameException {
        Integer schoolId = getSchoolIdBySchoolName(schoolName);

        return studentsHelper.getStudentList().stream()
                .filter(student -> checkSchoolName.test(student, schoolId))
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .collect(Collectors.toList());
    }


}
