package com.davity.ipa.Models;

public class Beneficiario extends Persona {

    private String curp;


    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Beneficiario(String nombre, String numeroTelefono, String direccion, String curp, String correo) {
        super(nombre, numeroTelefono, direccion, correo);
        this.curp= curp;


    }
}
