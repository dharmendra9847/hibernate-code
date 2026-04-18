package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        Employee emp7 = new Employee();
        emp7.setId(7);
        emp7.setName("EMP-7");
        emp7.setAge(27);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(Employee.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(emp7);

        System.out.println("Employee data persisted successfully");

        transaction.commit();

        session.close();
        sf.close();
    }
}
