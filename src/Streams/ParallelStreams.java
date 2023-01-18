package Streams;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreams {


    public void demoParallelStreams() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        List<Integer> nums = numbers.parallelStream()
                .map(n -> n * 2)
                .peek(n -> System.out.printf("%s processing %d%n",
                        Thread.currentThread().getName(), n))
                .sequential()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(nums);
//     Since the last parallel or sequential call before the collect method was to sequential.

    }

    public static int doubleIt(int a) {
        sleep(100);
        return a * 2;
    }

    public void SequentialvsParallel() {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};

        Instant before = Instant.now();
        int total = IntStream.of(arr)
                .map(ParallelStreams::doubleIt)
                .sum();
        Instant after = Instant.now();
        Duration duration = Duration.between(before, after);

        Instant before2 = Instant.now();
        int total2 = IntStream.of(arr)
                .parallel()
                .map(ParallelStreams::doubleIt)
                .sum();
        Instant after2 = Instant.now();
        Duration duration2 = Duration.between(before2, after2);

        System.out.println("SequentialSum: " + total);
        System.out.println("SequentialTime: " + duration.toMillis() + " ms");
        System.out.println("ParallelSum: " + total2);
        System.out.println("ParallelTime: " + duration2.toMillis() + " ms");
//        SequentialSum: 42
//        SequentialTime: 664 ms
//        ParallelSum: 42
//        ParallelTime: 115 ms

    }

    public static void sleep(int a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
