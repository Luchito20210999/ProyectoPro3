package pe.edu.pucp.proyectopro3.modelo.reclamos;

import java.util.Date;

public class Reclamo {
    private int idReclamo;
    private Date fechaReclamo;
    private String descripcion;
    private EstadoReclamo estadpReclamo;
    private String motivoResolucion;
    private Date fechaResolucion;

    public Reclamo(int idReclamo, Date fechaReclamo, String descripcion, EstadoReclamo estadpReclamo, String motivoResolucion, Date fechaResolucion) {
        this.idReclamo = idReclamo;
        this.fechaReclamo = fechaReclamo;
        this.descripcion = descripcion;
        this.estadpReclamo = estadpReclamo;
        this.motivoResolucion = motivoResolucion;
        this.fechaResolucion = fechaResolucion;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Date getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(Date fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoReclamo getEstadpReclamo() {
        return estadpReclamo;
    }

    public void setEstadpReclamo(EstadoReclamo estadpReclamo) {
        this.estadpReclamo = estadpReclamo;
    }

    public String getMotivoResolucion() {
        return motivoResolucion;
    }

    public void setMotivoResolucion(String motivoResolucion) {
        this.motivoResolucion = motivoResolucion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
}
