package pe.edu.pucp.proyectopro3.dao;

import pe.edu.pucp.proyectopro3.model.Notificacion;

import java.sql.*;

public class NotificacionDAOImpl extends DefaultBaseDAO<Notificacion> implements NotificacionDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Notificacion modelo) throws SQLException {
        // id_notificacion es AUTO_INCREMENT
        String sql = """
            INSERT INTO Notificacion (
                mensaje,
                tipo_notificacion,
                fecha_envio,
                leido
            ) VALUES (?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getMensaje());
        cmd.setString(2, modelo.getTipoNotificacion());

        // Manejo de fecha y hora de envío
        if (modelo.getFechaEnvio() != null) {
            cmd.setTimestamp(3, new java.sql.Timestamp(modelo.getFechaEnvio().getTime()));
        } else {
            cmd.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
        }

        // Traducción de boolean a int (1 = leído, 0 = no leído)
        cmd.setInt(4, modelo.isLeido() ? 1 : 0);

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Notificacion modelo) throws SQLException {
        String sql = """
            UPDATE Notificacion
            SET mensaje = ?,
                tipo_notificacion = ?,
                fecha_envio = ?,
                leido = ?
            WHERE id_notificacion = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getMensaje());
        cmd.setString(2, modelo.getTipoNotificacion());
        cmd.setTimestamp(3, new java.sql.Timestamp(modelo.getFechaEnvio().getTime()));
        cmd.setInt(4, modelo.isLeido() ? 1 : 0);

        // El ID para el WHERE
        cmd.setInt(5, modelo.getIdNotificacion());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Notificacion WHERE id_notificacion = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Notificacion WHERE id_notificacion = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Notificacion");
    }

    @Override
    protected Notificacion mapearModelo(ResultSet rs) throws SQLException {
        Notificacion notificacion = new Notificacion();

        notificacion.setIdNotificacion(rs.getInt("id_notificacion"));
        notificacion.setMensaje(rs.getString("mensaje"));
        notificacion.setTipoNotificacion(rs.getString("tipo_notificacion"));
        notificacion.setFechaEnvio(rs.getTimestamp("fecha_envio"));

        // Traducción de int a boolean
        notificacion.setLeido(rs.getInt("leido") == 1);

        return notificacion;
    }
}
