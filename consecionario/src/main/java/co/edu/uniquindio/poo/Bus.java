package co.edu.uniquindio.poo;

public class Bus extends Vehiculo {
    private String marca;
    private String modelo;
    private int cilindraje;
    private int velocidadMaxima;
    private int numeroDePasajeros;
    private int numeroDePuertas;
    private int capacidadMaletero;
    private CondicionVehiculo condicion;
    private TipoTransmision transmision;
    private boolean aireAcondicionado;
    private boolean camaraReversa;
    private int numeroDeEjes;
    private int numeroSalidasEmergencia;

    // Constructor de la clase Bus

    public Bus(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
            TipoCombustible combustible, Caracteristica caracteristica, int cilindraje,
            int velocidadMaxima, int numeroDePasajeros, int numeroDePuertas, int capacidadMaletero,
            boolean aireAcondicionado, boolean camaraReversa, int numeroDeEjes, int numeroSalidasEmergencia,double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.marca=marca;
        this.modelo=modelo;
        this.condicion=condicion;
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroDePasajeros = numeroDePasajeros;
        this.numeroDePuertas = numeroDePuertas;
        this.capacidadMaletero = capacidadMaletero;
        this.aireAcondicionado = aireAcondicionado;
        this.camaraReversa = camaraReversa;
        this.numeroDeEjes = numeroDeEjes;
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
        this.precio=precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getNumeroDePasajeros() {
        return numeroDePasajeros;
    }

    public void setNumeroDePasajeros(int numeroDePasajeros) {
        this.numeroDePasajeros = numeroDePasajeros;
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public CondicionVehiculo getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionVehiculo condicion) {
        this.condicion = condicion;
    }

    public TipoTransmision getTransmision() {
        return transmision;
    }

    public void setTransmision(TipoTransmision transmision) {
        this.transmision = transmision;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCamaraReversa() {
        return camaraReversa;
    }

    public void setCamaraReversa(boolean camaraReversa) {
        this.camaraReversa = camaraReversa;
    }

    public int getNumeroDeEjes() {
        return numeroDeEjes;
    }

    public void setNumeroDeEjes(int numeroDeEjes) {
        this.numeroDeEjes = numeroDeEjes;
    }

    public int getNumeroSalidasEmergencia() {
        return numeroSalidasEmergencia;
    }

    public void setNumeroSalidasEmergencia(int numeroSalidasEmergencia) {
        this.numeroSalidasEmergencia = numeroSalidasEmergencia;
    }

    // Método toString para mostrar la información del bus
    @Override
    public String toString() {
        return "Bus [Marca=" + marca + ", Modelo=" + modelo + ", Cilindraje=" + cilindraje +
                ", Velocidad Máxima=" + velocidadMaxima + " km/h, Número de Pasajeros=" + numeroDePasajeros +
                ", Número de Puertas=" + numeroDePuertas + ", Capacidad Maletero=" + capacidadMaletero + " kg, " +
                "Condición=" + condicion + ", Transmisión=" + transmision + ", Aire Acondicionado=" +
                (aireAcondicionado ? "Sí" : "No") + ", Cámara Reversa=" + (camaraReversa ? "Sí" : "No") +
                ", Número de Ejes=" + numeroDeEjes + ", Número de Salidas de Emergencia=" + numeroSalidasEmergencia
                + "]";
    }
}
