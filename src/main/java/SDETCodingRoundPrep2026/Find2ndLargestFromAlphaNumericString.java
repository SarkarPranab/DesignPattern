package SDETCodingRoundPrep2026;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Find2ndLargestFromAlphaNumericString {
    public static void main(String[] args) {
        String testString = "abDv1c64d41";
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(testString.toCharArray()));
        for (char ch : testString.toCharArray()) {
            if (Character.isDigit(ch)) {
                int num = ch-'0'; // Convert this character into int
                if(num > first){
                    second = first;
                    first  = num;
                }
                if(num > second && num< first){
                    second = num;
                }
            }
        }
        System.out.println("Second Highest : "+ second);
    }
}
