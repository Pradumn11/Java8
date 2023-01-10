package Constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterConstants {
    public static final int FIRSTCLASS = 65;
    public static final int DISTINCTION = 75;
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    public static List<Integer> schoolIdList = List.of(101, 102, 103);
    public static List<String> GenderList = Stream.of(MALE, FEMALE)
            .collect(Collectors.toList());
}
