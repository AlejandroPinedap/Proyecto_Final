package co.edu.uniquindio.poo;


import java.util.HashMap;
import java.util.Map;

public class SistemaAutenticacion {
    // Mapas para almacenar credenciales y preguntas de seguridad de los usuarios
    private Map<String, String> usuarios;  // "idUsuario" -> "contraseña"
    private Map<String, String> preguntasSeguridad; // "idUsuario" -> "pregunta"
    private Map<String, String> respuestasSeguridad; // "idUsuario" -> "respuesta"
    
    // Constructor
    public SistemaAutenticacion() {
        usuarios = new HashMap<>();
        preguntasSeguridad = new HashMap<>();
        respuestasSeguridad = new HashMap<>();
        
        // Cargar algunos usuarios para pruebas (puedes agregar más según lo necesites)
        usuarios.put("E001", "contrasena123"); // Empleado 1
        preguntasSeguridad.put("E001", "¿Nombre de tu primera mascota?");
        respuestasSeguridad.put("E001", "Firulais");
        
        usuarios.put("E002", "contrasena456"); // Empleado 2
        preguntasSeguridad.put("E002", "¿Ciudad de nacimiento?");
        respuestasSeguridad.put("E002", "Medellin");
        
        usuarios.put("admin", "adminpass");   // Admin para pruebas
        preguntasSeguridad.put("admin", "¿Superhéroe favorito?");
        respuestasSeguridad.put("admin", "Batman");
    }
    
    // Método para autenticar al usuario
    public boolean autenticar(String idUsuario, String contrasena) {
        if (usuarios.containsKey(idUsuario)) {
            return usuarios.get(idUsuario).equals(contrasena);
        } else {
            return false;  // Usuario no encontrado
        }
    }
    
    // Método para agregar nuevos usuarios al sistema con pregunta y respuesta de seguridad
    public void registrarUsuario(String idUsuario, String contrasena, String pregunta, String respuesta) {
        if (!usuarios.containsKey(idUsuario)) {
            usuarios.put(idUsuario, contrasena);
            preguntasSeguridad.put(idUsuario, pregunta);
            respuestasSeguridad.put(idUsuario, respuesta);
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("El ID de usuario ya existe.");
        }
    }
    
    // Método para eliminar usuarios si es necesario
    public void eliminarUsuario(String idUsuario) {
        if (usuarios.containsKey(idUsuario)) {
            usuarios.remove(idUsuario);
            preguntasSeguridad.remove(idUsuario);
            respuestasSeguridad.remove(idUsuario);
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    
    // Método para mostrar todos los usuarios (opcional, para depuración)
    public void mostrarUsuarios() {
        for (String usuario : usuarios.keySet()) {
            System.out.println("Usuario: " + usuario);
        }
    }
    
    // Método para recuperar la contraseña mediante una pregunta de seguridad
    public String recuperarContrasena(String idUsuario, String respuesta) {
        if (usuarios.containsKey(idUsuario)) {
            String respuestaCorrecta = respuestasSeguridad.get(idUsuario);
            if (respuestaCorrecta.equalsIgnoreCase(respuesta)) {
                return usuarios.get(idUsuario);
            } else {
                return "Respuesta incorrecta.";
            }
        } else {
            return "Usuario no encontrado.";
        }
    }

    // Método para obtener la pregunta de seguridad de un usuario
    public String obtenerPreguntaSeguridad(String idUsuario) {
        if (preguntasSeguridad.containsKey(idUsuario)) {
            return preguntasSeguridad.get(idUsuario);
        } else {
            return "Usuario no encontrado.";
        }
    }
}