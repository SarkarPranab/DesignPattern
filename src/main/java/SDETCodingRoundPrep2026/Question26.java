package SDETCodingRoundPrep2026;

import java.util.HashMap;
import java.util.Map;

public class Question26 {
    public static void main(String[] args){
        String[] a = {"xyz 9", "abc 11", "xyz 21", "abc 20", "pqr 99"};
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String s : a){
            String[] split_s = s.split("\\s+");
            hmap.put(split_s[0],hmap.getOrDefault(split_s[0],0)+Integer.parseInt(split_s[1]));
        }
        int max = 0;
        String key = null;
        for(Map.Entry<String,Integer> entrySet : hmap.entrySet()){
            if(entrySet.getValue() > max){
                max = entrySet.getValue();
                key = entrySet.getKey();
            }
        }
        System.out.println("[+] Get Key : "+ key +"# #"+"[+] Get Value "+ max );
    }
}
