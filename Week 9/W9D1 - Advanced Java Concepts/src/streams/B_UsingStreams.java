package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * the Stream API allows you to create pipelines, or sequences of aggregate operations, on streams of data.
 * Streams are a sequence of data. 
 * Streams do not STORE the data (like collections), they move the elements through the pipeline.
 * Streams do not manipulate the original source of data.
 * Useful for completing a series complex tasks on the data to get a result.
 * 
 * - pipelines:
 * -- require a source of data, like a collection
 * -- can contain zero or more intermediate operations
 * -- 
 * Types of operations:
 * - intermediate operations
 * -- produce a new stream
 * -- filter()
 * -- map()
 * 
 * 
 * - terminal operations
 * -- produces a non-stream value OR no value at all
 * -- forEach()
 * 
 * 
 * - reduction operations
 * -- a type of terminal operation that produce a single result
 * -- reduce(), collect(), max(), min(), average()
 * -- collect() uses the help of a Collector: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 * 
 * Other references for streams:
 * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */
public class B_UsingStreams {
    public static void main(String[] args) {
        // ======================= creating streams ===========================

        // from a collection
        ArrayList<String> wordCollection = new ArrayList<>();
        wordCollection.add("a");
        wordCollection.add("b");
        wordCollection.add("c");

        Stream<String> streamCreatedByCollection = wordCollection.stream();

        // from an array
        String[] wordArray = {"a", "b", "c"};
        Stream<String> streamCreatedByArray = Arrays.stream(wordArray);

        // inline
        Stream<String> streamCreatedInline = Stream.of("a", "b", "c");

        // =============================== INFINITE STREAMS =============================
        // starting value + unaryOperator (takes in a value, returns value of that type)
        Stream<Integer> evenNums = Stream.iterate(0, n -> n + 2);
        evenNums.limit(5).forEach(x -> System.out.println(x));

        // one stream is used, its gone! They are AutoCloseable.
        // evenNums.limit(5).forEach(x -> System.out.println(x)); 

        // unordered stream
        Stream<Integer> randNums = Stream.generate(() -> (int) (Math.random() * 10 + 1));
        randNums.limit(1).forEach(x -> System.out.println(x));

        // ======================== using common operations =============================

        // =========== terminals ================
        long count = streamCreatedByCollection.count();
        System.out.println(count);

        // forEach (already demonstrated)

         // reduce is useful for creating a new value during every iteration in its processing
        String concat = streamCreatedByArray.reduce("",  (x, y) -> x + y);
        System.out.println(concat);

         // collect is useful for modifying an existing value (like a collection) (adding to a collection)
        List<String> codedValues = streamCreatedInline.collect(Collectors.toList());
        System.out.println(codedValues);

        // ============== adding intermediates ===========================================
        Stream<Integer> numberStream1 = Stream.of(6, 9, 1, 4, 2, 10, 8, 7, 3, 5);
        List<Integer> sortedEvenNumbers = numberStream1.filter(x -> x % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(sortedEvenNumbers);

        Stream<Integer> numberStream2 = Stream.of(6, 9, 1, 4, 2, 10, 8, 7, 3, 5, 2, 6, 8);
        numberStream2.distinct().map(x -> x * 10).forEach(x -> System.out.print(x + " "));



    }
}
