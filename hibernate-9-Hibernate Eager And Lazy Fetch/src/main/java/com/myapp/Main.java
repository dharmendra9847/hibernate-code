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

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("HP");
        l3.setModel("Victus");
        l3.setRam("24GB");

        Employee emp1 = new Employee();
        emp1.setId(101);
        emp1.setName("Radhika");
        emp1.setAge(26);
        emp1.setLaptops(Arrays.asList(l1,l2));

        Employee emp2 = new Employee();
        emp2.setId(102);
        emp2.setName("Radha");
        emp2.setAge(33);
        emp2.setLaptops(Arrays.asList(l3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(emp1);
        session.persist(emp2);
        System.out.println("Employee data persist successfully");

        session.getTransaction().commit();
        session.close();

        Session session1  = sf.openSession();

        Employee emp5 = session1.find(Employee.class, 101);
        //System.out.println("Employee data retrieved successfully : " +  emp5);

        session1.close();
        sf.close();
    }
}
