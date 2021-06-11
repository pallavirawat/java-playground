package LeetCode.plusOne;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlusOne {
    public int[] plusOne(int[] digits) {

        LinkedList<Integer> integers = new LinkedList<>();
//
//        Arrays.stream(digits).forEach(d -> {
//            integers.add()
//        });
//        IntStream.range(0, digits.length)
//                .forEach(index -> {
//                    integers.add(digits[index]);
//                });


        int lastdigit = digits[digits.length-1] +1;

        int carryover = lastdigit/10;

        integers.addFirst(lastdigit%10);
        for (int i = digits.length-2; i >=0; i--) {
            int currDigit = digits[i] + carryover;
            carryover = currDigit/10;
            integers.addFirst(currDigit%10);
        }

        if(carryover!=0){
            integers.addFirst(carryover);
        }

        Object[] objectAarray = integers.toArray();
        int length = objectAarray.length;;
        int [] intArray = new int[length];
        for(int i =0; i < length; i++) {
            intArray[i] = (int) objectAarray[i];
        }
        return intArray;
    }
    
}
