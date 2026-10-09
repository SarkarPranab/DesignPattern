package SDETCodingRoundPrep2026;

import java.util.Arrays;

public class TransposeMatrix {
    public static void transposeMatrix(int[][] arr2d) {
        // if a is equal to null
        if (arr2d == null || arr2d.length == 0 || arr2d[0].length == 0) {
            System.out.println("Transpose is not possible with given array.");
        } else {
            int[][] reverse = new int[arr2d[0].length][arr2d.length];
            for (int i = 0; i < arr2d.length; i++) {
                for (int j = 0; j < arr2d[i].length; j++) {
                    reverse[j][i] = arr2d[i][j];
                }
            }
            System.out.println("[+] Print transpose matrix ");
            for (int i = 0; i < reverse.length; i++) {
                for (int j = 0; j < reverse[i].length; j++) {
                    System.out.print(reverse[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    public static void main(String args[]) {
        int[][] myNumbers = {{1, 4, 2}, {3, 6, 8}, {8, 12, 11}};
        transposeMatrix(myNumbers);
    }
}
