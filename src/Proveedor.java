public class Proveedor {
    private String nombre;
    private int tiempoEntregaDias;

    public Proveedor(String nombre, int tiempoEntregaDias) {
        this.nombre = nombre;
        this.tiempoEntregaDias = tiempoEntregaDias;
    }

    public String getNombre() { return nombre; }
    public int getTiempoEntregaDias() { return tiempoEntregaDias; }
}
