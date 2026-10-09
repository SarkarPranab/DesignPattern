package SDETCodingRoundPrep2026;

import java.util.Arrays;

public class RemoveDuplicateUsingStreams {
    public static void main(String[] args){
        int[] arr = {12,12,20,14,20,12,4854,9898,12,98};
        System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray()));
    }
}
