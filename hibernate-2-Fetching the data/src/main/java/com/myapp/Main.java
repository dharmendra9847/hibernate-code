package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .configure()
                .buildSessionFactory();

        try (Session session = sf.openSession()) {

            Employee employee = session.find(Employee.class, 5);

            if (employee != null) {
                System.out.println("Employee found: " + employee.getName());
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Age: " + employee.getAge());
            } else {
                System.out.println("Employee with ID 5 not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sf.close();
        }
    }
}
