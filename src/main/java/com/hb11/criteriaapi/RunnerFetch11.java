package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {

    public static void main(String[] args) {

        /*
        CRUD (Create, Read, Update, Delete)
            C --> session.save
            R --> session.get, HQL, SQL
            U --> session.update, updateQuery
            D --> session.delete, HQL, SQL
         */

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student11 student=session.get(Student11.class,1L);
//        student.setName("Guncellenmis "+student.getName());
//        session.update(student);

        // degisken tanimlama
//        int sMathGrade=80;
//        int lMathGrade=75;
//
//        String hqlQuery="update Student11 s set s.mathGrade=:sMath where s.mathGrade<:lMath";
//        Query query=session.createQuery(hqlQuery);
//        query.setParameter("sMath",sMathGrade);
//        query.setParameter("lMath",lMathGrade);
//        int numOfRecords=query.executeUpdate();
//        System.out.println("Degistirilen kayit sayisi: "+numOfRecords);

        // CriteriaAPI
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Student11>criteriaQuery=cb.createQuery(Student11.class  );
        Root<Student11>root=criteriaQuery.from(Student11.class);

        // 1. ornek:
//        criteriaQuery.select(root);
//        Query<Student11>query1= session.createQuery(criteriaQuery);
//        List<Student11>resultList1= query1.getResultList();
//        resultList1.forEach(System.out::println);


        // 2. ornek: student ismi Student Name: 6 olan ogrenci bilgilerini getirelim.
//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Student Name: 6"));
//        Query<Student11>query2= session.createQuery(criteriaQuery);
//        List<Student11>resultList2=query2.getResultList();
//        resultList2.forEach(System.out::println);

        // 3. ornek: mathGrade degeri 80 den buyuk olan datalari getirelim.
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
//        List<Student11>resultList3= session.createQuery(criteriaQuery).getResultList();
//        resultList3.forEach(System.out::println);

        // 4. ornek: MathGrade degeri 95 den kucuk olan datalari getirelim.
        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),95));
        List<Student11>resultList4=session.createQuery(criteriaQuery).getResultList();
        resultList4.forEach(System.out::println);


        tx.commit();
        sf.close();
        session.close();

    }
}
