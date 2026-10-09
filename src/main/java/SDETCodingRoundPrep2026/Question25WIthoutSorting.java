package SDETCodingRoundPrep2026;

public class Question25WIthoutSorting {
//Without Sorting
    public static void main(String[] args){
//        int[] a = {7,3,2,5};
        int[] a = {-10,-3,5,6,-20};

//        int[] a = {5,2,4,0,7};

       int max1 = 0,max2 = 0,max3 = 0;
       int min1 = 0, min2 = 0;
       for(int n : a){
           if(n> max1){
               max3 = max2;
               max2 = max1;
               max1 = n;
           }else if(n> max2){
               max3 = max2;
               max2 = n;
           }else if(n> max3){
               max3 = n;
           }

           if(n < min1){
               min2 = min1;
               min1 = n;
           } else if (n < min2) {
               min2 = n;
           }
       }
       
       int result1 = max1 * max2 * max3;
       int result2 = min1 * min2 * max1;

        System.out.println(Math.max(result1, result2));
    }
}
