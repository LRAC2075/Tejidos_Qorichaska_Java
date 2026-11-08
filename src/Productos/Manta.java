package Productos;

import Productos.Interfaces.IPrendible;

public class Manta extends Producto implements IPrendible {
    
    private String talla;
    private String color;

    public Manta(String codigo, String nombre, double precio, int stock, String talla, String color) throws Exception {
        super(codigo, nombre, precio, stock);
        this.talla = talla;
        this.color = color;
    }

    @Override
    public String obtenerDescripcion() {
        return "Manta de color " + this.color;
    }

    @Override 
    public String obtenerTalla() {
        return this.talla;
    }

    
    @Override 
    public String obtenerColor() {
        return this.color;
    }


    @Override 
    public String toFileString() {
        String str = super.toFileString();
        return str + ";" + this.talla + ";" + this.color;
    }

    @Override 
    public String toString() {
        return "Codigo: " + this.getCodigo() + "\nNombre: " + this.getNombre() + "\nPrecio: " + this.getPrecio() + "\nStock: " + this.getStock() + "\nTalla: " + this.talla + "\nColor: " + this.color;
    }
}
