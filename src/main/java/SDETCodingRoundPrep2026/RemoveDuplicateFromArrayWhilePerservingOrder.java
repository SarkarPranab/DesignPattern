package SDETCodingRoundPrep2026;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicateFromArrayWhilePerservingOrder {
    public static int[] removeDuplicateFromArray(Integer[] arr){
      LinkedHashSet<Integer> returnSet = new LinkedHashSet<>();
        for (int element : arr){
            returnSet.add(element);
      }
        return returnSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        Integer[] arr = {12,6,7,12,7,4,9};
        System.out.println(Arrays.toString(removeDuplicateFromArray(arr)));
    }
}