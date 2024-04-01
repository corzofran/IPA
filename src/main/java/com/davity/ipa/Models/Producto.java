package com.davity.ipa.Models;

import java.util.ArrayList;

public class Producto {

    private String nombre;
    private int cantidad;
    private String clasificacion;
    private int positionElimined;

   private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
  private static ArrayList<String> productclasification = new ArrayList<>();

    public Producto() {

    }

    public Producto(String nombre, int cantidad, String clasificacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
    }

    public boolean addNombre(String nombre){
        this.nombre = nombre;
        return productname.add(nombre);
    }

    public boolean addCantidad(int cantidad){
        this.cantidad = cantidad;
        return productquantity.add(cantidad);
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

    ////////////////////////////////////


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
