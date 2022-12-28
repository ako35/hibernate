package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student010.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student010 student010 = session.get(Student010.class, 10012);
        Student010 student011 = session.get(Student010.class, 1002);
        Student010 student012 = session.get(Student010.class, 1003);
        System.out.println(student010);
        System.out.println(student011);
        System.out.println(student012);

        String sqlQuery = "select * from t_student010";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] object : resultList) {
            System.out.println(Arrays.toString(object));
        }

        String hqlQuery = "from Student010";
        List<Student010> resultList2 = session.createQuery(hqlQuery, Student010.class).getResultList();
        for (Student010 student01 : resultList2) {
            System.out.println(student01);
        }

        String sqlQuery2 = "select * from t_student010 where student_name='Ali Kocan'";
        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult1));

        System.out.println(uniqueResult1[0] + " " + uniqueResult1[1] + " " + uniqueResult1[2]);

        String hqlQuery2 = "from Student010 where name='Ali Kocan'";
        Student010 uniqueResult2 = session.createQuery(hqlQuery2, Student010.class).uniqueResult();
        System.out.println(uniqueResult2);

        tx.commit();

        session.close();
        sf.close();


    }
}
