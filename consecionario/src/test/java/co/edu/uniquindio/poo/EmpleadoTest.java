package co.edu.uniquindio.poo;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    @Test
    public void testRegistrarCliente() {
        Empleado empleado = new Empleado("Juan Pérez", "123456", "juan@empresa.com", "555-1234", true);
        Cliente cliente = new Cliente("Carlos Sánchez", "654321", "carlos@cliente.com", "Calle Falsa 123", "555-5678");

        empleado.registrarCliente(cliente.getNombre(), cliente.getId(), cliente.getCorreo(), cliente.getDireccion(),
                cliente.getTelefono());
        assertEquals(1, empleado.getClientes().size());
        assertEquals("Carlos Sánchez", empleado.getClientes().get(0).getNombre());
    }

    @Test
    public void testMostrarClientes() {
        Empleado empleado = new Empleado("Juan Pérez", "123456", "juan@empresa.com", "555-1234", true);
        Cliente cliente = new Cliente("Carlos Sánchez", "654321", "carlos@cliente.com", "Calle Falsa 123", "555-5678");

        empleado.registrarCliente(cliente.getNombre(), cliente.getId(), cliente.getCorreo(), cliente.getDireccion(),
                cliente.getTelefono());
        empleado.mostrarClientes();
        // Esta prueba asume que el método mostrarClientes imprime correctamente la
        // lista de clientes
    }

    @Test
    public void testMostrarTransacciones() {
        Empleado empleado = new Empleado("Juan Pérez", "123456", "juan@empresa.com", "555-1234", true);
        Cliente cliente = new Cliente("Carlos Sánchez", "654321", "carlos@cliente.com", "Calle Falsa 123", "555-5678");
        Vehiculo PickUp = new PickUp("Toyota",
                "Hilux",
                CondicionVehiculo.NUEVO,
                TipoTransmision.MANUAL,
                TipoCombustible.DIESEL,
                Caracteristica.DISPONIBLE,
                5,
                4,
                Caracteristica.DISPONIBLE,
                Caracteristica.DISPONIBLE,
                6,
                Caracteristica.DISPONIBLE,
                Caracteristica.DISPONIBLE,
                1000, 20000);
        Date fecha = new Date();

        empleado.alquilarVehiculo(PickUp, cliente, fecha);
        empleado.mostrarTransacciones();
        // Esta prueba asume que el método mostrarTransacciones imprime correctamente la
        // lista de transacciones
    }
}
