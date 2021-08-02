package KR1.SmoothieMaker;

import java.util.*;
import java.util.stream.Collectors;

public class Smoothie {
    static Map<String, List<String>> menuOptions;
    static List<String> uniqueIngrediantsWhichRestaurantBuys ;

    static {
        menuOptions = new HashMap<>();
        menuOptions.put("Classic", Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
        menuOptions.put("Freezie", Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));
        menuOptions.put("Greenie", Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));
        menuOptions.put("Just Desserts", Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry"));
        uniqueIngrediantsWhichRestaurantBuys = menuOptions
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    public static String ingredients(String order) {
        try{
            String[] ordersplit = order.split(",");
            List<String> orderItems = Arrays.asList(ordersplit);
            String orderName = orderItems.get(0);
            List<String> orderIngredients = orderItems.subList(1, orderItems.size());

            if(!areIngredientsEvenValid(orderIngredients)){
                throw new IllegalArgumentException();
            }

            String finalOrder = "";
            if (menuOptions.containsKey(orderName)) {
                List<String> ingredientsAsPerMenu = menuOptions.get(orderName);
                List<String> ingrediantsToBeServed = new ArrayList<>(ingredientsAsPerMenu);

                for (String ingredient : orderIngredients) {
                    if (allergicIngredient(ingredient)) {
                        String allergicIngredient = ingredient.substring(1);
                        ingrediantsToBeServed.removeIf(x-> (x.equalsIgnoreCase(allergicIngredient)));
                    }else {
                        if (!ingredientsAsPerMenu.contains(ingredient)){
                            throw new IllegalArgumentException();
                        }
                    }
                }

                if(!ingrediantsToBeServed.isEmpty()){
                    finalOrder=ingrediantsToBeServed.stream()
                            .sorted()
//                            .map(String::valueOf)
                            .collect(Collectors.joining(","));
                }
            } else {
                throw  new IllegalArgumentException();
            }


            return finalOrder;
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }

    }

    private static boolean areIngredientsEvenValid(List<String> orderIngredients) {
        for (String orderIng :
                orderIngredients) {
            String parsedOrder = orderIng.startsWith("-")? orderIng.substring(1): orderIng;
            if (!uniqueIngrediantsWhichRestaurantBuys.contains(parsedOrder.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private static boolean allergicIngredient(String ingredient) {
        return ingredient.startsWith("-");
    }
}

