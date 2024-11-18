package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


class MainTest {
       
    
@Test
    public void testAutenticacionExitosa() {
        SistemaAutenticacion sistema = new SistemaAutenticacion();
        sistema.registrarUsuario("E001", "password123","¿Cuál es el nombre de tu primera mascota?","firulais");
        
        assertTrue(sistema.autenticar("E001", "password123"));
    }

@Test
    public void testAutenticacionFallida() {
        SistemaAutenticacion sistema = new SistemaAutenticacion();
        sistema.registrarUsuario("E001", "password123","¿Cuál es el nombre de tu primera mascota?","firulais");
        
        assertFalse(sistema.autenticar("E001", "wrongpassword"));
    }
}
