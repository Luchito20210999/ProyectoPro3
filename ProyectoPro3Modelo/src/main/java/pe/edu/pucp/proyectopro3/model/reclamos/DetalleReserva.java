package pe.edu.pucp.proyectopro3.model.reclamos;

public class DetalleReserva {
    private int IDDetalle;
    private int cantidad;
    private double subtotal;
    private Servicio servicio;
    private Reserva reserva;

    public DetalleReserva(int IDDetalle, int cantidad, double subtotal, Servicio servicio,Reserva reserva) {
        this.IDDetalle = IDDetalle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.servicio = servicio;
        this.reserva = reserva;
    }

    public DetalleReserva() {

    }

    public int getIDDetalle() {
        return IDDetalle;
    }
    public void setIDDetalle(int IDDetalle) {
        this.IDDetalle = IDDetalle;
    }
    // --- //
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // --- //
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    // --- //
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    // --- //
    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }
}
