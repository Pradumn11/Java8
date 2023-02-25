package Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {

    public static void main(String[] args) {
        genericDemo(4);
        genericDemo("generic");
        System.out.println(genericDemo1(1));
    }

    public static <T> void genericDemo(T whatever) {
        System.out.println(whatever);
    }
    public static <T> List<?> genericDemo1(T STRING){
        return List.of("a");
    }



}
