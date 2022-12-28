package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student010 student1 = new Student010();
        student1.setId(10012);
        student1.setName("Samet Guler2");
        student1.setGrade(902);

        Student010 student02=new Student010();
        student02.setId(100101);
        student02.setName("Ali Kocan");
        student02.setGrade(1000);

        Student010 student010=new Student010();
        student010.setId(1002);
        student010.setName("Ahmet Temizguney");
        student010.setGrade(1023);

        Student010 student011=new Student010();
        student011.setId(1003);
        student011.setName("Ahmet Bas");
        student011.setGrade(1040);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student010.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student011);

        tx.commit();

        session.close();
        sf.close();

    }
}
