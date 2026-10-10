package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    private static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        System.out.println("*********** Welcome ***********");
        Scanner scanner = new Scanner(System.in);
        System.out.println("[+] Enter name of the student : ");
        String name = scanner.next(); // For getting name in String
        System.out.println("[=] You have entered name : "+name);
        System.out.println("[+] Enter age of the student : ");
        int age = scanner.nextInt();
        System.out.println("[=] You have entered name : "+age);
    }

    public static Student findStudentById(String studentId) {
        Student result = null;
        try {
            result = studentsList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst().orElseThrow(() -> new RuntimeException("Data Not Found"));
        } catch (Exception ex) {
            System.err.println("Student with student ID : " + studentId + " was not found.");
        }
        return result;
    }

    public static void sortStudentByName() {
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(studentsList, studentComparator);
        System.out.println(studentsList);
    }
}
