package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;

public class Question18 {
    public static int[] reverse(int[] a, int left, int right){
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int n = 3;
//        Better to calculate K (very important)
        int k = n % a.length;
        int left = 0;
        int right = a.length-1;
        reverse(a, left, right);
        reverse(a, left, k-1);
        reverse(a, k, right);
        System.out.println(Arrays.toString(a));
    }
}