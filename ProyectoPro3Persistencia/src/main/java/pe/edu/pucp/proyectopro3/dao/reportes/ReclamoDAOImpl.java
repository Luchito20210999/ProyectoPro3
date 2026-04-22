package pe.edu.pucp.proyectopro3.dao.reportes;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.reportes.EstadoReclamo;
import pe.edu.pucp.proyectopro3.model.reportes.Reclamo;

import java.sql.*;

public class ReclamoDAOImpl extends DefaultBaseDAO<Reclamo> implements ReclamoDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Reclamo modelo) throws SQLException {
        // id_reclamo es AUTO_INCREMENT, no se incluye en el INSERT
        String sql = """
            INSERT INTO Reclamo (
                fecha_reclamo,
                descripcion,
                estado_reclamo,
                motivo_resolucion,
                fecha_resolucion
            ) VALUES (?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // fecha_reclamo suele ser datetime (Timestamp)
        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaReclamo().getTime()));
        cmd.setString(2, modelo.getDescripcion());
        cmd.setString(3, modelo.getEstadoReclamo().name());
        cmd.setString(4, modelo.getMotivoResolucion());

        // La fecha de resolución puede ser nula si el reclamo aún no se cierra
        if (modelo.getFechaResolucion() != null) {
            cmd.setDate(5, new java.sql.Date(modelo.getFechaResolucion().getTime()));
        } else {
            cmd.setNull(5, Types.DATE);
        }

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Reclamo modelo) throws SQLException {
        String sql = """
            UPDATE Reclamo
            SET fecha_reclamo = ?,
                descripcion = ?,
                estado_reclamo = ?,
                motivo_resolucion = ?,
                fecha_resolucion = ?
            WHERE id_reclamo = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaReclamo().getTime()));
        cmd.setString(2, modelo.getDescripcion());
        cmd.setString(3, modelo.getEstadoReclamo().name());
        cmd.setString(4, modelo.getMotivoResolucion());

        if (modelo.getFechaResolucion() != null) {
            cmd.setDate(5, new java.sql.Date(modelo.getFechaResolucion().getTime()));
        } else {
            cmd.setNull(5, Types.DATE);
        }

        // El ID para el WHERE
        cmd.setInt(6, modelo.getIDReclamo());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Reclamo WHERE id_reclamo = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Reclamo WHERE id_reclamo = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Reclamo");
    }

    @Override
    protected Reclamo mapearModelo(ResultSet rs) throws SQLException {
        Reclamo reclamo = new Reclamo();

        reclamo.setIDReclamo(rs.getInt("id_reclamo"));
        reclamo.setFechaReclamo(rs.getTimestamp("fecha_reclamo"));
        reclamo.setDescripcion(rs.getString("descripcion"));

        // Mapeo del Enum
        String estadoStr = rs.getString("estado_reclamo");
        if (estadoStr != null) {
            reclamo.setEstadoReclamo(EstadoReclamo.valueOf(estadoStr));
        }

        reclamo.setMotivoResolucion(rs.getString("motivo_resolucion"));
        reclamo.setFechaResolucion(rs.getDate("fecha_resolucion"));

        return reclamo;
    }
}
