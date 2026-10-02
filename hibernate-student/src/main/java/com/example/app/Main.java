package com.example.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.entity.Student;
import com.example.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        // =========================================
        // INSERT MULTIPLE STUDENTS
        // =========================================

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student student1 = new Student(
                1,
                "Rahul",
                "rahul@gmail.com",
                "Java"
        );

        Student student2 = new Student(
                2,
                "Priya",
                "priya@gmail.com",
                "Python"
        );

        Student student3 = new Student(
                3,
                "Arun",
                "arun@gmail.com",
                "Spring Boot"
        );

        Student student4 = new Student(
                4,
                "Divya",
                "divya@gmail.com",
                "Hibernate"
        );

        Student student5 = new Student(
                5,
                "Karthik",
                "karthik@gmail.com",
                "MySQL"
        );

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);
        session.persist(student5);

        transaction.commit();

        session.close();

        System.out.println("=================================");
        System.out.println("5 Students inserted successfully!");
        System.out.println("=================================");


        // =========================================
        // READ / DISPLAY STUDENTS
        // =========================================

        session = sessionFactory.openSession();

        Student s1 = session.get(Student.class, 1);
        Student s2 = session.get(Student.class, 2);
        Student s3 = session.get(Student.class, 3);
        Student s4 = session.get(Student.class, 4);
        Student s5 = session.get(Student.class, 5);

        System.out.println("\nStudents from Database:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        session.close();


        // =========================================
        // UPDATE STUDENTS
        // =========================================

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

        Student studentToUpdate =
                session.get(Student.class, 1);

        studentToUpdate.setCourse("Advanced Java");

        transaction.commit();

        session.close();

        System.out.println("\n=================================");
        System.out.println("Student 1 updated successfully!");
        System.out.println("=================================");


        // =========================================
        // VERIFY UPDATED STUDENT
        // =========================================

        session = sessionFactory.openSession();

        Student updatedStudent =
                session.get(Student.class, 1);

        System.out.println("\nUpdated Student:");
        System.out.println(updatedStudent);

        session.close();


        // =========================================
        // CLOSE SESSION FACTORY
        // =========================================

        sessionFactory.close();

        System.out.println("\n=================================");
        System.out.println("Program completed successfully!");
        System.out.println("=================================");
    }
}