package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    static void main(String[] args) {

        // Update
        // Laptop l1 = new Laptop();
        // l1.setLid(5);
        // l1.setBrand("Dell");
        // l1.setModel("Inspiron");
        // l1.setRam("32GB");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        //session.beginTransaction();

        //Update
        //session.persist(l1);
        //System.out.println("Employee data persist successfully");

        //session.getTransaction().commit();

        // Fetching Data
        //Laptop l2 = session.find(Laptop.class, 4);
        //System.out.println("Data Fetched Successfully : " + l2);

        // Fetch data using HQL
        // select * from laptop where ram='32GB' --> SQL
        // from laptop where ram='32GB' --> HQL


        //Query query = session.createQuery("from Laptop");
        //Query query = session.createQuery("from Laptop where ram='32GB'",  Laptop.class);
        //Query query = session.createQuery("from Laptop where brand like 'Apple'");

        String brand = "Dell";

        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
//        List<Laptop> laptopList = query.getResultList();
//        for (Object o : laptopList) {
//            System.out.println(o);
//        }

        List<Object[]> laptopList = query.getResultList();
        for (Object[] date : laptopList) {
            for (Object model : date) {
                System.out.print(model + " ");
            }
        }

        sf.close();
        session.close();
    }
}
