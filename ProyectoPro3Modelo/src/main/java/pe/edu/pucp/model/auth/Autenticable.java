package pe.edu.pucp.model.auth;

public interface Autenticable {
    boolean iniciarSesion(String correo, String contrasena);
    void cerrarSesion();
    void recuperarContrasena(String correo);
}
