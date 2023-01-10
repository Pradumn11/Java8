package ObjectHelper;

import Pojos.School;
import Pojos.Student;


import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static Constants.FilterConstants.*;

public class PredicateHelper {

    public static final BiPredicate<School, Student> isAdultMale = (p1, p2) -> p1.getSchoolId() == p2.getSchoolId();
    private static Predicate<Student> minFirstclass = (student) -> student.getPercentage() >= FIRSTCLASS;
    static Predicate<Student> maxFirstclass = (student) -> student.getPercentage() < DISTINCTION;
    public static Predicate<Student> checkFirstclass = maxFirstclass.and(minFirstclass);

    public static Predicate<Student>checkMale=(student)->student.getGender().equalsIgnoreCase(MALE);
    public static BiPredicate<School,Integer>checkSchoolId=(schoolId1,schoolI2)->schoolId1.getSchoolId()==schoolI2;
    public static Predicate<Student>checkFemale=(p)->p.getGender().equalsIgnoreCase(FEMALE);
}
