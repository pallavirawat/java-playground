package RepeatedStrings;

import java.io.IOException;

        import java.io.*;
        import java.util.Arrays;
        import java.util.List;

        import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static long repeatedString(String s, long n) {
        // Write your code here

        char[] chars = s.toLowerCase().toCharArray();

        long acount = 0;
        for (char c :
                chars) {
            if(c=='a'){
                acount++;
            }
        }
        int remainingStringSize = (int) n % s.length();

        acount *= (n/s.length());

        for (char c :
                s.toLowerCase().substring(0, Math.toIntExact(remainingStringSize)).toCharArray()) {
            if(c=='a'){
                acount++;
            }
        }

        return acount;
    }

}

public class RepeatedStrings {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String integers = "aba";

        int steps = 10;

//        String path = bufferedReader.readLine();

        long result = Result.repeatedString(integers, steps);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
