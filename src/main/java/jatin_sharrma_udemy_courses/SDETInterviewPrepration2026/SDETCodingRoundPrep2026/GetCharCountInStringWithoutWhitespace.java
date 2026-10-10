package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class GetCharCountInStringWithoutWhitespace {
    public static void main(String[] args){
        String data= "__hell yeah __ mother__fucker__";
        data = "__Hie__";
         data= "hell yeah __ r__fucker__";
        data= "Hello";
        char[] dataArray = data.toCharArray();
        int count = 0;
        for(int i = 0; i< dataArray.length ; i++){
            if(Character.isAlphabetic(dataArray[i])){
                if(i-1 >= 0 && i+1< dataArray.length && Character.isAlphabetic(dataArray[i - 1]) && Character.isAlphabetic(dataArray[i + 1])){
                    count++;
                }
            }
        }
        System.out.println("[+] Final Count : "+count);
        // Another way
        count = 0;
        for(int i = 0; i< dataArray.length ; i++){
            if(!Character.isAlphabetic(dataArray[i])){
                continue;
            }
            boolean illCharBeforeCHar = (i < dataArray.length-1) && (!Character.isAlphabetic(dataArray[i+1]));
            boolean illCharAfterCHar = (i >0) && (!Character.isAlphabetic(dataArray[i-1]));

            if(!illCharBeforeCHar && !illCharAfterCHar){
                count++;
            }
        }


        System.out.println("[+] Final Count New: "+count);
    }
}