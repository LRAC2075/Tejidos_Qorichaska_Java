package Productos;

import Productos.Interfaces.IPrendible;

public class Poncho extends Producto implements IPrendible {
    // Se crea la variable talla para poder implementar la interfaz IPrendible. No se usó en la clase Producto porque no todos los productos tienen talla, por ejemplo, un mantel no tiene talla.

    private String talla;
    private String color;

    public Poncho (String codigo, String nombre, double precio, int stock, String talla, String color) throws Exception {
        // Coloco los atributos de la clase padre Producto con super para poder acceder a ellos desde esta clase hija. Esto es necesario porque super me permite acceder a los atributos de la clase padre Producto, que son privados y no se pueden acceder directamente desde la clase hija. Super puede acceder gracias a que este llama al constructor de la clase padre.

        super(codigo, nombre, precio, stock);
        this.talla = talla;
        this.color = color;
    }

    // Override se utiliza para sobrescribir el método abstracto obtenerDescripcion() de la clase Producto. Esto es necesario porque cada producto tiene su propia descripción, y no se puede tener una descripción genérica para todos los productos.

    @Override 
    public String obtenerDescripcion() {
        return "Esto es un poncho de talla " + this.talla + " y color " + this.color + ". Quedan en stock " + this.getStock() + " unidades.";
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
