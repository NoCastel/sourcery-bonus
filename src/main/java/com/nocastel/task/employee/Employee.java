package com.nocastel.task.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private Long phoneNumber;
    
    Employee() {
    }

    Employee(String name, String email, Long phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, email: %s, number: %d", name, email, phoneNumber);
    }
}