package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
get() -->   gercek nesneyi dondurur,
            nesne yoksa null doner
            nesnenin oldugundan emin degilseniz get() kullanin
            donen nesneyi hemen kullanacaksam get() kullanilmali

load() -->  proxy nesne dondurur, gercek nesnenin golgesi,
            nesne yoksa exception firlatir
            donen nesne uzerinde delete yapilacaksa kullanilabilir
 */
public class RunnerFetch13 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

//        System.out.println("get methodunun baslangic yeri...");
//        Student13 student1= session.get(Student13.class,1L);
//        System.out.println("get methodunun bittigi satir...");
//        System.out.println("Student ID: "+student1.getId());
//        System.out.println("Student getName: "+student1.getName());

//        System.out.println("*************************************");
//        System.out.println("load methodunun baslangic yeri... ");
//        Student13 student2=session.load(Student13.class,2L);
//        System.out.println("getName() cagirildi.");
//        System.out.println("Student2 nin ismi: "+student2.getName());
//        System.out.println("getName() bitti...");
//        System.out.println("load methodunun bittigi satir...");

        // DB de olmayan id yi cagirirsak ?
//        System.out.println("get() methodu calismaya basladi.");
//        Student13 student3= session.get(Student13.class,5L);
//        System.out.println("get() methodu bitti.");
//
//        if (student3!=null){
//            System.out.println("Student ID: "+student3.getId());
//            System.out.println("Student getName: "+student3.getName());
//        }
        System.out.println("*******************************");
//
//        System.out.println("load() methodu calismaya basladi.");
//        Student13 student4=session.load(Student13.class,10L);
//        System.out.println("load() methodu bitti.");
//
//        if (student4!=null){
//            System.out.println("Student ID: "+student4.getId());
//            System.out.println("Student getName: "+student4.getName());
//        }

        // peki load() methodunu niye kullanayim ?
        Student13 student5= session.get(Student13.class,1L);
        session.delete(student5);

        // load methodu ile obje referansi alinir ve sonra delete cagrilir.
        // get methodu cagrilmayarak DB ye hit(database e sorgu gondermek) engellenmis olur.

        Student13 student6= session.load(Student13.class,1L);
        session.delete(student6);



        tx.commit();
        sf.close();
        session.close();

    }

}
