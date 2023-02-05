package Reduce;

import ObjectHelper.SchoolListHelper;
import Pojos.School;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class reduceDemo {

    public static void main(String[] args) {
        reduceDemomethod();
    }
    public static void reduceDemomethod(){
        SchoolListHelper schoolListHelper=new SchoolListHelper();

        List<School>schoolList=schoolListHelper.getSchoolsList();
        System.out.println(schoolList.stream()
                .map(school -> school.getSchoolId())
//              .reduce(0,(total,age)->total+age)
//                        .reduce(0,(total,age)->Integer.sum(total,age))
                        .reduce(0,Integer::sum));




    }
}
