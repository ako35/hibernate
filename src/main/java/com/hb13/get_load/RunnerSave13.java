package com.hb13.get_load;

import com.hb12.caching.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {

    public static void main(String[] args) {

        Student13 student1=new Student13();
        student1.setName("Mustafa Keser");
        student1.setMathGrade(35);

        Student13 student2=new Student13();
        student2.setName("Yusuf Sefa Bayindir");
        student2.setMathGrade(35);

        Student13 student3=new Student13();
        student3.setName("Halide K");
        student3.setMathGrade(35);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        sf.close();
        session.close();

    }

}
