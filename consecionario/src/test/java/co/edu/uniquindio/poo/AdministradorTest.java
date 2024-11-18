package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AdministradorTest {

    @Test
    public void testRegistrarEmpleado() {
        Administrador admin = new Administrador("Juan Pérez", "A001", "juan@empresa.com", "1234567890", true);

        admin.registrarEmpleado("Carlos Ruiz", "E001", "carlos@empresa.com", "9876543210", true);

        List<Empleado> empleados = admin.getEmpleados();
        assertEquals(1, empleados.size());

        Empleado empleadoRegistrado = empleados.get(0);
        assertEquals("Carlos Ruiz", empleadoRegistrado.getNombre());
        assertEquals("E001", empleadoRegistrado.getId());
        assertEquals("carlos@empresa.com", empleadoRegistrado.getCorreo());
        assertEquals("9876543210", empleadoRegistrado.getTelefono());
        assertTrue(empleadoRegistrado.isActivo());
    }

    // Agregamos este método auxiliar a la clase de prueba para verificar si un empleado existe en la lista
    private boolean empleadoExiste(List<Empleado> empleados, String idEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(idEmpleado)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testBloquearEmpleado() {
        Administrador admin = new Administrador("Juan Pérez", "A001", "juan@empresa.com", "1234567890", true);

        admin.registrarEmpleado("María López", "E002", "maria@empresa.com", "5555555555", true);

        admin.bloquearEmpleado("E002");

        List<Empleado> empleados = admin.getEmpleados();
        Empleado empleadoBloqueado = empleados.get(0);
        assertFalse(empleadoBloqueado.isActivo());
    }

    @Test
    public void testBloquearEmpleadoInexistente() {
        Administrador admin = new Administrador("Juan Pérez", "A001", "juan@empresa.com", "1234567890", true);

        admin.registrarEmpleado("María López", "E002", "maria@empresa.com", "5555555555", true);

        admin.bloquearEmpleado("NoExiste");

        List<Empleado> empleados = admin.getEmpleados();
        assertFalse(empleadoExiste(empleados, "NoExiste"));
    }

    @Test
    public void testRegistrarMultiplesEmpleados() {
        Administrador admin = new Administrador("Juan Pérez", "A001", "juan@empresa.com", "1234567890", true);

        admin.registrarEmpleado("Ana García", "E003", "ana@empresa.com", "1111111111", true);
        admin.registrarEmpleado("Pedro Sánchez", "E004", "pedro@empresa.com", "2222222222", true);
        admin.registrarEmpleado("Laura Torres", "E005", "laura@empresa.com", "3333333333", true);

        List<Empleado> empleados = admin.getEmpleados();
        assertEquals(3, empleados.size());
    }
}