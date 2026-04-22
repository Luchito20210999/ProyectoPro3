package pe.edu.pucp.proyectopro3.dao;

import pe.edu.pucp.proyectopro3.model.LogAuditoria;
import pe.edu.pucp.proyectopro3.model.auth.Usuario;

import java.sql.*;

public class LogAuditoriaDAOImpl extends DefaultBaseDAO<LogAuditoria> implements LogAuditoriaDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, LogAuditoria modelo) throws SQLException {
        // id_log_auditoria es AUTO_INCREMENT
        String sql = """
            INSERT INTO LogAuditoria (
                fecha_registro,
                descripcion,
                id_usuario,
                command,
                location
            ) VALUES (?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // Un log siempre debe tener la fecha y hora exacta
        if (modelo.getFechaRegistro() != null) {
            cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaRegistro().getTime()));
        } else {
            cmd.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
        }

        cmd.setString(2, modelo.getDescripcion());

        // Guardamos solo la llave foránea del Usuario
        if (modelo.getUsuario() != null) {
            cmd.setInt(3, modelo.getUsuario().getIDUsuario());
        } else {
            cmd.setNull(3, Types.INTEGER); // Por si el log fue generado por el sistema y no por un usuario específico
        }

        cmd.setString(4, modelo.getCommand());
        cmd.setString(5, modelo.getLocation());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, LogAuditoria modelo) throws SQLException {
        /*
         * NOTA ARQUITECTÓNICA: En la vida real, una tabla de auditoría NUNCA debería
         * actualizarse ni borrarse por seguridad. Sin embargo, como estamos implementando
         * la interfaz genérica DefaultBaseDAO, debemos proveer el código.
         */
        String sql = """
            UPDATE LogAuditoria
            SET fecha_registro = ?,
                descripcion = ?,
                id_usuario = ?,
                command = ?,
                location = ?
            WHERE id_log_auditoria = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaRegistro().getTime()));
        cmd.setString(2, modelo.getDescripcion());

        if (modelo.getUsuario() != null) {
            cmd.setInt(3, modelo.getUsuario().getIDUsuario());
        } else {
            cmd.setNull(3, Types.INTEGER);
        }

        cmd.setString(4, modelo.getCommand());
        cmd.setString(5, modelo.getLocation());

        // ID para el WHERE
        cmd.setInt(6, modelo.getIdLogAuditoria());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        // Al igual que actualizar, esto normalmente no se usaría en producción para una tabla de logs
        String sql = "DELETE FROM LogAuditoria WHERE id_log_auditoria = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM LogAuditoria WHERE id_log_auditoria = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM LogAuditoria");
    }

    @Override
    protected LogAuditoria mapearModelo(ResultSet rs) throws SQLException {
        LogAuditoria log = new LogAuditoria();

        log.setIdLogAuditoria(rs.getInt("id_log_auditoria"));
        log.setFechaRegistro(rs.getTimestamp("fecha_registro"));
        log.setDescripcion(rs.getString("descripcion"));
        log.setCommand(rs.getString("command"));
        log.setLocation(rs.getString("location"));

        // Reconstrucción parcial del Usuario (solo con su ID)
        int idUsuario = rs.getInt("id_usuario");
        if (!rs.wasNull()) {
            Usuario usuario = new Usuario();
            usuario.setIDUsuario(idUsuario);
            log.setUsuario(usuario);
        }

        return log;
    }
}
