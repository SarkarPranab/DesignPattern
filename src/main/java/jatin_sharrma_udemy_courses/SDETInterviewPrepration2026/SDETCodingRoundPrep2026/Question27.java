package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class Question27 {
    public static void main(String[] args){
        String input = "ddmmmmtta";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=1; i < input.length() ; i++){
            if(input.charAt(i) == input.charAt(i-1)){
                count++;
            }else{
                sb.append(input.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        System.out.println(sb.toString());
    }
}
