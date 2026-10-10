package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;

public class ReverseFirstWOrdOfString {
    public static String reverseFirstWordOfString(String words){
        String[] arr = words.split("\\s+",2);
        String firstWord = arr[0];
        System.out.println(firstWord);
        char[] char_arr = firstWord.toCharArray();
        int left = 0;
        int right = char_arr.length-1;

        while(left < right){
            char temp = char_arr[left];
            char_arr[left] = char_arr[right];
            char_arr[right] = temp;
            left++;
            right--;
        }
//        String reversedString=new;
//        for(char c : char_arr){
//            reversedString=reversedString+c;
//        }
        return new String(char_arr)+" "+ arr[1];
    }

    public static void main(String[] args){
        String words = "Hello World from Java";
        System.out.println(reverseFirstWordOfString(words));
    }
}