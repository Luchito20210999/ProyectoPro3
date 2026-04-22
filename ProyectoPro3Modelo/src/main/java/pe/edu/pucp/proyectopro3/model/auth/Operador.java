package pe.edu.pucp.proyectopro3.model.auth;

import pe.edu.pucp.proyectopro3.model.crm.TipoDocumento;
import pe.edu.pucp.proyectopro3.model.reclamos.ReservasGestionable;
import pe.edu.pucp.proyectopro3.model.reportes.Atendible;

public class Operador extends Usuario implements ReservasGestionable, Atendible {

    public Operador(int IDUsuario, String nombres, String apellidos, TipoDocumento tipoDocumento, int numeroDocumento, String numeroContacto, String correo, String contrasena) {
        super(IDUsuario, nombres, apellidos, tipoDocumento, numeroDocumento, numeroContacto, correo, contrasena);
    }

    public Operador() {

    }

    //ReservasGestionable
    @Override
    public void modificarReserva(int idReserva) {

    }

    @Override
    public void anularReserva(int idReserva) {

    }

    //Atendible
    @Override
    public void atenderReclamo(int idReclamo) {

    }

    @Override
    public void evaluarProcedencia(int idReclamo, boolean procede) {

    }
}
