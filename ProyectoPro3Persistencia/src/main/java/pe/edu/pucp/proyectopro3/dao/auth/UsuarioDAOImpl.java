package pe.edu.pucp.proyectopro3.dao.auth;

import pe.edu.pucp.proyectopro3.model.auth.Usuario;

import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO{
    protected PreparedStatement comandoCrear(Connection conn,
                                             Usuario modelo) throws SQLException {
        String sql = """
            INSERT INTO USUARIO (
                IDUsuario,
                nombres,
                apellidos,
                tipoDocumento,
                numeroDocumento,
                numeroContacto,
                correo,
                contrasena
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;
        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        setCamposCliente(cmd, modelo);
        return cmd;
    }

    protected PreparedStatement comandoActualizar(Connection conn,
                                                  Usuario modelo) throws SQLException {
        String sql = """
            UPDATE USUARIO
            SET IDUsuario = ?,
                nombres = ?,
                apellidos = ?,
                tipoDocumento = ?,
                numeroDocumento = ?,
                numeroContacto = ?,
                correo = ?,
                contrasena = ?,
            WHERE IDUsuario = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        int nextIndex = setCamposCliente(cmd, modelo);
        cmd.setInt(nextIndex, modelo.getIDUsuario());
        return cmd;
    }

    protected PreparedStatement comandoEliminar(Connection conn,
                                                Integer id) throws SQLException {
        String sql = """
            DELETE FROM USUARIO WHERE IDUsuario = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    protected PreparedStatement comandoLeer(Connection conn,
                                            Integer id) throws SQLException {
        String sql = """
            SELECT * FROM USUARIO WHERE IDUsuario= ?
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
            SELECT * FROM USUARIO WHERE numeroDocumento = ?
            """;
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, numDOC);
        return cmd;
    }

    protected Usuario mapearModelo(ResultSet rs) throws SQLException {
        Usuario modelo = new Usuario();
        modelo.setIDUsuario(rs.getInt("id"));

        Integer idCuentaUsuario = leerIdCuentaUsuario(rs);
        if (idCuentaUsuario != null) {
            modelo.setCuentaUsuario(new CuentaUsuarioDAOImpl().leer(idCuentaUsuario));
        }

        mapearCamposPersona(rs, modelo);
        modelo.setCategoria(CategoriaCliente.valueOf(rs.getString("categoria")));
        modelo.setLineaCredito(rs.getDouble("lineaCredito"));
        modelo.setActivo(rs.getBoolean("activo"));
        return modelo;
    }

    private int setCamposCliente(PreparedStatement cmd, Cliente modelo) throws SQLException {
        setCuentaUsuarioNullable(cmd, 1, modelo);
        int idx = setCamposPersona(cmd, 2, modelo);
        cmd.setString(idx, modelo.getCategoria().name());
        cmd.setDouble(idx + 1, modelo.getLineaCredito());
        cmd.setBoolean(idx + 2, modelo.isActivo());
        return idx + 3;
    }
}
