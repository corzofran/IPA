package com.davity.ipa.Models;

public class Empleado extends Usuario  {

    private String nombre;
    private String correo;
    private String numeroTelefonico;
    private String sexo;

    public Empleado(String id, String password, String nombre, String correo, String numeroTelefonico, String sexo) {
        super(id, password);
        this.nombre=nombre;
        this.correo=correo;
        this.numeroTelefonico=numeroTelefonico;
        this.sexo=sexo;
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
