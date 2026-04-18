package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setBrand("Apple");
        laptop.setModel("Ios");
        laptop.setRam("16GB");

        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Radhika");
        emp.setAge(26);
        emp.setLaptop(laptop);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        session.persist(laptop);
        session.persist(emp);
        System.out.println("Employee data persist successfully");

        session.getTransaction().commit();

//        Employee emp = session.find(Employee.class, 110);
//        System.out.println(emp);

        sf.close();
        session.close();
    }
}
