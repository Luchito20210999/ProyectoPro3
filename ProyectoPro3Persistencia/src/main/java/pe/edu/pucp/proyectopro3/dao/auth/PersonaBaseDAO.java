package pe.edu.pucp.proyectopro3.dao.auth;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.auth.Usuario;
import pe.edu.pucp.proyectopro3.model.crm.TipoDocumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PersonaBaseDAO<M extends Usuario> extends DefaultBaseDAO<M> {

    protected abstract PreparedStatement comandoBuscarPorNumeroDocumento(Connection conn,
                                                                         String numDoc) throws SQLException;

    public M buscarPorNumDoc(String numDoc) {
        return ejecutarComando(conn -> {
            try (PreparedStatement cmd = comandoBuscarPorNumeroDocumento(conn, numDoc);
                 ResultSet rs = cmd.executeQuery()) {
                return rs.next() ? mapearModelo(rs) : null;
            }
        });
    }

    protected int setCamposPersona(PreparedStatement cmd, int startIndex,
                                   M modelo) throws SQLException {
        cmd.setInt(startIndex, modelo.getIDUsuario());
        cmd.setString(startIndex + 1, modelo.getNombres());
        cmd.setString(startIndex + 2, modelo.getApellidos());
        cmd.setString(startIndex + 3, modelo.getTipoDocumento().name());
        cmd.setInt(startIndex + 4, modelo.getNumeroDocumento());
        cmd.setString(startIndex + 5, modelo.getNumeroContacto());
        cmd.setString(startIndex + 6, modelo.getCorreo());
        cmd.setString(startIndex + 7, modelo.getContrasena());
        return startIndex + 8;
    }

    protected void mapearCamposPersona(ResultSet rs, M modelo) throws SQLException {
        modelo.setIDUsuario(rs.getInt("id_usuario"));
        modelo.setNombres(rs.getString("nombres"));
        modelo.setApellidos(rs.getString("apellidos"));
        modelo.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipo_documento")));
        modelo.setNumeroDocumento(rs.getInt("numero_documento"));
        modelo.setNumeroContacto(rs.getString("numero_contacto"));
        modelo.setCorreo(rs.getString("correo"));
        modelo.setContrasena(rs.getString("contrasena"));
    }
}
