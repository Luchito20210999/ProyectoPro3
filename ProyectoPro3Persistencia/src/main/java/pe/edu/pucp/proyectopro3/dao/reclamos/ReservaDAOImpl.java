package pe.edu.pucp.proyectopro3.dao.reclamos;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.crm.Cliente;
import pe.edu.pucp.proyectopro3.model.reclamos.DetalleReserva;
import pe.edu.pucp.proyectopro3.model.reclamos.EstadoReserva;
import pe.edu.pucp.proyectopro3.model.reclamos.Reserva;

import java.sql.*;

public class ReservaDAOImpl extends DefaultBaseDAO<Reserva> implements ReservaDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Reserva modelo) throws SQLException {
        String sql = """
            INSERT INTO Reserva (
                fecha_registro,
                estado_reserva,
                cantidad_boletos,
                monto_total,
                fecha_ultima_modif,
                canal_venta,
                monto_impuestos,
                id_cliente
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaRegistro().getTime()));

        // CORRECCIÓN: Convertimos el Enum a String usando .name()
        cmd.setString(2, modelo.getEstadoReserva().name());

        cmd.setInt(3, modelo.getCantidadBoletos());
        cmd.setDouble(4, modelo.getMontoTotal());

        if (modelo.getFechaUltimaModificacion() != null) {
            cmd.setTimestamp(5, new java.sql.Timestamp(modelo.getFechaUltimaModificacion().getTime()));
        } else {
            cmd.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
        }

        cmd.setString(6, modelo.getCanalVenta());
        cmd.setDouble(7, modelo.getMontoImpuestos());
        cmd.setInt(8, modelo.getCliente().getIDCliente());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Reserva modelo) throws SQLException {
        // CORRECCIÓN: Se agregó fecha_registro para que estén absolutamente todos los campos
        String sql = """
            UPDATE Reserva
            SET fecha_registro = ?,
                estado_reserva = ?,
                cantidad_boletos = ?,
                monto_total = ?,
                fecha_ultima_modif = ?,
                canal_venta = ?,
                monto_impuestos = ?,
                id_cliente = ?
            WHERE id_reserva = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);

        cmd.setTimestamp(1, new java.sql.Timestamp(modelo.getFechaRegistro().getTime()));
        cmd.setString(2, modelo.getEstadoReserva().name());
        cmd.setInt(3, modelo.getCantidadBoletos());
        cmd.setDouble(4, modelo.getMontoTotal());

        cmd.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));

        cmd.setString(6, modelo.getCanalVenta());
        cmd.setDouble(7, modelo.getMontoImpuestos());
        cmd.setInt(8, modelo.getCliente().getIDCliente());

        cmd.setInt(9, modelo.getIDReserva());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Reserva WHERE id_reserva = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Reserva WHERE id_reserva = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Reserva");
    }

    @Override
    protected Reserva mapearModelo(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();

        reserva.setIDReserva(rs.getInt("id_reserva"));
        reserva.setFechaRegistro(rs.getTimestamp("fecha_registro"));

        // CORRECCIÓN: Convertimos el String de la BD de vuelta al Enum de Java
        String estadoStr = rs.getString("estado_reserva");
        if (estadoStr != null) {
            reserva.setEstadoReserva(EstadoReserva.valueOf(estadoStr));
        }

        reserva.setCantidadBoletos(rs.getInt("cantidad_boletos"));
        reserva.setMontoTotal(rs.getDouble("monto_total"));
        reserva.setFechaUltimaModificacion(rs.getTimestamp("fecha_ultima_modif"));
        reserva.setCanalVenta(rs.getString("canal_venta"));
        reserva.setMontoImpuestos(rs.getDouble("monto_impuestos"));

        Cliente cliente = new Cliente();
        cliente.setIDCliente(rs.getInt("id_cliente"));
        reserva.setCliente(cliente);

        return reserva;
    }
}

