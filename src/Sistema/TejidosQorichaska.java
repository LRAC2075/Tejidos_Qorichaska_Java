package Sistema;

import Productos.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TejidosQorichaska {
    
    private ArrayList<Producto> inventario;
    private Scanner teclado = new Scanner(System.in);

    public TejidosQorichaska() {
        // Acá declaro con this para que se entienda que estoy haciendo referencia al atributo de la clase y no a una variable local

        this.inventario = new ArrayList<Producto>();
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = this.menu();
            switch (opcion) {
                case 1: leerArchivo();
                    break;
                case 2: registrarProducto();
                    break;
                case 3: listarProductos();
                    break;
                case 4: editarProducto();
                    break;
                case 5: eliminarProducto();
                    break;
                case 6: guardarProductos();
                    break;
                case 7: buscarXCodigo();
                    break;
                case 8: 
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("\n\n\tNo es una opción válida. \n\n");
            }
        } while (opcion != 8);
    }

    public int menu() {
        System.out.println("\n---TEJIDOS QORICHASKA---");
        System.out.println("1. Cargar productos (de archivo).");
        System.out.println("2. Registrar nuevo producto.");
        System.out.println("3. Listar productos.");
        System.out.println("4. Editar producto.");
        System.out.println("5. Eliminar producto.");
        System.out.println("6. Guardar productos (en archivo).");
        System.out.println("7. Buscar producto por código.");
        System.out.println("8. Salir.");
        System.out.println("-------------------------------");
        System.out.println("Seleccione una opción: ");
        int opc = teclado.nextInt();
        return opc;
    }

    private void registrarProducto() {
        System.out.println("\n¿Qué tipo de producto va a registrar?: \n[1] Manta \n[2] Poncho \n[3] Bufanda \nSeleccione su opción: ");
        int tipo;
        try {
            tipo = Integer.parseInt((teclado.nextLine().trim()));
        } catch (Exception e) {
            System.out.println("Opción no válida. Debe ingresar un número entre 1 y 3.");
            return;
        }

        if (tipo >= 1 && tipo <= 3) {
            System.out.println("Ingrese el código del producto a registrar: ");
            String codigo = teclado.nextLine();
            System.out.println("Ingrese el nombre del producto a registrar: ");
            String nombre = teclado.nextLine();
            System.out.println("Ingrese el precio del producto a registrar: ");
            double precio = Double.parseDouble(teclado.nextLine().trim());
            System.out.println("Ingrese el stock del producto a registrar: ");
            int stock = Integer.parseInt(teclado.nextLine().trim());

            switch (tipo) {
                case 1:
                    System.out.println("Ingrese la talla de la manta:");
                    System.out.println("[S] S \n[M] M \n[L] L \n[XL] XL");
                    String tallaManta = teclado.nextLine();
                    System.out.println("Ingrese el color de la manta: ");
                    String colorManta = teclado.nextLine();
                    try {
                        Manta m = new Manta(codigo, nombre, precio, stock, tallaManta, colorManta);
                        this.inventario.add(m);
                        System.out.println("Manta registrada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al registrar la manta: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la talla del poncho: ");
                    System.out.println("[S] S \n[M] M \n[L] L \n[XL] XL");
                    String tallaPoncho = teclado.nextLine();
                    try {
                        Poncho p = new Poncho(
                            codigo, 
                            nombre, 
                            precio, 
                            stock, 
                            tallaPoncho, 
                            "Color no especificado" // Pongo un color por defecto ya que no se solicita al usuario en este caso
                        );
                        this.inventario.add(p);
                        System.out.println("Poncho registrado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al registrar el poncho: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el color de la bufanda: ");
                    String colorBufanda = teclado.nextLine();
                    try {
                        Bufanda b = new Bufanda(codigo, nombre, precio, stock, colorBufanda);
                        this.inventario.add(b);
                        System.out.println("Bufanda registrada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al registrar la bufanda: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Ocurrió un error al registrar el producto. Por favor, intente nuevamente.");
                    break;
            }
        } else {
            System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
        }

    }

    private void listarProductos() {
        for (Producto prod : inventario) {
            System.out.println(prod.toString());
            System.out.println("-------------------------------");
        }
    }

    private int buscarXCodigo () {
        System.out.println("Ingrese el código del producto a buscar: ");
        String codigoBuscar = teclado.nextLine();
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getCodigo().equals(codigoBuscar)) {
                Producto prod = inventario.get(i);
                System.out.println("Producto encontrado: ");
                System.out.println("Codigo: " + prod.getCodigo());
                System.out.println("Nombre: " + prod.getNombre());
                System.out.println("Precio: " + prod.getPrecio());
                System.out.println("Stock: " + prod.getStock());
                return i;
            }
        }
        System.out.println("Producto no encontrado.");
        return -1;
    }

    private void editarProducto() {
        int indice = this.buscarXCodigo();
        if (indice < 0) {
            System.out.println("Producto no encontrado. No se puede editar. ");
            return;
        }
        try {
            Producto prod = this.inventario.get(indice);

            System.out.println("Ingrese e nuevo nombre: ");
            prod.setNombre(teclado.nextLine());

            System.out.println("Ingrese el nuevo precio: ");
            prod.setPrecio(Double.parseDouble(teclado.nextLine()));

            System.out.println("Ingrese el nuevo stock: ");
            prod.setStock(Integer.parseInt(teclado.nextLine()));

            switch (prod.getClass().getSimpleName()) {
                case "Manta":
                    System.out.println("Ingrese la nueva talla de la manta: ");
                    String nueva_talla_manta = teclado.nextLine();

                    // Este método se llama Casting. Según encontré, es para poder tratar a la variable prod como un objeto de tipo (objeto_especificado).

                    ((Manta) prod).setTalla(nueva_talla_manta);
                    System.out.println("Ingrese el nuevo color de la manta: ");
                    String nuevo_color_manta = teclado.nextLine();
                    ((Manta) prod).setColor(nuevo_color_manta);
                    break;
                case "Poncho":
                    System.out.println("Ingrese la nueva talla del poncho: ");
                    String nueva_talla_poncho = teclado.nextLine();
                    ((Poncho) prod).setTalla(nueva_talla_poncho);
                    System.out.println("Ingrese el nuevo color del poncho: ");
                    String nuevo_color_poncho = teclado.nextLine();
                    ((Poncho) prod).setColor(nuevo_color_poncho);
                    break;
                case "Bufanda":
                    System.out.println("Ingrese el nuevo color de la bufanda: ");
                    String nuevo_color_bufanda = teclado.nextLine();
                    ((Bufanda) prod).setColor(nuevo_color_bufanda);
                    break;
            }
            System.out.println("Producto editado correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar editar el producto: " + e.getMessage());
        }
    }

    private void eliminarProducto() {
        int indice = this.buscarXCodigo();

        if (indice >= 0) {
            this.inventario.remove(indice);
            System.out.println("Producto eliminado del sistema.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void guardarProductos() {
        int contReg = 0;
        try ( // TRY - WITH - RESOURCES
            FileWriter file = new FileWriter("productos.txt");
            BufferedWriter bw = new BufferedWriter(file)
        ) {
            for (Producto prod : inventario) {
                String tipo = prod.getClass().toString().replace("class Productos.", "");
                String prod_to_line = null;
                switch (tipo) {
                    case "Poncho":
                        prod_to_line = ((Poncho) prod).toFileString();
                        break;
                    case "Manta":
                        prod_to_line = ((Manta) prod).toFileString();
                        break;
                    case "Bufanda":
                        prod_to_line = ((Bufanda) prod).toFileString();
                        break;
                }
                String linea = tipo + ";" + prod_to_line;
                bw.write(linea);
                bw.newLine();
                contReg++;
            }
            System.out.println("Se guardaron " + contReg + " registros en el archivo.");
        } catch (IOException e) {
            System.out.println("Algo fallo al intentar guardar en el archivo.");
        }
    }

    private void leerArchivo() {
        int contReg = 0;
        try ( // TRY - WITH - RESOURCES
            BufferedReader br = new BufferedReader(new FileReader("productos.txt"))
        ) {
            String linea = null;
            while ( (linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                this.guardarEnInventario(datos);
                contReg++;
            }
            System.out.println("Se cargaron " + contReg + " registros del archivo.");
        } catch (IOException e) {
            System.out.println("Algo fallo al intentar leer el archivo.");
        } catch (Exception e) {
            System.out.println("Error al intentar guardar en inventario: " + e.getMessage()); 
        }
    }

    private void guardarEnInventario(String[] datos) {
        String tipo = datos[0];

        try {
            switch (tipo) {
                case "Manta":
                    Manta m = new Manta(
                        datos[1], // codigo
                        datos[2], // nombre
                        Double.parseDouble(datos[3]), // precio
                        Integer.parseInt(datos[4]), // stock
                        datos[5], // talla
                        datos[6]  // color
                    );
                    this.inventario.add(m);
                    break;
                case "Poncho":
                    Poncho p = new Poncho(
                        datos[1], // codigo
                        datos[2], // nombre
                        Double.parseDouble(datos[3]), // precio
                        Integer.parseInt(datos[4]), // stock
                        datos[5], // talla
                        datos[6]  // color
                    );
                    this.inventario.add(p);
                    break;
                case "Bufanda":
                    Bufanda b = new Bufanda(
                        datos[1], // codigo
                        datos[2], // nombre
                        Double.parseDouble(datos[3]), // precio
                        Integer.parseInt(datos[4]), // stock
                        datos[5]  // color   
                    );
                    this.inventario.add(b);
                    break;
                default:
                    System.out.println("Tipo de producto no reconocido: " + tipo);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Algo fallo al intentar guardar en inventario: " + e.getMessage());
        }
    }
}
