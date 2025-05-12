import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario(200, 1000);
        boolean continuar = true;



        while (continuar) {
            System.out.println("\n--- Menú de Gestión de Inventario VitalNature ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Eliminar productos vencidos");
            System.out.println("4. Calcular valor total del inventario");
            System.out.println("5. Modificar producto existente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID del producto: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    System.out.print("Precio de compra: ");
                    double precioCompra = sc.nextDouble();
                    System.out.print("Precio de venta: ");
                    double precioVenta = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nombre del proveedor: ");
                    String nombreProveedor = sc.nextLine();
                    System.out.print("Tiempo de entrega (días): ");
                    int tiempoEntrega = sc.nextInt();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
                    String fecha = sc.next();
                    LocalDate fechaVencimiento = LocalDate.parse(fecha);

                    Proveedor proveedor = new Proveedor(nombreProveedor, tiempoEntrega);
                    Producto producto = new Producto(id, nombre, categoria, precioCompra, precioVenta, proveedor);
                    StockItem item = new StockItem(producto, cantidad, fechaVencimiento);

                    inventario.agregarStockItem(item);
                    System.out.println("Producto agregado correctamente.");
                    break;
                case 2:
                    inventario.mostrarInventario();
                    break;
                case 3:
                    inventario.eliminarVencidos();
                    System.out.println("Productos vencidos eliminados.");
                    break;
                case 4:
                    System.out.println("Valor total del inventario: $" + inventario.calcularValorTotal());
                    break;
                case 5:

                    System.out.print("Ingrese el ID del producto a modificar: ");
                    String buscarId = sc.nextLine();
                    StockItem modItem = inventario.buscarPorId(buscarId);
                    if (modItem != null) {
                        boolean modificando = true;
                        while (modificando) {
                            System.out.println("\n--- Menú de modificación ---");
                            System.out.println("1. Nombre");
                            System.out.println("2. Categoría");
                            System.out.println("3. Precio de compra");
                            System.out.println("4. Precio de venta");
                            System.out.println("5. Nombre del proveedor");
                            System.out.println("6. Tiempo de entrega");
                            System.out.println("7. Cantidad");
                            System.out.println("8. Fecha de vencimiento");
                            System.out.println("9. Salir de modificación");
                            System.out.print("Seleccione el campo a modificar: ");
                            int op = sc.nextInt(); sc.nextLine();
                            Producto p = modItem.getProducto();
                            switch (op) {
                                case 1:
                                    System.out.print("Nuevo nombre: ");
                                    p.setNombre(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.print("Nueva categoría: ");
                                    p.setCategoria(sc.nextLine());
                                    break;
                                case 3:
                                    System.out.print("Nuevo precio de compra: ");
                                    p.setPrecioCompra(sc.nextDouble());
                                    sc.nextLine();
                                    break;
                                case 4:
                                    System.out.print("Nuevo precio de venta: ");
                                    p.setPrecioVenta(sc.nextDouble());
                                    sc.nextLine();
                                    break;
                                case 5:
                                    System.out.print("Nuevo nombre del proveedor: ");
                                    p.getProveedor().setNombre(sc.nextLine());
                                    break;
                                case 6:
                                    System.out.print("Nuevo tiempo de entrega: ");
                                    p.getProveedor().setTiempoEntregaDias(sc.nextInt());
                                    sc.nextLine();
                                    break;
                                case 7:
                                    System.out.print("Nueva cantidad: ");
                                    modItem.setCantidad(sc.nextInt());
                                    sc.nextLine();
                                    break;
                                case 8:
                                    System.out.print("Nueva fecha de vencimiento (YYYY-MM-DD): ");
                                    modItem.setFechaVencimiento(LocalDate.parse(sc.nextLine()));
                                    break;
                                case 9:
                                    modificando = false;
                                    System.out.println("Modificación finalizada.");
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
        System.out.println("Sistema cerrado.");
}
}