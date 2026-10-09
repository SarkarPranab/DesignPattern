package SDETCodingRoundPrep2026;

import java.util.Arrays;

public class Question15 {
    public static void main(String[] args){
        int a[] = {4,5,10,3,7,11};
        int sum = Arrays.stream(a).sum();
        System.out.println("[+] Sum : "+ sum);
        int mid = a.length/2;
        int left = 0;
        int right = mid - 1;
        int temp;
        // Reverse first half of this array
        while (left<right){
            temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
        System.out.println("[+] Reverse first half of array : "+ Arrays.toString(a));
        // reverse second half of this array
        left = mid;
        right = a.length-1;
        while (left<right){
            temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
        System.out.println("[+] Reverse second half of array : "+ Arrays.toString(a));
        System.out.println("[+] Largest number : "+ Arrays.stream(a).sorted().toArray()[a.length-1]);
        System.out.println("[+] Second Largest number : "+ Arrays.stream(a).sorted().toArray()[a.length-2]);

    }
}
