package com.davity.ipa.Models;

import java.util.ArrayList;

public class Producto {

    protected String nombre;
    protected String cantidad;
    protected String clasificacion;
    protected int positionElimined;

   private static ArrayList<String> productname = new ArrayList<>();
   private static ArrayList<Integer> productquantity = new ArrayList<>();
   private static ArrayList<String> productclasification = new ArrayList<>();


public Producto(){

}

    public Producto(String nombre, String cantidad, String clasificacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
    }


    public boolean addNombre(String nombre){
        this.nombre = nombre;
        return productname.add(nombre);
    }

    public boolean addCantidad(String cantidad){
        this.cantidad = cantidad;
        return productquantity.add(Integer.valueOf(cantidad));
    }

    public boolean addClasificacion(String clasificacion){
        this.clasificacion = clasificacion;
        return productclasification.add(clasificacion);
    }

    public static ArrayList<String> getProductname() {
        return productname;
    }

    public static ArrayList<Integer> getProductquantity() {
        return productquantity;
    }

    public static ArrayList<String> getProductclasification() {
        return productclasification;
    }


    public int getPositionElimined() {
        return positionElimined;
    }

    public void setPositionElimined(int positionElimined) {
        this.positionElimined = positionElimined;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
