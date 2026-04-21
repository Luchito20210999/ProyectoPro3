package pe.edu.pucp.proyectopro3.model.reclamos;

import pe.edu.pucp.proyectopro3.model.crm.Cliente;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    private int IDReserva;
    private Date fechaRegistro;
    private EstadoReserva estadoReserva;
    private int cantidadBoletos;
    private double montoTotal;
    private Date fechaUltimaModificacion;
    private String canalVenta;
    private Cliente cliente;
    private ArrayList<DetalleReserva> detalles;
    private double montoImpuestos;

    public Reserva(int IDReserva, Date fechaRegistro, EstadoReserva estadoReserva, int cantidadBoletos, double montoTotal, Date fechaUltimaModificacion, String canalVenta, Cliente cliente, ArrayList<DetalleReserva> detalles,double montoImpuestos) {
        this.IDReserva = IDReserva;
        this.fechaRegistro = fechaRegistro;
        this.estadoReserva = estadoReserva;
        this.cantidadBoletos = cantidadBoletos;
        this.montoTotal = montoTotal;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.canalVenta = canalVenta;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.montoImpuestos = montoImpuestos;
    }
    // --- //
    public int getIDReserva() {
        return IDReserva;
    }
    public void setIDReserva(int IDReserva) {
        this.IDReserva = IDReserva;
    }
    // --- //
    public Date getFechaRegistro() {return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    // --- //
    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }
    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    // --- //
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
    // --- //
    public double getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    // --- //
    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }
    // --- //
    public String getCanalVenta() {
        return canalVenta;
    }
    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }
    // --- //
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    // --- //
    public ArrayList<DetalleReserva> getDetalles() {
        return detalles;
    }
    public void setDetalles(ArrayList<DetalleReserva> detalles) {
        this.detalles = detalles;
    }
    // --- //
    public double getMontoImpuestos(){
        return montoImpuestos;
    }
    public void setMontoImpuestos(double montoImpuestos){
        this.montoImpuestos = montoImpuestos;
    }
}
