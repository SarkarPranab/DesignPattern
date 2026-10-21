package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-18: COUNT VOWELS AND CONSONANTS IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, count the total number of vowels and consonants in it.
 * Non-alphabetic characters (digits, spaces, special characters, symbols)
 * must be ignored.
 *
 * Vowels: 'a', 'e', 'i', 'o', 'u' (case-insensitive)
 * Consonants: Any alphabetic character that is not a vowel.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "Hello World!"
 *   Output: Vowels = 3, Consonants = 7
 *
 * Example 2:
 *   Input:  s = "Java 123"
 *   Output: Vowels = 2, Consonants = 2
 *
 * CONSTRAINTS:
 * - 0 <= s.length <= 10^5
 * - Handles null and empty strings safely (returns counts as [0, 0]).
 * ============================================================================
 */
public class CountVowelsAndConsonants {

    /**
     * Immutable data carrier class for holding vowel and consonant counts.
     */
    public static class VowelConsonantResult {
        private final int vowels;
        private final int consonants;

        public VowelConsonantResult(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        public int getVowels() { return vowels; }
        public int getConsonants() { return consonants; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VowelConsonantResult that = (VowelConsonantResult) o;
            return vowels == that.vowels && consonants == that.consonants;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vowels, consonants);
        }

        @Override
        public String toString() {
            return String.format("Result{Vowels=%d, Consonants=%d}", vowels, consonants);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Single Pass Iterative Character Inspection
     *
     * @implNote Iterate through `s.toCharArray()`. Check `Character.isLetter(ch)`.
     *           Convert to lowercase and evaluate against set/switch of vowels
     *           ('a', 'e', 'i', 'o', 'u') to increment respective counters.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public VowelConsonantResult countIterative(String s) {
        // TODO: Write solution here
        return new VowelConsonantResult(0, 0);
    }

    /**
     * Approach 2: Functional Streams API filtering
     *
     * @implNote Use `s.chars()` pipeline. Filter alphabetic characters, then partition
     *           or count vowels vs consonants using lambda predicates.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public VowelConsonantResult countStreamAPI(String s) {
        // TODO: Write solution here
        return new VowelConsonantResult(0, 0);
    }

    /**
     * Approach 3: Boolean Lookup Array / Bitmask Buffer
     *
     * @implNote Use an ASCII boolean lookup array `isVowel[128]` for $O(1)$ constant-time
     *           vowel identification during character iteration.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed lookup table
     */
    public VowelConsonantResult countLookupTable(String s) {
        // TODO: Write solution here
        return new VowelConsonantResult(0, 0);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final VowelConsonantResult expected;
        private final String description;

        public TestCase(int id, String input, VowelConsonantResult expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public VowelConsonantResult getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CountVowelsAndConsonants solver = new CountVowelsAndConsonants();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello World!", new VowelConsonantResult(3, 7), "Standard phrase with punctuation"),
                new TestCase(2, "Java 123", new VowelConsonantResult(2, 2), "Mixed alphanumeric input"),
                new TestCase(3, "AEIOU aeiou", new VowelConsonantResult(10, 0), "All vowels uppercase and lowercase"),
                new TestCase(4, "bcdfghjklmnpqrstvwxyz", new VowelConsonantResult(0, 21), "All consonants"),
                new TestCase(5, "1234567890 !@#$%^&*()", new VowelConsonantResult(0, 0), "No letters present"),
                new TestCase(6, "", new VowelConsonantResult(0, 0), "Empty string check"),
                new TestCase(7, null, new VowelConsonantResult(0, 0), "Null string safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-18 COUNT VOWELS AND CONSONANTS");
        System.out.println("================================================================================");

        runApproach("1. Single Pass Iterative Character Inspection", solver::countIterative, testCases);
        runApproach("2. Functional Streams API", solver::countStreamAPI, testCases);
        runApproach("3. Boolean Lookup Array", solver::countLookupTable, testCases);
    }

    /**
     * Executes test cases, compares actual VowelConsonantResult against expected, and logs timing.
     */
    private static void runApproach(String name, Function<String, VowelConsonantResult> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            VowelConsonantResult result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}