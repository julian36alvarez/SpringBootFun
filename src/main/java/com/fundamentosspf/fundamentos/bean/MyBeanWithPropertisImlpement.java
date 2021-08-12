package com.fundamentosspf.fundamentos.bean;

public class MyBeanWithPropertisImlpement implements MyBeanWithPropertis {
    private String nombre;
    private String apellido;

    public MyBeanWithPropertisImlpement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
