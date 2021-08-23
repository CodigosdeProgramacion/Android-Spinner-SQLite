package com.cdp.android_spinner_sqlite.entidades;

import androidx.annotation.NonNull;

public class Categorias {

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String toString() {
        return nombre;
    }
}