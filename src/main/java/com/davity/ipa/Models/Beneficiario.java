package com.davity.ipa.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Beneficiario extends Persona {

    private String curp;

    public Beneficiario(StringProperty nombre, IntegerProperty numeroTelefono, StringProperty direccion, StringProperty correo, String curp){
        super(nombre,numeroTelefono,direccion,correo);
        this.curp=curp;
    }

    
}
