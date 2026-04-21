package pe.edu.pucp.model.auth;

import pe.edu.pucp.model.crm.TipoDocumento;
import pe.edu.pucp.model.reportes.Consultable;
import pe.edu.pucp.model.reportes.Reporte;

import java.util.Date;

public class Analista extends Usuario implements Consultable {

    public Analista(int IDUsuario, String nombres, String apellidos, TipoDocumento tipoDocumento, int numeroDocumento, String numeroContacto, String correo, String contrasena) {
        super(IDUsuario, nombres, apellidos, tipoDocumento, numeroDocumento,numeroContacto, correo, contrasena);
    }

    //Consultable
    @Override
    public Reporte generarReporte(Date fechaInicio, Date fechaFin) {
        return new Reporte();
    }

    @Override
    public double calcularKPI(String tipoKPI) {
        return 0.0;
    }

    @Override
    public void exportarDashboard() {

    }
}
