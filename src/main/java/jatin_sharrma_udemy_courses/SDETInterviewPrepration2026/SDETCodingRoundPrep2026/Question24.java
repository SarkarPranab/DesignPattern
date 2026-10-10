package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;

public class Question24 {

    public static void main(String[] args){
        int[] a = {-10,-3,5,6,-20};
//        int[] a = {5,2,4,0,7};
        Arrays.sort(a);
        int max_product_1 = a[a.length-1]*a[0]*a[1];
        int max_product_2 = a[a.length-1]*a[a.length-2]*a[a.length-3];
        System.out.println(Arrays.toString(a));
        if(max_product_1>max_product_2){
            System.out.println("[+] Max Product is : "+ max_product_1);
        }else {
            System.out.println("[+] Max Product is : "+ max_product_2);
        }
    }
}
