package com.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        /*  Level 2 cache using Ehcache   */
        Laptop l1 = session.find(Laptop.class, 1);
        System.out.println(l1);

        Laptop l2 = session.find(Laptop.class, 1);
        System.out.println(l2);

        sf.close();
        session.close();
    }
}
