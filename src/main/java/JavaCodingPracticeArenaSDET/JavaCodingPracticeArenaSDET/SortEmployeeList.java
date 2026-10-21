package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-11: SORT LIST OF OBJECTS WITH COMPARATOR (EMPLOYEES BY SALARY)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a list of `Employee` objects (containing `id`, `name`, and `salary`),
 * write a method to sort the employees in descending order of their salary.
 * If two employees have the exact same salary, break ties by sorting them
 * alphabetically by `name` in ascending order.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  [Emp(1, "Alice", 75000), Emp(2, "Bob", 90000), Emp(3, "Charlie", 75000)]
 *   Output: [Emp(2, "Bob", 90000), Emp(1, "Alice", 75000), Emp(3, "Charlie", 75000)]
 *
 * CONSTRAINTS:
 * - 0 <= employees.size() <= 10^4
 * - `salary` is non-negative.
 * - Handles null lists and null elements safely.
 * ============================================================================
 */
public class SortEmployeeList {

    /**
     * Domain model class representing an Employee.
     */
    public static class Employee {
        private final int id;
        private final String name;
        private final double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, salary);
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Classical Anonymous Inner Class / Standard Comparator
     *
     * @implNote Implement `Comparator<Employee>` explicitly comparing salary descending
     *           (`Double.compare(e2.getSalary(), e1.getSalary())`) and breaking ties with
     *           `e1.getName().compareTo(e2.getName())`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(1) in-place sort or O(N) copy
     */
    public List<Employee> sortBySalaryClassicalComparator(List<Employee> employees) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    /**
     * Approach 2: Comparator Chaining with Lambda Expressions (`Comparator.comparing`)
     *
     * @implNote Use `Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName)`
     *           and pass into `List.sort()`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(1) in-place sort
     */
    public List<Employee> sortBySalaryLambdaChaining(List<Employee> employees) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    /**
     * Approach 3: Stream Pipeline Sorting (`List.stream().sorted()`)
     *
     * @implNote Process `employees.stream()` through `.sorted(...)` pipeline and collect
     *           to a new list using Java Stream Collectors.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N) memory allocation for stream result
     */
    public List<Employee> sortBySalaryStream(List<Employee> employees) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final List<Employee> input;
        private final List<Employee> expected;
        private final String description;

        public TestCase(int id, List<Employee> input, List<Employee> expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public List<Employee> getInput() { return input; }
        public List<Employee> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SortEmployeeList solver = new SortEmployeeList();

        List<Employee> sampleInput = new ArrayList<>();
        sampleInput.add(new Employee(1, "Alice", 75000));
        sampleInput.add(new Employee(2, "Bob", 90000));
        sampleInput.add(new Employee(3, "Charlie", 75000));
        sampleInput.add(new Employee(4, "David", 110000));

        List<Employee> sampleExpected = new ArrayList<>();
        sampleExpected.add(new Employee(4, "David", 110000));
        sampleExpected.add(new Employee(2, "Bob", 90000));
        sampleExpected.add(new Employee(1, "Alice", 75000));
        sampleExpected.add(new Employee(3, "Charlie", 75000));

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, sampleInput, sampleExpected, "Standard sorting with salary ties resolved alphabetically"),
                new TestCase(2, new ArrayList<>(), new ArrayList<>(), "Empty list check"),
                new TestCase(3, null, new ArrayList<>(), "Null list safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-11 SORT LIST OF OBJECTS WITH COMPARATOR");
        System.out.println("================================================================================");

        runApproach("1. Classical Anonymous Inner Class Comparator", solver::sortBySalaryClassicalComparator, testCases);
        runApproach("2. Comparator Chaining with Lambda Expressions", solver::sortBySalaryLambdaChaining, testCases);
        runApproach("3. Stream Pipeline Sorting", solver::sortBySalaryStream, testCases);
    }

    /**
     * Executes test cases, compares actual sorted list against expected, and logs timing.
     */
    private static void runApproach(String name, Function<List<Employee>, List<Employee>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            List<Employee> workingList = (tc.getInput() != null) ? new ArrayList<>(tc.getInput()) : null;

            long startTime = System.nanoTime();
            List<Employee> result = method.apply(workingList);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}