package com.hb12.caching;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
/*
1) first level cache:
    defaultta acik geliyor kapatma durumu yok
    ayni session icinde kayit alir.
    session kapaninca icindekiler silinir.

2) second level cache:
    defaultta kapalidir.
    session factory seviyesinde cachleme yapar yani farkli sessionlar arasinda data kullanilabiliyor
    hibernate.cfg.xml den active edilebilir.

3) query cache:
    query ler icin kullaniliyor.
    hibernate.cfg.xml den active edilebilir.
 */

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student12")
public class Student12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int mathGrade;

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
