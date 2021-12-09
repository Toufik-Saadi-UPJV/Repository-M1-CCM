package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestLambda {
    public static void main(String[] args) throws Exception {
        var list = List.of("hello", "world", "hello", "lambda");

        System.out.println(count(list, "hello"));
        System.out.println(countWithStream(list, "hello"));
        System.out.println(countWithReduce(list, "hello"));

        System.out.println(upperCase(list));
        System.out.println(upperCaseWithStreamAndCollector(list));

        var list2 =
                new Random(0)
                        .ints(1_000_000, 0, 100)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.toList());

        printAndTime(() -> countWithReduce(list,"hello"));
    }

    @FunctionalInterface
    interface CountInterface {
        int count(List<String> laList, String word);
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


    private static long countWithStream(List<String> list, String word) {

        return list.stream().filter(s -> s.equals(word)).count();

    }


    private static <CountInterface> void printAndTime(Supplier<CountInterface> function) throws Exception {
        var start = System.nanoTime();
        var result = function.get();
        var end = System.nanoTime();
        System.out.println("result " + result);
        System.out.println(" elapsed time " + (end - start));
    };


}
