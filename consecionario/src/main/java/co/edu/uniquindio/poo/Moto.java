package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private String marca;
    private String modelo;
    private int cilindraje;
    private int velocidadMaxima; // Debes definir cómo calcular o establecer este valor
    private int numeroDeCambios; // También debes definir cómo calcular o establecer este valor
    private CondicionVehiculo condicion; 
    private TipoTransmision transmision; 
    private boolean aireAcondicionado;

    public Moto(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
                TipoCombustible combustible, Caracteristica caracteristica, int cilindraje,
                int velocidadMaxima, int numeroDeCambios, boolean aireAcondicionado, double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.marca = marca; // Asignar valor a la propiedad
        this.modelo = modelo; // Asignar valor a la propiedad
        this.condicion = condicion; // Asignar valor a la propiedad
        this.transmision = transmision; // Asignar valor a la propiedad
        this.cilindraje = cilindraje; // Asignar valor a la propiedad
        this.velocidadMaxima = velocidadMaxima; // Asignar valor a la propiedad
        this.numeroDeCambios = numeroDeCambios; // Asignar valor a la propiedad
        this.aireAcondicionado = aireAcondicionado; // Asignar valor a la propiedad
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

    public int getNumeroDeCambios() {
        return numeroDeCambios;
    }

    public void setNumeroDeCambios(int numeroDeCambios) {
        this.numeroDeCambios = numeroDeCambios;
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

    // Método toString para mostrar la información de la moto
    @Override
    public String toString() {
        return "Moto [Marca=" + marca + ", Modelo=" + modelo + ", Cilindraje=" + cilindraje +
                ", Velocidad Máxima=" + velocidadMaxima + " km/h, Número de Cambios=" + numeroDeCambios +
                ", Condición=" + condicion + ", Transmisión=" + transmision +
                ", Aire Acondicionado=" + (aireAcondicionado ? "Sí" : "No") + "]";
    }
}
