package pe.edu.pucp.model.reportes;

import java.util.Date;

public class Reporte {
    private int idReporte; // [cite: 167, 168]
    private Date fechaGeneracion; // [cite: 169, 170]
    private TipoReporte tipoReporte; // [cite: 171, 172]
    private int totalRegistros; // [cite: 173, 174]
    private double montoTotalGen; // [cite: 175, 176]
    private Date fechaInicioFiltro; // [cite: 175, 177]
    private Date fechaFinFiltro; // [cite: 178, 179]

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public TipoReporte getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReporte tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public double getMontoTotalGen() {
        return montoTotalGen;
    }

    public void setMontoTotalGen(double montoTotalGen) {
        this.montoTotalGen = montoTotalGen;
    }

    public Date getFechaInicioFiltro() {
        return fechaInicioFiltro;
    }

    public void setFechaInicioFiltro(Date fechaInicioFiltro) {
        this.fechaInicioFiltro = fechaInicioFiltro;
    }

    public Date getFechaFinFiltro() {
        return fechaFinFiltro;
    }

    public void setFechaFinFiltro(Date fechaFinFiltro) {
        this.fechaFinFiltro = fechaFinFiltro;
    }
}
