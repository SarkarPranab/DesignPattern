package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2. Implement a `Student` Class:
        - Define a `Student` class with the following attributes:
        - `String name`
        - `int age`
        - `String studentId`
        - `List<String> courses`
        - Implement the following methods:
        - A constructor to initialize `name`, `age`, and `studentId`.
        - A method `void enrollCourse(String course)` to add a course to the `courses` list.
        - A method `void printStudentInf*/
public class Student {
    private String name;
    private int age;
    private String studentId;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    private List<String> courses;

    public Student(String name, int age, String studentId) {
        super();
        if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            this.courses = new ArrayList<>();
        }
    }

    void enrollCourse(String course) {
        if (validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("[+] Student enrolled to the course " + course + " successfully!");
            } else {
                System.err.println("[+] Course already added name : " + course);
            }
        } else {
            System.err.println("[+] Invalid Course name : " + course + " only Java, Python, Selenium, DSA allowed");
        }
    }

    void printStudentInf() {
        System.out.println("======= Student Information =======");
        System.out.println("Student name : " + name);
        System.out.println("Student age : " + age);
        System.out.println("Student id : " + studentId);
        System.out.println("Student enrolled courses : " + courses);
    }

    //    Validation Method
    public boolean validateAge(int age) {
        if (age > 21 && age < 35) {
            return true;
        } else {
            System.err.println("Student with age : " + age + " cannot be register it has tobe between 21 to 35.");
            return false;
        }
    }

    public boolean validateName(String name) {
        Pattern namePatter = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher nameMatcher = namePatter.matcher(name);
        if (nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("[+] Invalid Name Format.");
            return false;
        }
    }

    public boolean validateStudentId(String studentId) {
        Pattern studentPattern = Pattern.compile("^S-\\d+$");
        Matcher studentIdMatcher = studentPattern.matcher(studentId);
        if (studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("[+] Invalid Student ID format.");
            return false;
        }
    }

    public boolean validateCourseName(String course) {
        if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Python") || course.equalsIgnoreCase("Selenium")) {
            return true;
        } else {
            return false;
        }
    }

    public String getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }
}