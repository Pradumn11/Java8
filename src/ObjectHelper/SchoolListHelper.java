package ObjectHelper;

import Pojos.School;

import java.util.Arrays;
import java.util.List;

public class SchoolListHelper {

    public List<School> getSchoolsList() {
        List<School> schoolsList = Arrays.asList(
                new School(101, "DCU", "North Dublin"),
                new School(102, "TUD", "Grangegorman"),
                new School(103, "NCI", "Central Dublin")
        );
        return schoolsList;
    }
}
