package sockMerchant;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, List<Integer>> collect = ar.stream().collect(
                Collectors.groupingBy(Function.identity())
        );

        Integer count = 0;
        collect.keySet();
        for (Map.Entry<Integer, List<Integer>> entry : collect.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

            count += (entry.getValue().size()/2);
        }

        System.out.println("my grouping: " + collect);
        return count;
    }

}

public class SockMerchant {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> integers = Arrays.asList(1, 2, 3, 1, 2, 1,9);

        int result = Result.sockMerchant(integers.size(), integers);

        System.out.println("result is " + result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//        System.out.println("hello world");
    }
}
