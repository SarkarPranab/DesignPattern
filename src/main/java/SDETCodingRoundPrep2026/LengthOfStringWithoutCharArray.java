package SDETCodingRoundPrep2026;

import java.util.Arrays;

public class LengthOfStringWithoutCharArray {
    public static long LengthOfStringWithoutCharArray(String str){
        return Arrays.stream(str.split("")).count();
    }

    public static int usingCharAt(String str){
        int count=0;
        while (true){
            try {
                str.charAt(count);
                count++;
            }catch(IndexOutOfBoundsException ie){
                System.out.println("Length of String "+ count);
                break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(LengthOfStringWithoutCharArray("Fuck you Bitch!"));
        System.out.println(usingCharAt("Fuck you Bitch!"));


    }
}
