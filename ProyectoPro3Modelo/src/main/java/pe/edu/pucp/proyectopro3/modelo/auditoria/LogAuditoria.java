package pe.edu.pucp.proyectopro3.modelo.auditoria;

import java.util.Date;

public class LogAuditoria {
    private int idLogAuditoria;
    private Date fechaRegistro;
    private String descripcion;
    private int idUsuario;
    private String accion;
    private String origenAccion;


    public LogAuditoria(int idLogAuditoria, Date fechaRegistro, String descripcion, int idUsuario, String accion, String origenAccion) {
        this.idLogAuditoria = idLogAuditoria;
        this.fechaRegistro = fechaRegistro;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.accion = accion;
        this.origenAccion = origenAccion;
    }

    public int getIdLogAuditoria() {
        return idLogAuditoria;
    }

    public void setIdLogAuditoria(int idLogAuditoria) {
        this.idLogAuditoria = idLogAuditoria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOrigenAccion() {
        return origenAccion;
    }

    public void setOrigenAccion(String origenAccion) {
        this.origenAccion = origenAccion;
    }
}
