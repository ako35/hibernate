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
//        System.out.println(session.get(Student07.class, 1001));
//
//        System.out.println(session.get(Student07.class, 1001).getBookList());
//
//        Student07 student=session.get(Student07.class, 1001);
//
//        student.getBookList().forEach(System.out::println);
//
//        student.getBookList().forEach(b-> System.out.println(b));

        // sql ile ogrenci bilgilerini alalim.
//        String sqlQuery="select s.student_name, b.name from student07 s inner join book07 b on b.student_id=s.id";
//        List<Object[]>resultList1=session.createSQLQuery(sqlQuery).getResultList();
//        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));
//
//        String hqlQuery="select s.name, b.name from Student07 s inner join fetch Book07 b on s.id=b.student.id";
//        List<Object[]>resultList2=session.createQuery(hqlQuery).getResultList();
//        resultList2.forEach(oa-> System.out.println(Arrays.toString(oa)));

        // delete islemi sql ile
//        String sqlQuery1="delete from book07";
//        int silinenKayitSayisi=session.createSQLQuery(sqlQuery1).executeUpdate();
//        System.out.println(silinenKayitSayisi);

//        String sqlQuery2="delete from student07";
//        int silinenKayitSayisi2=session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println(silinenKayitSayisi2);

        // delete islemi hql ile
//        String hqlQuery3="delete from Book07";
//        int silinenKayitSayisi3=session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println(silinenKayitSayisi3);

//        String hqlQuery4="delete from Student07";
//        int silinenKayitSayisi4=session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println(silinenKayitSayisi4);

        // A Book kitabini hql ile siliniz.
//        String hqlQuery5="delete from Book07 b where b.name='A Book'";
//        int silinenKayitSayisi5=session.createQuery(hqlQuery5).executeUpdate();
//        System.out.println(silinenKayitSayisi5);

        // kitap bilgisi olan bir ogrenciyi silmek istersek bunun iki yolu var
        // once book tablosundan iliskili oldugu book lar silinir daha sonra istenen student objesi silinebilir.
        // student entity clasinin ilgili yerine cascade / orphanRemoval

        // 1001 id li student objemi delete methoduyla silelim
//        Student07 student=session.get(Student07.class,1001);
//        session.delete(student);

        // student.getBookList().set(0,null) // orphanRemovel=true, 0. index deki child i Child tablosundan siler.

        // book ismi icinde Java gecen student kayitlarini alalim
        String hqlQuery6="select s from Student07 s join s.bookList b where b.name like '%Java%'";
        List<Student07>resultList6=session.createQuery(hqlQuery6,Student07.class).getResultList();
        resultList6.forEach(oa-> System.out.println(oa));
        resultList6.forEach(System.out::println);

        tx.commit();
        sf.close();
        session.close();

    }

}
