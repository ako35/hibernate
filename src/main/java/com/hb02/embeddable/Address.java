package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String country;
<<<<<<< HEAD
    private String zipCode;

    // Getter-Setter

=======
    private String zipcode;
>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

<<<<<<< HEAD
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // toString()

=======
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
<<<<<<< HEAD
                ", zipCode='" + zipCode + '\'' +
=======
                ", zipcode='" + zipcode + '\'' +
>>>>>>> 1345d3e77ea90f134743890cffd50ba648d7bba3
                '}';
    }
}
