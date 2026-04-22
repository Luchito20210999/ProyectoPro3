package pe.edu.pucp.proyectopro3.model;

import java.util.Date;

public class Notificacion {
    private int idNotificacion;
    private String mensaje;
    private String tipoNotificacion;
    private Date fechaEnvio; // En el diagrama dice LocalDate Time, pero mantendremos Date por consistencia con tus DAOs
    private boolean leido;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String mensaje, String tipoNotificacion, Date fechaEnvio, boolean leido) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.tipoNotificacion = tipoNotificacion;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
    }

    // Getters y Setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
