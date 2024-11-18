package co.edu.uniquindio.poo;

public class Deportivo extends Vehiculo {
    private int numeroPasajeros;
    private int numeroPuertas;
    private int numeroBolsasAire;
    private int caballosDeFuerza;
    private double tiempoAceleraCien;

    public Deportivo(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,TipoCombustible combustible, Caracteristica caracteristica, int numeroPasajeros, int numeroPuertas,
            int numeroBolsasAire, int caballosDeFuerza, double tiempoAceleraCien,double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.numeroBolsasAire = numeroBolsasAire;
        this.caballosDeFuerza = caballosDeFuerza;
        this.tiempoAceleraCien = tiempoAceleraCien;
        this.precio=precio;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroBolsasAire() {
        return numeroBolsasAire;
    }

    public void setNumeroBolsasAire(int numeroBolsasAire) {
        this.numeroBolsasAire = numeroBolsasAire;
    }

    public int getCaballosDeFuerza() {
        return caballosDeFuerza;
    }

    public void setCaballosDeFuerza(int caballosDeFuerza) {
        this.caballosDeFuerza = caballosDeFuerza;
    }

    public double getTiempoAceleraCien() {
        return tiempoAceleraCien;
    }

    public void setTiempoAceleraCien(double tiempoAceleraCien) {
        this.tiempoAceleraCien = tiempoAceleraCien;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Pasajeros: " + numeroPasajeros +
                ", Número de Puertas: " + numeroPuertas + ", Número de Bolsas de Aire: " + numeroBolsasAire +
                ", Caballos de Fuerza: " + caballosDeFuerza + ", Tiempo a los 100 km/h: " + tiempoAceleraCien + " s";
    }
}
