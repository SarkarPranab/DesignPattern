package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: TRANSPOSE OF A 2D MATRIX (LEETCODE 867)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a 2D integer array `matrix`, return the transpose of `matrix`.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 * Formally, `transpose[j][i] = matrix[i][j]`.
 *
 * Note:
 * - For a matrix of dimensions `R x C`, its transpose will have dimensions `C x R`.
 * - If the matrix is square (`R == C`), the transpose can also be performed in-place.
 *
 * EXAMPLES:
 * Example 1 (Square Matrix 3x3):
 *   Input:  matrix = [[1, 4, 2],
 *                     [3, 6, 8],
 *                     [8, 12, 11]]
 *   Output: [[1, 3, 8],
 *            [4, 6, 12],
 *            [2, 8, 11]]
 *
 * Example 2 (Rectangular Matrix 2x3):
 *   Input:  matrix = [[1, 2, 3],
 *                     [4, 5, 6]]
 *   Output: [[1, 4],
 *            [2, 5],
 *            [3, 6]]
 *
 * CONSTRAINTS:
 * - 1 <= R, C <= 1000
 * - 1 <= R * C <= 10^5
 * - -10^9 <= matrix[i][j] <= 10^9
 * - Handles null and empty matrices safely by returning an empty or null matrix.
 * ============================================================================
 */
public class TransposeMatrix {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Out-of-Place Matrix Allocation (Supports RxC Rectangular & Square Matrices)
     *
     * @implNote Determine `R = matrix.length` and `C = matrix[0].length`.
     *           Allocate new array `transpose[C][R]`. Fill using `transpose[j][i] = matrix[i][j]`.
     * @targetTimeComplexity O(R * C)
     * @targetSpaceComplexity O(R * C) for new transposed matrix space
     */
    public int[][] transposeNewMatrix(int[][] matrix) {
        // TODO: Write solution here
        return new int[0][0];
    }

    /**
     * Approach 2: In-Place Diagonal Swap (Square Matrices NxN Only)
     *
     * @implNote Iterate `i` from 0 to `N - 1` and `j` from `i + 1` to `N - 1`.
     *           Swap `matrix[i][j]` with `matrix[j][i]` directly without allocating extra space.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1) auxiliary space (In-place)
     */
    public int[][] transposeInPlaceSquareOnly(int[][] matrix) {
        // TODO: Write in-place swap solution here for square matrices
        return matrix;
    }

    /**
     * Approach 3: Stream API Row-Column Mapping
     *
     * @implNote Use `IntStream.range(0, C)` to stream column indices and map each
     *           column `j` to a new row formed by streaming row indices `IntStream.range(0, R)`.
     * @targetTimeComplexity O(R * C)
     * @targetSpaceComplexity O(R * C)
     */
    public int[][] transposeStream(int[][] matrix) {
        // TODO: Write functional stream solution here
        return new int[0][0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[][] input;
        private final int[][] expected;
        private final String description;

        public TestCase(int id, int[][] input, int[][] expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[][] getInput() { return input; }
        public int[][] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        TransposeMatrix solver = new TransposeMatrix();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[][]{{1, 4, 2}, {3, 6, 8}, {8, 12, 11}},
                        new int[][]{{1, 3, 8}, {4, 6, 12}, {2, 8, 11}}, "Square Matrix 3x3"),
                new TestCase(2, new int[][]{{1, 2, 3}, {4, 5, 6}},
                        new int[][]{{1, 4}, {2, 5}, {3, 6}}, "Rectangular Matrix 2x3"),
                new TestCase(3, new int[][]{{1, 2}, {3, 4}, {5, 6}},
                        new int[][]{{1, 3, 5}, {2, 4, 6}}, "Rectangular Matrix 3x2"),
                new TestCase(4, new int[][]{{5}}, new int[][]{{5}}, "Single Element 1x1 Matrix"),
                new TestCase(5, new int[][]{}, new int[][]{}, "Empty Matrix"),
                new TestCase(6, null, null, "Null Input Matrix Safety Check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: TRANSPOSE MATRIX (LEETCODE 867)");
        System.out.println("================================================================================");

        runApproach("1. Out-of-Place Matrix Allocation (RxC)", solver::transposeNewMatrix, testCases);
        runApproach("2. Stream API Row-Column Mapping", solver::transposeStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected 2D matrix content, and logs execution timing.
     */
    private static void runApproach(String name, Function<int[][], int[][]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[][] workingMatrix = copyMatrix(tc.getInput());

            long startTime = System.nanoTime();
            int[][] result = method.apply(workingMatrix);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = compareMatrices(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", Arrays.deepToString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", Arrays.deepToString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[][] copyMatrix(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0][0];
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }

    private static boolean compareMatrices(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null) return m1 == m2;
        return Arrays.deepEquals(m1, m2);
    }
}