package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student09 student=session.get(Student09.class,1002);
//        session.delete(student);

//        Book09 book1=session.get(Book09.class,101);


        tx.commit();
        session.close();
/*
Eager yapida calisirken asagidaki sorguda hata almiyorken, FetchType LAZY olsaydi exception alacaktik.

        for (Book09 book: student.getBookList()){
            System.out.println(book);
        }
 */

        sf.close();

    }

}
