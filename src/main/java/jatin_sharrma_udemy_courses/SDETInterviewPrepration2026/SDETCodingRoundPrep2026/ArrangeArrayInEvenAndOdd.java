package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;
// ## Pending
public class ArrangeArrayInEvenAndOdd {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4, 1, 5};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while ((left < right) && (arr[left] % 2 == 0)) {
                left++;
            }
            while ((left < right) && (arr[right] % 2 != 0)) {
                right--;
            }
            if(left < right){
                int temp =arr[left];
                arr[left] = arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
