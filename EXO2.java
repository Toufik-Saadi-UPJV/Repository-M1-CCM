package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestLambda {
    public static void main(String[] args){
        var list = List.of("hello", "world", "hello", "lambda");

        System.out.println(count(list, "hello"));
        System.out.println(countWithStream(list, "hello"));

        System.out.println(upperCase(list));
        System.out.println(upperCaseWithStreamAndCollector(list));

   
    }



    private static List<String> upperCase(List<String> list2) {
         var listUppered = new ArrayList<String>();
         list2.forEach(e -> listUppered.add(e.toUpperCase()));
         return listUppered;
    }

    private static List<String> upperCaseWithStreamAndCollector(List<String> list2) {
        return list2.stream().map(String::toUpperCase).collect(Collectors.toList());
    }


    private static long count(List<String> list, String word) {
        long i = 0;

        for (String element: list){
            if(element.equals(word)){
                i++;
            }
        }

        return i;
    }
    
    private static long countWithStream(List<String> list, String word) {

        return list.stream().filter(s -> s.equals(word)).count();

    }


}
