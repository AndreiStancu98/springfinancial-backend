package com.codecool.springfinancial.customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )

    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate dob;
    private String address;
    private String email;
    private LocalDate id_issued;
    private LocalDate id_expiry;
    private String gender;
    private String pid;
    @Transient
    private Integer age;

    public Customer() {
    }

    public Customer(Long id, String first_name, String last_name, LocalDate dob, String address, String email, LocalDate id_issued, LocalDate id_expiry, String gender, String pid) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.id_issued = id_issued;
        this.id_expiry = id_expiry;
        this.gender = gender;
        this.pid = pid;
    }

    public Customer(String first_name, String last_name, LocalDate dob, String address, String email, LocalDate id_issued, LocalDate id_expiry, String gender, String pid) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.id_issued = id_issued;
        this.id_expiry = id_expiry;
        this.gender = gender;
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getId_issued() {
        return id_issued;
    }

    public void setId_issued(LocalDate id_issued) {
        this.id_issued = id_issued;
    }

    public LocalDate getId_expiry() {
        return id_expiry;
    }

    public void setId_expiry(LocalDate id_expiry) {
        this.id_expiry = id_expiry;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getAge() {
        return age;
    }

}