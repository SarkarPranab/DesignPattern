package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class CountUpperAndLowerCase {
    public static void main(String[] args){
        String is = "AabBBcDF234@#iKLYhfd";
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        for(char ch : is.toCharArray()){
            if(Character.isUpperCase(ch)){
                uppercaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            }else{
                continue;
            }
        }
        System.out.println("Uppercase count : "+ uppercaseCount +"  "+"Lowercase count:"+lowercaseCount);
    }
}
