import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Proveedor prov1 = new Proveedor("Proveedor Andes", 5);
        Producto p1 = new Producto("001", "Té Verde", "TéOrgánico", 1.2, 2.5, prov1);
        Producto p2 = new Producto("002", "Aceite de Lavanda", "AceiteEsencial", 3.5, 6.5, prov1);

        StockItem si1 = new StockItem(p1, 100, LocalDate.of(2025, 7, 15));
        StockItem si2 = new StockItem(p2, 50, LocalDate.of(2025, 5, 1));

        Inventario inventario = new Inventario(200, 1000);
        inventario.agregarStockItem(si1);
        inventario.agregarStockItem(si2);

        System.out.println("--- Inventario Inicial ---");
        inventario.mostrarInventario();

        System.out.println("\nEliminando productos vencidos...");
        inventario.eliminarVencidos();

        System.out.println("--- Inventario Actualizado ---");
        inventario.mostrarInventario();

        System.out.println("\nValor total del inventario: $" + inventario.calcularValorTotal());
}
}