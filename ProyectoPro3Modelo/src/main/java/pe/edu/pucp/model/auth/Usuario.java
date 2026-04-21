package pe.edu.pucp.model.auth;

import pe.edu.pucp.model.crm.TipoDocumento;

public class Usuario {
    private int IDUsuario;
    private String nombres;
    private String apellidos;
    private TipoDocumento tipoDocumento;
    private int numeroDocumento;
    private String numeroContacto;
    private String correo;
    private String contrasena;

    public Usuario(int IDUsuario, String nombres, String apellidos, TipoDocumento tipoDocumento, int numeroDocumento, String numeroContacto, String correo, String contrasena) {
        this.IDUsuario = IDUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // --- //
    public int getIDUsuario() {
        return IDUsuario;
    }
    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
    // --- //
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    // --- //
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    // --- //
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    // --- //
    public int getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    // --- //
    public String getNumeroContacto() {
        return numeroContacto;
    }
    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    // --- //
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // --- //
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
