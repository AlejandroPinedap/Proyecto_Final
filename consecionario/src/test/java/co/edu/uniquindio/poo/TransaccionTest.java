package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class TransaccionTest {

        @Test
        public void testCreacionTransaccion() {
                // Crear objetos necesarios para la prueba
                Empleado empleado = new Empleado("Juan Vendedor", "E001", "juan@empresa.com", "1234567890", true);
                Cliente cliente = new Cliente("María Compradora", "C001", "maria@gmail.com", "9876543210", "1233");
                Vehiculo van = new Van(
                                "Mercedes-Benz",
                                "Sprinter",
                                CondicionVehiculo.NUEVO,
                                TipoTransmision.AUTOMATICA,
                                TipoCombustible.DIESEL,
                                Caracteristica.DISPONIBLE,
                                12,
                                4,
                                2500,
                                Caracteristica.DISPONIBLE,
                                Caracteristica.NO_DISPONIBLE,
                                6,
                                Caracteristica.DISPONIBLE,
                                200000);
                Date fecha = new Date();

                // Crear la transacción con el tipo de transacción adecuado
                Transaccion transaccion = new Transaccion(empleado, van, cliente, TipoTransaccion.VENTA, fecha,
                                van.getPrecio());

                // Verificar que todos los campos se hayan establecido correctamente
                assertEquals(empleado, transaccion.getEmpleado());
                assertEquals(van, transaccion.getVehiculo());
                assertEquals(cliente, transaccion.getCliente());
                assertEquals(TipoTransaccion.VENTA, transaccion.getTipoTransaccion());
                assertEquals(fecha, transaccion.getFecha());
                assertEquals(van.getPrecio(), transaccion.getMonto());
        }

        @Test
        public void testTransaccionConDiferentesTipos() {
                // Crear objetos base
                Empleado empleado = new Empleado("Carlos Vendedor", "E003", "carlos@empresa.com", "7777777777", true);
                Cliente cliente = new Cliente("Luis Comprador", "C003", "luis@gmail.com", "8888888888", "123455");
                Vehiculo van = new Van(
                                "Mercedes-Benz",
                                "Sprinter",
                                CondicionVehiculo.NUEVO,
                                TipoTransmision.AUTOMATICA,
                                TipoCombustible.DIESEL,
                                Caracteristica.DISPONIBLE,
                                12,
                                4,
                                2500,
                                Caracteristica.DISPONIBLE,
                                Caracteristica.NO_DISPONIBLE,
                                6,
                                Caracteristica.DISPONIBLE,
                                200000);
                Date fecha = new Date();

                // Probar diferentes tipos de transacción
                Transaccion ventaTransaccion = new Transaccion(empleado, van, cliente, TipoTransaccion.VENTA, fecha,
                                van.getPrecio());
                assertEquals(TipoTransaccion.VENTA, ventaTransaccion.getTipoTransaccion());

                Transaccion alquilerTransaccion = new Transaccion(empleado, van, cliente, TipoTransaccion.ALQUILER,
                                fecha, van.getPrecio());
                assertEquals(TipoTransaccion.ALQUILER, alquilerTransaccion.getTipoTransaccion());
        }
}