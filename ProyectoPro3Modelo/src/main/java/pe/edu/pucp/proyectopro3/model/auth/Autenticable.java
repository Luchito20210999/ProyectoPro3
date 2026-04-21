package pe.edu.pucp.proyectopro3.model.auth;

public interface Autenticable {
    boolean iniciarSesion(String correo, String contrasena);
    void cerrarSesion();
    void recuperarContrasena(String correo);
}
