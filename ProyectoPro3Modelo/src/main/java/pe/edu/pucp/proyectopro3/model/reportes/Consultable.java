package pe.edu.pucp.proyectopro3.model.reportes;

import java.util.Date;

public interface Consultable {
    Reporte generarReporte(Date fechaInicio, Date fechaFin);
    double calcularKPI(String tipoKPI);
    void exportarDashboard();
}
