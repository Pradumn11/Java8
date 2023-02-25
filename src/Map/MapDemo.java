package Map;

import MapGson.Animal;
import MapGson.Child;
import Pojos.School;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
    public static Map<String,List<Child>>filterByValueInsideObjectListInsideObject(){
        Gson gson=new Gson();
        String typeT=" {\n" +
                " \"Bob\":{\n" +
                "    \"location\": \"Nashik\",\n" +
                "    \"number\": 10,\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"name\": \"Pradumnya\",\n" +
                "            \"category\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Yash\",\n" +
                "            \"category\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Omkar\",\n" +
                "            \"category\": 3\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                " }";
        Type empMapType = new TypeToken<Map<String, Animal>>() {}.getType();
        Map<String,Animal>aaa=gson.fromJson(typeT,empMapType);
        System.out.println(aaa);
        Map<String,List<Child>>ap=aaa.entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                k->k.getKey(),
                                e->e.getValue().getList()
                                        .stream().filter(op->op.getCategory()==1)
                                        .collect(Collectors.toList())
                        )
                );
        return ap;
    }


}
