package jumpingOnTheClouds;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here

        int jumps=0;
        for (int i=1; i<c.size(); i++) {
            if((i+1)<c.size() && c.get(i+1)==0){
                i++;
            }
            jumps+=1;
        }
        return jumps;
    }

}

public class JumpingOnTheClouds {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> integers = Arrays.asList(0,0,1, 0, 0 ,1,0);

//        String path = bufferedReader.readLine();

        int result = Result.jumpingOnClouds(integers);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
