package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ReporteTest {

    @Test
    public void testCreacionReporteConDatos() {
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        Reporte reporte = new Reporte(fechaInicio, fechaFin);

        // Verificar que los datos se hayan guardado correctamente
        assertEquals(fechaInicio, reporte.getFechaInicio());
        assertEquals(fechaFin, reporte.getFechaFin());
        assertEquals(0.0, reporte.getTotalVentas(), 0.01); // Inicialmente debe ser 0
        assertEquals(0.0, reporte.getTotalAlquileres(), 0.01); // Inicialmente debe ser 0
    }

    @Test
    public void testCreacionReporteVacio() {
        // Crear reporte con valores vacíos/nulos
        Reporte reporte = new Reporte(null, null);

        // Verificar que los valores sean nulos o cero
        assertNull(reporte.getFechaInicio());
        assertNull(reporte.getFechaFin());
        assertEquals(0.0, reporte.getTotalVentas(), 0.01);
        assertEquals(0.0, reporte.getTotalAlquileres(), 0.01);
    }

    @Test
    public void testValoresNegativos() {
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        Reporte reporte = new Reporte(fechaInicio, fechaFin);

        // Crear un negocio con valores negativos
        Negocio negocio = new Negocio("E001", fechaInicio, -1000.0, "venta");
        reporte.agregarNegocio(negocio);

        // Verificar que los valores negativos se guarden correctamente
        assertEquals(-1000.0, reporte.getTotalVentas(), 0.01);
        assertEquals(0.0, reporte.getTotalAlquileres(), 0.01);
    }

    @Test
    public void testFechaFinAnteriorAInicio() {
        // Crear fechas donde la fecha fin es anterior a la fecha inicio
        Date fechaInicio = new Date(System.currentTimeMillis());
        Date fechaFin = new Date(System.currentTimeMillis() - 86400000); // Un día antes

        Reporte reporte = new Reporte(fechaInicio, fechaFin);
        
        // Verificar que las fechas se guarden tal cual
        assertEquals(fechaInicio, reporte.getFechaInicio());
        assertEquals(fechaFin, reporte.getFechaFin());
    }

    @Test
    public void testAgregarNegociosYCalcularTotales() {
        Date fechaInicio = new Date(System.currentTimeMillis() - 86400000); // Ayer
        Date fechaFin = new Date(); // Hoy
        Reporte reporte = new Reporte(fechaInicio, fechaFin);

        // Agregar negocios
        Negocio negocio1 = new Negocio("E001", new Date(), 5000.0, "venta");
        Negocio negocio2 = new Negocio("E002", new Date(), 3000.0, "alquiler");
        Negocio negocio3 = new Negocio("E003", new Date(), 7000.0, "venta");

        reporte.agregarNegocio(negocio1);
        reporte.agregarNegocio(negocio2);
        reporte.agregarNegocio(negocio3);

        // Verificar los totales
        assertEquals(12000.0, reporte.getTotalVentas(), 0.01);
        assertEquals(3000.0, reporte.getTotalAlquileres(), 0.01);
    }
}