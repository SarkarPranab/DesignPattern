package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

import java.util.Arrays;

public class Question14
{
    public static void main(String[] args) {
        int a[] = {1,0,2,0,4,3,5};
        int left = 0;
        int right = a.length-1;
        while (left < right){
            while (left < right && a[left]%2 == 0){
                left++;
            }
            while (left < right && a[right]%2 !=0){
                right--;
            }
            if(left < right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(a));

        int evenEnd = 0;
        while(evenEnd < a.length && a[evenEnd] %2 == 0){
            evenEnd++;
        }
        Arrays.sort(a,0, evenEnd);
        Arrays.sort(a,evenEnd, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}