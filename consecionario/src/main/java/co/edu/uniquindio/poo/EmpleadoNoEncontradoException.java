package co.edu.uniquindio.poo;

public class EmpleadoNoEncontradoException extends Exception {

    // Constructor que recibe solo el mensaje
    public EmpleadoNoEncontradoException(String message) {
        super(message);
    }

    // Constructor que recibe mensaje y causa (otra excepción)
    public EmpleadoNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
