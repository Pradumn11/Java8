package Collectors;

import ObjectHelper.SchoolListHelper;
import Pojos.School;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//import static java.util.stream.Collectors.toMap;

@SuppressWarnings({"unused"})
public class Collectorss {

    public static void main(String[] args) {

        SchoolListHelper schoolListHelper = new SchoolListHelper();
        List<School> schools = schoolListHelper.getSchoolsList();

// *********************************--To List--*******************************************
        List<Integer> list = schools.stream()
                .map(School::getSchoolId)
                .collect(toList());

//*****************************--TO CONVERT TO MAP--*************************************
        Map<Integer, String> map = schools.stream()
//               .collect(toMap(school -> school.getSchoolId(),school2 ->school2.getSchoolName() ));
//                .collect(toMap(School::getSchoolId, School::getSchoolName));--->this code will throw exception if duplicate key foung
                //this will handle duplicate and keep the key which we mention
                .collect(toMap(School::getSchoolId, School::getSchoolName,(a1,a2)->a1));
        System.out.println(map);

//**************************--To create un-mutable list--************************************
//        we can also have un-mutable set,map
        List<Integer> list1 = schools.stream()
                .map(School::getSchoolId)
                .collect(toUnmodifiableList());
//            list1.add(99);--->ERROR-->>UNSUPPORTED

//******************************--Join by any string or eg-comma--***********************************

        String addedcomma = schools.stream()
                .map(School::getSchoolName)
//                .collect(Collectors.joining(","))
                .collect(joining(",", "[", "]"));
        System.out.println(addedcomma);

//**************************************--Partition--*********************************
//  Here instead of creating two new array and writing two separate codes for odd and even

        Map<Boolean, List<Integer>> map1 = schools.stream()
                .map(School::getSchoolId)
                .collect(partitioningBy(id -> id % 2 == 0));
        System.out.println(map1.get(true));


        //************************************************GroupBY*************************

// adding school object as value and school name as key
        Map<String, List<School>> map3 = schools.stream()
                .collect(groupingBy(School::getSchoolName));

//        grouping by name and integer as value;------------>>>>>>mapping()
        //here we are grouping by name , but wwe dont want whole object , to ge specific value we do mapping
        Map<String, List<Integer>> map2 = schools.stream()
                .collect(groupingBy(School::getSchoolName, mapping(School::getSchoolId, toList())));
        System.out.println(map2);

        //Here we are grouping by ID but getting only name of of the school in grouping
        Map<Integer, List<String>>listMap=schools.stream()
                .collect(groupingBy(School::getSchoolId,mapping(School::getSchoolName,toList())));
        System.out.println("listMap: "+listMap);

//        Group by name and count the number of person having that name----->counting()
//        Here we are getting value as long, as return type of counting is long
        Map<String, Long> map4 = schools.stream()
                .collect(groupingBy(School::getSchoolName, counting()));
        System.out.println(map4);

//        We want the return integer instead of long, we can parse to int by telling that collect and then parse
        Map<String,Integer>map5=schools.stream()
                .collect(groupingBy(School::getSchoolName,
                        collectingAndThen(counting(),Long::intValue)));

//*********************************************Max,sum and maxBy*************************

//        Here max and sum give value comparing the integer and school id
        int sum= schools.stream()
                .mapToInt(School::getSchoolId)
                .sum();
        System.out.println("sum=: "+sum);

        //Here we get optional bcoz stream doesnt know if we have any value in list if not what is max whereas sum can give 0 instead

        OptionalInt max=schools.stream()
                .mapToInt(School::getSchoolId)
                .max();
        System.out.println("max: "+max.getAsInt());

        //Max give us max int value , but what if we need object( eg-School with max id) which can be done by maxBy

        Optional<School> school1=schools.stream()
                .collect(maxBy(Comparator.comparing(School::getSchoolId)));
        System.out.println(school1.get());

        //Now we dont want entire object we want only name of school who has maxID
      String maxName=schools.stream()
              .collect(collectingAndThen(maxBy(Comparator.comparing(School::getSchoolId)),
                      school -> school.map(School::getSchoolName).orElse("")
                      ));

//                      Filtering
          Map<Integer, List<String>> maplist2=schools.stream()
                  .collect(groupingBy(School::getSchoolId,mapping(School::getSchoolName,filtering(s->s.length()>4,toList()))));
        System.out.println(maplist2);
    //groupBy mapping  --->(function,collector)
        //collectingAndThen(collectors,function)
//        teeing-->(collector,collector,operation wih both)

        //FlatMapping ----you want to flatmap at collect level
        System.out.println(
                schools.stream()
                        .collect(groupingBy(School::getSchoolId,flatMapping(a->Stream.of(a.getSchoolName().split("")),toSet())))
        );

        // Sorting based on object value --here issue is two id is same it doesnt sort base on the schoolname --
        schools.stream().sorted(Comparator.comparing(School::getSchoolId)
                //to sort based on school name if is is same
                .thenComparing(School::getSchoolName)
        ).forEach(System.out::println);


    }
}
