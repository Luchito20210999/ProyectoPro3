package pe.edu.pucp.proyectopro3.modelo.reclamos;

public interface Atendible {
    public void atenderReclamo(int idReclamo);
    public void evaluarProcedencia(int idReclamo,boolean procede);
}
