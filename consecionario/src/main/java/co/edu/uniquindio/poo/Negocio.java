package co.edu.uniquindio.poo;

import java.util.Date;

public class Negocio {
    private String idEmpleado; // ID del empleado que realizó el negocio
    private Date fecha; // Fecha del negocio
    private double monto; // Monto de la transacción
    private String tipo; // Tipo de negocio (por ejemplo, "venta" o "alquiler")

    public Negocio(String idEmpleado, Date fecha, double monto, String tipo) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo; // "venta" o "alquiler"
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Negocio{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}