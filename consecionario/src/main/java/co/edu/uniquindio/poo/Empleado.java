package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Empleado extends Persona {
    private boolean activo; // Indica si el empleado está habilitado
    private List<Cliente> clientes; // Lista de clientes asociados al empleado
    private List<Transaccion> transacciones; // Lista de transacciones realizadas por el empleado
    private List<Vehiculo> listaVehiculos; // Lista de vehículos registrados por el empleado

    public Empleado(String nombre, String id, String correo, String telefono, boolean activo) {
        super(nombre, id, correo, telefono);
        this.activo = true; // Por defecto, un empleado está activo al crearse
        this.clientes = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
    }

    // Método para registrar un cliente
    public void registrarCliente(String nombre, String id, String correo, String direccion, String telefono) {
        Cliente nuevoCliente = new Cliente(nombre, id, correo, direccion, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado: " + nuevoCliente);
    }

    // Método para mostrar la lista de clientes
    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Método para registrar un vehículo
    public void registrarVehiculo(Vehiculo vehiculo) throws VehiculoNoDisponibleException {
        if (!activo) {
            System.out.println("El empleado está inactivo y no puede registrar vehículos.");
            return;
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }

        // Verificamos si el vehículo no está disponible
        if (vehiculo.getCaracteristica() != Caracteristica.DISPONIBLE) {
            throw new VehiculoNoDisponibleException("El vehículo no está disponible para el registro.");
        }

        listaVehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
    }

    // Método genérico para registrar una transacción
    private void registrarTransaccion(Vehiculo vehiculo, Cliente cliente, TipoTransaccion tipoTransaccion, Date fecha) {
        if (!activo) {
            System.out.println("El empleado está inactivo y no puede realizar transacciones.");
            return;
        }
        if (vehiculo == null || cliente == null || fecha == null) {
            throw new IllegalArgumentException("El vehículo, cliente y fecha no pueden ser nulos.");
        }
    
        // Aquí ya está correctamente pasando el tipo de transacción
        Transaccion transaccion = new Transaccion(null, vehiculo, cliente, tipoTransaccion, fecha, 0);
        transacciones.add(transaccion);
        System.out.println("Transacción registrada: " + tipoTransaccion + " - Vehículo: " + vehiculo.getMarca() + " "
                + vehiculo.getModelo() + " - Cliente: " + cliente.getNombre() + " - Fecha: " + fecha);
    }
    
    // Métodos específicos para transacciones
    public void alquilarVehiculo(Vehiculo vehiculo, Cliente cliente, Date fecha) {
        registrarTransaccion(vehiculo, cliente, TipoTransaccion.ALQUILER, fecha);
    }
    
    public void comprarVehiculo(Vehiculo vehiculo, Cliente cliente, Date fecha) {
        registrarTransaccion(vehiculo, cliente, TipoTransaccion.COMPRA, fecha);
    }
    
    public void venderVehiculo(Vehiculo vehiculo, Cliente cliente, Date fecha) {
        registrarTransaccion(vehiculo, cliente, TipoTransaccion.VENTA, fecha);
    }
    // Método para mostrar las transacciones realizadas
    public void mostrarTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }
        System.out.println("Transacciones realizadas:");
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }

    // Getters y setters
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public boolean esEmpleado() {
        return true;  // Un Empleado es siempre un Empleado
    }


    @Override
    public String toString() {
        return super.toString() + ", activo=" + activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
