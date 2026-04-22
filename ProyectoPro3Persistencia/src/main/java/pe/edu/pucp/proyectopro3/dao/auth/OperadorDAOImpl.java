package pe.edu.pucp.proyectopro3.dao.auth;

import pe.edu.pucp.proyectopro3.model.auth.Operador;

import java.sql.*;

public class OperadorDAOImpl extends PersonaBaseDAO<Operador> implements OperadorDAO {
    protected PreparedStatement comandoCrear(Connection conn,
                                             Operador modelo) throws SQLException {
        String sql = """
            INSERT INTO USUARIO (
                id_usuario,
                nombres,
                apellidos,
                tipo_documento,
                numero_documento,
                correo,
                contrasena,
                numero_contacto
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;
        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        setCamposUsuario(cmd, modelo);
        return cmd;
    }

    protected PreparedStatement comandoActualizar(Connection conn,
                                                  Operador modelo) throws SQLException {
        String sql = """
            UPDATE USUARIO
            SET id_usuario = ?,
                nombres = ?,
                apellidos = ?,
                tipo_documento = ?,
                numero_documento = ?,
                correo = ?,
                contrasena = ?,
                numero_contacto = ?,
            WHERE id_usuario = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        int nextIndex = setCamposUsuario(cmd, modelo);
        cmd.setInt(nextIndex, modelo.getIDUsuario());
        return cmd;
    }

    private int setCamposUsuario(PreparedStatement cmd, Operador modelo) throws SQLException {
        int idx = setCamposPersona(cmd, 1, modelo);
        return idx;
    }

    protected PreparedStatement comandoEliminar(Connection conn,
                                                Integer id) throws SQLException {
        String sql = """
            DELETE FROM USUARIO WHERE id_usuario = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    protected PreparedStatement comandoLeer(Connection conn,
                                            Integer id) throws SQLException {
        String sql = """
            SELECT * FROM USUARIO WHERE id_usuario= ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        String sql = """
            SELECT * FROM USUARIO
            """;
        return conn.prepareStatement(sql);
    }

    @Override
    protected PreparedStatement comandoBuscarPorNumeroDocumento(Connection conn,
                                                                String numDOC) throws SQLException {
        String sql = """
            SELECT * FROM Usuario WHERE numero_documento = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, numDOC);
        return cmd;
    }

    protected Operador mapearModelo(ResultSet rs) throws SQLException {
        Operador modelo = new Operador();
        mapearCamposPersona(rs, modelo);
        return modelo;
    }
}
