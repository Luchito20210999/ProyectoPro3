package pe.edu.pucp.proyectopro3.modelo.crm;

import java.util.Date;

public class Cliente {
    private int idCliente;
    private String nombres;
    private String apellidos;
    private TipoDocumento tipoDocumento;
    private int numeroDocumento;
    private String nacionalidad;
    private String correo;
    private Date fechaRegsitro;
    private String numeroContacto;
    private Date fechaNacimiento;

    public Cliente(int idCliente, String nombres, String apellidos, TipoDocumento tipoDocumento, int numeroDocumento, String nacionalidad, String correo, Date fechaRegsitro, String numeroContacto, Date fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.fechaRegsitro = fechaRegsitro;
        this.numeroContacto = numeroContacto;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegsitro() {
        return fechaRegsitro;
    }

    public void setFechaRegsitro(Date fechaRegsitro) {
        this.fechaRegsitro = fechaRegsitro;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
