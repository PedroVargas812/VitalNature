import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario {
    private List<StockItem> stock;
    private int capacidadMaxima;
    private double presupuestoMensual;

    public Inventario(int capacidadMaxima, double presupuestoMensual) {
        this.stock = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
        this.presupuestoMensual = presupuestoMensual;
    }

    public void agregarStockItem(StockItem item) {
        if (stock.size() < capacidadMaxima) {
            stock.add(item);
        } else {
            System.out.println("Capacidad máxima alcanzada. No se puede agregar más productos.");
        }
    }

    public void eliminarVencidos() {
        Iterator<StockItem> it = stock.iterator();
        while (it.hasNext()) {
            if (it.next().estaVencido()) {
                it.remove();
            }
        }
    }

    public void mostrarInventario() {
        for (StockItem item : stock) {
            System.out.println("Producto: " + item.getProducto().getNombre() +
                    " | Cantidad: " + item.getCantidad() +
                    " | Vence: " + item.getFechaVencimiento());
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (StockItem item : stock) {
            total += item.getCantidad() * item.getProducto().getPrecioCompra();
        }
        return total;
    }

    public int getCantidadTotalItems() {
        int total = 0;
        for (StockItem item : stock) {
            total += item.getCantidad();
        }
        return total;
    }

    public boolean verificarPresupuesto(double nuevoPedido) {
        return (calcularValorTotal() + nuevoPedido) <= presupuestoMensual;
    }
}
