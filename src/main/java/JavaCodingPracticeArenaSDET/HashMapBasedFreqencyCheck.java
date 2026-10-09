package JavaCodingPracticeArenaSDET;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: FREQUENCY COUNTING (WORDS IN SENTENCE & CHARACTERS IN STRING)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Implement frequency counting for two common interview scenarios:
 *
 * PART 1 - Word Frequency in Sentence:
 * Given a sentence string, count the frequency of each word.
 * - Ignore case (convert words to lowercase).
 * - Remove all non-alphabetic characters/punctuation attached to words.
 * - Ignore empty tokens resulting from spaces or punctuation.
 *
 * PART 2 - Character Frequency in String:
 * Given a word/string, count the frequency of each character (case-sensitive).
 *
 * EXAMPLES:
 * Example 1 (Word Frequency):
 *   Input:  "Hey there! Hey, how are you?"
 *   Output: {"hey": 2, "there": 1, "how": 1, "are": 1, "you": 1}
 *
 * Example 2 (Char Frequency):
 *   Input:  "hello"
 *   Output: {'h': 1, 'e': 1, 'l': 2, 'o': 1}
 *
 * CONSTRAINTS:
 * - 0 <= string length <= 10^6
 * - Handles null and empty string inputs safely by returning an empty map.
 * ============================================================================
 */
public class HashMapBasedFreqencyCheck {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    // --- PART 1: WORD FREQUENCY IN SENTENCE ---

    /**
     * Approach 1A: Word Frequency via Iterative HashMap & Regex Cleanup
     *
     * @implNote Split by `\\s+`, clean non-alphabetic chars using `replaceAll("[^a-zA-Z]", "")`,
     *           convert to lowercase, and populate `HashMap` using `getOrDefault()`.
     * @targetTimeComplexity O(N) where N is string length
     * @targetSpaceComplexity O(W) where W is number of unique words
     */
    public Map<String, Integer> countWordFrequencyIterative(String sentence) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    /**
     * Approach 1B: Word Frequency via Java Stream & Collectors.groupingBy
     *
     * @implNote Use `Arrays.stream(sentence.split("\\s+"))`, filter out blank tokens after
     *           cleaning, and collect using `Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1))`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(W)
     */
    public Map<String, Integer> countWordFrequencyStream(String sentence) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    // --- PART 2: CHARACTER FREQUENCY IN STRING ---

    /**
     * Approach 2A: Character Frequency via Iterative HashMap Loop
     *
     * @implNote Convert string to char array, iterate, and build frequency map
     *           using `map.put(c, map.getOrDefault(c, 0) + 1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K is unique character set size (max 256 for ASCII)
     */
    public Map<Character, Integer> countCharFrequencyIterative(String str) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    /**
     * Approach 2B: Character Frequency via Java IntStream & Collectors
     *
     * @implNote Use `str.chars().mapToObj(c -> (char) c)`, collect using
     *           `Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1))`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K)
     */
    public Map<Character, Integer> countCharFrequencyStream(String str) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class WordTestCase {
        private final int id;
        private final String sentence;
        private final Map<String, Integer> expected;
        private final String description;

        public WordTestCase(int id, String sentence, Map<String, Integer> expected, String description) {
            this.id = id;
            this.sentence = sentence;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getSentence() { return sentence; }
        public Map<String, Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    static class CharTestCase {
        private final int id;
        private final String str;
        private final Map<Character, Integer> expected;
        private final String description;

        public CharTestCase(int id, String str, Map<Character, Integer> expected, String description) {
            this.id = id;
            this.str = str;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getStr() { return str; }
        public Map<Character, Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        HashMapBasedFreqencyCheck solver = new HashMapBasedFreqencyCheck();

        // Word Frequency Test Cases
        Map<String, Integer> wordExpected1 = new HashMap<>();
        wordExpected1.put("hey", 2);
        wordExpected1.put("there", 1);
        wordExpected1.put("how", 2);
        wordExpected1.put("are", 3);
        wordExpected1.put("you", 4);
        wordExpected1.put("doing", 1);
        wordExpected1.put("whats", 1);
        wordExpected1.put("phone", 1);
        wordExpected1.put("number", 1);
        wordExpected1.put("married", 1);
        wordExpected1.put("your", 1);
        wordExpected1.put("parents", 1);

        WordTestCase[] wordTestCases = new WordTestCase[]{
                new WordTestCase(1, "Hey there how are you doing. Hey whats you you phone number. are you married? How are your parents.", wordExpected1, "Full multi-sentence text with punctuation"),
                new WordTestCase(2, "   ", Collections.emptyMap(), "Whitespace only string"),
                new WordTestCase(3, null, Collections.emptyMap(), "Null input check"),
                new WordTestCase(4, "Java 123 Java!! JAVA??", createMap(new String[]{"java", "java", "java"}, new Integer[]{1, 1, 1}), "Punctuation and duplicate case normalization")
        };

        // Character Frequency Test Cases
        Map<Character, Integer> charExpected1 = new HashMap<>();
        charExpected1.put('h', 1);
        charExpected1.put('e', 1);
        charExpected1.put('l', 2);
        charExpected1.put('o', 1);

        CharTestCase[] charTestCases = new CharTestCase[]{
                new CharTestCase(1, "hello", charExpected1, "Standard lowercase word"),
                new CharTestCase(2, "AabB", createCharMap(new char[]{'A', 'a', 'b', 'B'}, new int[]{1, 1, 1, 1}), "Case sensitive character count"),
                new CharTestCase(3, "", Collections.emptyMap(), "Empty string"),
                new CharTestCase(4, null, Collections.emptyMap(), "Null safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: HASHMAP BASED FREQUENCY CHECK");
        System.out.println("================================================================================");

        System.out.println("\n>>> PART 1: WORD FREQUENCY IN SENTENCE <<<");
        runWordApproach("1A. Iterative HashMap (Word)", solver::countWordFrequencyIterative, wordTestCases);
        runWordApproach("1B. Stream & Collectors (Word)", solver::countWordFrequencyStream, wordTestCases);

        System.out.println("\n>>> PART 2: CHARACTER FREQUENCY IN STRING <<<");
        runCharApproach("2A. Iterative HashMap (Char)", solver::countCharFrequencyIterative, charTestCases);
        runCharApproach("2B. Stream & Collectors (Char)", solver::countCharFrequencyStream, charTestCases);
    }

    private static void runWordApproach(String name, Function<String, Map<String, Integer>> method, WordTestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (WordTestCase tc : testCases) {
            long startTime = System.nanoTime();
            Map<String, Integer> result = method.apply(tc.getSentence());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: %s | Got: %s\n",
                        tc.getId(), tc.getDescription(), tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static void runCharApproach(String name, Function<String, Map<Character, Integer>> method, CharTestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (CharTestCase tc : testCases) {
            long startTime = System.nanoTime();
            Map<Character, Integer> result = method.apply(tc.getStr());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: %s | Got: %s\n",
                        tc.getId(), tc.getDescription(), tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static Map<String, Integer> createMap(String[] keys, Integer[] values) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], map.getOrDefault(keys[i], 0) + values[i]);
        }
        return map;
    }

    private static Map<Character, Integer> createCharMap(char[] keys, int[] values) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}