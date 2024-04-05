package com.davity.ipa.Models;

import java.util.ArrayList;

public class Objetos extends Producto{

    private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
    private static ArrayList<String> productclasification = new ArrayList<>();
    public Objetos(String nombre, String cantidad, String clasificacion) {
        super(nombre, cantidad, clasificacion);

    }

    public boolean addNombres(String nombre){
        this.nombre = nombre;
        return productname.add(nombre);
    }

    public boolean addCantidades(String cantidad){
        this.cantidad = cantidad;
        return productquantity.add(Integer.valueOf(cantidad));
    }

    public boolean addClasificaciones(String clasificacion){
        this.clasificacion = clasificacion;
        return productclasification.add(clasificacion);
    }

    public static ArrayList<String> getProductnames() {
        return productname;
    }

    public static ArrayList<Integer> getProductquantitys() {
        return productquantity;
    }

    public static ArrayList<String> getProductclasifications() {
        return productclasification;
    }

    public Objetos() {

    }
}