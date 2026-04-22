package pe.edu.pucp.proyectopro3.dao.reclamos;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.reclamos.DetalleReserva;
import pe.edu.pucp.proyectopro3.model.reclamos.Reserva;
import pe.edu.pucp.proyectopro3.model.reclamos.Servicio;

import java.sql.*;

public class DetalleReservaDAOImpl extends DefaultBaseDAO<DetalleReserva> implements DetalleReservaDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, DetalleReserva modelo) throws SQLException {
        // id_detalle_reserva es AUTO_INCREMENT
        String sql = """
            INSERT INTO Detalle_Reserva (
                id_reserva,
                id_servicio,
                cantidad,
                subtotal
            ) VALUES (?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // Llaves Foráneas (Relaciones)
        cmd.setInt(1, modelo.getReserva().getIDReserva());
        cmd.setInt(2, modelo.getServicio().getIDServicio());

        // Datos propios del detalle
        cmd.setInt(3, modelo.getCantidad());
        cmd.setDouble(4, modelo.getSubtotal());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, DetalleReserva modelo) throws SQLException {
        String sql = """
            UPDATE Detalle_Reserva
            SET id_reserva = ?,
                id_servicio = ?,
                cantidad = ?,
                subtotal = ?
            WHERE id_detalle_reserva = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);

        cmd.setInt(1, modelo.getReserva().getIDReserva());
        cmd.setInt(2, modelo.getServicio().getIDServicio());
        cmd.setInt(3, modelo.getCantidad());
        cmd.setDouble(4, modelo.getSubtotal());

        // Identificador para el WHERE (ahora es el parámetro 5)
        cmd.setInt(5, modelo.getIDDetalle());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Detalle_Reserva WHERE id_detalle_reserva = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Detalle_Reserva WHERE id_detalle_reserva = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Detalle_Reserva");
    }

    @Override
    protected DetalleReserva mapearModelo(ResultSet rs) throws SQLException {
        DetalleReserva detalle = new DetalleReserva();

        detalle.setIDDetalle(rs.getInt("id_detalle_reserva"));
        detalle.setCantidad(rs.getInt("cantidad"));
        detalle.setSubtotal(rs.getDouble("subtotal"));

        // Reconstrucción parcial de la Reserva (Lazy Loading)
        Reserva reservaParcial = new Reserva();
        reservaParcial.setIDReserva(rs.getInt("id_reserva"));
        detalle.setReserva(reservaParcial);

        // Reconstrucción parcial del Servicio (Lazy Loading)
        Servicio servicioParcial = new Servicio();
        servicioParcial.setIDServicio(rs.getInt("id_servicio"));
        detalle.setServicio(servicioParcial);

        return detalle;
    }
}
