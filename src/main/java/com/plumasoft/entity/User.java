package com.plumasoft.entity;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String nombre;
    public String apellido;

    public User() {}

    public User(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, nombre='%s', apellido='%s']",
                id, nombre, apellido);
    }

}