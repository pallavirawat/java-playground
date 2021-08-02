package LeetCode.longestSubWithoutRep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRep {
    public int lengthOfLongestSubstring(String s) {
        int w1=0,w2=0;
        if(s.length()<=1){
            return s.length();
        }

        String window="";
        int maxWindow = -1;
        for (w2 = 0; w2 < s.length(); w2++) {
            window = s.substring(w1, w2);

            // if(window.length()>maxWindow){
            //     maxWindow=window.length();
            // }

            int dupliactionIndex = window.lastIndexOf(Character.toString(s.charAt(w2)));
            System.out.println(window+ " " + dupliactionIndex +" "+ w1 + " " + s.charAt(w2));

            if(dupliactionIndex>=0){
                w1=w1+dupliactionIndex+1;
            }else{
                int delta = w2-w1+1;
                if(delta>maxWindow){
                    maxWindow=delta;
                }
            }
        }
        return maxWindow;
    }

    public int optimisedonereqrite(String s){
        if(s.length()<=1){
            return s.length();
        }

        int wl=0,wr=1;

        Map<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0), 0);

        Map<String, String> m = new HashMap<String, String>();
        Map<String, String> m2 = new HashMap<String, String>();


        int maxWindow = 1;

        while (wr<s.length()){
            char currChar = s.charAt(wr);
            if(hm.containsKey(currChar) && hm.get(currChar)>=wl) {
                wl = hm.get(currChar)+1;
            }
            else{
                int delta = wr-wl+1;
                if(delta>maxWindow)
                    maxWindow = delta;
            }

            hm.put(currChar, wr);
            wr++;
        }

        return maxWindow;
    }
}
