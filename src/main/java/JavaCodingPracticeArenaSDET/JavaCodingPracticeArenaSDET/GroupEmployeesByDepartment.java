package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-12: GROUP EMPLOYEES BY DEPARTMENT USING STREAMS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a list of `Employee` objects (containing `id`, `name`, `department`,
 * and `salary`), group the employees by their department name into a map where
 * the key is the department name and the value is a list of employees belonging
 * to that department.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  [Emp(1, "Alice", "HR"), Emp(2, "Bob", "IT"), Emp(3, "Charlie", "HR")]
 *   Output: {
 *             "HR": [Emp(1, "Alice", "HR"), Emp(3, "Charlie", "HR")],
 *             "IT": [Emp(2, "Bob", "IT")]
 *           }
 *
 * CONSTRAINTS:
 * - 0 <= employees.size() <= 10^4
 * - Handles null lists, empty lists, and null department names safely.
 * ============================================================================
 */
public class GroupEmployeesByDepartment {

    /**
     * Domain model class representing an Employee.
     */
    public static class Employee {
        private final int id;
        private final String name;
        private final String department;
        private final double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && Double.compare(employee.salary, salary) == 0 &&
                    Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, department, salary);
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f}", id, name, department, salary);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Stream API Collectors.groupingBy (Optimal & Declarative)
     *
     * @implNote Use `employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))`
     *           to partition employees into department lists using Java Streams.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, List<Employee>> groupByDepartmentStream(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    /**
     * Approach 2: Classic Imperative Loop using Map.computeIfAbsent()
     *
     * @implNote Iterate through `employees` with a standard `for-each` loop.
     *           Use `map.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp)`
     *           to populate grouped categories efficiently without Stream overhead.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, List<Employee>> groupByDepartmentImperative(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    /**
     * Approach 3: Parallel Stream Pipeline
     *
     * @implNote Use `employees.parallelStream().collect(Collectors.groupingByConcurrent(...))`
     *           or standard `groupingBy` for multi-threaded stream partitioning on large datasets.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, List<Employee>> groupByDepartmentParallelStream(List<Employee> employees) {
        // TODO: Write solution here
        return new HashMap<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final List<Employee> input;
        private final Map<String, List<Employee>> expected;
        private final String description;

        public TestCase(int id, List<Employee> input, Map<String, List<Employee>> expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public List<Employee> getInput() { return input; }
        public Map<String, List<Employee>> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        GroupEmployeesByDepartment solver = new GroupEmployeesByDepartment();

        List<Employee> sampleInput = new ArrayList<>();
        sampleInput.add(new Employee(1, "Alice", "HR", 75000));
        sampleInput.add(new Employee(2, "Bob", "IT", 90000));
        sampleInput.add(new Employee(3, "Charlie", "HR", 80000));
        sampleInput.add(new Employee(4, "David", "Finance", 95000));
        sampleInput.add(new Employee(5, "Eve", "IT", 105000));

        Map<String, List<Employee>> sampleExpected = new HashMap<>();
        sampleExpected.put("HR", List.of(new Employee(1, "Alice", "HR", 75000), new Employee(3, "Charlie", "HR", 80000)));
        sampleExpected.put("IT", List.of(new Employee(2, "Bob", "IT", 90000), new Employee(5, "Eve", "IT", 105000)));
        sampleExpected.put("Finance", List.of(new Employee(4, "David", "Finance", 95000)));

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, sampleInput, sampleExpected, "Standard multi-department grouping"),
                new TestCase(2, new ArrayList<>(), new HashMap<>(), "Empty list check"),
                new TestCase(3, null, new HashMap<>(), "Null list safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-12 GROUP EMPLOYEES BY DEPARTMENT");
        System.out.println("================================================================================");

        runApproach("1. Stream API Collectors.groupingBy", solver::groupByDepartmentStream, testCases);
        runApproach("2. Imperative Loop with computeIfAbsent", solver::groupByDepartmentImperative, testCases);
        runApproach("3. Parallel Stream Pipeline", solver::groupByDepartmentParallelStream, testCases);
    }

    /**
     * Executes test cases, compares actual grouped map against expected output, and logs timing.
     */
    private static void runApproach(String name, Function<List<Employee>, Map<String, List<Employee>>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            List<Employee> workingList = (tc.getInput() != null) ? new ArrayList<>(tc.getInput()) : null;

            long startTime = System.nanoTime();
            Map<String, List<Employee>> result = method.apply(workingList);
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