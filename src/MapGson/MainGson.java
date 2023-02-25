package MapGson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainGson {
    public static void main(String[] args) {

        Gson gson = new Gson();
        String try1 = "{\n" +
                "    \"location\":\"Nashik\",\n" +
                "    \"number\":10,\n" +
                "    \"list\":[\n" +
                "        {\n" +
                "          \"name\":\"Pradumnya\",\n" +
                "          \"category\":1\n" +
                "        },\n" +
                "         {\n" +
                "          \"name\":\"Yash\",\n" +
                "          \"category\":2\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\":\"Omkar\",\n" +
                "          \"category\":3\n" +
                "        }\n" +
                "    ]\n" +
                "}";
//        Animal animal= gson.fromJson(try1, Animal.class);
//        System.out.println(animal.getNumber());
//        String jsonString = "{'name':'Bob','salary':100}";
//        Map map = gson.fromJson(jsonString, Map.class);
//        System.out.println(map.get("name").getClass() +" "+map.get("salary").getClass());

        String typeT = " {\n" +
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
        Map<String, Animal> aaa = gson.fromJson(typeT, empMapType);
        System.out.println(aaa);
        Map<String, List<Child>> ap = aaa.entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                k -> k.getKey(),
                                e -> e.getValue().getList()
                                        .stream().filter(op -> op.getCategory() == 1)
                                        .collect(Collectors.toList())
                        )
                );
        System.out.println(ap);




    }
}
