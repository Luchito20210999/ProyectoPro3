package pe.edu.pucp.proyectopro3.dao.webhook;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.webhook.WebhookLog;

import java.sql.*;

public class WebhookLogDAOImpl extends DefaultBaseDAO<WebhookLog> implements WebhookLogDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, WebhookLog modelo) throws SQLException {
        // IDLog es generado por la base de datos (AUTO_INCREMENT)
        String sql = """
            INSERT INTO WebhookLog (
                booking_id,
                timestamp,
                raw_data
            ) VALUES (?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getBookingID()); // Usando tu método exacto

        if (modelo.getTimestamp() != null) {
            cmd.setTimestamp(2, new java.sql.Timestamp(modelo.getTimestamp().getTime())); // [cite: 22]
        } else {
            cmd.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
        }

        cmd.setString(3, modelo.getRawData()); //

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, WebhookLog modelo) throws SQLException {
        String sql = """
            UPDATE WebhookLog
            SET booking_id = ?,
                timestamp = ?,
                raw_data = ?
            WHERE id_log = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getBookingID()); //
        cmd.setTimestamp(2, new java.sql.Timestamp(modelo.getTimestamp().getTime())); // [cite: 22]
        cmd.setString(3, modelo.getRawData()); //

        // Identificador para el WHERE
        cmd.setInt(4, modelo.getIDLog()); //

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM WebhookLog WHERE id_log = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM WebhookLog WHERE id_log = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM WebhookLog");
    }

    @Override
    protected WebhookLog mapearModelo(ResultSet rs) throws SQLException {
        // Extraemos los datos de la fila de MySQL
        int idLog = rs.getInt("id_log");
        String bookingId = rs.getString("booking_id");
        java.util.Date timestamp = rs.getTimestamp("timestamp");
        String rawData = rs.getString("raw_data");

        // A diferencia de otras clases que usan un constructor vacío,
        // tu clase WebhookLog usa un constructor con todos los parámetros.
        // ¡Así que instanciamos el objeto pasándole todo directamente!
        return new WebhookLog(idLog, bookingId, timestamp, rawData); //
    }
}
