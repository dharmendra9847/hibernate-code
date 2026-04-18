package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Apple");
        l1.setModel("IOS");
        l1.setRam("16GB");

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam("32GB");

        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Radhika");
        emp.setAge(26);
        emp.setLaptops(Arrays.asList(l1,l2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(emp);
        System.out.println("Employee data persist successfully");

        session.getTransaction().commit();

//        Employee emp = session.find(Employee.class, 110);
//        System.out.println(emp);

        sf.close();
        session.close();
    }
}
