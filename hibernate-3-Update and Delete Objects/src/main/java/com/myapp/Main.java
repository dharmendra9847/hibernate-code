package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        //UPDATE
//        Employee emp5 = new Employee();
//        emp5.setId(109);
//        emp5.setName("Ankita");
//        emp5.setAge(29);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Employee employee = session.find(Employee.class, 109);
        session.beginTransaction();

        //UPDATE
//        session.merge(emp5);
//        System.out.println("Employee data updated successfully");

        //Delete
        session.remove(employee);
        System.out.println("Employee data deleted successfully");

        session.getTransaction().commit();
        sf.close();
        session.close();
    }
}
