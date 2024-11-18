package co.edu.uniquindio.poo;

public class Sedan extends Vehiculo {
    private int numeroPasajeros;
    private int numeroPuertas;
    private int capacidadMaletero;
    private Caracteristica aireAcondicionado;
    private Caracteristica camaraReversa;
    private Caracteristica velocidadCrucero;
    private int numeroBolsasAire;
    private Caracteristica abs;
    private Caracteristica sensoresColision;
    private Caracteristica sensorTraficoCruzado;
    private Caracteristica asistentePermanenciaCarril;

    public Sedan(String marca, String modelo, CondicionVehiculo condicion, TipoTransmision transmision,
            TipoCombustible combustible, Caracteristica caracteristica, int numeroPasajeros, int numeroPuertas,
            int capacidadMaletero, Caracteristica aireAcondicionado, Caracteristica camaraReversa,
            Caracteristica velocidadCrucero, int numeroBolsasAire, Caracteristica abs, Caracteristica sensoresColision,
            Caracteristica sensorTraficoCruzado, Caracteristica asistentePermanenciaCarril,double precio) {
        super(marca, modelo, condicion, transmision, combustible, caracteristica,precio);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.capacidadMaletero = capacidadMaletero;
        this.aireAcondicionado = aireAcondicionado;
        this.camaraReversa = camaraReversa;
        this.velocidadCrucero = velocidadCrucero;
        this.numeroBolsasAire = numeroBolsasAire;
        this.abs = abs;
        this.sensoresColision = sensoresColision;
        this.sensorTraficoCruzado = sensorTraficoCruzado;
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
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

    public Caracteristica getVelocidadCrucero() {
        return velocidadCrucero;
    }

    public void setVelocidadCrucero(Caracteristica velocidadCrucero) {
        this.velocidadCrucero = velocidadCrucero;
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

    public Caracteristica getSensoresColision() {
        return sensoresColision;
    }

    public void setSensoresColision(Caracteristica sensoresColision) {
        this.sensoresColision = sensoresColision;
    }

    public Caracteristica getSensorTraficoCruzado() {
        return sensorTraficoCruzado;
    }

    public void setSensorTraficoCruzado(Caracteristica sensorTraficoCruzado) {
        this.sensorTraficoCruzado = sensorTraficoCruzado;
    }

    public Caracteristica getAsistentePermanenciaCarril() {
        return asistentePermanenciaCarril;
    }

    public void setAsistentePermanenciaCarril(Caracteristica asistentePermanenciaCarril) {
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Pasajeros: " + numeroPasajeros +
                ", Número de Puertas: " + numeroPuertas + ", Capacidad Maletero: " + capacidadMaletero +
                ", Aire Acondicionado: " + aireAcondicionado + ", Cámara Reversa: " + camaraReversa +
                ", Velocidad Crucero: " + velocidadCrucero + ", Número de Bolsas de Aire: " + numeroBolsasAire +
                ", ABS: " + abs + ", Sensores de Colisión: " + sensoresColision +
                ", Sensor de Tráfico Cruzado: " + sensorTraficoCruzado +
                ", Asistente de Permanencia en Carril: " + asistentePermanenciaCarril;
    }
}
