package SDETCodingRoundPrep2026;

public class Question20 {
    public static void main(String[] args){
        String str = "This is Fun";
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words){
            StringBuilder reverseWord = new StringBuilder(word);
            result.append(reverseWord.reverse()).append(" ");
        }
        System.out.println(result);
    }
}
