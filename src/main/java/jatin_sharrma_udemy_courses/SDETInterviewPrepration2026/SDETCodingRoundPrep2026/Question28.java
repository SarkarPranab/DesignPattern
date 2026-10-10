package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class Question28 {
    public static void main(String[] args) {
        String input = "d3m4t2b0a1";
        char[] inp_arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inp_arr.length; i++){
            if(i!=0 && Character.isDigit(inp_arr[i])){
                int counter = 0;
                while (counter < inp_arr[i]-'0'){
                    sb.append(inp_arr[i-1]);
                    counter++;
                }
            }
        }
        System.out.println(sb);
    }

}