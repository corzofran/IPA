package com.davity.ipa.Models;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> product = new ArrayList<>();

    public ArrayList<Producto> getProduct() {
        return product;
    }

    public void agregarProdcutos(Producto producto){
        product.add(producto);
    }
}
