package Productos;

public class Bufanda extends Producto{

    private String color;

    public Bufanda(String codigo, String nombre, double precio, int stock, String color) throws Exception {
        super(codigo, nombre, precio, stock);
        this.color = color;
    }

    @Override
    public String obtenerDescripcion() {
        return "Bufanda de color " + this.color;
    }

    @Override 
    public String toFileString() {
        String str = super.toFileString();
        return str + ";" + this.color;
    }

    @Override 
    public String toString() {
        return "Codigo: " + this.getCodigo() + "\nNombre: " + this.getNombre() + "\nPrecio: " + this.getPrecio() + "\nStock: " + this.getStock() + "\nColor: " + this.color;
    }

}