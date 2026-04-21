package pe.edu.pucp.proyectopro3.dao;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ComandoDAO<R> {
    /** Ejecuta la operación sobre {@code conn} y devuelve el resultado. */
    R ejecutar(Connection conn) throws SQLException;
}
