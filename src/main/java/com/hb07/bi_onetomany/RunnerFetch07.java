package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // get methodu
        System.out.println(session.get(Student07.class, 1001));

        System.out.println(session.get(Student07.class, 1001).getBookList());

        Student07 student=session.get(Student07.class, 1001);

        student.getBookList().forEach(System.out::println);

        student.getBookList().forEach(b-> System.out.println(b));

        // sql ile ogrenci bilgilerini alalim.
        String sqlQuery="select s.student_name, b.name from student07 s inner join book07 b on b.student_id=s.id";
        List<Object[]>resultList1=session.createSQLQuery(sqlQuery).getResultList();
        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));

        String hqlQuery="select s.name, b.name from Student07 s inner join fetch Book07 b on s.id=b.student.id";
        List<Object[]>resultList2=session.createQuery(hqlQuery).getResultList();
        resultList2.forEach(oa-> System.out.println(Arrays.toString(oa)));

        tx.commit();
        sf.close();
        session.close();

    }

}
