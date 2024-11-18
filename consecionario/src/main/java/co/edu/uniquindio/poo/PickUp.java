package co.edu.uniquindio.poo;

public class PickUp extends Vehiculo {
    private int numeroPasajeros;
    private int numeroPuertas;
    private Caracteristica aireAcondicionado;
    private Caracteristica camaraReversa;
    private int numeroBolsasAire;
    private Caracteristica abs;
    private Caracteristica es4x4;
    private int capacidadCajaCarga;

    public PickUp(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
            TipoCombustible combustible, Caracteristica caracteristica, int numeroPasajeros, int numeroPuertas,
            Caracteristica aireAcondicionado, Caracteristica camaraReversa, int numeroBolsasAire, Caracteristica abs,
            Caracteristica es4x4, int capacidadCajaCarga, double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.camaraReversa = camaraReversa;
        this.numeroBolsasAire = numeroBolsasAire;
        this.abs = abs;
        this.es4x4 = es4x4;
        this.capacidadCajaCarga = capacidadCajaCarga;
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

    public Caracteristica getEs4x4() {
        return es4x4;
    }

    public void setEs4x4(Caracteristica es4x4) {
        this.es4x4 = es4x4;
    }

    public int getCapacidadCajaCarga() {
        return capacidadCajaCarga;
    }

    public void setCapacidadCajaCarga(int capacidadCajaCarga) {
        this.capacidadCajaCarga = capacidadCajaCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Pasajeros: " + numeroPasajeros +
                ", Número de Puertas: " + numeroPuertas + ", Aire Acondicionado: " + aireAcondicionado +
                ", Cámara Reversa: " + camaraReversa + ", Número de Bolsas de Aire: " + numeroBolsasAire +
                ", ABS: " + abs + ", 4x4: " + es4x4 + ", Capacidad de Caja de Carga: " + capacidadCajaCarga;
    }
}
