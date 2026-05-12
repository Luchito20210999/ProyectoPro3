package pe.edu.pucp.proyectopro3.modelo.notificaciones;

import java.util.Date;

public class Notificacion {
    private int idNotificacion;
    private String mensaje;
    private String tipoNotificacion;
    private Date fechaEnvio;
    private int idUsuario;
    private boolean leido;
    private TipoEvento tipEvento;

    public Notificacion(int idNotificacion, String mensaje, String tipoNotificacion, Date fechaEnvio, int idUsuario, boolean leido, TipoEvento tipEvento) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.tipoNotificacion = tipoNotificacion;
        this.fechaEnvio = fechaEnvio;
        this.idUsuario = idUsuario;
        this.leido = leido;
        this.tipEvento = tipEvento;
    }

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public TipoEvento getTipEvento() {
        return tipEvento;
    }

    public void setTipEvento(TipoEvento tipEvento) {
        this.tipEvento = tipEvento;
    }
}
