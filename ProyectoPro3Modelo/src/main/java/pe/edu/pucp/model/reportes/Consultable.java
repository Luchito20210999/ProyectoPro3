package pe.edu.pucp.model.reportes;

import java.util.Date;

public interface Consultable {
    Reporte generarReporte(Date fechaInicio, Date fechaFin);
    double calcularKPI(String tipoKPI);
    void exportarDashboard();
}
