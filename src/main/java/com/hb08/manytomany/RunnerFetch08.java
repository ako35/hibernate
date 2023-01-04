package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // get ile bir ogrenci getirelim.
//        System.out.println(session.get(Student08.class, 1001));

        // get ile book getirelim.
        System.out.println(session.get(Book08.class, 101));

        tx.commit();
        sf.close();
        session.close();

    }

}
