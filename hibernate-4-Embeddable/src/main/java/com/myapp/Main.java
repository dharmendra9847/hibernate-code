package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setBrand("Apple");
        laptop.setModel("Ios");
        laptop.setRam("16GB");

        //UPDATE
        Employee emp = new Employee();
        emp.setId(110);
        emp.setName("Radhika");
        emp.setAge(26);
        emp.setLaptop(laptop);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

//        session.persist(emp);
//        System.out.println("Employee data persist successfully");


        Laptop l1 = session.find(Laptop.class, 110);
        System.out.println(l1);

        session.getTransaction().commit();
        sf.close();
        session.close();
    }
}
