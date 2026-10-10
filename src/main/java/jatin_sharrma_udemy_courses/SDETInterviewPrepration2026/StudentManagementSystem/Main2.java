package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2 {
    private static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        System.out.println("*********** Welcome ***********");
        Student s1;
        s1 = new Student("Kajal Talreja", 22, "S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("Selenium");
        s1.enrollCourse("python");

        Student s2 = new Student("Uday", 23, "S-2");
        s2.enrollCourse("Java");

        Student s3 = new Student("Kanta", 27, "S-4");
        s3.enrollCourse("Selenium");

        Student s4 = new Student("Ajit", 25, "S-7");
        s4.enrollCourse("DSA");

        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);

        findStudentById("S-1").printStudentInf();
        sortStudentByName();
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
