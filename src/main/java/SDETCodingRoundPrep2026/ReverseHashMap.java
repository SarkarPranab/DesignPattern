package SDETCodingRoundPrep2026;

import java.util.HashMap;

public class ReverseHashMap
{
    public static HashMap<Integer, String> reverseHashMap(HashMap<String, Integer> data){
        HashMap<Integer, String> reversedMap = new HashMap<>();
        for(String key : data.keySet()){
            reversedMap.put(data.get(key),key);
        }
        return reversedMap;
    }

    public static void main(String[] args){
        HashMap<String, Integer> orgMap = new HashMap<String, Integer>();
        orgMap.put("A",1);
        orgMap.put("B",2);
        orgMap.put("C",3);
        orgMap.put("D",4);
        System.out.println(reverseHashMap(orgMap));
    }
}
