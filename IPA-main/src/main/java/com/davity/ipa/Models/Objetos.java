package com.davity.ipa.Models;

import java.util.ArrayList;

public class Objetos extends Producto{

    private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
    private static ArrayList<String> productclasification = new ArrayList<>();
    private static ArrayList<String> productmark = new ArrayList<>();

    public Objetos(String nombre, String cantidad, String clasificacion, String marca) {
        super(nombre, cantidad, clasificacion, marca);
    }

public Objetos(){

}

    public static boolean addNombres(String nombre){
        return productname.add(nombre);
    }

    public static boolean addCantidades(String cantidad){
        return productquantity.add(Integer.valueOf(cantidad));
    }

    public static boolean addClasificaciones(String clasificacion){
        return productclasification.add(clasificacion);
    }

    public static boolean addMarks(String marca){
        return productmark.add(marca);
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

    public static ArrayList<String> getProductmark() {
        return productmark;
    }
}