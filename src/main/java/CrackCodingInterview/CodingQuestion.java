package CrackCodingInterview;

import org.apache.commons.exec.util.StringUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CodingQuestion {
    /*Length of last word*/
    public static int LengthOfLastWord(String val){
        String arr[] = val.split("\\s+");
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-1].length();
    }
    /*Length of last word without using split*/
    public static int LengthOfLastWordWithoutSplit(String val){
        int count = 0;
        for(Character ch : val.toCharArray()){
            if(ch.toString().equals("\u0020")){
                count = 0;
            }else{
                count +=1;
            }
        }
        return count;
    }

    /* Reverse a string
    * Implement it using stack
    * */
    public static String reverseString(String str){
        String reverse = "";
        for(int i = str.length()-1; i>=0;i--){
            reverse += str.split("")[i];
        }
        return reverse;
    }

    /*Longest Common Prefix
    * 14. Longest Common Prefix
    * */
    public static String LongestCommonPrfix(ArrayList<String> arr){
        Collections.sort(arr);
        System.out.println(arr);
        ArrayList<String> refinedList = new ArrayList<String>();
        for(int j=1; j<arr.size();j++){
            for(int i = arr.get(0).length()-1; i >= 0; i--){
                if(arr.get(j).contains(arr.get(0).substring(0,i+1))){
                    refinedList.add(arr.get(0).substring(0,i+1));
                    break;
                }

            }
        }

        Collections.sort(refinedList);
        return refinedList.get(0);
    }

    /* Fizz Buzz
    * 412. Fizz Buzz
    * */
    public static ArrayList<String> fizzBuzzLogicImpl(int n){
        ArrayList<String> answerList = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5 ==0){
                answerList.add("Fuzz Buzz");
            } else if (i%3==0) {
                answerList.add("Fuzz");
            } else if (i%5==0) {
                answerList.add("Buzz");
            }else {
                answerList.add(String.valueOf(i));
            }
        }
        System.out.println(answerList);
        return answerList;
    }

    /*
    * 150. Evaluate Reverse Polish Notation
    * */
    public static boolean checkNumeric(String str){
        boolean res = false;
        try{
            Integer.parseInt(str);
            res = true;
        }catch(Exception e){
            res = false;
        }
        return res;
    }
    public static int reversePolishNotation(String[] arr){
        ArrayList<String> strLi = new ArrayList<String>();
        for (String ele : arr){
            if(checkNumeric(ele)){
                strLi.add(ele);
            }else{
                int val = 0;
                switch (ele){
                    case "+":
                        val = Integer.parseInt(strLi.get(strLi.size()-2))+ Integer.parseInt(strLi.get(strLi.size()-1));
                        break;
                    case "-":
                        val = Integer.parseInt(strLi.get(strLi.size()-2))- Integer.parseInt(strLi.get(strLi.size()-1));
                        break;
                    case "/":
                        val = Integer.parseInt(strLi.get(strLi.size()-2))/ Integer.parseInt(strLi.get(strLi.size()-1));
                        break;
                    case "*":
                        val = Integer.parseInt(strLi.get(strLi.size()-2))* Integer.parseInt(strLi.get(strLi.size()-1));
                        break;
                    default:
                        System.out.println("Invalid Operand : "+ ele);
                        break;
                }
                strLi.remove(strLi.size()-2);
                strLi.remove(strLi.size()-1);
                strLi.add(String.valueOf(val));
            }
        }
        System.out.println(strLi);
        return Integer.parseInt(strLi.get(0));
    }

    /*
    * 171. Excel Sheet Column Number
    */
    public static int ExcelSheetColumnNumber(String str){
        int TEMP_INTEGER = 64;
        int returnSum = 0;
        int power=0;
        for(int i = str.length()-1; i >= 0; i--){
//            int exp_power = (int) ((power == 0) ? (Math.pow(26,power)*0) : Math.pow(26,power));
            int exp_power = (int)Math.pow(26,power);
            System.out.println("-");
            System.out.println(exp_power);
            System.out.println(((int) str.toCharArray()[i])-TEMP_INTEGER);
            System.out.println("-");
            returnSum += (exp_power *(((int) str.toCharArray()[i])-TEMP_INTEGER));
            System.out.println("Return Sum : "+ returnSum);
            power+=1;
        }
        return returnSum;
    }

/*    125. Valid Palindrome*/
    public static boolean validPalindrome(String str){

        boolean res = true;
        str = str.replaceAll("[^A-Za-z]+","").toLowerCase();
        if(str.length()==0){
            return true;
        }
        int r = 0;
        for(int i = str.length()-1; i>=0; i--){
            if(Character.compare(str.charAt(i),str.charAt(r)) == 0){
                res =  res &&true;
            }else{
                res = res &&false;
            }
            r++;
        }
        return res;
    }
//    680. Valid Palindrome II
        /*
    public boolean palCheck(String str){
        boolean res = true;
        int r = 0;
        for(int i = str.length()-1; i>=0 ; i--){
            if(Character.compare(str.charAt(i), str.charAt(r))==0){
                res = res && true;
            }else{
                res = res && false;
            }
            r++;
        }
        return res;
    }
    */
public static boolean palCheck(ArrayList<String> str){
    ArrayList<String> arr = new ArrayList<String>(str);
    Collections.reverse(str);
    if(arr.equals(str)){
        return true;
    }else{
        return false;
    }
}
    public static boolean validPalindrome2(String s) {
    /*    boolean result = false;
        for(int i = s.length(); i>=0 ; i--){
            if( i == s.length()){
                if(palCheck(s)){
                    result = true;
                    break;
                }
            }else{
                String str2 = new StringBuilder(s).deleteCharAt(i).toString();
                if(palCheck(str2)){
                    result = true;
                    break;
                }
            }

        }
        return result;
        */
        boolean result = false;
        ArrayList<String> arr_str = new ArrayList<String>(Arrays.asList(s.split("")));
        if(palCheck(arr_str)){
            result = true;
        }else{
            for(int i=arr_str.size()-1; i >= 0; i--){
                arr_str = new ArrayList<String>(Arrays.asList(s.split("")));
                arr_str.remove(i);
                if(palCheck(arr_str)){
                    result = true;
                    break;
                }
            }
        }
        return result;

    }

    /*
    * 1047. Remove All Adjacent Duplicates
    * */

    public static String RemoveAdjunctCharacter(String str){
        boolean loop = true;
        while(loop){
            if(str.isEmpty() || str.length()==1){
                loop=false;
                break;
            }
            for(int i=1; i<str.length();i++)
            {

                if(Character.compare(str.charAt(i-1), str.charAt(i))==0){
                    int begain = i-1;
                    int end=i+1;
                    str = str.replaceAll(str.substring(begain,end),"");
                    loop = true;
                    break;
                }else{
                    loop = false;
                }
            }
        }
        return str;
    }

    /*
    * 1209. Remove All Adjacent Duplicates in String II
    * */
    public static String RemoveAdjunctCharacter(String s, int k){
        boolean loop = true;
        while(loop){
            for(int i=0;i<s.length();i++){
                for(int j=0; j<k;j++){
                    boolean strFlag= false;

                }
            }
        }
        return "";
    }
    public static void main(String[] args){
        /*
        Assert.assertEquals(5,LengthOfLastWord("Hello World"));
        Assert.assertEquals(5,LengthOfLastWordWithoutSplit("Hello World"));
        Assert.assertEquals("olleh",reverseString("hello"));
        Assert.assertEquals("a",reverseString("a"));
        Assert.assertEquals("kcorb",reverseString("brock"));
        ArrayList<String> arrLi = new ArrayList<String>();
        arrLi.add("GeeksforGeeks");
        arrLi.add("Geeks");
        arrLi.add("Geekzer");
        Assert.assertEquals("Geek",LongestCommonPrfix(arrLi));
        arrLi = new ArrayList<String>();
        arrLi.add("flower");
        arrLi.add("flokal");
        arrLi.add("flghol");
        Assert.assertEquals("fl",LongestCommonPrfix(arrLi));
        arrLi = new ArrayList<String>();
        arrLi.add("abcdef");
        arrLi.add("aghi");
        arrLi.add("avfkl");
        Assert.assertEquals("a",LongestCommonPrfix(arrLi));
        fizzBuzzLogicImpl(15);
        String[] arr = {"2","1","+","3","*"};
        Assert.assertEquals(9,reversePolishNotation(arr));
        String[] arr2 = {"4","13","5","/","+"};
        Assert.assertEquals(6,reversePolishNotation(arr2));
        String[] arr3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Assert.assertEquals(22,reversePolishNotation(arr3));
        Assert.assertEquals(1,ExcelSheetColumnNumber("A"));
        Assert.assertEquals(28,ExcelSheetColumnNumber("AB"));
        Assert.assertEquals(701,ExcelSheetColumnNumber("ZY"));
        Assert.assertTrue(validPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(validPalindrome("race a car"));
        Assert.assertTrue(validPalindrome(" "));
        validPalindrome2("abca");
        */
        Assert.assertEquals(RemoveAdjunctCharacter("abbaca"),"ca");
        Assert.assertEquals(RemoveAdjunctCharacter("azxxzy"),"ay");
        Assert.assertEquals(RemoveAdjunctCharacter("aaaaaaaaa"),"a");
        // s = "deeedbbcccbdaa", k = 3


    }
}
