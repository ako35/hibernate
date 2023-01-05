package com.hb14.entity_life_cycle;

import javax.persistence.*;
/*
Hibernate in objeler ile nasil calistigi ile ilgili ek bilgi:
    Entity State:
        * Transient: objenin newlenmis hali, DB ile iliskisi yok

        * Persisted or Managed: DB de row a karsilik geldigi durum, save(), get() vs. yapildigi zamana denk geliyor.

        * Detached: session kapandiktan sonra elimizdeki objenin state durumu.

        * Removed: obje remove yapildigi zamanki durum.
 */

@Entity
public class Student14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int mathGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
