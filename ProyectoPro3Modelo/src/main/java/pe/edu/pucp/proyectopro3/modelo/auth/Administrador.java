package pe.edu.pucp.proyectopro3.modelo.auth;

import pe.edu.pucp.proyectopro3.modelo.crm.TipoDocumento;

public class Administrador extends Usuario implements UsuariosGestionable{
    public Administrador(int idUsuario, String nombres, String apellidos, TipoDocumento tipoDocumento, String numeroDocumento, String numeroContacto, String correo, String contrasena) {
        super(idUsuario, nombres, apellidos, tipoDocumento, numeroDocumento, numeroContacto, correo, contrasena);
    }
    @Override
    public void crearUsuario(Usuario u){

    }
    @Override
    public void editarUsuario(int id){

    }
    @Override
    public void eliminarUsuario(int id){

    }
    @Override
    public void buscarUsuario(int id){

    }

}
