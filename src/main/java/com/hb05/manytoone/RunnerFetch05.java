package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // get methodu
        Student05 student=session.get(Student05.class,1001);
        System.out.println(student);
        System.out.println(student.getUniversity());

        // 1 id li universiteye giden butun ogrencileri bulalim hql ile
        String hqlQuery="from Student05 s where s.university.id=1";
        List<Student05> resultList=session.createQuery(hqlQuery, Student05.class).getResultList();
        for (Student05 student05:resultList){
            System.out.println(student05);
        }

        resultList.forEach(s-> System.out.println(s));


        tx.commit();
        sf.close();
        session.close();

    }

}
