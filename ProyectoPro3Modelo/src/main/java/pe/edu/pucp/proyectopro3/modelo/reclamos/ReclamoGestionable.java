package pe.edu.pucp.proyectopro3.modelo.reclamos;

public interface ReclamoGestionable {
    public void registrarReclamo(Reclamo r,int idReserva);
    public void consultarReclamo(int idReclamo);
    public void eliminarReclamo(int idReclamo);
}
