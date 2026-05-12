package pe.edu.pucp.proyectopro3.modelo.reservas;

public interface ReservasGestionable {
    public void consultarReserva(int idReserva);
    public void modificarReserva(int idReserva);
    public void anularReserva(int idReserva);
}
