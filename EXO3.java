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
        System.out.println(countWithReduce(list, "hello"));

        System.out.println(upperCase(list));
        System.out.println(upperCaseWithStreamAndCollector(list));


    }

    private static long countWithReduce(List<String> list, String hello) {
        return list.stream().filter(e -> e.equals(hello)).mapToLong(e -> 1).reduce(Long::sum).getAsLong();
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

    @FunctionalInterface
    public interface Foo {
        void prandti();
        default void defaultMethod() {}
    }

    private static long countWithStream(List<String> list, String word) {

        return list.stream().filter(s -> s.equals(word)).count();

    }


}
