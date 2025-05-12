import java.time.LocalDate;

public class StockItem {
    private Producto producto;
    private int cantidad;
    private LocalDate fechaVencimiento;

    public StockItem(Producto producto, int cantidad, LocalDate fechaVencimiento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean estaVencido() {
        return fechaVencimiento.isBefore(LocalDate.now());
    }
}

