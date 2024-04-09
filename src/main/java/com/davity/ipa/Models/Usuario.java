package com.davity.ipa.Models;

import java.util.ArrayList;

public class Usuario {
    protected String id;
    protected String password;

    private static  ArrayList<String> usuario = new ArrayList<>();
    private static ArrayList<String> contrasena = new ArrayList<>();
    private static ArrayList<String> recuperarNames = new ArrayList<>();
    private static int notificacion;

    public Usuario(ArrayList<String> usuario, ArrayList<String> contrasena, ArrayList<String> recuperarNames, int notificacion) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.recuperarNames=recuperarNames;
        this.notificacion=notificacion;
    }

    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Usuario() {

    }


    public static ArrayList<String> getRecuperarNames() {
        return recuperarNames;
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

    public static ArrayList<String> getUsuario() {
        return usuario;
    }

    public static ArrayList<String> getContrasena() {
        return contrasena;
    }

    public void addUsuario(String element){
        usuario.add(element);
    }

    public void addContrasena(String element){
        contrasena.add(element);
    }

    public static int setNotificacion(int notificacion) {
        Usuario.notificacion = notificacion;
        return notificacion;
    }

    public static int getNotificacion() {
        return notificacion;
    }



}
