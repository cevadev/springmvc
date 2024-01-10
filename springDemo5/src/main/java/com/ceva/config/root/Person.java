package com.ceva.config.root;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
public class Person {
    private int id_person;

    @NotEmpty
    @Size(max=64)
    private String name;

    @NotEmpty
    @Size(max=64)
    private String address;

    @NotEmpty
    @Size(max=64)
    private String phone;

    public Person() {

    }

    public Person(int id_person, String name, String address, String phone) {
        this.id_person = id_person;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
