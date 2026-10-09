package SDETCodingRoundPrep2026;

public class Question22 {
    public static void main(String[] args) {
        int a[] = {16, 17, 4, 3, 5, 2};
        int max_right = a[a.length-1];
        System.out.println(max_right);
        for(int index=a.length-2; index>0; index--){
            if(a[index] > max_right){
                max_right = a[index];
                System.out.println(max_right);
            }
        }
    }
}
