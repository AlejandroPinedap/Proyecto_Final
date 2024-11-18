package co.edu.uniquindio.poo;

public class Camion extends Vehiculo {
    private String marca;
    private String modelo;
    private int cilindraje;
    private int velocidadMaxima;
    private int capacidadCarga; // Capacidad de carga del camión
    private int numeroDeEjes;
    private String tipoCamion; // Tipo de camión (por ejemplo: caja cerrada, plataforma)
    private CondicionVehiculo condicion; // Condición del vehículo (nuevo o usado)
    private TipoTransmision transmision; // Tipo de transmisión (manual o automática)
    private boolean aireAcondicionado;
    private boolean frenosDeAire; // Si tiene frenos de aire


    public Camion(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
            TipoCombustible combustible, Caracteristica caracteristica, int cilindraje,
            int velocidadMaxima, int capacidadCarga, int numeroDeEjes, String tipoCamion, boolean aireAcondicionado, boolean frenosDeAire,double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.marca=marca;
        this.modelo=modelo;
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadCarga = capacidadCarga;
        this.numeroDeEjes = numeroDeEjes;
        this.tipoCamion = tipoCamion;
        this.aireAcondicionado = aireAcondicionado;
        this.frenosDeAire = frenosDeAire;
        this.precio=precio;
    }

    

    // Métodos getters y setters
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

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroDeEjes() {
        return numeroDeEjes;
    }

    public void setNumeroDeEjes(int numeroDeEjes) {
        this.numeroDeEjes = numeroDeEjes;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
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

    public boolean isFrenosDeAire() {
        return frenosDeAire;
    }

    public void setFrenosDeAire(boolean frenosDeAire) {
        this.frenosDeAire = frenosDeAire;
    }

    // Método toString para mostrar la información del camión
    @Override
    public String toString() {
        return "Camión [Marca=" + marca + ", Modelo=" + modelo + ", Cilindraje=" + cilindraje +
                ", Velocidad Máxima=" + velocidadMaxima + " km/h, Capacidad de Carga=" + capacidadCarga + " kg, " +
                "Número de Ejes=" + numeroDeEjes + ", Tipo de Camión=" + tipoCamion + ", Condición=" + condicion +
                ", Transmisión=" + transmision + ", Aire Acondicionado=" + (aireAcondicionado ? "Sí" : "No") +
                ", Frenos de Aire=" + (frenosDeAire ? "Sí" : "No") + "]";
    }
}