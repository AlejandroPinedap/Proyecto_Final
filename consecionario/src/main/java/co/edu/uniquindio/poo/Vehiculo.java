package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    public String marca;
    public String modelo;
    public CondicionVehiculo condicion;
    public TipoTransmision transmision;
    public TipoCombustible combustible;
    public Caracteristica caracteristica;
    public double precio;

    public Vehiculo(String marca, String modelo, CondicionVehiculo condicion,
            TipoTransmision transmision, TipoCombustible combustible, Caracteristica caracteristica, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.condicion = condicion;
        this.transmision = transmision;
        this.combustible = combustible;
        this.caracteristica = caracteristica;
        this.precio = precio;
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

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio; // Método para obtener el precio
    }

    public void setPrecio(double precio) {
        this.precio = precio; // Método para establecer el precio
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Condición: " + condicion +
                ", Transmisión: " + transmision + ", Combustible: " + combustible +
                ", Precio: " + precio;
    }

}
