package pe.edu.pucp.proyectopro3.app;

import pe.edu.pucp.proyectopro3.dao.crm.ClienteDAO;
import pe.edu.pucp.proyectopro3.dao.crm.ClienteDAOImpl;
import pe.edu.pucp.proyectopro3.dao.reclamos.*;
import pe.edu.pucp.proyectopro3.model.crm.Cliente;
import pe.edu.pucp.proyectopro3.model.reclamos.DetalleReserva;
import pe.edu.pucp.proyectopro3.model.reclamos.EstadoReserva;
import pe.edu.pucp.proyectopro3.model.reclamos.Reserva;
import pe.edu.pucp.proyectopro3.model.reclamos.Servicio;

import java.util.Date;

public class main {
    public static void main(String[] args) {

        // 1. Inicialización de los DAOs
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ServicioDAO servicioDAO = new ServicioDAOImpl();
        ReservaDAO reservaDAO = new ReservaDAOImpl();
        DetalleReservaDAO detalleReservaDAO = new DetalleReservaDAOImpl();

        // 2. Variables para almacenar los IDs autogenerados
        Integer idCliente = null;
        Integer idServicio = null;
        Integer idReserva = null;
        Integer idDetalleReserva = null;

        try {
            System.out.println("--- INICIANDO PRUEBAS CRUD ---");

            // ==========================================
            // PRUEBA 1: CLIENTE
            // ==========================================
            Cliente cliente = new Cliente();
            cliente.setNombres("Juan");
            cliente.setApellidos("Perez");
            cliente.setCorreo("juan.perez@email.com");
            // ... (Setear demás campos del cliente como tipo/numero documento)

            idCliente = clienteDAO.crear(cliente);
            cliente.setIDCliente(idCliente);
            System.out.println("1. Cliente creado con ID: " + idCliente);

            // ==========================================
            // PRUEBA 2: SERVICIO
            // ==========================================
            Servicio servicio = new Servicio();
            servicio.setNombre("Tour Valle Sagrado");
            servicio.setDescripcion("Recorrido completo por el valle sagrado de los incas.");
            servicio.setPrecioUSD(85.50);
            servicio.setDuracionHoras(8.5);
            servicio.setIdiomaGuia("Español/Inglés");
            servicio.setCapacidadMaxima(15);
            servicio.setIncluyeRecojo(true);
            servicio.setCiudadDestino("Cusco");

            idServicio = servicioDAO.crear(servicio);
            servicio.setIDServicio(idServicio);
            System.out.println("2. Servicio creado con ID: " + idServicio);

            // ==========================================
            // PRUEBA 3: RESERVA
            // ==========================================
            Reserva reserva = new Reserva();
            reserva.setFechaRegistro(new Date());
            reserva.setEstadoReserva(EstadoReserva.PENDIENTE); // Enum
            reserva.setCantidadBoletos(2);
            reserva.setMontoTotal(171.00); // 85.50 * 2
            reserva.setCanalVenta("Web Site");
            reserva.setMontoImpuestos(30.78);
            reserva.setCliente(cliente); // Relación

            idReserva = reservaDAO.crear(reserva);
            reserva.setIDReserva(idReserva);
            System.out.println("3. Reserva creada con ID: " + idReserva);

            // Actualizando Reserva
            reserva.setEstadoReserva(EstadoReserva.APROBADO);
            reservaDAO.actualizar(reserva);
            System.out.println(" -> Reserva actualizada a CONFIRMADA.");

            // ==========================================
            // PRUEBA 4: DETALLE DE RESERVA
            // ==========================================
            DetalleReserva detalle = new DetalleReserva();
            detalle.setReserva(reserva);     // Llave foránea a Reserva
            detalle.setServicio(servicio);   // Llave foránea a Servicio
            detalle.setCantidad(2);
            detalle.setSubtotal(171.00);

            idDetalleReserva = detalleReservaDAO.crear(detalle);
            detalle.setIDDetalle(idDetalleReserva);
            System.out.println("4. Detalle de Reserva creado con ID: " + idDetalleReserva);

            // ==========================================
            // LECTURA (READ TODOS)
            // ==========================================
            System.out.println("\n--- RESUMEN DE REGISTROS ---");
            System.out.println("Total Clientes en BD: " + clienteDAO.leerTodos().size());
            System.out.println("Total Servicios en BD: " + servicioDAO.leerTodos().size());
            System.out.println("Total Reservas en BD: " + reservaDAO.leerTodos().size());
            System.out.println("Total Detalles en BD: " + detalleReservaDAO.leerTodos().size());

            System.out.println("\nFlujo de prueba completado exitosamente.");

        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n--- INICIANDO LIMPIEZA DE BASE DE DATOS (ROLLBACK MANUAL) ---");
            // NOTA MUY IMPORTANTE:
            // La eliminación debe hacerse en ORDEN INVERSO a la creación
            // para no romper las restricciones de Llaves Foráneas (Foreign Keys).

            try {
                if (idDetalleReserva != null) {
                    detalleReservaDAO.eliminar(idDetalleReserva);
                    System.out.println("- Detalle de Reserva eliminado.");
                }
                if (idReserva != null) {
                    reservaDAO.eliminar(idReserva);
                    System.out.println("- Reserva eliminada.");
                }
                if (idServicio != null) {
                    servicioDAO.eliminar(idServicio);
                    System.out.println("- Servicio eliminado.");
                }
                if (idCliente != null) {
                    clienteDAO.eliminar(idCliente);
                    System.out.println("- Cliente eliminado.");
                }
            } catch (Exception ex) {
                System.err.println("Error durante la limpieza: " + ex.getMessage());
            }
        }
    }
}
