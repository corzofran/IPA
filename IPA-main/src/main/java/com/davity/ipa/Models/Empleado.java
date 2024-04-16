package com.davity.ipa.Models;

import java.util.ArrayList;

public class Empleado extends Usuario  {

    private String nombre;
    private String correo;
    private String numeroTelefonico;
    private String sexo;
    private static String usuarioSelect;

    public Empleado(String id, String password, String nombre, String correo, String numeroTelefonico, String sexo, String usuarioSelect) {
        super(id, password);
        this.nombre=nombre;
        this.correo=correo;
        this.numeroTelefonico=numeroTelefonico;
        this.sexo=sexo;
        this.usuarioSelect=usuarioSelect;
    }


    public static String getUsuarioSelect() {
        return usuarioSelect;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


}
