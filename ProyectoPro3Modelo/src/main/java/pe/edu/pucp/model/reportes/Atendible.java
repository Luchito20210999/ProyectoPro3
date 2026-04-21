package pe.edu.pucp.model.reportes;

public interface Atendible {
    void atenderReclamo(int IDReclamo);
    void evaluarProcedencia(int IDReclamo, boolean procede);
}
