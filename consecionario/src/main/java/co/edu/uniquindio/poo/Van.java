package co.edu.uniquindio.poo;

public class Van extends Vehiculo {
    private int numeroPasajeros;
    private int numeroPuertas;
    private int capacidadMaletero;
    private Caracteristica aireAcondicionado;
    private Caracteristica camaraReversa;
    private int numeroBolsasAire;
    private Caracteristica abs;

    
    public Van(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
            TipoCombustible combustible, Caracteristica caracteristica, int numeroPasajeros, int numeroPuertas,
            int capacidadMaletero, Caracteristica aireAcondicionado, Caracteristica camaraReversa, int numeroBolsasAire,
            Caracteristica abs, double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.capacidadMaletero = capacidadMaletero;
        this.aireAcondicionado = aireAcondicionado;
        this.camaraReversa = camaraReversa;
        this.numeroBolsasAire = numeroBolsasAire;
        this.abs = abs;
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

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public Caracteristica getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Caracteristica aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Caracteristica getCamaraReversa() {
        return camaraReversa;
    }

    public void setCamaraReversa(Caracteristica camaraReversa) {
        this.camaraReversa = camaraReversa;
    }

    public int getNumeroBolsasAire() {
        return numeroBolsasAire;
    }

    public void setNumeroBolsasAire(int numeroBolsasAire) {
        this.numeroBolsasAire = numeroBolsasAire;
    }

    public Caracteristica getAbs() {
        return abs;
    }

    public void setAbs(Caracteristica abs) {
        this.abs = abs;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Pasajeros: " + numeroPasajeros +
                ", Número de Puertas: " + numeroPuertas + ", Capacidad Maletero: " + capacidadMaletero +
                ", Aire Acondicionado: " + aireAcondicionado + ", Cámara Reversa: " + camaraReversa +
                ", Número de Bolsas de Aire: " + numeroBolsasAire + ", ABS: " + abs;
    }
}
