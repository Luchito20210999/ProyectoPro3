package pe.edu.pucp.proyectopro3.dao.reportes;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.reportes.Reporte;
import pe.edu.pucp.proyectopro3.model.reportes.TipoReporte;

import java.sql.*;
import java.util.List;

public class ReporteDAOImpl extends DefaultBaseDAO<Reporte> implements ReporteDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Reporte modelo) throws SQLException {
        // IMPORTANTE: id_reporte NO va en el INSERT porque es AUTO_INCREMENT
        String sql = """
            INSERT INTO Reporte (
                fecha_generacion,
                tipo_reporte,
                total_registros,
                monto_total_gen,
                fecha_inicio_filtro,
                fecha_fin_filtro
            ) VALUES (?, ?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setDate(1, new java.sql.Date(modelo.getFechaGeneracion().getTime()));
        cmd.setString(2, modelo.getTipoReporte().name());
        cmd.setInt(3, modelo.getTotalRegistros());
        cmd.setDouble(4, modelo.getMontoTotalGen());
        cmd.setDate(5, new java.sql.Date(modelo.getFechaInicioFiltro().getTime()));
        cmd.setDate(6, new java.sql.Date(modelo.getFechaFinFiltro().getTime()));

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Reporte modelo) throws SQLException {
        String sql = """
            UPDATE Reporte
            SET fecha_generacion = ?,
                tipo_reporte = ?,
                total_registros = ?,
                monto_total_gen = ?,
                fecha_inicio_filtro = ?,
                fecha_fin_filtro = ?
            WHERE id_reporte = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setDate(1, new java.sql.Date(modelo.getFechaGeneracion().getTime()));
        cmd.setString(2, modelo.getTipoReporte().name());
        cmd.setInt(3, modelo.getTotalRegistros());
        cmd.setDouble(4, modelo.getMontoTotalGen());
        cmd.setDate(5, new java.sql.Date(modelo.getFechaInicioFiltro().getTime()));
        cmd.setDate(6, new java.sql.Date(modelo.getFechaFinFiltro().getTime()));
        // Aquí usamos el id_reporte para saber cuál registro actualizar
        cmd.setInt(7, modelo.getIdReporte());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Reporte WHERE id_reporte = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Reporte WHERE id_reporte = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Reporte");
    }

    @Override
    protected Reporte mapearModelo(ResultSet rs) throws SQLException {
        Reporte reporte = new Reporte();

        // CORRECCIÓN: Asignamos el ID recuperado de la columna 'id_reporte'
        reporte.setIdReporte(rs.getInt("id_reporte"));

        reporte.setFechaGeneracion(rs.getDate("fecha_generacion"));
        reporte.setTipoReporte(TipoReporte.valueOf(rs.getString("tipo_reporte")));
        reporte.setTotalRegistros(rs.getInt("total_registros"));
        reporte.setMontoTotalGen(rs.getDouble("monto_total_gen"));
        reporte.setFechaInicioFiltro(rs.getDate("fecha_inicio_filtro"));
        reporte.setFechaFinFiltro(rs.getDate("fecha_fin_filtro"));

        return reporte;
    }
}
