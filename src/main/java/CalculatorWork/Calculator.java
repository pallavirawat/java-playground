package CalculatorWork;

import java.text.DecimalFormat;
import java.util.*;

public class Calculator {
    public String calculate(String input) {

        int separationIndex = findIndexOfOperators(input);

        if(separationIndex<1){
            return input;
        }

        List<String> numbers = Arrays.asList(input.substring(0, separationIndex).trim().split(" "));
        List<String> operators = Arrays.asList(input.substring(separationIndex).trim().split(" "));

        Queue<String> numberStack = new LinkedList<>();
        Queue<String> operatorStack = new LinkedList<>();

        for(String str : numbers)
            numberStack.add(str);

        for(String str : operators)
            operatorStack.add(str);

        String result = "";

       while (!numberStack.isEmpty()){
           int number1 = Integer.parseInt(numberStack.remove());
           int number2 = Integer.parseInt(numberStack.remove());

           String operation = operatorStack.remove();
           float  interimResult = -1;
           if(operation.equals("+")){
               interimResult=(number1+number2);
           }

           if(operation.equals("-")){
               interimResult=(number1-number2);
           }


           if(operation.equals("/")){
               interimResult=((float)number1/ number2);
           }

           if(operation.equals("*")){
               interimResult=(number1*number2);
           }

           DecimalFormat format = new DecimalFormat("0.#");

           result+=format.format(interimResult)+" ";
       }

        return result.trim();
    }

    private int findIndexOfOperators(String input) {
        for (int i = 0; i< input.length(); i++) {
            char currCharr = input.charAt(i);
            if(currCharr!=' ' && !Character.isDigit(currCharr)){
                return i;
            }
        }
        return -1;
    }
}
