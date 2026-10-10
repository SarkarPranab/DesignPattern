package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question19 {
    public static void main(String[] args){
        String str = "This is Fun";

        String[] arr = str.split("\\s+");
        String result="";
        for (String s: arr){
            char[] ch_arr = s.toCharArray();
            int left = 0;
            int right = ch_arr.length-1;
            while (left < right){
                char temp = ch_arr[left];
                ch_arr[left] = ch_arr[right];
                ch_arr[right] = temp;
                left++;
                right--;
            }
            result= result + new String(ch_arr)+ " ";
        }

        System.out.println(result);
    }
}
