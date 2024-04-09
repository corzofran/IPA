package com.davity.ipa.Models;

import java.util.ArrayList;

public class Objetos extends Producto{

    private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
    private static ArrayList<String> productclasification = new ArrayList<>();

    public Objetos(String nombre, String cantidad, String clasificacion) {
        super(nombre, cantidad, clasificacion);
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

    public static ArrayList<String> getProductnames() {
        return productname;
    }

    public static ArrayList<Integer> getProductquantitys() {
        return productquantity;
    }

    public static ArrayList<String> getProductclasifications() {
        return productclasification;
    }


}