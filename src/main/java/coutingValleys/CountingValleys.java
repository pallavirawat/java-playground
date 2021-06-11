package coutingValleys;//https://www.hackerrank.com/challenges/counting-valleys

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

    public static int countingValleys(int steps, String path) {
        // Write your code here

       char[] chars = path.toCharArray();
       Integer sealevel = 0;
       Integer plateau = 0;
       for(char step: chars){
           if(step ==  'U'){
               sealevel++;
           }
           else sealevel--;

           if(sealevel==0 && step=='U'){
               plateau++;
           }
       }
        return plateau;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String integers = "UDDDUDUU";

        int steps = integers.length();

//        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, integers);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
