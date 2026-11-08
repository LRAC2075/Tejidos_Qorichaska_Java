package Productos;
// Este archivo actuará como la base de los productos a crear
// Lo que puedan hacer los  productos, lo que puedan tener, etc.

public abstract class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Se crea una clase constructora para inicializar los atributos de la clase Producto y así las herencias de esta clase puedan tener acceso a estos atributos

    public Producto(String codigo, String nombre, double precio, int stock) throws Exception {
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
    }

    // Get y Set de nombre

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }
    }

    // Get y Set de codigo

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
        if (codigo == null || codigo.isEmpty()) {
            throw new Exception("El código no puede estar vacío");
        }
    }

    // Get y Set de Stock

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Exception {
        if (stock < 0) {
            throw new Exception("El stock no puede ser negativo");
        }
    }

    // Get y Set de Precio
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws Exception {
        if (precio < 0) {
            throw new Exception("El precio no puede ser negativo");
        }
    }

    // Get y Set de Talla

    public String getTalla() {
        return null;
    }

    public void setTalla(String talla) throws Exception {
        if (talla == null || talla.isEmpty()) {
            throw new Exception("La talla no puede estar vacía");
        }
    }

    // Get y Set de Color

    public String getColor() {
        return null;
    }

    public void setColor(String color) throws Exception {
        if (color == null || color.isEmpty()) {
            throw new Exception("El color no puede estar vacío");
        }
    }

    // Se crea un método abstracto para que cada producto tenga su propia descripción

    public abstract String obtenerDescripcion();

    public String toFileString() {
        return this.codigo + ";" + this.nombre + ";" + this.precio + ";" + this.stock;
    }
}