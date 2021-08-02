package repeatedCharOcc;

import java.util.*;
import java.util.function.Predicate;

public class RepeatedOcc {
        public static Character myfunc(String s){
            char[] chars = s.toCharArray();
            int[] occounter = new int[s.length()];


            final LinkedList<String> strings = new LinkedList<>();
            final String reduce = strings.stream().reduce("", (a, b) -> a + b);

            strings.stream().forEach(i-> {
                if(i.isEmpty()){
                    int a =1;
                }
            });

            final List<Integer> integers = new LinkedList<>();

            int[] fr = new int[] {1, 2,3};

            final ArrayList<Integer> iArrayList = new ArrayList<>();
            iArrayList.sort((a,b) -> a-b);


            strings.stream().max(Comparator.comparing(String::length));

            strings.stream().filter(customPredicate("", ""));

            Set<String> hash_Set = new HashSet<String>();
            Set<String> hash_Set2 = new TreeSet<>();







            for(int i = 0; i<s.length(); i++){
                occounter[i]++;
            }

            for(int i = 0; i<s.length(); i++){
                if(occounter[i]==1)
                    return s.charAt(i);
            }

            return 'A';

        }


        static Predicate<String> customPredicate(String a, String b){
            return (elem) -> elem.equals(a);
        }

    static Comparator<Integer> customPComparator(Integer cons, String b){
        return (i1, i2) -> i1-i2 -cons;
    }

}
