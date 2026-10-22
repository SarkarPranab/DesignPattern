# Java Coding Practice Arena for SDET: Detailed Catalogue

Package: `JavaCodingPracticeArenaSDET`  |  Source: `src/main/java/JavaCodingPracticeArenaSDET/JavaCodingPracticeArenaSDET`

Generated from a fresh clone of the repository. Every class was compiled and its `main` was executed.

## 1. Health check

| Check | Result |
|---|---|
| Classes in package | 113 |
| Solution approaches across all classes | 304 |
| Whole package compiles (javac, Java 8 level) | ✅ Yes, no errors (Maven itself was not available to test) |
| Every class has `main` and a test harness | ✅ Yes |
| Class name matches file name, single package | ✅ Yes |
| Duplicate problem IDs | ✅ None |
| Classes listed in the prep table but missing from the repo | ❌ 5 (see section 2) |

### Practice progress (by class)

| Status | Classes |
|---|---|
| ⬜ not started | 106 |
| ✅ self-test passes (1 checks) | 4 |
| — (no approach list) | 3 |

Note: `HashMapBasedFreqencyCheck`, `ImplementQueueUsingStacks` and `ImplementStackUsingQueues` use a different Javadoc layout, so they show no approach list. They are still unsolved stubs.

Legend: ⬜ every method still has `TODO`. 🟡 some methods written, rest still `TODO`. ✅ all methods written and every test passes. ⚠️ a method has no `TODO` but a test fails, so check the logic.

## 2. Findings

1. **Five classes in the prep table do not exist in the repo.** They are marked "Covered" but have no file:
    - `ValidMountainArray.java` (Question 21: Check if an Array is Mountain array or not)
    - `SumOfArrayElements.java` (COD-01: Sum elements of an array)
    - `PyramidPatternPrinting.java` (COD-07: Program for printing Pyramid Pattern in Java)
    - `PrimeNumberChecker.java` (COD-08: Java logic to check if given number is Prime)
    - `MinAndMaxInMultiDimensionalArray.java` (COD-09: Print Min number and Max number in Multi-Dimensional Array)
      Either add them or fix the table. Closest existing files: `ArrayElementSumAndMetrics` (array sum).
2. **Shared classes.** Question 10 and 11 both map to `Find2ndLargestFromAlphaNumericString`, and Question 13A and 13B both map to `HashMapBasedFreqencyCheck`. This is fine if that class has both approaches, but the table should say so.
3. **Header styles differ.** The 28 course-question classes use `PROBLEM: <title>` with no ID, while the practice classes use `PROBLEM EXP-n` or `PROBLEM COD-n`. Not a bug, but IDs would make the catalogue easier to search.
4. **Overlapping problems.** `LongestSubstringWithoutRepeating` and `LongestSubstringWithoutRepeatingCharacters` are the same problem. `MaximumSubarray` and `MaximumSubarrayKadane` overlap. `RotateArray*` has four variants. Consider merging.
5. **`pom.xml` has conflicting compiler settings.** The properties say Java 1.7 (`maven.compiler.source/target`), while a `maven-compiler-plugin` block sets 8, and the plugin is declared twice (around lines 89 and 123). The code uses lambdas and streams, so it needs 8 or higher. Remove the 1.7 properties and the duplicate plugin block, or set both to 17 or 21.
6. **Many methods are still `TODO` by design.** Those classes are practice stubs, so test failures there are expected and are not defects.

## 3. Core course questions (Question 01 to 28)

| # | Problem | Class | Approaches | Solved | Status |
|---|---|---|---|---|---|
| Question 01 | Transpose a Matrix | `TransposeMatrix` | 3 | 0/3 | ⬜ not started |
| Question 02 | Find the Length of a String | `LengthofStringNodotLength` | 3 | 0/3 | ⬜ not started |
| Question 03 | Find the Length of a String without char array | `LengthOfStringWithoutCharArray` | 3 | 0/3 | ⬜ not started |
| Question 04 | Traverse a Linked List | `SinglyLinkedListTraversal` | 3 | 0/3 | ⬜ not started |
| Question 05 | Reverse a HashMap | `ReverseHashMap` | 3 | 0/3 | ⬜ not started |
| Question 06 | Remove duplicate from array using SET interface while preserving order | `RemoveDuplicatesFromArrayPreservingOrder` | 3 | 0/3 | ⬜ not started |
| Question 07 | Remove duplicate from array using java streams | `RemoveDuplicatesUsingStreams` | 3 | 0/3 | ⬜ not started |
| Question 08 | Get First word from String and reverse it then append it back | `ReverseFirstWordOfString` | 3 | 0/3 | ⬜ not started |
| Question 09 | Count Uppercase and lowercase character in a string | `CountUpperAndLowerCase` | 3 | 0/3 | ⬜ not started |
| Question 10 | Extract number from alphanumeric digit and find out second-largest number | `Find2ndLargestFromAlphaNumericString` | 3 | 0/3 | ⬜ not started |
| Question 11 | Extract number from alphanumeric digit and find out second-largest number Using Java Collections from last index | `Find2ndLargestFromAlphaNumericString` | 3 | 0/3 | ⬜ not started |
| Question 12 | Count the characters in a string where each character has only alphabets before and after it | `GetCharCountInStringWithoutWhitespace` | 3 | 0/3 | ⬜ not started |
| Question 13A | Count the frequency of words in a Sentence | `HashMapBasedFreqencyCheck` | - | - | — (no approach list) |
| Question 13B | Count the frequency of character in a string | `HashMapBasedFreqencyCheck` | - | - | — (no approach list) |
| Question 14 | Rearrange an array in such a way where even number come first followed by odd numbers both sorted in ascending order | `ArrangeArrayInEvenAndOdd` | 3 | 0/3 | ⬜ not started |
| Question 15 | Calculate the sum of integer from a sentence | `SumOfIntegerFromSentence` | 3 | 0/3 | ⬜ not started |
| Question 16 | From an integer array 1) Calculate sum 2) Largest & 2nd largest 3) Reverse 1st half | `SplitHalfArrayReversalAndMetrics` | 2 | 0/2 | ⬜ not started |
| Question 17 | Rotate an array | `RotateArrayByKPositions` | 3 | 0/3 | ⬜ not started |
| Question 18 | Rotate an array K times both clockwise and anti-clockwise | `RotateArrayClockwiseAndAntiClockwise` | 2 | 0/2 | ⬜ not started |
| Question 19 | Reverse the characters of the words in a string | `ReverseCharactersOfEachWord` | 3 | 0/3 | ⬜ not started |
| Question 20 | Reverse the characters of the words in a string using StringBuilder | `ReverseWordsUsingStringBuilder` | 3 | 0/3 | ⬜ not started |
| Question 21 | Check if an Array is Mountain array or not | `ValidMountainArray` (missing) | - | - | ❌ file missing |
| Question 22 | Find Leader number in array | `LeadersInAnArray` | 3 | 0/3 | ⬜ not started |
| Question 23 | Find unique characters in a string | `RemoveDuplicateCharactersPreserveOrder` | 3 | 0/3 | ⬜ not started |
| Question 24 | Find the Max Product of triplets in the Array | `MaximumProductOfThreeNumbers` | 3 | 0/3 | ⬜ not started |
| Question 25 | Find the Max Product of triplets in the Array without sorting | `MaximumProductOfThreeNumbersWithoutSorting` | 3 | 0/3 | ⬜ not started |
| Question 26 | Find Max Quantity in alphanumeric array where element is "str num" | `AggregateKeyValuesAndFindMax` | 3 | 0/3 | ⬜ not started |
| Question 27 | Encoding of String (Run-Length Encoding) | `StringRunLengthEncoding` | 3 | 0/3 | ⬜ not started |
| Question 28 | Decoding of String (Run-Length Decoding) | `DecodeRunLengthEncodedString` | 3 | 0/3 | ⬜ not started |

## 4. Additional practice arena questions (COD-01 to COD-21)

| # | Problem | Class | Approaches | Solved | Status |
|---|---|---|---|---|---|
| COD-01 | Sum elements of an array | `SumOfArrayElements` (missing) | - | - | ❌ file missing |
| COD-02 | Print multiplication table without using `*` multiply operator | `MultiplicationTableWithoutMultiply` | 3 | 0/3 | ⬜ not started |
| COD-03 | Max difference between any adjacent index in array | `MaxAdjacentDifferenceInArray` | 3 | 0/3 | ⬜ not started |
| COD-04 | Compare same indexes of 2 different arrays and create new array for match values | `CompareArrayIndicesAndExtractMatches` | 3 | 0/3 | ⬜ not started |
| COD-05 | Sort array in Ascending and Descending order | `SortArrayAscendingAndDescending` | 3 | 0/3 | ⬜ not started |
| COD-06 | Swap two variables with and without using temp variable | `SwapTwoVariables` | 4 | 0/4 | ⬜ not started |
| COD-07 | Program for printing Pyramid Pattern in Java | `PyramidPatternPrinting` (missing) | - | - | ❌ file missing |
| COD-08 | Java logic to check if given number is Prime | `PrimeNumberChecker` (missing) | - | - | ❌ file missing |
| COD-09 | Print Min number and Max number in Multi-Dimensional Array | `MinAndMaxInMultiDimensionalArray` (missing) | - | - | ❌ file missing |
| COD-10 | Reverse the String / Palindrome check without using predefined reverse methods | `ReverseStringAndPalindrome` | 3 | 0/3 | ⬜ not started |
| COD-11 | Count the occurrences of a given character in a String | `CountCharacterOccurrences` | 3 | 0/3 | ⬜ not started |
| COD-12 | Print Fibonacci Series up to N terms | `FibonacciSeriesGenerator` | 3 | 0/3 | ⬜ not started |
| COD-13 | Find Factorial of a Number | `FactorialCalculator` | 3 | 0/3 | ⬜ not started |
| COD-14 | Length of last word | `LengthOfLastWord` | 3 | 0/3 | ⬜ not started |
| COD-15 | Longest Common Prefix | `LongestCommonPrefix` | 3 | 0/3 | ⬜ not started |
| COD-16 | Fizz Buzz logic implementation | `FizzBuzzImplementation` | 3 | 0/3 | ⬜ not started |
| COD-17 | Evaluate Reverse Polish Notation | `EvaluateReversePolishNotation` | 3 | 0/3 | ⬜ not started |
| COD-18 | Excel Sheet Column Number | `ExcelSheetColumnNumber` | 3 | 0/3 | ⬜ not started |
| COD-19 | Valid Palindrome II (Delete at most one character) | `ValidPalindromeII` | 3 | 0/3 | ⬜ not started |
| COD-20 | Remove All Adjacent Duplicates in String | `RemoveAllAdjacentDuplicates` | 3 | 0/3 | ⬜ not started |
| COD-21 | Remove All Adjacent Duplicates in String II (K Adjacent) | `RemoveAllAdjacentDuplicatesII` | 3 | 0/3 | ⬜ not started |

## 5. Extra problems in the repo (EXP series and others)

| ID | Problem | Class | Approaches | Solved | Status |
|---|---|---|---|---|---|
| EXP-01 | ANAGRAM CHECK | `AnagramCheck` | 3 | 0/3 | ⬜ not started |
| COD-01 | ARRAY ELEMENT SUM AND METRICS | `ArrayElementSumAndMetrics` | 3 | 0/3 | ⬜ not started |
| EXP-02 | FIRST NON-REPEATING CHARACTER | `FirstNonRepeatingCharacter` | 3 | 0/3 | ⬜ not started |
| EXP-03 | LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS | `LongestSubstringWithoutRepeating` | 3 | 0/3 | ⬜ not started |
| EXP-04 | VALID PARENTHESES | `ValidParentheses` | 3 | 0/3 | ⬜ not started |
| EXP-05 | TWO SUM | `TwoSum` | 3 | 0/3 | ⬜ not started |
| EXP-06 | MERGE TWO SORTED ARRAYS | `MergeSortedArrays` | 3 | 0/3 | ⬜ not started |
| EXP-07 | MOVE ZEROES TO END | `MoveZeroesToEnd` | 3 | 0/3 | ⬜ not started |
| EXP-08 | FIND THE MISSING NUMBER FROM 1 TO N | `FindMissingNumber` | 3 | 0/3 | ⬜ not started |
| EXP-09 | MAXIMUM SUBARRAY (KADANE'S ALGORITHM) | `MaximumSubarrayKadane` | 3 | 0/3 | ⬜ not started |
| EXP-10 | BINARY SEARCH | `BinarySearch` | 3 | 0/3 | ⬜ not started |
| EXP-11 | SORT LIST OF OBJECTS WITH COMPARATOR (EMPLOYEES BY SALARY) | `SortEmployeeList` | 3 | 0/3 | ⬜ not started |
| EXP-12 | GROUP EMPLOYEES BY DEPARTMENT USING STREAMS | `GroupEmployeesByDepartment` | 3 | 0/3 | ⬜ not started |
| EXP-13 | FIND DUPLICATES IN A LIST USING STREAMS | `FindDuplicatesStreams` | 3 | 0/3 | ⬜ not started |
| EXP-14 | REVERSE A LINKED LIST | `ReverseLinkedList` | 3 | 0/3 | ⬜ not started |
| EXP-15 | THREAD-SAFE SINGLETON | `ThreadSafeSingletonArena` | 4 | 0/4 | ⬜ not started |
| EXP-16 | PRINT ODD AND EVEN NUMBERS USING TWO THREADS | `PrintOddEvenThreads` | 3 | 0/3 | ⬜ not started |
| EXP-17 | CHECK WHETHER ONE STRING IS A ROTATION OF ANOTHER | `CheckStringRotation` | 3 | 0/3 | ⬜ not started |
| EXP-18 | COUNT VOWELS AND CONSONANTS IN A STRING | `CountVowelsAndConsonants` | 3 | 0/3 | ⬜ not started |
| EXP-19 | REMOVE ALL WHITE SPACES FROM A STRING | `RemoveWhiteSpaces` | 3 | 0/3 | ⬜ not started |
| EXP-20 | CHECK IF A STRING CONTAINS ONLY DIGITS | `CheckStringOnlyDigits` | 3 | 0/3 | ⬜ not started |
| EXP-22 | CHECK IF A STRING IS ANAGRAM OF ANOTHER | `ValidAnagram` | 3 | 0/3 | ⬜ not started |
| EXP-23 | REVERSE WORDS IN A STRING | `ReverseWordsInString` | 3 | 0/3 | ⬜ not started |
| EXP-25 | LONGEST PALINDROMIC SUBSTRING | `LongestPalindromicSubstring` | 3 | 0/3 | ⬜ not started |
| EXP-27 | IMPLEMENT QUEUE USING STACKS | `ImplementQueueUsingStacks` | - | - | — (no approach list) |
| EXP-28 | IMPLEMENT STACK USING QUEUES | `ImplementStackUsingQueues` | - | - | — (no approach list) |
| EXP-29 | MERGE TWO SORTED LISTS | `MergeTwoSortedLists` | 2 | 0/2 | ⬜ not started |
| EXP-30 | DETECT CYCLE IN A LINKED LIST | `DetectLinkedListCycle` | 3 | 0/3 | ⬜ not started |
| EXP-31 | PALINDROME LINKED LIST | `PalindromeLinkedList` | 3 | 0/3 | ⬜ not started |
| EXP-32 | INTERSECTION OF TWO LINKED LISTS | `IntersectionOfTwoLinkedLists` | 3 | 0/3 | ⬜ not started |
| EXP-34 | REMOVE NTH NODE FROM END OF LIST | `RemoveNthNodeFromEndOfList` | 2 | 0/2 | ⬜ not started |
| EXP-35 | ADD TWO NUMBERS | `AddTwoNumbers` | 2 | 0/2 | ⬜ not started |
| EXP-36 | SWAP NODES IN PAIRS | `SwapNodesInPairs` | 2 | 0/2 | ⬜ not started |
| EXP-37 | REVERSE NODES IN K-GROUP | `ReverseNodesInKGroup` | 2 | 0/2 | ⬜ not started |
| EXP-38 | COPY LIST WITH RANDOM POINTER | `CopyListWithRandomPointer` | 2 | 0/2 | ⬜ not started |
| EXP-40 | LRU CACHE | `LRUCache` | - | - | ✅ self-test passes (1 checks) |
| EXP-41 | LFU CACHE | `LFUCache` | - | - | ✅ self-test passes (1 checks) |
| EXP-42 | DESIGN CIRCULAR QUEUE | `DesignCircularQueue` | - | - | ✅ self-test passes (1 checks) |
| EXP-43 | DESIGN CIRCULAR DEQUE | `DesignCircularDeque` | - | - | ✅ self-test passes (1 checks) |
| EXP-44 | SLIDING WINDOW MAXIMUM | `SlidingWindowMaximum` | 3 | 0/3 | ⬜ not started |
| EXP-45 | MINIMUM WINDOW SUBSTRING | `MinimumWindowSubstring` | 2 | 0/2 | ⬜ not started |
| EXP-46 | LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS | `LongestSubstringWithoutRepeatingCharacters` | 2 | 0/2 | ⬜ not started |
| EXP-47 | LONGEST REPEATING CHARACTER REPLACEMENT | `LongestRepeatingCharacterReplacement` | 2 | 0/2 | ⬜ not started |
| EXP-48 | PERMUTATION IN STRING | `PermutationInString` | 2 | 0/2 | ⬜ not started |
| EXP-49 | FIND ALL ANAGRAMS IN A STRING | `FindAllAnagramsInAString` | 2 | 0/2 | ⬜ not started |
| EXP-50 | MINIMUM SIZE SUBARRAY SUM | `MinimumSizeSubarraySum` | 2 | 0/2 | ⬜ not started |
| EXP-51 | MAXIMUM SUBARRAY | `MaximumSubarray` | 3 | 0/3 | ⬜ not started |
| EXP-52 | MAXIMUM PRODUCT SUBARRAY | `MaximumProductSubarray` | 2 | 0/2 | ⬜ not started |
| EXP-53 | PRODUCT OF ARRAY EXCEPT SELF | `ProductOfArrayExceptSelf` | 2 | 0/2 | ⬜ not started |
| EXP-54 | FIRST MISSING POSITIVE | `FirstMissingPositive` | 2 | 0/2 | ⬜ not started |
| EXP-55 | TRAPPING RAIN WATER | `TrappingRainWater` | 3 | 0/3 | ⬜ not started |
| EXP-56 | BEST TIME TO BUY AND SELL STOCK | `BestTimeToBuyAndSellStock` | 3 | 0/3 | ⬜ not started |
| EXP-57 | MAJORITY ELEMENT | `MajorityElement` | 3 | 0/3 | ⬜ not started |
| EXP-58 | KTH LARGEST ELEMENT IN AN ARRAY | `KthLargestElement` | 3 | 0/3 | ⬜ not started |
| EXP-59 | SUBARRAY SUM EQUALS K | `SubarraySumEqualsK` | 3 | 0/3 | ⬜ not started |
| EXP-60 | CONTAINS DUPLICATE | `ContainsDuplicate` | 4 | 0/4 | ⬜ not started |
| EXP-61 | FIND THE DUPLICATE NUMBER | `FindTheDuplicateNumber` | 4 | 0/4 | ⬜ not started |
| EXP-62 | SORT COLORS (SORT 0s, 1s AND 2s) | `SortColors` | 3 | 0/3 | ⬜ not started |
| EXP-63 | HIGHEST SALARY PER DEPARTMENT (STREAMS) | `HighestSalaryPerDepartment` | 3 | 0/3 | ⬜ not started |
| EXP-64 | NTH HIGHEST DISTINCT SALARY | `NthHighestSalary` | 3 | 0/3 | ⬜ not started |
| EXP-65 | SORT A MAP BY VALUE | `SortMapByValue` | 3 | 0/3 | ⬜ not started |
| EXP-66 | REVERSE INTEGER (WITH OVERFLOW CHECK) | `ReverseInteger` | 3 | 0/3 | ⬜ not started |
| EXP-67 | PALINDROME NUMBER | `PalindromeNumber` | 3 | 0/3 | ⬜ not started |
| EXP-68 | GCD AND LCM OF TWO NUMBERS | `GcdAndLcm` | 3 | 0/3 | ⬜ not started |
| EXP-69 | ARMSTRONG NUMBER | `ArmstrongNumber` | 3 | 0/3 | ⬜ not started |
| EXP-70 | MIDDLE OF THE LINKED LIST | `MiddleOfLinkedList` | 3 | 0/3 | ⬜ not started |
| EXP-71 | ISOMORPHIC STRINGS | `IsomorphicStrings` | 3 | 0/3 | ⬜ not started |
| EXP-72 | INTERSECTION OF TWO ARRAYS | `IntersectionOfTwoArrays` | 3 | 0/3 | ⬜ not started |
| - | ROTATE ARRAY IN RIGHT AND LEFT DIRECTIONS BY K POSITIONS | `RotateArrayInRightAndLeftDirection` | 2 | 0/2 | ⬜ not started |
| - | ROTATE ARRAY TO RIGHT WITH MODULO K HANDLING (LEETCODE 189) | `RotateArrayWithModulo` | 3 | 0/3 | ⬜ not started |

## 6. Approach-by-approach detail

Target complexities are taken from each method's Javadoc.

### `ArrayElementSumAndMetrics`: ARRAY ELEMENT SUM AND METRICS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Standard Imperative For-Loop | O(N) | O(1) | ⬜ TODO |
| 2 | Enhanced For-Each Loop | O(N) | O(1) | ⬜ TODO |
| 3 | Java 8+ Arrays.stream().sum() (Declarative Style) | O(N) | O(1) | ⬜ TODO |

### `MultiplicationTableWithoutMultiply`: PRINT MULTIPLICATION TABLE WITHOUT MULTIPLY OPERATOR

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Repeated Addition Loop | O(limit) | O(limit) for output sequence | ⬜ TODO |
| 2 | Bitwise Bit-Shift Multiplication (Russian Peasant / Booth's Algorithm) | O(limit * log(limit)) | O(limit) | ⬜ TODO |
| 3 | Tail-Recursive Sequence Generator | O(limit) | O(limit) recursion stack depth | ⬜ TODO |

### `MaxAdjacentDifferenceInArray`: MAX DIFFERENCE BETWEEN ADJACENT INDICES IN ARRAY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Single Pass Linear Iteration (Math.abs) | O(N) | O(1) | ⬜ TODO |
| 2 | Bitwise Absolute Difference (Branchless Math) | O(N) | O(1) | ⬜ TODO |
| 3 | IntStream Range Mapping (Declarative Functional Style) | O(N) | O(1) | ⬜ TODO |

### `CompareArrayIndicesAndExtractMatches`: COMPARE SAME INDEXES OF 2 ARRAYS AND EXTRACT MATCHES

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Dynamic List Collector with Single Pass Iteration | O(min(N, M)) | O(K) where K is match count | ⬜ TODO |
| 2 | Two-Pass Fixed Primitive Array Buffer (Zero Auto-boxing) | O(min(N, M)) | O(K) avoiding wrapper object allocations | ⬜ TODO |
| 3 | IntStream Range Filtering (Declarative Stream Style) | O(min(N, M)) | O(K) | ⬜ TODO |

### `SortArrayAscendingAndDescending`: SORT ARRAY IN ASCENDING AND DESCENDING ORDER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Dual Dual Pivot Quicksort (`Arrays.sort` & Two-Pointer Inversion) | O(N log N) | O(N) | ⬜ TODO |
| 2 | Manual In-Place Algorithm Implementation | O(N log N) or O(N^2) | O(N) | ⬜ TODO |
| 3 | Java 8+ Streams & Boxed Collections | O(N log N) | O(N) | ⬜ TODO |

### `SwapTwoVariables`: SWAP TWO VARIABLES WITH AND WITHOUT TEMP VARIABLE

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Classical Temporary Variable Swap | O(1) | O(1) | ⬜ TODO |
| 2 | Arithmetic Addition & Subtraction (No Temp Variable) | O(1) | O(1) | ⬜ TODO |
| 3 | Bitwise XOR Operator (No Temp Variable) | O(1) | O(1) | ⬜ TODO |
| 4 | Single-Line Inline Expression Swap (No Temp Variable) | O(1) | O(1) | ⬜ TODO |

### `ReverseStringAndPalindrome`: REVERSE STRING AND PALINDROME CHECK (STANDARD JAVA)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Character Array Swap | O(N) | O(N) | ⬜ TODO |
| 2 | Backward Loop Concatenation / StringBuilder | O(N) | O(N) | ⬜ TODO |
| 3 | Two-Pointer Early Exit Palindrome Validation | O(N) | O(1) | ⬜ TODO |

### `CountCharacterOccurrences`: COUNT OCCURRENCES OF A CHARACTER IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Standard Imperative Loop with charAt() | O(N) | O(1) | ⬜ TODO |
| 2 | Character Array Iteration (toCharArray) | O(N) | O(N) for character array allocation | ⬜ TODO |
| 3 | String Length Difference Manipulation | O(N) | O(N) string copy allocation | ⬜ TODO |

### `FibonacciSeriesGenerator`: PRINT FIBONACCI SERIES UP TO N TERMS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Dynamic State Swapping | O(N) | O(N) for sequence array storage | ⬜ TODO |
| 2 | Memoized Recursive Sequence Builder | O(N) | O(N) call stack and array storage | ⬜ TODO |
| 3 | Binet's Closed-Form Formula (Math Exact Rounding) | O(N) | O(N) | ⬜ TODO |

### `FactorialCalculator`: FIND FACTORIAL OF A NUMBER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Standard Imperative For-Loop | O(N) | O(1) | ⬜ TODO |
| 2 | Traditional Tail-Recursive Function | O(N) | O(N) stack frames | ⬜ TODO |
| 3 | BigInteger Stream Reduction | O(N) | O(1) | ⬜ TODO |

### `LengthOfLastWord`: LENGTH OF LAST WORD

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Right-to-Left String Pointer Traversal (No Split) | O(N) | O(1) | ⬜ TODO |
| 2 | Regex String Split Arrays | O(N) | O(N) for string array allocation | ⬜ TODO |
| 3 | String lastIndexOf Substring Truncation | O(N) | O(1) | ⬜ TODO |

### `LongestCommonPrefix`: LONGEST COMMON PREFIX

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Horizontal Scanning | O(S) where S is sum of all characters in all strings | O(1) | ⬜ TODO |
| 2 | Vertical Scanning | O(S) worst case, early exit optimization | O(1) | ⬜ TODO |
| 3 | Lexicographical Array Sorting Bounds Comparison | O(N * M * log N) where N is array length, M is string length | O(1) or O(N) depending on sort implementation | ⬜ TODO |

### `FizzBuzzImplementation`: FIZZ BUZZ LOGIC IMPLEMENTATION

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Modulo Arithmetic Check (% 3, % 5, % 15) | O(N) | O(N) for output collection | ⬜ TODO |
| 2 | String Concatenation Pattern | O(N) | O(N) | ⬜ TODO |
| 3 | Hash Map / Rule-Based Mapping (Scalable Extensions) | O(N) | O(N) | ⬜ TODO |

### `EvaluateReversePolishNotation`: EVALUATE REVERSE POLISH NOTATION (POSTFIX EVALUATION)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Classical Stack Data Structure (`java.util.Stack`) | O(N) | O(N) | ⬜ TODO |
| 2 | High-Performance ArrayDeque (`java.util.ArrayDeque`) | O(N) | O(N) | ⬜ TODO |
| 3 | Fixed Primitive Pointer Array Buffer (Zero Auto-Boxing) | O(N) | O(N) primitive array memory | ⬜ TODO |

### `ExcelSheetColumnNumber`: EXCEL SHEET COLUMN NUMBER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Left-to-Right Base-26 Positional Polynomial Accumulation | O(N) where N is length of columnTitle (N <= 7) | O(1) | ⬜ TODO |
| 2 | Right-to-Left Exponent Power Weighting | O(N) | O(1) | ⬜ TODO |
| 3 | Character Array Buffer with Bitwise/Direct Math | O(N) | O(N) for char array | ⬜ TODO |

### `ValidPalindromeII`: VALID PALINDROME II (DELETE AT MOST ONE CHARACTER)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Verification with Substring Helper | O(N) | O(1) | ⬜ TODO |
| 2 | Character Array Buffer Pointer Traversal | O(N) | O(N) for character array allocation | ⬜ TODO |
| 3 | Tail-Recursive Branching Check | O(N) | O(N) recursion stack frames | ⬜ TODO |

### `RemoveAllAdjacentDuplicates`: REMOVE ALL ADJACENT DUPLICATES IN STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | StringBuilder as an In-Place Stack Buffer | O(N) | O(N) | ⬜ TODO |
| 2 | Character Array Two-Pointer Simulation | O(N) | O(N) for char array | ⬜ TODO |
| 3 | Explicit Stack (`java.util.ArrayDeque`) | O(N) | O(N) | ⬜ TODO |

### `RemoveAllAdjacentDuplicatesII`: REMOVE ALL ADJACENT DUPLICATES IN STRING II (K DUPLICATES)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Frequency Stack Tracking (`ArrayDeque<CharCountPair>`) | O(N) | O(N) | ⬜ TODO |
| 2 | Parallel Array Buffers (In-Place Two-Pointer Pointer Simulation) | O(N) | O(N) memory allocation for primitive arrays | ⬜ TODO |
| 3 | Memoisable Character Memory Counter Array Stack | O(N) | O(N) | ⬜ TODO |

### `AnagramCheck`: ANAGRAM CHECK

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Fixed-Size Frequency Array Buffer | O(N) | O(1) - fixed 26-element array | ⬜ TODO |
| 2 | Character Array Sorting | O(N log N) | O(N) | ⬜ TODO |
| 3 | HashMap Frequency Counter | O(N) | O(K) where K is number of unique characters | ⬜ TODO |

### `FirstNonRepeatingCharacter`: FIRST NON-REPEATING CHARACTER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Fixed-Size Frequency Array Buffer (Two-Pass) | O(N) | O(1) - fixed 26-element integer array | ⬜ TODO |
| 2 | LinkedHashMap Order-Preserving Counter (Single Pass String Search) | O(N) | O(K) where K is number of unique characters (K <= 26) | ⬜ TODO |
| 3 | String Index Bounds Check (`indexOf` vs `lastIndexOf`) | O(N^2) worst case, highly practical for short strings | O(1) | ⬜ TODO |

### `LongestSubstringWithoutRepeating`: LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sliding Window using HashMap (Optimized Pointer Jump) | O(N) single pass | O(K) where K is number of unique characters | ⬜ TODO |
| 2 | Sliding Window using HashSet (Two Pointers) | O(N) worst-case 2N steps | O(K) | ⬜ TODO |
| 3 | Direct Integer Array Index Lookup (ASCII Buffer) | O(N) | O(1) fixed 128/256 size array | ⬜ TODO |

### `ValidParentheses`: VALID PARENTHESES

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | High-Performance ArrayDeque LIFO Stack | O(N) | O(N) | ⬜ TODO |
| 2 | Primitive Character Array Buffer (Zero Auto-Boxing) | O(N) | O(N) primitive array memory | ⬜ TODO |
| 3 | HashMap Matching Buffer (`Map<Character, Character>`) | O(N) | O(N) | ⬜ TODO |

### `TwoSum`: TWO SUM

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | One-Pass HashMap Lookup | O(N) | O(N) | ⬜ TODO |
| 2 | Two-Pointer Method on Indexed Class Array | O(N log N) | O(N) | ⬜ TODO |
| 3 | Brute Force Nested Loop Traversal | O(N^2) | O(1) | ⬜ TODO |

### `MergeSortedArrays`: MERGE TWO SORTED ARRAYS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Three-Pointer In-Place Reverse Traversal (Optimal) | O(m + n) | O(1) in-place modification | ⬜ TODO |
| 2 | Temporary Buffer Merge Array | O(m + n) | O(m + n) extra space | ⬜ TODO |
| 3 | Copy and Sort System Utility (`System.arraycopy` + `Arrays.sort`) | O((m + n) log(m + n)) | O(1) or O(log(m + n)) depending on sort implementation | ⬜ TODO |

### `MoveZeroesToEnd`: MOVE ZEROES TO END

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Overwrite and Zero-Fill (Optimal) | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Two-Pointer Swap (Single Pass) | O(N) single pass | O(1) in-place | ⬜ TODO |
| 3 | Temporary Buffer Array Copy | O(N) | O(N) auxiliary space | ⬜ TODO |

### `FindMissingNumber`: FIND THE MISSING NUMBER FROM 1 TO N

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Gauss Sum Formula (Arithmetic Series Math) | O(N) | O(1) | ⬜ TODO |
| 2 | Bitwise XOR Operator Logic | O(N) | O(1) | ⬜ TODO |
| 3 | HashSet Lookup Buffer | O(N) | O(N) | ⬜ TODO |

### `MaximumSubarrayKadane`: MAXIMUM SUBARRAY (KADANE'S ALGORITHM)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Dynamic Programming / Kadane's Algorithm (Optimal) | O(N) | O(1) | ⬜ TODO |
| 2 | Divide and Conquer | O(N log N) | O(log N) recursion stack | ⬜ TODO |
| 3 | Brute Force Quad-Check (Nested Loops) | O(N^2) | O(1) | ⬜ TODO |

### `BinarySearch`: BINARY SEARCH

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Binary Search (Optimal Space) | O(log N) | O(1) | ⬜ TODO |
| 2 | Recursive Binary Search | O(log N) | O(log N) recursion call stack memory | ⬜ TODO |
| 3 | Standard JDK Utility Wrapper (`Arrays.binarySearch`) | O(log N) | O(1) | ⬜ TODO |

### `SortEmployeeList`: SORT LIST OF OBJECTS WITH COMPARATOR (EMPLOYEES BY SALARY)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Classical Anonymous Inner Class / Standard Comparator | O(N log N) | O(1) in-place sort or O(N) copy | ⬜ TODO |
| 2 | Comparator Chaining with Lambda Expressions (`Comparator.comparing`) | O(N log N) | O(1) in-place sort | ⬜ TODO |
| 3 | Stream Pipeline Sorting (`List.stream().sorted()`) | O(N log N) | O(N) memory allocation for stream result | ⬜ TODO |

### `GroupEmployeesByDepartment`: GROUP EMPLOYEES BY DEPARTMENT USING STREAMS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Stream API Collectors.groupingBy (Optimal & Declarative) | O(N) | O(N) | ⬜ TODO |
| 2 | Classic Imperative Loop using Map.computeIfAbsent() | O(N) | O(N) | ⬜ TODO |
| 3 | Parallel Stream Pipeline | O(N) | O(N) | ⬜ TODO |

### `FindDuplicatesStreams`: FIND DUPLICATES IN A LIST USING STREAMS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Stream Filter with Set.add() Side-Effect | O(N) | O(N) | ⬜ TODO |
| 2 | Stream Collectors.groupingBy & Frequency Filtering | O(N) | O(N) | ⬜ TODO |
| 3 | Stream Collections.frequency() Filter | O(N^2) - clean functional syntax for small inputs | O(N) | ⬜ TODO |

### `ReverseLinkedList`: REVERSE A LINKED LIST

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Three-Pointer Pointer-Reversal (Optimal Space) | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Recursive Functional Reversal | O(N) | O(N) call stack memory | ⬜ TODO |
| 3 | Stack Auxiliary Buffer Traversal | O(N) | O(N) auxiliary space | ⬜ TODO |

### `ThreadSafeSingletonArena`: THREAD-SAFE SINGLETON

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Double-Checked Locking (DCL) | O(1) | O(1) | ⬜ TODO |
| 2 | Bill Pugh Singleton Implementation | O(1) | O(1) | ⬜ TODO |
| 3 | Enum Singleton | O(1) | O(1) | ⬜ TODO |
| 4 | Eager Initialization | O(1) | O(1) | ⬜ TODO |

### `PrintOddEvenThreads`: PRINT ODD AND EVEN NUMBERS USING TWO THREADS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Synchronized Monitor Object (`wait()` and `notify()`) | O(N) | O(N) for output collection | ⬜ TODO |
| 2 | Explicit Lock with `Condition` signal (`await()` / `signal()`) | O(N) | O(N) for output collection | ⬜ TODO |
| 3 | State-based signaling using `AtomicBoolean` / `volatile` state | O(N) | O(N) for output collection | ⬜ TODO |

### `CheckStringRotation`: CHECK WHETHER ONE STRING IS A ROTATION OF ANOTHER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | String Concatenation Trick (`(s1 + s1).contains(s2)`) | O(N) where N is length of string | O(N) for concatenated string | ⬜ TODO |
| 2 | Manual Rotation Pointer Matching (KMP / Rolling Hash Pattern) | O(N^2) worst case, O(N) with KMP index search | O(1) | ⬜ TODO |
| 3 | Two-Pointer Circular Index Modulo Traversal | O(N) | O(1) | ⬜ TODO |

### `CountVowelsAndConsonants`: COUNT VOWELS AND CONSONANTS IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Single Pass Iterative Character Inspection | O(N) | O(1) | ⬜ TODO |
| 2 | Functional Streams API filtering | O(N) | O(1) | ⬜ TODO |
| 3 | Boolean Lookup Array / Bitmask Buffer | O(N) | O(1) fixed lookup table | ⬜ TODO |

### `RemoveWhiteSpaces`: REMOVE ALL WHITE SPACES FROM A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Regular Expression Replacement (`replaceAll("\\s+", "")`) | O(N) regex evaluation | O(N) for string copy | ⬜ TODO |
| 2 | StringBuilder Traversal (`Character.isWhitespace()`) | O(N) single pass | O(N) for StringBuilder output | ⬜ TODO |
| 3 | In-Place Primitive Char Array Pointer Filtering | O(N) zero auto-boxing | O(N) primitive char array memory | ⬜ TODO |

### `CheckStringOnlyDigits`: CHECK IF A STRING CONTAINS ONLY DIGITS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Single Pass Iterative Character Inspection (`Character.isDigit`) | O(N) | O(1) | ⬜ TODO |
| 2 | Regular Expression (`s.matches("\\d+")`) | O(N) | O(1) | ⬜ TODO |
| 3 | Functional Stream API (`s.chars().allMatch`) | O(N) | O(1) | ⬜ TODO |

### `ValidAnagram`: CHECK IF A STRING IS ANAGRAM OF ANOTHER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Fixed-Size Character Frequency Counter Array (Optimal Space/Time) | O(N) | O(1) fixed 26/256 array | ⬜ TODO |
| 2 | Sorting Character Arrays | O(N log N) | O(N) for primitive array creation | ⬜ TODO |
| 3 | HashMap Character Frequency Map (Unicode/General Purpose) | O(N) | O(K) where K is number of unique characters | ⬜ TODO |

### `ReverseWordsInString`: REVERSE WORDS IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Trim, Regex Split, and Reverse Iteration | O(N) | O(N) for split tokens | ⬜ TODO |
| 2 | Two-Pointer Backward Parsing (Zero Regex / In-Place Style) | O(N) single pass | O(N) for output string | ⬜ TODO |
| 3 | Collections / List Reversal Pipeline (`Collections.reverse()`) | O(N) | O(N) | ⬜ TODO |

### `LongestPalindromicSubstring`: LONGEST PALINDROMIC SUBSTRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Expand Around Center (Optimal Space/Time) | O(N^2) | O(1) | ⬜ TODO |
| 2 | Dynamic Programming Table | O(N^2) | O(N^2) matrix table memory | ⬜ TODO |
| 3 | Manacher's Algorithm (Linear Time) | O(N) | O(N) | ⬜ TODO |

### `MergeTwoSortedLists`: MERGE TWO SORTED LISTS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Pointer Merging with Dummy Head (Optimal Space/Time) | O(N + M) | O(1) in-place pointer manipulation | ⬜ TODO |
| 2 | Recursive Functional Merging | O(N + M) | O(N + M) call stack memory | ⬜ TODO |

### `DetectLinkedListCycle`: DETECT CYCLE IN A LINKED LIST

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Floyd's Cycle-Finding Algorithm (Tortoise and Hare - Optimal Space) | O(N) | O(1) | ⬜ TODO |
| 2 | HashSet Visited Tracker | O(N) | O(N) auxiliary space | ⬜ TODO |
| 3 | Visited Flag / Node Mutation (Destructive) | O(N) | O(1) | ⬜ TODO |

### `PalindromeLinkedList`: PALINDROME LINKED LIST

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Fast & Slow Pointer with Second Half Reversal (Optimal O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 2 | ArrayList Buffer Copy | O(N) | O(N) auxiliary space | ⬜ TODO |
| 3 | Stack Auxiliary Buffer | O(N) | O(N) call stack / deque storage | ⬜ TODO |

### `IntersectionOfTwoLinkedLists`: INTERSECTION OF TWO LINKED LISTS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Traversal Switch (Optimal O(1) Space) | O(N + M) | O(1) | ⬜ TODO |
| 2 | HashSet Visited Reference Tracker | O(N + M) | O(N) auxiliary space | ⬜ TODO |
| 3 | Length Difference Alignment | O(N + M) | O(1) | ⬜ TODO |

### `RemoveNthNodeFromEndOfList`: REMOVE NTH NODE FROM END OF LIST

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Single Pass with Dummy Head (Optimal O(N) Time, O(1) Space) | O(N) single pass | O(1) | ⬜ TODO |
| 2 | Two-Pass Length Calculation | O(N) two passes | O(1) | ⬜ TODO |

### `AddTwoNumbers`: ADD TWO NUMBERS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Elementary Math Iterative Traversal with Carry (Optimal O(max(N, M)) Time) | O(max(N, M)) | O(max(N, M)) to store the output result list | ⬜ TODO |
| 2 | Recursive Addition with Carry Propagation | O(max(N, M)) | O(max(N, M)) call stack memory | ⬜ TODO |

### `SwapNodesInPairs`: SWAP NODES IN PAIRS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Pointer Swapping with Dummy Head (Optimal O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Recursive Pair Swapping | O(N) | O(N) call stack memory | ⬜ TODO |

### `ReverseNodesInKGroup`: REVERSE NODES IN K-GROUP

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Pointer Group Reversal with Dummy Head (Optimal O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Recursive k-Group Reversal | O(N) | O(N/k) call stack memory | ⬜ TODO |

### `CopyListWithRandomPointer`: COPY LIST WITH RANDOM POINTER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Interweaving Clone Nodes in-place (Optimal O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 2 | HashMap Mapping (Original Node -> Copied Node) | O(N) | O(N) map storage | ⬜ TODO |

### `SlidingWindowMaximum`: SLIDING WINDOW MAXIMUM

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Monotonic Deque (Optimal $O(N)$ Time, $O(K)$ Space) | O(N) | O(K) | ⬜ TODO |
| 2 | Max-Priority Queue with Lazy Deletion | O(N log N) | O(N) | ⬜ TODO |
| 3 | Brute Force Scan | O(N * K) | O(1) auxiliary space (excluding result array) | ⬜ TODO |

### `MinimumWindowSubstring`: MINIMUM WINDOW SUBSTRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sliding Window with Frequency Map / Hash Array (Optimal $O(N)$ Time, $O(1)$ Space) | O(M + N) | O(1) assuming fixed alphabet size (or O(N) auxiliary space) | ⬜ TODO |
| 2 | Filtered Sliding Window | O(M + N) | O(M) | ⬜ TODO |

### `LongestSubstringWithoutRepeatingCharacters`: LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Optimized Sliding Window with Character Index Map (Optimal $O(N)$ Time) | O(N) | O(min(N, charset_size)) | ⬜ TODO |
| 2 | Sliding Window with HashSet | O(2N) = O(N) | O(min(N, charset_size)) | ⬜ TODO |

### `LongestRepeatingCharacterReplacement`: LONGEST REPEATING CHARACTER REPLACEMENT

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Optimized Sliding Window with Frequency Tracker (Optimal $O(N)$ Time) | O(N) | O(1) fixed 26-element character frequency array | ⬜ TODO |
| 2 | Sliding Window with Dynamic Max Frequency Optimization | O(N) | O(1) | ⬜ TODO |

### `PermutationInString`: PERMUTATION IN STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sliding Window Frequency Array Comparison (Optimal $O(N)$ Time) | O(N) where N is length of s2 | O(1) constant frequency array space | ⬜ TODO |
| 2 | Sliding Window with Match Count Optimization | O(N) | O(1) | ⬜ TODO |

### `FindAllAnagramsInAString`: FIND ALL ANAGRAMS IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sliding Window Frequency Array Comparison (Optimal $O(N)$ Time) | O(N) where N is length of s | O(1) constant frequency array space | ⬜ TODO |
| 2 | Sliding Window Match Count Optimization | O(N) | O(1) | ⬜ TODO |

### `MinimumSizeSubarraySum`: MINIMUM SIZE SUBARRAY SUM

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sliding Window / Two Pointers (Optimal $O(N)$ Time) | O(N) | O(1) | ⬜ TODO |
| 2 | Prefix Sum with Binary Search | O(N log N) | O(N) for prefix sum array | ⬜ TODO |

### `MaximumSubarray`: MAXIMUM SUBARRAY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Kadane's Algorithm (Optimal $O(N)$ Time, $O(1)$ Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Divide and Conquer ($O(N \log N)$ Time, $O(\log N)$ Space) | O(N log N) | O(log N) call stack space | ⬜ TODO |
| 3 | Brute Force Scan | O(N^2) | O(1) | ⬜ TODO |

### `MaximumProductSubarray`: MAXIMUM PRODUCT SUBARRAY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Dynamic Programming Tracking Min/Max (Optimal $O(N)$ Time, $O(1)$ Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Brute Force Scan | O(N^2) | O(1) | ⬜ TODO |

### `ProductOfArrayExceptSelf`: PRODUCT OF ARRAY EXCEPT SELF

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Left and Right Product Passes (Optimal $O(N)$ Time, $O(1)$ Auxiliary Space) | O(N) | O(1) auxiliary space (excluding result array) | ⬜ TODO |
| 2 | Left and Right Prefix/Suffix Arrays ($O(N)$ Time, $O(N)$ Space) | O(N) | O(N) | ⬜ TODO |

### `FirstMissingPositive`: FIRST MISSING POSITIVE

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | In-Place Cyclic Sort / Index Marking (Optimal $O(N)$ Time, $O(1)$ Space) | O(N) | O(1) auxiliary space | ⬜ TODO |
| 2 | HashSet Filtering ($O(N)$ Time, $O(N)$ Space) | O(N) | O(N) | ⬜ TODO |

### `TrappingRainWater`: TRAPPING RAIN WATER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two Pointers (Optimal $O(N)$ Time, $O(1)$ Auxiliary Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Dynamic Programming with Prefix/Suffix Max Arrays ($O(N)$ Time, $O(N)$ Space) | O(N) | O(N) | ⬜ TODO |
| 3 | Monotonic Stack ($O(N)$ Time, $O(N)$ Space) | O(N) | O(N) | ⬜ TODO |

### `BestTimeToBuyAndSellStock`: BEST TIME TO BUY AND SELL STOCK

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Brute Force (All Pairs) | O(N^2) | O(1) | ⬜ TODO |
| 2 | One Pass With Running Minimum | O(N) | O(1) | ⬜ TODO |
| 3 | Kadane On Daily Differences | O(N) | O(1) | ⬜ TODO |

### `MajorityElement`: MAJORITY ELEMENT

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | HashMap Frequency Count | O(N) | O(N) | ⬜ TODO |
| 2 | Sort And Take Middle | O(N log N) | O(N) | ⬜ TODO |
| 3 | Boyer-Moore Voting | O(N) | O(1) | ⬜ TODO |

### `KthLargestElement`: KTH LARGEST ELEMENT IN AN ARRAY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Sort Then Index | O(N log N) | O(N) | ⬜ TODO |
| 2 | Min-Heap Of Size K | O(N log K) | O(K) | ⬜ TODO |
| 3 | Quickselect (Average O(N)) | O(N) average, O(N^2) worst | O(1) extra | ⬜ TODO |

### `SubarraySumEqualsK`: SUBARRAY SUM EQUALS K

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Brute Force With Running Sum | O(N^2) | O(1) | ⬜ TODO |
| 2 | Prefix Sum Array (Pair Check) | O(N^2) | O(N) | ⬜ TODO |
| 3 | Prefix Sum With HashMap (Optimal) | O(N) | O(N) | ⬜ TODO |

### `ContainsDuplicate`: CONTAINS DUPLICATE

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | HashSet Early Exit | O(N) | O(N) | ⬜ TODO |
| 2 | Sort And Compare Neighbours | O(N log N) | O(N) | ⬜ TODO |
| 3 | Java Streams Distinct Count | O(N) | O(N) | ⬜ TODO |
| 4 | Brute Force Nested Loop | O(N^2) | O(1) | ⬜ TODO |

### `FindTheDuplicateNumber`: FIND THE DUPLICATE NUMBER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | HashSet Of Seen Values | O(N) | O(N) | ⬜ TODO |
| 2 | Sort A Copy | O(N log N) | O(N) | ⬜ TODO |
| 3 | Floyd Cycle Detection (Tortoise And Hare) | O(N) | O(1) | ⬜ TODO |
| 4 | Negative Index Marking | O(N) | O(1) (modifies input) | ⬜ TODO |

### `SortColors`: SORT COLORS (SORT 0s, 1s AND 2s)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Library Sort | O(N log N) | O(1) | ⬜ TODO |
| 2 | Counting Sort (Two Passes) | O(N) | O(1) | ⬜ TODO |
| 3 | Dutch National Flag (One Pass) | O(N) | O(1) | ⬜ TODO |

### `HighestSalaryPerDepartment`: HIGHEST SALARY PER DEPARTMENT (STREAMS)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Streams toMap With Merge Function | O(N) | O(D) where D = departments | ⬜ TODO |
| 2 | Streams groupingBy + maxBy | O(N) | O(D) | ⬜ TODO |
| 3 | Classic Loop With Map.merge | O(N) | O(D) | ⬜ TODO |

### `NthHighestSalary`: NTH HIGHEST DISTINCT SALARY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Streams distinct + sorted + skip | O(N log N) | O(N) | ⬜ TODO |
| 2 | TreeSet In Descending Order | O(N log N) | O(N) | ⬜ TODO |
| 3 | Min-Heap Of Size N (Distinct) | O(N log n) | O(N) | ⬜ TODO |

### `SortMapByValue`: SORT A MAP BY VALUE

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Streams sorted + LinkedHashMap Collector | O(N log N) | O(N) | ⬜ TODO |
| 2 | List Of Entries + Collections.sort | O(N log N) | O(N) | ⬜ TODO |
| 3 | PriorityQueue Of Entries | O(N log N) | O(N) | ⬜ TODO |

### `ReverseInteger`: REVERSE INTEGER (WITH OVERFLOW CHECK)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Pure Int Math With Pre-Overflow Check | O(log10 N) | O(1) | ⬜ TODO |
| 2 | Long Accumulator | O(log10 N) | O(1) | ⬜ TODO |
| 3 | StringBuilder Reverse | O(log10 N) | O(log10 N) | ⬜ TODO |

### `PalindromeNumber`: PALINDROME NUMBER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | String Reverse Compare | O(log10 N) | O(log10 N) | ⬜ TODO |
| 2 | Reverse The Whole Number | O(log10 N) | O(1) | ⬜ TODO |
| 3 | Reverse Only Half Of The Number | O(log10 N) | O(1) | ⬜ TODO |

### `GcdAndLcm`: GCD AND LCM OF TWO NUMBERS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Euclidean Algorithm | O(log(min(a, b))) | O(1) | ⬜ TODO |
| 2 | Recursive Euclidean Algorithm | O(log(min(a, b))) | O(log(min(a, b))) call stack | ⬜ TODO |
| 3 | Brute Force Counting Down | O(min(a, b)) | O(1) | ⬜ TODO |

### `ArmstrongNumber`: ARMSTRONG NUMBER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Digit Extraction With % And / | O(D^2) where D = digits | O(1) | ⬜ TODO |
| 2 | String Characters With Math.pow | O(D) | O(D) | ⬜ TODO |
| 3 | Java Streams On Digits | O(D) | O(D) | ⬜ TODO |

### `MiddleOfLinkedList`: MIDDLE OF THE LINKED LIST

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Count Nodes Then Walk Half | O(N) | O(1) | ⬜ TODO |
| 2 | Slow And Fast Pointers | O(N) | O(1) | ⬜ TODO |
| 3 | Copy Nodes To ArrayList | O(N) | O(N) | ⬜ TODO |

### `IsomorphicStrings`: ISOMORPHIC STRINGS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two HashMaps (s to t and t to s) | O(N) | O(K) where K = alphabet size | ⬜ TODO |
| 2 | One HashMap + Set Of Used Targets | O(N) | O(K) | ⬜ TODO |
| 3 | Last Seen Index Arrays | O(N) | O(1) fixed tables | ⬜ TODO |

### `IntersectionOfTwoArrays`: INTERSECTION OF TWO ARRAYS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | HashSet Lookup | O(N + M) | O(N + M) | ⬜ TODO |
| 2 | Sort Both And Two Pointers | O(N log N + M log M) | O(N + M) | ⬜ TODO |
| 3 | Java Streams distinct + filter | O(N + M) | O(M) | ⬜ TODO |

### `AggregateKeyValuesAndFindMax`: AGGREGATE KEY-VALUE PAIRS AND FIND MAXIMUM SUM KEY

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | HashMap Aggregation & Iterative Entry Scan | O(N) | O(U) where U is unique keys count | ⬜ TODO |
| 2 | Java 8+ Stream API Grouping & Reduction | O(N) | O(U) | ⬜ TODO |
| 3 | Helper Method to Return Full Aggregated Map | O(N) | O(U) | ⬜ TODO |

### `ArrangeArrayInEvenAndOdd`: ARRANGE ARRAY IN EVEN AND ODD (SORT ARRAY BY PARITY)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two Pointers (In-Place Partitioning) | O(N) | O(1) | ⬜ TODO |
| 2 | Auxiliary Array / Two-Pass | O(N) | O(N) | ⬜ TODO |
| 3 | Java Stream & Lambda Expression | O(N) | O(N) | ⬜ TODO |

### `CountUpperAndLowerCase`: COUNT UPPERCASE AND LOWERCASE CHARACTERS IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Traditional Iterative Loop (Character.isUpperCase / isLowerCase) | O(N) | O(1) | ⬜ TODO |
| 2 | ASCII Value Range Checking | O(N) | O(1) | ⬜ TODO |
| 3 | Java Stream & Lambda Expression | O(N) | O(1) | ⬜ TODO |

### `DecodeRunLengthEncodedString`: DECODE RUN-LENGTH ENCODED STRING (STRING EXPANSION)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Character Parsing with Multi-Digit Count Support | O(N + M) where N is input length and M is output length | O(M) for output allocation | ⬜ TODO |
| 2 | Java 11+ String.repeat() Expansion | O(N + M) | O(M) | ⬜ TODO |
| 3 | Regex Pattern Matching (`([a-zA-Z])(\\d+)`) | O(N + M) | O(M) | ⬜ TODO |

### `Find2ndLargestFromAlphaNumericString`: FIND 2ND LARGEST DIGIT FROM ALPHANUMERIC STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Single-Pass Tracking Pointers | O(N) | O(1) | ⬜ TODO |
| 2 | Deduplication via Set / TreeSet Sorting | O(N) | O(1) -- max set size is 10 (digits 0-9) | ⬜ TODO |
| 3 | Java Stream & Lambda Expression | O(N) | O(1) | ⬜ TODO |

### `GetCharCountInStringWithoutWhitespace`: COUNT CHARACTERS IN A STRING (EXCLUDING WHITESPACE & DELIMITERS)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Count Non-Whitespace Characters (Iterative Loop) | O(N) | O(1) | ⬜ TODO |
| 2 | Count Enclosed / Internal Letters (Neighbor Checking) | O(N) | O(1) | ⬜ TODO |
| 3 | Stream & Lambda Expression (Non-Whitespace Filter) | O(N) | O(1) | ⬜ TODO |

### `LeadersInAnArray`: LEADERS IN AN ARRAY (SUPERIOR ELEMENTS)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Right-to-Left Single Scan (Optimal O(N) Time, O(1) Extra Space) | O(N) | O(1) auxiliary space (excluding output list) | ⬜ TODO |
| 2 | Brute Force Nested Loops | O(N^2) | O(1) | ⬜ TODO |
| 3 | Stream & IntStream Functional Range Filter | O(N^2) | O(N) | ⬜ TODO |

### `LengthOfStringWithoutCharArray`: FIND LENGTH OF STRING WITHOUT USING toCharArray() OR .length()

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Index Lookup via charAt & Exception Handling | O(N) | O(1) | ⬜ TODO |
| 2 | String Split & Stream API | O(N) | O(N) for string array allocation | ⬜ TODO |
| 3 | IntStream CodePoints / Chars & Lambda Expression | O(N) | O(1) | ⬜ TODO |

### `LengthofStringNodotLength`: FIND LENGTH OF STRING WITHOUT USING .length() METHOD

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Character Array Loop | O(N) | O(N) for character array allocation | ⬜ TODO |
| 2 | Exception Handling (StringIndexOutOfBoundsException) | O(N) | O(1) | ⬜ TODO |
| 3 | Stream & Lambda Expression | O(N) | O(1) | ⬜ TODO |

### `MaximumProductOfThreeNumbers`: MAXIMUM PRODUCT OF THREE NUMBERS (LEETCODE 628)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Array Sorting | O(N log N) | O(1) or O(log N) space depending on sort implementation | ⬜ TODO |
| 2 | Single-Pass Linear Scan (Optimal O(N) Time, O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 3 | Stream API Sorting (Declarative Style) | O(N log N) | O(N) | ⬜ TODO |

### `MaximumProductOfThreeNumbersWithoutSorting`: MAXIMUM PRODUCT OF THREE NUMBERS (OPTIMAL O(N) WITHOUT SORTING)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Single-Pass Linear Pointer Scan (Optimal O(N) Time, O(1) Space) | O(N) | O(1) | ⬜ TODO |
| 2 | Min-Heap & Max-Heap PriorityQueue | O(N log 3) = O(N) | O(1) | ⬜ TODO |
| 3 | Dual-Scan (Separated Max/Min Passes) | O(N) | O(1) | ⬜ TODO |

### `RemoveDuplicateCharactersPreserveOrder`: REMOVE DUPLICATE CHARACTERS PRESERVING ORIGINAL ORDER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | LinkedHashSet Tracking | O(N) | O(K) where K is unique character set size | ⬜ TODO |
| 2 | Boolean Array / BitSet Lookup | O(N) | O(1) fixed auxiliary array size 256 | ⬜ TODO |
| 3 | Java Stream API & distinct() (Functional Style) | O(N) | O(K) | ⬜ TODO |

### `RemoveDuplicatesFromArrayPreservingOrder`: REMOVE DUPLICATES FROM ARRAY PRESERVING ORDER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | LinkedHashSet Insertion-Order Collection | O(N) | O(U) where U is unique element count | ⬜ TODO |
| 2 | Primitive Array Scan with HashSet Lookup | O(N) | O(U) avoiding boxed stream conversions | ⬜ TODO |
| 3 | Java 8+ Stream API .distinct() (Declarative Style) | O(N) | O(U) | ⬜ TODO |

### `RemoveDuplicatesUsingStreams`: REMOVE DUPLICATE ELEMENTS FROM ARRAY USING JAVA STREAMS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Primitive IntStream.distinct() (Optimal Functional One-Liner) | O(N) | O(U) where U is unique element count | ⬜ TODO |
| 2 | Boxed Stream with Collectors.toCollection(LinkedHashSet::new) | O(N) | O(U) | ⬜ TODO |
| 3 | Imperative LinkedHashSet (Benchmarking Baseline) | O(N) | O(U) | ⬜ TODO |

### `ReverseCharactersOfEachWord`: REVERSE CHARACTERS OF EACH WORD IN A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Split Words & Two-Pointer Char Array Reversal | O(N) | O(N) | ⬜ TODO |
| 2 | Single-Pass In-Place Reversal (Zero Split Allocations) | O(N) | O(N) for final output string allocation | ⬜ TODO |
| 3 | Stream API & StringBuilder (Functional Style) | O(N) | O(N) | ⬜ TODO |

### `ReverseFirstWordOfString`: REVERSE THE FIRST WORD OF A STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Limited Regex Split (limit=2) & Two-Pointer Char Array Reversal | O(N) | O(N) | ⬜ TODO |
| 2 | Limited Split & StringBuilder.reverse() | O(N) | O(N) | ⬜ TODO |
| 3 | Substring Index Scan (Zero Regex Split Allocations) | O(N) | O(N) avoiding array allocation from regex split | ⬜ TODO |

### `ReverseHashMap`: REVERSE A HASHMAP (SWAP KEYS AND VALUES)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | KeySet Iteration Loop (Standard 1-to-1 Map Inversion) | O(N) | O(N) | ⬜ TODO |
| 2 | EntrySet Iteration Loop (Optimal Performance) | O(N) | O(N) | ⬜ TODO |
| 3 | Java 8+ Stream API Collectors.toMap() | O(N) | O(N) | ⬜ TODO |

### `ReverseWordsUsingStringBuilder`: REVERSE CHARACTERS OF EACH WORD USING STRINGBUILDER

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Word Split & StringBuilder.reverse() Loop | O(N) | O(N) | ⬜ TODO |
| 2 | Single-Pass Traversing with StringBuilder Buffer | O(N) | O(N) | ⬜ TODO |
| 3 | Stream API with StringBuilder Mapping | O(N) | O(N) | ⬜ TODO |

### `RotateArrayByKPositions`: ROTATE AN ARRAY BY K POSITIONS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Reversal Algorithm (Optimal) | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Auxiliary Array Allocation | O(N) | O(N) | ⬜ TODO |
| 3 | Left Rotation (Alternative Variant) | O(N) | O(1) in-place | ⬜ TODO |

### `RotateArrayClockwiseAndAntiClockwise`: ROTATE ARRAY K TIMES (CLOCKWISE & ANTI-CLOCKWISE)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Clockwise (Right) Rotation using In-Place Reversal Algorithm | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Anti-Clockwise (Left) Rotation using In-Place Reversal Algorithm | O(N) | O(1) in-place | ⬜ TODO |

### `RotateArrayInRightAndLeftDirection`: ROTATE ARRAY IN RIGHT AND LEFT DIRECTIONS BY K POSITIONS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Right Rotation via Auxiliary Array Allocation | O(N) | O(N) | ⬜ TODO |
| 2 | Stream & IntStream Index Mapping | O(N) | O(N) | ⬜ TODO |

### `RotateArrayWithModulo`: ROTATE ARRAY TO RIGHT WITH MODULO K HANDLING (LEETCODE 189)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Reversal Algorithm with Modulo Normalization (Optimal In-Place) | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Extra Array Allocation with Modulo Index Mapping | O(N) | O(N) | ⬜ TODO |
| 3 | Functional / Java IntStream Lambda Expression (One-Liner) | O(N) | O(N) | ⬜ TODO |

### `SinglyLinkedListTraversal`: SINGLY LINKED LIST TRAVERSAL AND OPERATIONS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Pointer Traversal (`while current != null`) | O(N) | O(N) for returned collection output | ⬜ TODO |
| 2 | Recursive Pointer Traversal | O(N) | O(N) recursion stack memory | ⬜ TODO |
| 3 | Helper Method to Calculate Linked List Length | O(N) | O(1) | ⬜ TODO |

### `SplitHalfArrayReversalAndMetrics`: REVERSE ARRAY HALVES IN-PLACE & COMPUTE ARRAY METRICS

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Two-Pointer Range Reversal & Single-Pass Metrics | O(N) | O(1) in-place | ⬜ TODO |
| 2 | Java 8+ Stream & Array Processing (Declarative Style) | O(N log N) due to stream sorting | O(N) | ⬜ TODO |

### `StringRunLengthEncoding`: STRING RUN-LENGTH ENCODING / CHARACTER COMPRESSION

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Iterative Single-Pass Loop with Tail Flush | O(N) | O(N) for StringBuilder output allocation | ⬜ TODO |
| 2 | Two-Pointer / Sliding Window Character Grouping | O(N) | O(N) | ⬜ TODO |
| 3 | Regex Pattern Matching & Matcher Group Replacement | O(N) | O(N) | ⬜ TODO |

### `SumOfIntegerFromSentence`: SUM OF INTEGERS FROM A SENTENCE STRING

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Regex Matcher Scanning (`\d+`) | O(N) | O(1) auxiliary space (no array allocation) | ⬜ TODO |
| 2 | Whitespace Split & Stream Filter | O(N) | O(N) due to string array allocation | ⬜ TODO |
| 3 | Imperative Character-by-Character Parser | O(N) | O(1) | ⬜ TODO |

### `TransposeMatrix`: TRANSPOSE OF A 2D MATRIX (LEETCODE 867)

| # | Approach | Time | Space | State |
|---|---|---|---|---|
| 1 | Out-of-Place Matrix Allocation (Supports RxC Rectangular & Square Matrices) | O(R * C) | O(R * C) for new transposed matrix space | ⬜ TODO |
| 2 | In-Place Diagonal Swap (Square Matrices NxN Only) | O(N^2) | O(1) auxiliary space (In-place) | ⬜ TODO |
| 3 | Stream API Row-Column Mapping | O(R * C) | O(R * C) | ⬜ TODO |

## 7. How to run

```
mvn -q compile        # or: javac -d out src/main/java/JavaCodingPracticeArenaSDET/JavaCodingPracticeArenaSDET/*.java
java -cp target/classes JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET.<ClassName>
```

Each class prints `[PASS]` or `[FAIL]` per test, grouped by approach, with timing. Write your solution under `// TODO: Write solution here`, rerun, and aim for all PASS.

## 8. Suggested revision order

1. Start with the most commonly asked: `TwoSum`, `ValidParentheses`, `ValidAnagram`, `FirstNonRepeatingCharacter`, `MergeSortedArrays`, `MoveZeroesToEnd`, `BinarySearch`, `MaximumSubarray`, `ReverseLinkedList`.
2. Then the new set: `BestTimeToBuyAndSellStock`, `MajorityElement`, `KthLargestElement`, `SubarraySumEqualsK`, `ContainsDuplicate`, `SortColors`, `HighestSalaryPerDepartment`, `SortMapByValue`.
3. Finish with the harder set: `TrappingRainWater`, `MinimumWindowSubstring`, `SlidingWindowMaximum`, `LRUCache`.
4. For each solved approach, practise explaining the time and space complexity out loud.