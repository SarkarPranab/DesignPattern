package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("*************** Student Management System ***************");
        while(true){
            System.out.println("*********** Welcome ***********");
            System.out.println("1. Register Student \n2. Find student by id \n3. List all students \n4. List all students in sorted manner \n5. Exit");
            scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    System.out.println("Enter Student ID: ");
                    findStudentById(scanner.next()).printStudentInf();
                    break;
                case 3:
                    ListAllStudents();
                    break;
                case 4:
                    sortStudentByName();
                    break;
                case 5:
                    exitTerminal();
                    break;

            }
        }

    }

    private static void exitTerminal() {
        System.out.println("Good Bye!!");
        System.exit(0);
    }

    private static void ListAllStudents() {
        System.out.println("****************** Printing All Students ******************");
        for(Student s : studentsList){
            s.printStudentInf();
        }
    }

    public static void registerStudent() {
        System.out.println("Enter Student name:");
        String name = scanner.next();
        System.out.println("Enter Student age:");
        int age = scanner.nextInt();
        System.out.println("Enter Student ID:");
        String id = scanner.next();
        Student s1 = new Student(name, age, id);
        System.out.println("Enter subject to enroll :\n1. Java\n2. Selenium\n3. Python\n4. DSA and once completed give 'done' as input");
        while (true) {
            String val = scanner.next();
            if (val.equalsIgnoreCase("done")) {
                break;
            } else {
                s1.enrollCourse(val);
            }
        }
        if(s1.getName()!=null){
            studentsList.add(s1);
        }
        System.out.println("[+] Student Added Successfully!");
        s1.printStudentInf();
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
        System.out.println("****************** Printing All Students Sorted Order ******************");
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
