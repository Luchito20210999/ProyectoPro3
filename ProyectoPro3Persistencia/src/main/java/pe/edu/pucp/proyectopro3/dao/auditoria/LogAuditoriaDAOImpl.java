package pe.edu.pucp.proyectopro3.dao.auditoria;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.modelo.auditoria.LogAuditoria;

import java.sql.*;

public class LogAuditoriaDAOImpl extends DefaultBaseDAO<LogAuditoria> implements LogAuditoriaDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, LogAuditoria modelo) throws SQLException {
        String sql = "{call sp_InsertLogAuditoria(?, ?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);
        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaRegistro().getTime()));
        cmd.setString(2, modelo.getDescripcion());
        cmd.setInt(3, modelo.getIdUsuario());
        cmd.setString(4, modelo.getAccion());
        cmd.setString(5, modelo.getOrigenAccion());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, LogAuditoria modelo) throws SQLException {
        throw new UnsupportedOperationException("No se permite actualizar registros de auditoría.");
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        throw new UnsupportedOperationException("No se permite actualizar registros de auditoría.");
//        String sql = "{call sp_DeleteLogAuditoria(?)}";
//        CallableStatement cmd = conn.prepareCall(sql);
//        cmd.setInt(1, id);
//        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM LogAuditoria WHERE idLogAuditoria = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        // sp_ListLogAuditoria()
        String sql = "{call sp_ListLogAuditoria()}";
        return conn.prepareCall(sql);
    }

    @Override
    protected LogAuditoria mapearModelo(ResultSet rs) throws SQLException {
        LogAuditoria log = new LogAuditoria();

        log.setIdLogAuditoria(rs.getInt("idLogAuditoria"));
        log.setFechaRegistro(rs.getTimestamp("fechaRegistro")); // Recupera fecha y hora
        log.setDescripcion(rs.getString("descripcion"));
        log.setIdUsuario(rs.getInt("idUsuario"));
        int idUsu = rs.getInt("idUsuario");
        if (!rs.wasNull()) {
            log.setIdUsuario(idUsu);
        }
        log.setAccion(rs.getString("accion"));
        log.setOrigenAccion(rs.getString("origenAccion"));

        return log;
    }
}