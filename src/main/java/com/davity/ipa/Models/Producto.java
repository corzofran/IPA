package com.davity.ipa.Models;

import java.util.ArrayList;

public class Producto {

    private String nombre;
    private int cantidad;
    private String clasificacion;
    private int positionArray;

   private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
  private static ArrayList<String> productclasification = new ArrayList<>();

    public Producto() {

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

    public int getPositionArray() {
        return positionArray;
    }
}
