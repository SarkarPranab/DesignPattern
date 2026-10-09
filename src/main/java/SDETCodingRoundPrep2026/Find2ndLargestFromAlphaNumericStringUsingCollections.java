package SDETCodingRoundPrep2026;

import java.util.Arrays;
import java.util.TreeSet;

// Second largest from last index
public class Find2ndLargestFromAlphaNumericStringUsingCollections {
    public static void main(String[] args) {
        String testString = "3a7b5D9v1c64d41";
        TreeSet<Integer> refined_data  = new TreeSet<>(); // Treeset stored data in sorted order
        System.out.println(Arrays.toString(testString.toCharArray()));
        for (char ch : testString.toCharArray()) {
            if (Character.isDigit(ch)){
                int val = ch-'0';
                refined_data.add(val);
            }
        }

        System.out.println("[+] 2nd Largest number : "+ refined_data.stream().toArray()[refined_data.size()-2]);

//        Using Poll Last
        refined_data.pollLast();
        System.out.println("[+] 2nd Largest from last index using poll last : "+ refined_data.last());
    }
}
