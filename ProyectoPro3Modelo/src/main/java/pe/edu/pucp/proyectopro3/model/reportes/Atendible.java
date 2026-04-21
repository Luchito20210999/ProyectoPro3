package pe.edu.pucp.proyectopro3.model.reportes;

public interface Atendible {
    void atenderReclamo(int IDReclamo);
    void evaluarProcedencia(int IDReclamo, boolean procede);
}
