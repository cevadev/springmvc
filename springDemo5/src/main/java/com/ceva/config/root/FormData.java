package com.ceva.config.root;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class FormData {
    @NotEmpty(message="Te falta escribir un nombre.")
    @Size(min=5, max=64)
    private String name;

    @NotEmpty
    @Size(min=5, max=64)
    private String address;

    @NotEmpty
    @Size(min=8, max=16)
    private String phone;

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
