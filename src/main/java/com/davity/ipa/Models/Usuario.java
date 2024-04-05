package com.davity.ipa.Models;

import java.util.ArrayList;

public class Usuario {
    protected String id="david";
    protected String password= "1234";

    private ArrayList<String> usuario = new ArrayList<>();
    private ArrayList<String> contrasena = new ArrayList<>();


    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
