package SDETCodingRoundPrep2026;

import java.util.Arrays;

public class Question17 {
    public static int[] reverse(int[] a, int first, int last) {
        int left = first;
        int right = last;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return a;
    }

    public static void rotateArrayInRightDirection(int[] a, int k) {
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    public static void rotateArrayInLeftDirection(int[] a, int k){
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);
        reverse(a,0,a.length-1);
    }
    public static void main(String[] args) {
        int k = 2;
        int[] a = {1, 2, 3, 4, 5}; // -> 5,1,2,3,4 --> 4,5,1,2,3
//        rotateArrayInRightDirection(a, k);
        rotateArrayInLeftDirection(a,k);
        System.out.println(Arrays.toString(a));
    }
}
