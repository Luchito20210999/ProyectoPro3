package pe.edu.pucp.proyectopro3.dao.reclamos;

import pe.edu.pucp.proyectopro3.dao.DefaultBaseDAO;
import pe.edu.pucp.proyectopro3.model.reclamos.Servicio;

import java.sql.*;

public class ServicioDAOImpl extends DefaultBaseDAO<Servicio> implements ServicioDAO {

    @Override
    protected PreparedStatement comandoCrear(Connection conn, Servicio modelo) throws SQLException {
        // id_servicio es AUTO_INCREMENT
        String sql = """
            INSERT INTO Servicio (
                nombre,
                descripcion,
                precio_usd,
                duracion_horas,
                idioma_guia,
                capacidad_maxima,
                incluye_recojo,
                ciudad_destino
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        cmd.setString(1, modelo.getNombre());
        cmd.setString(2, modelo.getDescripcion());
        cmd.setDouble(3, modelo.getPrecioUSD());
        cmd.setDouble(4, modelo.getDuracionHoras());
        cmd.setString(5, modelo.getIdiomaGuia());
        cmd.setInt(6, modelo.getCapacidadMaxima());

        // Traducción de boolean (Java) a int (MySQL)
        cmd.setInt(7, modelo.getIncluyeRecojo() ? 1 : 0);

        cmd.setString(8, modelo.getCiudadDestino());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoActualizar(Connection conn, Servicio modelo) throws SQLException {
        String sql = """
            UPDATE Servicio
            SET nombre = ?,
                descripcion = ?,
                precio_usd = ?,
                duracion_horas = ?,
                idioma_guia = ?,
                capacidad_maxima = ?,
                incluye_recojo = ?,
                ciudad_destino = ?
            WHERE id_servicio = ?
            """;

        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setString(1, modelo.getNombre());
        cmd.setString(2, modelo.getDescripcion());
        cmd.setDouble(3, modelo.getPrecioUSD());
        cmd.setDouble(4, modelo.getDuracionHoras());
        cmd.setString(5, modelo.getIdiomaGuia());
        cmd.setInt(6, modelo.getCapacidadMaxima());

        // Traducción de boolean (Java) a int (MySQL)
        cmd.setInt(7, modelo.getIncluyeRecojo() ? 1 : 0);

        cmd.setString(8, modelo.getCiudadDestino());

        // El ID siempre va al final para el filtro WHERE
        cmd.setInt(9, modelo.getIDServicio());

        return cmd;
    }

    @Override
    protected PreparedStatement comandoEliminar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Servicio WHERE id_servicio = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeer(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM Servicio WHERE id_servicio = ?";
        PreparedStatement cmd = conn.prepareStatement(sql);
        cmd.setInt(1, id);
        return cmd;
    }

    @Override
    protected PreparedStatement comandoLeerTodos(Connection conn) throws SQLException {
        return conn.prepareStatement("SELECT * FROM Servicio");
    }

    @Override
    protected Servicio mapearModelo(ResultSet rs) throws SQLException {
        Servicio servicio = new Servicio();

        servicio.setIDServicio(rs.getInt("id_servicio"));
        servicio.setNombre(rs.getString("nombre"));
        servicio.setDescripcion(rs.getString("descripcion"));
        servicio.setPrecioUSD(rs.getDouble("precio_usd"));
        servicio.setDuracionHoras(rs.getDouble("duracion_horas"));
        servicio.setIdiomaGuia(rs.getString("idioma_guia"));
        servicio.setCapacidadMaxima(rs.getInt("capacidad_maxima"));

        // Traducción de int (MySQL) a boolean (Java)
        // Si la BD devuelve 1, se asigna true. Si es 0, false.
        servicio.setIncluyeRecojo(rs.getInt("incluye_recojo") == 1);

        servicio.setCiudadDestino(rs.getString("ciudad_destino"));

        return servicio;
    }
}
