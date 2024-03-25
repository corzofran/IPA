package com.davity.ipa.Models;

public class Empleado extends Usuario  {

    private String nombre;
    private String correo;
    private int numeroTelefonico;
    private String sexo;
    public Empleado(String id, String password) {
        super(id, password);
    }

}
