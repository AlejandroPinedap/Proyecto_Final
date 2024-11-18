package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporte {
    private Date fechaInicio;
    private Date fechaFin;
    private double totalVentas;
    private double totalAlquileres;
    private List<Negocio> negocios;

    public Reporte(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.negocios = new ArrayList<>();
        this.totalVentas = 0;
        this.totalAlquileres = 0;
    }

    public void agregarNegocio(Negocio negocio) {
        if (!negocio.getFecha().before(fechaInicio) && !negocio.getFecha().after(fechaFin)) {
            negocios.add(negocio);
            if (negocio.getTipo().equals("venta")) {
                totalVentas += negocio.getMonto();
            } else if (negocio.getTipo().equals("alquiler")) {
                totalAlquileres += negocio.getMonto();
            }
        }
    }

    public void generarReporte() {
        System.out.println("Reporte de Negocios Realizados");
        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + fechaFin);
        System.out.println("Total Ventas: " + totalVentas);
        System.out.println("Total Alquileres: " + totalAlquileres);
    }

    // Getters y Setters
    // ...


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public double getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(double totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }
}
