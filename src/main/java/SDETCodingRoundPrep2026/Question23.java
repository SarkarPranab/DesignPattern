package SDETCodingRoundPrep2026;

import java.util.LinkedHashSet;

public class Question23 {
    public static void main(String[] args){
        LinkedHashSet<Character> lhset = new LinkedHashSet<>();
        String input = "abbacdaab";
        StringBuilder str = new StringBuilder();
        for(char a : input.toCharArray()){
            if(lhset.add(a)){
                str.append(a);
            }
        }
        System.out.println(str.toString());
    }
}
