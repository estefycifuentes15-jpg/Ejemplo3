package Modelo;

public class Socio {
    private String cedula;
    private String nombre;
    private String membresia;
    private String estadoPago;

    public Socio(String cedula, String nombre, String membresia, String estadoPago) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.membresia = membresia;
        this.estadoPago = estadoPago;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getMembresia() { return membresia; }
    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }
}