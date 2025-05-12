public class Producto {
    private String id;
    private String nombre;
    private String categoria;
    private double precioCompra;
    private double precioVenta;
    private Proveedor proveedor;

    public Producto(String id, String nombre, String categoria, double precioCompra, double precioVenta, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.proveedor = proveedor;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecioCompra() { return precioCompra; }
    public double getPrecioVenta() { return precioVenta; }
    public Proveedor getProveedor() { return proveedor; }
}
