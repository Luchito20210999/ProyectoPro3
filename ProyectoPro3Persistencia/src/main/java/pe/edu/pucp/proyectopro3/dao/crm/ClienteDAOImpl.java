package pe.edu.pucp.proyectopro3.dao.crm;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.crm.Cliente;
import pe.edu.pucp.proyectopro3.model.crm.TipoDocumento;

import java.sql.*;

public class ClienteDAOImpl extends DefaultBaseDAO<Cliente> implements ClienteDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Cliente modelo) throws SQLException {
        // id_cliente es AUTO_INCREMENT, no se incluye.
        // Incluimos nacionalidad y fecha_registro según tu diagrama.
        String sql = """
            INSERT INTO Cliente (
                nombres,
                apellidos,
                tipo_documento,
                numero_documento,
                nacionalidad,
                correo,
                fecha_registro,
                numero_contacto,
                fecha_nacimiento
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getNombres());
        cmd.setString(2, modelo.getApellidos());
        cmd.setString(3, modelo.getTipoDocumento().name());
        cmd.setInt(4, modelo.getNumeroDocumento());
        cmd.setString(5, modelo.getNacionalidad());
        cmd.setString(6, modelo.getCorreo());

        // fecha_registro: suele ser la fecha actual del sistema al crear
        if (modelo.getFechaRegistro() != null) {
            cmd.setDate(7, new java.sql.Date(modelo.getFechaRegistro().getTime()));
        } else {
            cmd.setDate(7, new java.sql.Date(System.currentTimeMillis()));
        }

        cmd.setString(8, modelo.getNumeroContacto());

        if (modelo.getFechaNacimiento() != null) {
            cmd.setDate(9, new java.sql.Date(modelo.getFechaNacimiento().getTime()));
        } else {
            cmd.setNull(9, Types.DATE);
        }

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Cliente modelo) throws SQLException {
        String sql = """
            UPDATE Cliente
            SET nombres = ?,
                apellidos = ?,
                tipo_documento = ?,
                numero_documento = ?,
                nacionalidad = ?,
                correo = ?,
                fecha_registro = ?,
                numero_contacto = ?,
                fecha_nacimiento = ?
            WHERE id_cliente = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getNombres());
        cmd.setString(2, modelo.getApellidos());
        cmd.setString(3, modelo.getTipoDocumento().name());
        cmd.setInt(4, modelo.getNumeroDocumento());
        cmd.setString(5, modelo.getNacionalidad());
        cmd.setString(6, modelo.getCorreo());
        cmd.setDate(7, new java.sql.Date(modelo.getFechaRegistro().getTime()));
        cmd.setString(8, modelo.getNumeroContacto());
        cmd.setDate(9, new java.sql.Date(modelo.getFechaNacimiento().getTime()));

        // El ID para el filtro WHERE (parámetro 10)
        cmd.setInt(10, modelo.getIDCliente());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Cliente");
    }

    @Override
    protected Cliente mapearModelo(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setIDCliente(rs.getInt("id_cliente"));
        cliente.setNombres(rs.getString("nombres"));
        cliente.setApellidos(rs.getString("apellidos"));

        String tipoDocStr = rs.getString("tipo_documento");
        if (tipoDocStr != null) {
            cliente.setTipoDocumento(TipoDocumento.valueOf(tipoDocStr));
        }

        cliente.setNumeroDocumento(rs.getInt("numero_documento"));
        cliente.setNacionalidad(rs.getString("nacionalidad"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setFechaRegistro(rs.getDate("fecha_registro"));
        cliente.setNumeroContacto(rs.getString("numero_contacto"));
        cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));

        return cliente;
    }
}
