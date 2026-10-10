package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class LengthofStringNodotLength {
    public static int lengthOfString(String str){
        if(str == null) return 0;
        char[] arr = str.toCharArray();
        int len = 0;
        for(char c : arr){ len++;}
        return len;
    }

    public static void main(String[] args){
        System.out.println(lengthOfString("Fuck you Bitch!"));
    }
}
