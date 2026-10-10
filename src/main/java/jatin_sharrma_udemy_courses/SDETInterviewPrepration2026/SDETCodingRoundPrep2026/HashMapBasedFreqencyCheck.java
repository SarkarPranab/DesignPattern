package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapBasedFreqencyCheck {
    public static void checkFrequencyInSentance(String sentance){
        HashMap<String, Integer> freq = new HashMap<>();
        for (String input : sentance.split("\\s+")){
            input = input.replaceAll("[^a-zA-z]","").toLowerCase();
            freq.put(input,freq.getOrDefault(input,0)+1);
        }
        System.out.println(freq);
    }

    public static void checkFrequencyOfWordInString(String str){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : str.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        System.out.println(freq);
    }
    public static void main(String[] args){
        String sentence = "Hey there how are you doing. Hey whats you you phone number. are you married? How are your parents.";
        checkFrequencyInSentance(sentence);
        String str = "hello";
        checkFrequencyOfWordInString(str);

    }
}