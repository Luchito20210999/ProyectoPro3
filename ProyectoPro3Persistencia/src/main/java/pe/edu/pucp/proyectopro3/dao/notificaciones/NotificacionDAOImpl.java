package pe.edu.pucp.proyectopro3.dao.notificaciones;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.modelo.notificaciones.Notificacion;

import java.sql.*;

public class NotificacionDAOImpl extends DefaultBaseDAO<Notificacion> implements NotificacionDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Notificacion modelo) throws SQLException {
        // sp_InsertNotificacion(_fEnv, _msj, _lei, _idUsu)
        String sql = "{call sp_InsertNotificacion(?, ?, ?, ?)}";
        CallableStatement cmd = conn.prepareCall(sql);

        // Usamos Timestamp para DATETIME en MySQL
        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaEnvio().getTime()));
        cmd.setString(2, modelo.getMensaje());
        cmd.setBoolean(3, modelo.isLeido());
        cmd.setInt(4, modelo.getIdUsuario());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Notificacion modelo) throws SQLException {
        // Asumiendo un sp_UpdateNotificacion similar a los anteriores
        String sql = "UPDATE Notificacion SET fechaEnvio=?, mensaje=?, leido=?, idUsuario=? WHERE idNotificacion=?";
        PreparedStatement cmd = conn.prepareStatement(sql);

        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaEnvio().getTime()));
        cmd.setString(2, modelo.getMensaje());
        cmd.setBoolean(3, modelo.isLeido());
        cmd.setInt(4, modelo.getIdUsuario());
        cmd.setInt(5, modelo.getIdNotificacion());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        // Si no tienes SP de delete, usamos SQL directo como permite el framework
        String sql = "DELETE FROM Notificacion WHERE idNotificacion = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Notificacion WHERE idNotificacion = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        // sp_ListNotificacion() definido en tu SQL
        String sql = "{call sp_ListNotificacion()}";
        return conn.prepareCall(sql);
    }

    @Override
    protected Notificacion mapearModelo(ResultSet rs) throws SQLException {
        Notificacion notificacion = new Notificacion();

        notificacion.setIdNotificacion(rs.getInt("idNotificacion"));
        notificacion.setFechaEnvio(rs.getDate("fechaEnvio"));
        notificacion.setMensaje(rs.getString("mensaje"));
        notificacion.setLeido(rs.getBoolean("leido"));
        notificacion.setIdUsuario(rs.getInt("idUsuario"));

        return notificacion;
    }
}
