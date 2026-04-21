package pe.edu.pucp.proyectopro3.model.auth;

public interface UsuariosGestionable {
    void crearUsuario(Usuario U);
    void editarUsuario(int ID);
    void eliminarUsuario(int ID);
    void bloquearUsuario(int ID);
}
