package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

    public static void main(String[] args) {

<<<<<<< HEAD
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student02 student = session.get(Student02.class, 1001);
        System.out.println(student);
        System.out.println(student.getAdress());

        tx.commit();
        session.close();
        sf.close();
    }
=======
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student02 student= session.get(Student02.class,1001);
        System.out.println(student);
        System.out.println(student.getAddress());

        tx.commit();
        sf.close();
        session.close();

    }


>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3
}
