import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario(200, 1000);
        boolean continuar = true;
        Proveedor prov1 = new Proveedor("Proveedor Andes", 5);
        Producto p1 = new Producto("001", "Té Verde", "TéOrgánico", 1.2, 2.5, prov1);
        Producto p2 = new Producto("002", "Aceite de Lavanda", "AceiteEsencial", 3.5, 6.5, prov1);

        StockItem si1 = new StockItem(p1, 100, LocalDate.of(2025, 7, 15));
        StockItem si2 = new StockItem(p2, 50, LocalDate.of(2025, 5, 1));


        inventario.agregarStockItem(si1);
        inventario.agregarStockItem(si2);



        while (continuar) {
            System.out.println("\n--- Menú de Gestión de Inventario VitalNature ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Eliminar productos vencidos");
            System.out.println("4. Calcular valor total del inventario");
            System.out.println("5. Salir");
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