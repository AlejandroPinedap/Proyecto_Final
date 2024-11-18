package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Empleado {
    private List<Empleado> empleados;

    public Administrador(String nombre, String id, String correo, String telefono, boolean activo) {
        super(nombre, id, correo, telefono, activo);
        this.empleados = new ArrayList<>();
    }

    public void registrarEmpleado(String nombre, String id, String correo, String telefono, boolean activo) {
        Empleado nuevoEmpleado = new Empleado(nombre, id, correo, telefono, activo);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado registrado: " + nuevoEmpleado);
    }

    public void bloquearEmpleado(String idEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(idEmpleado)) {
                empleado.setActivo(false);
                System.out.println("Empleado bloqueado: " + empleado);
                return;
            }
        }
        System.out.println("No se encontró el empleado con ID: " + idEmpleado);
    }

    public void actualizarEmpleado(String idEmpleado, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(idEmpleado)) {
                empleado.setNombre(nuevoNombre);
                empleado.setCorreo(nuevoCorreo);
                empleado.setTelefono(nuevoTelefono);
                System.out.println("Datos actualizados para el empleado: " + empleado);
                return;
            }
        }
        System.out.println("No se encontró el empleado con ID: " + idEmpleado);
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean esAdministrador() {
        return true;
    }

    // Método para generar reportes
    public void generarReporteNegocios(Reporte reporte, List<Negocio> todosLosNegocios) {
        for (Negocio negocio : todosLosNegocios) {
            reporte.agregarNegocio(negocio);
        }
        reporte.generarReporte();
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + getNombre() + '\'' +
                ", id='" + getId() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", activo=" + isActivo() +
                '}';
    }
}
