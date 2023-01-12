package Optional;

import Pojos.Student;

import java.util.NoSuchElementException;
import java.util.Optional;

import static Filter.FilterDemo.studentsHelper;

public class OptionalDemo {
    public static void main(String[] args) {
        getStudentById(333)
                .orElseThrow(NoSuchElementException::new);

    }

//    return object with optional wrapping
    public static Optional<Student> getStudentById(int id) {

        return studentsHelper.getStudentList()
                .stream()
                .filter(a -> a.getPassportNo() == id)
                .findFirst();
//    findfirst will find or if couldn't will send empty optional
    }

//    Value will be send without Optional wrapping,if no value null will be send
    public static Student getStudentById_withoutoptional(int id) {

        return studentsHelper.getStudentList()
                .stream()
                .filter(a -> a.getPassportNo() == id)
                .findFirst()
                .orElse(null);
    }

//    throw exception if the optional(findfirst) is empty
    public static Student getStudentById_withException(int id) {

        return studentsHelper.getStudentList()
                .stream()
                .filter(a -> a.getPassportNo() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

    }




}
