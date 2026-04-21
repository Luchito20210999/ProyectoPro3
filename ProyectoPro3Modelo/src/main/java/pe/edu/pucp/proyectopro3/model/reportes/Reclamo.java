package pe.edu.pucp.proyectopro3.model.reportes;

import pe.edu.pucp.proyectopro3.model.reclamos.Reserva;

import java.util.Date;

public class Reclamo {
    private int IDReclamo;
    private Date fechaReclamo;
    private String descripcion;
    private EstadoReclamo estadoReclamo;
    private String motivoResolucion;
    private Date fechaResolucion;
    private Reserva reserva;

    public Reclamo(int IDReclamo, Date fechaReclamo, String descripcion, EstadoReclamo estadoReclamo, String motivoResolucion, Date fechaResolucion, Reserva reserva) {
        this.IDReclamo = IDReclamo;
        this.fechaReclamo = fechaReclamo;
        this.descripcion = descripcion;
        this.estadoReclamo = estadoReclamo;
        this.motivoResolucion = motivoResolucion;
        this.fechaResolucion = fechaResolucion;
        this.reserva = reserva;
    }

    // --- //
    public int getIDReclamo() {
        return IDReclamo;
    }
    public void setIDReclamo(int IDReclamo) {
        this.IDReclamo = IDReclamo;
    }
    // --- //
    public Date getFechaReclamo() {
        return fechaReclamo;
    }
    public void setFechaReclamo(Date fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }
    // --- //
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // --- //
    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }
    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }
    // --- //
    public String getMotivoResolucion() {
        return motivoResolucion;
    }
    public void setMotivoResolucion(String motivoResolucion) {
        this.motivoResolucion = motivoResolucion;
    }
    // --- //
    public Date getFechaResolucion() {
        return fechaResolucion;
    }
    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
    // --- //
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
