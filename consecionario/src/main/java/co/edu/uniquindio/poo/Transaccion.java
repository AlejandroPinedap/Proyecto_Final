package co.edu.uniquindio.poo;

import java.util.Date;

public class Transaccion {
    private Empleado empleado;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private TipoTransaccion tipoTransaccion; 
    private Date fecha;
    private double monto;

    public Transaccion(Empleado empleado, Vehiculo vehiculo, Cliente cliente,
            TipoTransaccion tipoTransaccion, Date fecha, double monto) {
        this.empleado = empleado;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.tipoTransaccion = tipoTransaccion;
        this.fecha = fecha;
        this.monto = monto; 
    }

    // Getters y otros métodos
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public double getMonto() { 
        return monto;
    }

    @Override
    public String toString() {
        return "Transacción: " + tipoTransaccion + " - Vehículo: " + vehiculo.getMarca() + " " +
                vehiculo.getModelo() + " - Cliente: " + cliente.getNombre() + " - Fecha: " + fecha +
                " - Monto: $" + monto; 
    }
}