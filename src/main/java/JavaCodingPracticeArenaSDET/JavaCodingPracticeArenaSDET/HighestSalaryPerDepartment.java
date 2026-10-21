package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-63: HIGHEST SALARY PER DEPARTMENT (STREAMS)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a list of `Employee` objects (name, department, salary), return a map from each
 * department to the highest salary in that department.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  [(A, IT, 70000), (B, IT, 90000), (C, HR, 50000)]
 *   Output: {IT=90000.0, HR=50000.0}
 *
 * CONSTRAINTS:
 * - 0 <= employees.size() <= 10^4
 * - salary is non-negative
 * - Null list returns an empty map; null elements are skipped.
 * ============================================================================
 */
public class HighestSalaryPerDepartment {

    public static class Employee {
        private final String name;
        private final String department;
        private final double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "(" + department + ", " + salary + ")";
        }
    }

    static Map<String, Double> mapOf(Object... keyValues) {
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            map.put((String) keyValues[i], ((Number) keyValues[i + 1]).doubleValue());
        }
        return map;
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Streams toMap With Merge Function
     *
     * @implNote Collectors.toMap(department, salary, Math::max) keeps the larger salary on key collisions.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(D) where D = departments
     */
    public Map<String, Double> highestSalaryToMap(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    /**
     * Approach 2: Streams groupingBy + maxBy
     *
     * @implNote groupingBy(department, maxBy(comparingDouble(salary))) then unwrap the Optional to the salary.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(D)
     */
    public Map<String, Double> highestSalaryGroupingBy(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    /**
     * Approach 3: Classic Loop With Map.merge
     *
     * @implNote Iterate once and call map.merge(department, salary, Math::max).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(D)
     */
    public Map<String, Double> highestSalaryLoop(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        Map<String, Double> solve(List<Employee> employees);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final List<Employee> employees;
        private final Map<String, Double> expected;

        public TestCase(int id, String description, List<Employee> employees, Map<String, Double> expected) {
            this.id = id;
            this.description = description;
            this.employees = employees;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        HighestSalaryPerDepartment solver = new HighestSalaryPerDepartment();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Two departments", Arrays.asList(new Employee("A", "IT", 70000), new Employee("B", "IT", 90000), new Employee("C", "HR", 50000)), mapOf("IT", 90000.0, "HR", 50000.0)),
                new TestCase(2, "Single employee", Arrays.asList(new Employee("A", "QA", 60000)), mapOf("QA", 60000.0)),
                new TestCase(3, "Equal salaries", Arrays.asList(new Employee("A", "IT", 5), new Employee("B", "IT", 5)), mapOf("IT", 5.0)),
                new TestCase(4, "Three departments mixed order", Arrays.asList(new Employee("A", "HR", 10), new Employee("B", "IT", 30), new Employee("C", "HR", 20), new Employee("D", "QA", 25), new Employee("E", "IT", 15)), mapOf("HR", 20.0, "IT", 30.0, "QA", 25.0)),
                new TestCase(5, "Null element is skipped", Arrays.asList(new Employee("A", "IT", 10), null), mapOf("IT", 10.0)),
                new TestCase(6, "Empty list", new ArrayList<Employee>(), mapOf()),
                new TestCase(7, "Null input safety check", null, mapOf())
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-63 HIGHEST SALARY PER DEPARTMENT (STREAMS)");
        System.out.println("================================================================================");

        runApproach("1. Streams toMap With Merge Function", solver::highestSalaryToMap, testCases);
        runApproach("2. Streams groupingBy + maxBy", solver::highestSalaryGroupingBy, testCases);
        runApproach("3. Classic Loop With Map.merge", solver::highestSalaryLoop, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            Map<String, Double> result = null;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.employees);
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isCorrect = !threw && Objects.deepEquals(result, tc.expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.employees)));
                System.out.printf("         Expected: %s | Actual: %s%s\n",
                        fmt(tc.expected), fmt(result), threw ? " (exception thrown)" : "");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    /**
     * Formats arrays, linked lists and other objects for readable test output.
     */
    private static String fmt(Object o) {
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        if (o instanceof long[]) return Arrays.toString((long[]) o);
        return String.valueOf(o);
    }
}
