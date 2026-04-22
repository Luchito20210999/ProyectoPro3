package pe.edu.pucp.proyectopro3.model;

import pe.edu.pucp.proyectopro3.model.auth.Usuario;

import java.util.Date;

public class LogAuditoria {
    private int idLogAuditoria;
    private Date fechaRegistro;
    private String descripcion;
    private Usuario usuario;
    private String command;
    private String location;

    public LogAuditoria() {
    }

    public LogAuditoria(int idLogAuditoria, Date fechaRegistro, String descripcion, Usuario usuario, String command, String location) {
        this.idLogAuditoria = idLogAuditoria;
        this.fechaRegistro = fechaRegistro;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.command = command;
        this.location = location;
    }

    // Getters y Setters
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
