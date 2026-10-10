package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026;

public class Question21 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 3, 1, 0};
        if (a.length < 3) {
            System.out.println("[+] Not mountain array");
        }
        int i = 0;
        while (a[i] < a[i + 1]) {
            i++;
        }
        while (i+1 < a.length && a[i] > a[i + 1]) {
            i++;
        }
        if (i == a.length-1){
            System.out.println("[+] Mountain array");
        }else{
            System.out.println("[+] Not Mountain array");
        }

    }
}