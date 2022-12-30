package com.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name="t_student02")
public class Student02 {

    @Id
    private int id;

<<<<<<< HEAD
    @Column(name="student_name", length = 100,nullable = false,unique = false)
=======
    @Column(name="student_name",length = 100, nullable = false, unique = false)
>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3
    private String name;

    private int grade;

<<<<<<< HEAD
    // @Embedded   // kullanımı optsiyonel
    private Address adress;

    // Getter-Setter
=======
    @Embedded // kullanimi opsiyonel kullansan da olur kullanmasanda
    private Address address;
>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

<<<<<<< HEAD
    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    // toString()

=======
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3
    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
