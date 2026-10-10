package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        System.out.println("*********** Welcome ***********");
        Student s1;
        s1 = new Student("Kajal Talreja", 22, "S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("Selenium");
        s1.enrollCourse("python");
        s1.printStudentInf();

        Student s2 = new Student("Uday",23,"S-2");
        s2.enrollCourse("Java");
        s2.printStudentInf();

        Student s3 = new Student("Kanta",27,"S-4");
        s3.enrollCourse("Selenium");
        s3.printStudentInf();
    }
}
