package pe.edu.pucp.proyectopro3.dao.webhook;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.webhook.WebhookBokun;

import java.sql.*;

public class WebhookBokunDAOImpl extends DefaultBaseDAO<WebhookBokun> implements WebhookBokunDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, WebhookBokun modelo) throws SQLException {
        // id_bokun es AUTO_INCREMENT en la BD [cite: 4]
        String sql = """
            INSERT INTO WebhookBokun (
                secret_key,
                access_key
            ) VALUES (?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getSecretKey());
        cmd.setString(2, modelo.getAccessKey());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, WebhookBokun modelo) throws SQLException {
        String sql = """
            UPDATE WebhookBokun
            SET secret_key = ?,
                access_key = ?
            WHERE id_bokun = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getSecretKey());
        cmd.setString(2, modelo.getAccessKey());
        cmd.setInt(3, modelo.getIDBokun()); // El ID para el WHERE [cite: 7]

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM WebhookBokun WHERE id_bokun = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM WebhookBokun WHERE id_bokun = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM WebhookBokun");
    }

    @Override
    protected WebhookBokun mapearModelo(ResultSet rs) throws SQLException {
        WebhookBokun webhook = new WebhookBokun();
        webhook.setIDBokun(rs.getInt("id_bokun"));
        webhook.setSecretKey(rs.getString("secret_key"));
        webhook.setAccessKey(rs.getString("access_key"));
        return webhook;
    }
}
