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

        /*  EAGER LOADING    */
        //Laptop l1 = session.get(Laptop.class, 1);
        //Laptop l1 = session.find(Laptop.class, 1);

        /*  LAZY LOADING    */
        //Laptop l1 = session.load(Laptop.class, 1);
        //Laptop l1 = session.byId(Laptop.class).getReference(1);
        Laptop l1 = session.getReference(Laptop.class,1);
        //System.out.println(l1);

        sf.close();
        session.close();
    }
}
