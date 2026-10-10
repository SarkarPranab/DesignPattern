package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;

public class SumOfIntegerFromSentence {
    public static void main(String[] args){
        String input = "This is 1000 and it should be 20 30 50 1050";
        String[] arr =  input.split("\\s+");
        int sum = Arrays.stream(arr).filter(data -> data.matches("\\d+")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }
}
