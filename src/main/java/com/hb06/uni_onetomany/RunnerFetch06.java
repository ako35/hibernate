package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // get methodu
        Student06 student=session.get(Student06.class,1001);
        System.out.println(student);

        // hql ile id si 101 olan kitabi getirelim.
        String hqlQuery="from Book06 b where b.id=101";
        Book06 book=session.createQuery(hqlQuery, Book06.class).uniqueResult();
        System.out.println(book);

        // hql ile bir ogrencinin kitaplarini ogrenci id ye gore getirme
        String hqlQuery2="from Student06 s where s.id=1001";
        Student06 student1=session.createQuery(hqlQuery2, Student06.class).uniqueResult();
        System.out.println(student1.getBookList());

        String hqlQuery3="select b.id, b.name from Student06 s inner join s. bookList b where s.id=1001";
        List<Object[]>resultList1=session.createQuery(hqlQuery3).getResultList();
        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));

        tx.commit();
        sf.close();
        session.close();

    }

}
