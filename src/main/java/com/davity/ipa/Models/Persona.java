package com.davity.ipa.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Persona {

 protected final StringProperty nombre;
 protected final IntegerProperty numeroTelefono;
 protected final StringProperty direccion;
 protected final StringProperty correo;


public Persona(){
    nombre=new SimpleStringProperty(this,"nombre");
    numeroTelefono=new SimpleIntegerProperty(this,"numeroTelefono");
    direccion=new SimpleStringProperty(this,"direccion");
    correo=new SimpleStringProperty(this,"correo");
}

    public Persona(StringProperty nombre, IntegerProperty numeroTelefono, StringProperty direccion, StringProperty correo) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public int getNumeroTelefono() {
        return numeroTelefono.get();
    }

    public IntegerProperty numeroTelefonoProperty() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono.set(numeroTelefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getCorreo() {
        return correo.get();
    }

    public StringProperty correoProperty() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }


}
