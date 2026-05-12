package pe.edu.pucp.proyectopro3.modelo.reservas;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaRegistro;
    private EstadoReserva estadoReserva;
    private int cantidadBoletos;
    private double montoTotal;
    private Date fechaUltimaModificacion;
    private String canalVenta;
    private double montoImpuestos;
    private int idCliente;

    public Reserva(int idReserva, Date fechaRegistro, EstadoReserva estadoReserva, int cantidadBoletos, double montoTotal, Date fechaUltimaModificacion, String canalVenta, double montoImpuestos, int idCliente) {
        this.idReserva = idReserva;
        this.fechaRegistro = fechaRegistro;
        this.estadoReserva = estadoReserva;
        this.cantidadBoletos = cantidadBoletos;
        this.montoTotal = montoTotal;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.canalVenta = canalVenta;
        this.montoImpuestos = montoImpuestos;
        this.idCliente = idCliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public double getMontoImpuestos() {
        return montoImpuestos;
    }

    public void setMontoImpuestos(double montoImpuestos) {
        this.montoImpuestos = montoImpuestos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
