package co.edu.uniquindio.poo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    private static SistemaAutenticacion sistemaAutenticacion;
    private static List<Empleado> empleados;
    private static List<Cliente> clientes;
    private static List<Vehiculo> vehiculos;
    private static Administrador administrador;
    private static Empleado empleadoActual;
    private static List<Transaccion> transacciones = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializar sistema de autenticación y empleados
        sistemaAutenticacion = new SistemaAutenticacion();
        empleados = new ArrayList<>();
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
    
        // Crear un administrador para la prueba
        administrador = new Administrador("lol", "admin", "@", "213", false);
        
        // Agregar el administrador a la lista de empleados
        empleados.add(administrador);
    
        // Crear algunos empleados y registrarlos
        Empleado empleado1 = new Empleado("Empleado 1", "E1", "empleado1@empresa.com", "312345678", true);
        Empleado empleado2 = new Empleado("Empleado 2", "E2", "empleado2@empresa.com", "323456789", true);
        
        // Registrar empleados en el sistema de autenticación
        sistemaAutenticacion.registrarUsuario(empleado1.getId(), "contrasena123", "¿Nombre de tu primera mascota?", "Firulais");
        sistemaAutenticacion.registrarUsuario(empleado2.getId(), "contrasena456", "¿Ciudad de nacimiento?", "Medellin");
    
        // Asegúrate de añadir los empleados a la lista de empleados
        empleados.add(empleado1);
        empleados.add(empleado2);
    
        // Crear clientes
        Cliente cliente1 = new Cliente("Carlos", "C001", "carlos@cliente.com", "Cra 1 #1-1", "312345678");
        Cliente cliente2 = new Cliente("Ana", "C002", "ana@cliente.com", "Cra 2 #2-2", "312345679");
        clientes.add(cliente1);
        clientes.add(cliente2);
    
        if (autenticarUsuario()) {
            mostrarMenu(new Scanner(System.in)); // Pasar scanner al método mostrarMenu
        } else {
            System.out.println("Autenticación fallida. Fin del programa.");
        }
    }

    public static boolean autenticarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        // Llamamos al método autenticar de SistemaAutenticacion
        if (sistemaAutenticacion.autenticar(idUsuario, contrasena)) {
            System.out.println("Autenticación exitosa.");

            // Establecer el empleadoActual después de la autenticación
            empleadoActual = encontrarEmpleado(idUsuario); // Aquí buscamos el empleado por su ID
            if (empleadoActual == null) {
                System.out.println("Error: No se encontró el empleado con ID: " + idUsuario);
                return false;
            }

            return true; // Autenticación exitosa
        } else {
            System.out.println("Autenticación fallida.");
            return false; // Autenticación fallida
        }
    }

    private static Empleado encontrarEmpleado(String usuario) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(usuario)) { // Buscar por ID
                return empleado;
            }
        }
        return null;
    }

    // Ejemplo de la función que verifica el tipo de empleado
    private static void mostrarMenu(Scanner scanner) {
        if (empleadoActual != null) {
            boolean continuar = true;
            while (continuar) {
                if (empleadoActual.esAdministrador()) {
                    mostrarMenuAdministrador(scanner); // Menú de administrador
                } else if (empleadoActual.esEmpleado()) {
                    mostrarMenuEmpleado(scanner); // Menú de empleado
                } else {
                    System.out.println("Error: Tipo de usuario no reconocido.");
                    continuar = false;
                }
            }
        } else {
            System.out.println("Error: Usuario no autenticado.");
        }
    }

    // Menú para administrador
    private static void mostrarMenuAdministrador(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Ver transacciones");
            System.out.println("4. Gestionar empleados");
            System.out.println("5. Recuperar Contraseña");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
    
            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner);
                    break;
                case 2:
                    registrarCliente(scanner);
                    break;
                case 3:
                    verTransacciones();
                    break;
                case 4:
                    gestionarEmpleados(scanner);
                    break;
                case 5:
                    recuperarContrasena(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    private static void recuperarContrasena(Scanner scanner) {
        System.out.print("Ingrese su ID de usuario: ");
        String idUsuario = scanner.nextLine();
    
        // Obtener la pregunta de seguridad
        String preguntaSeguridad = sistemaAutenticacion.obtenerPreguntaSeguridad(idUsuario);
        if (preguntaSeguridad.equals("Usuario no encontrado.")) {
            System.out.println("No se encontró un usuario con ese ID.");
            return;
        }
    
        System.out.println("Pregunta de seguridad: " + preguntaSeguridad);
        System.out.print("Ingrese la respuesta: ");
        String respuesta = scanner.nextLine();
    
        // Recuperar la contraseña
        String contrasenaRecuperada = sistemaAutenticacion.recuperarContrasena(idUsuario, respuesta);
        if (contrasenaRecuperada.equals("Respuesta incorrecta.")) {
            System.out.println("Respuesta incorrecta.");
        } else if (contrasenaRecuperada.equals("Usuario no encontrado.")) {
            System.out.println("No se encontró un usuario con ese ID.");
        } else {
            System.out.println("La contraseña recuperada es: " + contrasenaRecuperada);
        }
    }

    private static void gestionarEmpleados(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Gestionar Empleados ---");
            System.out.println("1. Ver empleados");
            System.out.println("2. Registrar nuevo empleado"); // Nueva opción
            System.out.println("3. Modificar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Activar/Desactivar empleado");
            System.out.println("6. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    verEmpleados();
                    break;
                case 2:
                    registrarNuevoEmpleado(scanner); // Método para registrar nuevo empleado
                    break;
                case 3:
                    modificarEmpleado(scanner);
                    break;
                case 4:
                    eliminarEmpleado(scanner);
                    break;
                case 5:
                    activarDesactivarEmpleado(scanner);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarNuevoEmpleado(Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del empleado: ");
        String id = scanner.nextLine();

        // Validar que el ID no esté duplicado
        if (encontrarEmpleado(id) != null) {
            System.out.println("Error: Ya existe un empleado con este ID.");
            return;
        }

        System.out.print("Ingrese el correo del empleado: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el teléfono del empleado: ");
        String telefono = scanner.nextLine();
        System.out.print("¿Está activo el empleado? (true/false): ");
        boolean activo = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer

        // Crear un nuevo empleado y agregarlo a la lista
        Empleado nuevoEmpleado = new Empleado(nombre, id, correo, telefono, activo);
        empleados.add(nuevoEmpleado);
        administrador.registrarEmpleado(nombre, id, correo, telefono, activo); // También registra en el administrador
        System.out.println("Empleado registrado exitosamente.");
    }

    private static void mostrarMenuEmpleado(Scanner scanner) {
        boolean continuar = true;

        // Verificar si el empleado está activo
        Empleado empleado = (Empleado) empleadoActual; // Hacemos el casting a Empleado
        if (!empleado.isActivo()) {
            System.out.println("El empleado está inactivo y no puede realizar ninguna acción.");
            return; // Salir si el empleado está inactivo
        }

        while (continuar) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Alquilar vehículo");
            System.out.println("4. Vender vehículo");
            System.out.println("5. Comprar vehículo");
            System.out.println("6. Ver transacciones");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner);
                    break;
                case 2:
                    registrarCliente(scanner);
                    break;
                case 3:
                    alquilarVehiculo();
                    break;
                case 4:
                    venderVehiculo();
                    break;
                case 5:
                    comprarVehiculo();
                    break;
                case 6:
                    verTransacciones();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarVehiculo(Scanner scanner) {
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Moto");
        System.out.println("4. Bus");
        System.out.println("5. Camion");
        System.out.println("6. Deportivo");
        System.out.println("7. PickUp");
        System.out.println("8. Van");
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el año del vehículo: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Crear el vehículo según la opción seleccionada
        Vehiculo vehiculo = null;
        switch (opcion) {
            case 1:
                vehiculo = crearSedan(scanner, marca, modelo, anio);
                break;
            case 2:
                vehiculo = crearSUV(scanner, marca, modelo, anio);
                break;
            case 3:
                vehiculo = crearMoto(scanner, marca, modelo, anio);
                break;
            case 4:
                vehiculo = crearBus(scanner, marca, modelo, anio);
                break;
            case 5:
                vehiculo = crearCamion(scanner, marca, modelo, anio);
                break;
            case 6:
                vehiculo = crearDeportivo(scanner, marca, modelo, anio);
                break;
            case 7:
                vehiculo = crearPickUp(scanner, marca, modelo, anio);
                break;
            case 8:
                vehiculo = crearVan(scanner, marca, modelo, anio);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (vehiculo != null) {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo registrado con éxito: ");
            System.out.println(vehiculo);
        } else {
            System.out.println("No se pudo registrar el vehículo.");
        }
    }

    private static Sedan crearSedan(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar la condición del vehículo
        System.out.print("¿El Sedan es nuevo o usado? (nuevo/usado): ");
        CondicionVehiculo condicion = scanner.nextLine().equalsIgnoreCase("nuevo")
                ? CondicionVehiculo.NUEVO
                : CondicionVehiculo.USADO;
    
        // Solicitar el precio del vehículo
        System.out.print("Ingrese el precio del Sedan: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar datos específicos del Sedan
        System.out.print("Ingrese el número de pasajeros: ");
        int numeroPasajeros = scanner.nextInt();
        System.out.print("Ingrese el número de puertas: ");
        int numeroPuertas = scanner.nextInt();
        System.out.print("Ingrese la capacidad del maletero: ");
        int capacidadMaletero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Preguntar por las características opcionales y convertir a enum
        System.out.print("¿El Sedan tiene aire acondicionado? (sí/no): ");
        Caracteristica aireAcondicionado = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene cámara de reversa? (sí/no): ");
        Caracteristica camaraReversa = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene velocidad crucero? (sí/no): ");
        Caracteristica velocidadCrucero = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene ABS? (sí/no): ");
        Caracteristica abs = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene sensores de colisión? (sí/no): ");
        Caracteristica sensoresColision = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene sensor de tráfico cruzado? (sí/no): ");
        Caracteristica sensorTraficoCruzado = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El Sedan tiene asistente de permanencia en carril? (sí/no): ");
        Caracteristica asistenteCarril = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        // Características adicionales
        int numeroBolsasAire = 2; // Número predeterminado, puedes cambiar esto si es necesario
    
        // Selección de transmisión y combustible (puedes ajustar estos valores según
        // las necesidades)
        TipoTransmision transmision = TipoTransmision.MANUAL; // Valor predeterminado
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
    
        // Crear el objeto Sedan con todos los datos
        return new Sedan(marca, modelo, condicion, transmision, combustible, null, numeroPasajeros, numeroPuertas,
                capacidadMaletero, aireAcondicionado, camaraReversa, velocidadCrucero, numeroBolsasAire, abs,
                sensoresColision, sensorTraficoCruzado, asistenteCarril, precio);
    }

    private static Suv crearSUV(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar la condición del vehículo
        System.out.print("¿El SUV es nuevo o usado? (nuevo/usado): ");
        CondicionVehiculo condicion = scanner.nextLine().equalsIgnoreCase("nuevo")
                ? CondicionVehiculo.NUEVO
                : CondicionVehiculo.USADO;
    
        // Solicitar el precio del vehículo
        System.out.print("Ingrese el precio del SUV: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar datos específicos del SUV
        System.out.print("Ingrese el número de pasajeros: ");
        int numeroPasajeros = scanner.nextInt();
        System.out.print("Ingrese el número de puertas: ");
        int numeroPuertas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para los valores introducidos
        if (numeroPasajeros <= 0 || numeroPuertas <= 0) {
            System.out.println("Los valores deben ser mayores a 0.");
            return null;
        }
    
        // Preguntar por las características opcionales y convertir a enum
        System.out.print("¿El SUV tiene tracción en las cuatro ruedas? (sí/no): ");
        Caracteristica traccion4x4 = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El SUV tiene control de descenso? (sí/no): ");
        Caracteristica controlDescenso = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El SUV tiene asistente de estacionamiento? (sí/no): ");
        Caracteristica asistenteEstacionamiento = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El SUV tiene ABS? (sí/no): ");
        Caracteristica abs = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El SUV tiene sensores de colisión? (sí/no): ");
        Caracteristica sensoresColision = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        // Características adicionales predeterminadas o personalizables
        TipoTransmision transmision = TipoTransmision.AUTOMATICA; // Valor predeterminado
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
    
        // Crear el objeto Suv con todos los datos
        return new Suv(marca, modelo, condicion, transmision, combustible, null, numeroPasajeros, numeroPuertas,
                0, null, null, null, 0, abs, sensoresColision, traccion4x4, controlDescenso, asistenteEstacionamiento, precio);
    }

    private static Moto crearMoto(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar la condición del vehículo
        System.out.print("¿La moto es nueva o usada? (nuevo/usado): ");
        CondicionVehiculo condicion = scanner.nextLine().equalsIgnoreCase("nuevo")
                ? CondicionVehiculo.NUEVO
                : CondicionVehiculo.USADO;
    
        // Solicitar el precio de la motocicleta
        System.out.print("Ingrese el precio de la moto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar el tipo de transmisión
        System.out.print("¿La motocicleta tiene transmisión manual? (sí/no): ");
        TipoTransmision transmision = scanner.nextLine().equalsIgnoreCase("sí")
                ? TipoTransmision.MANUAL
                : TipoTransmision.AUTOMATICA;
    
        // Solicitar datos específicos de la motocicleta
        System.out.print("Ingrese el número de cilindrada (cc): ");
        int cilindrada = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Preguntar si tiene frenos ABS
        System.out.print("¿La motocicleta tiene frenos ABS? (sí/no): ");
        Caracteristica tieneABS = scanner.nextLine().equalsIgnoreCase("sí")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        // Preguntar si es deportiva
        System.out.print("¿Es deportiva? (sí/no): ");
        boolean esDeportiva = scanner.nextLine().equalsIgnoreCase("sí");
    
        // Validación de datos introducidos
        if (cilindrada <= 0) {
            System.out.println("La cilindrada debe ser mayor a 0.");
            return null;
        }
    
        // Solicitar velocidad máxima
        System.out.print("Ingrese la velocidad máxima (km/h): ");
        int velocidadMaxima = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar número de cambios
        System.out.print("Ingrese el número de cambios: ");
        int numeroDeCambios = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Asignar valores predeterminados para los atributos restantes
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
    
        // Crear el objeto Moto con todos los datos
        return new Moto(marca, modelo, condicion, transmision, combustible, tieneABS, cilindrada, velocidadMaxima, numeroDeCambios, esDeportiva, precio);
    }

    private static Bus crearBus(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar el precio del bus
        System.out.print("Ingrese el precio del bus: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar datos específicos del Bus
        System.out.print("Cilindraje: ");
        int cilindraje = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Velocidad máxima (km/h): ");
        int velocidadMaxima = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Número de pasajeros: ");
        int numeroDePasajeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Número de puertas: ");
        int numeroDePuertas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Capacidad del maletero (kg): ");
        int capacidadMaletero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("¿Tiene aire acondicionado? (sí/no): ");
        boolean aireAcondicionado = scanner.nextLine().equalsIgnoreCase("sí");
    
        System.out.print("¿Tiene cámara de reversa? (sí/no): ");
        boolean camaraReversa = scanner.nextLine().equalsIgnoreCase("sí");
    
        System.out.print("Número de ejes: ");
        int numeroDeEjes = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Número de salidas de emergencia: ");
        int numeroSalidasEmergencia = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar CondicionVehiculo
        System.out.print("Condición del vehículo (nuevo/usado): ");
        String condicionInput = scanner.nextLine().toUpperCase();
        CondicionVehiculo condicion;
        try {
            condicion = CondicionVehiculo.valueOf(condicionInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Condición no válida. Se establecerá como USADO.");
            condicion = CondicionVehiculo.USADO; // Valor predeterminado en caso de error
        }
    
        // Solicitar TipoTransmision
        System.out.print("Tipo de transmisión (automática/manual): ");
        String transmisionInput = scanner.nextLine().toUpperCase();
        TipoTransmision transmision;
        try {
            transmision = TipoTransmision.valueOf(transmisionInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Transmisión no válida. Se establecerá como AUTOMATICA.");
            transmision = TipoTransmision.AUTOMATICA; // Valor predeterminado en caso de error
        }
    
        // Solicitar TipoCombustible
        System.out.print("Tipo de combustible (diesel/gasolina): ");
        String combustibleInput = scanner.nextLine().toUpperCase();
        TipoCombustible combustible;
        try {
            combustible = TipoCombustible.valueOf(combustibleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Combustible no válido. Se establecerá como DIESEL.");
            combustible = TipoCombustible.DIESEL; // Valor predeterminado en caso de error
        }
    
        // Validación para los valores introducidos
        if (cilindraje <= 0 || velocidadMaxima <= 0 || numeroDePasajeros <= 0 || numeroDePuertas <= 0
                || capacidadMaletero < 0 || numeroDeEjes <= 0 || numeroSalidasEmergencia <= 0) {
            System.out.println(
                    "Todos los valores deben ser mayores a 0, excepto capacidad del maletero que debe ser mayor o igual a 0.");
            return null;
        }
    
        // Crear el objeto Bus con todos los datos
        return new Bus(marca, modelo, condicion, transmision, combustible, null, cilindraje,
                velocidadMaxima, numeroDePasajeros, numeroDePuertas, capacidadMaletero, aireAcondicionado,
                camaraReversa, numeroDeEjes, numeroSalidasEmergencia, precio);
    }

    private static Camion crearCamion(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar el precio del camión
        System.out.print("Ingrese el precio del camión: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Preguntar por los detalles del camión
        System.out.print("Ingrese el cilindraje del camión: ");
        int cilindraje = scanner.nextInt();
        System.out.print("Ingrese la velocidad máxima del camión (km/h): ");
        int velocidadMaxima = scanner.nextInt();
        System.out.print("Ingrese la capacidad de carga del camión (kg): ");
        int capacidadCarga = scanner.nextInt();
        System.out.print("Ingrese el número de ejes del camión: ");
        int numeroDeEjes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el tipo de camión (caja cerrada, plataforma, etc.): ");
        String tipoCamion = scanner.nextLine();
        System.out.print("¿El camión tiene aire acondicionado? (sí/no): ");
        boolean aireAcondicionado = scanner.nextLine().equalsIgnoreCase("sí");
        System.out.print("¿El camión tiene frenos de aire? (sí/no): ");
        boolean frenosDeAire = scanner.nextLine().equalsIgnoreCase("sí");
    
        // Selección de condición
        System.out.print("Ingrese la condición del camión (NUEVO/USADO): ");
        String condicionInput = scanner.nextLine().toUpperCase();
        CondicionVehiculo condicion = null;
        try {
            condicion = CondicionVehiculo.valueOf(condicionInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Condición no válida, asignando por defecto 'USADO'.");
            condicion = CondicionVehiculo.USADO; // Asignar valor por defecto si la entrada es inválida
        }
    
        // Selección de transmisión
        System.out.print("Ingrese el tipo de transmisión (MANUAL/AUTOMATICA): ");
        String transmisionInput = scanner.nextLine().toUpperCase();
        TipoTransmision transmision = null;
        try {
            transmision = TipoTransmision.valueOf(transmisionInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Transmisión no válida, asignando por defecto 'MANUAL'.");
            transmision = TipoTransmision.MANUAL; // Asignar valor por defecto si la entrada es inválida
        }
    
        // Crear el camión
        Camion camion = new Camion(marca, modelo, condicion, transmision, null, null, cilindraje, velocidadMaxima,
                capacidadCarga, numeroDeEjes, tipoCamion, aireAcondicionado, frenosDeAire, precio);
    
        // Agregar el camión a la lista de vehículos
        vehiculos.add(camion);
    
        System.out.println("Camión registrado con éxito: ");
        System.out.println(camion);
    
        return camion;
    }

    private static Deportivo crearDeportivo(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar el precio del deportivo
        System.out.print("Ingrese el precio del deportivo: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar la velocidad máxima del deportivo
        System.out.print("Velocidad máxima (km/h): ");
        double velocidadMaxima = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para los valores introducidos
        if (velocidadMaxima <= 0) {
            System.out.println("La velocidad máxima debe ser mayor a 0.");
            return null;
        }
    
        // Asignar valores predeterminados para los atributos restantes
        CondicionVehiculo condicion = CondicionVehiculo.USADO; // Valor predeterminado
        TipoTransmision transmision = TipoTransmision.AUTOMATICA; // Valor predeterminado
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
    
        // Crear el objeto Deportivo con todos los datos
        return new Deportivo(marca, modelo, condicion, transmision, combustible,
                null, anio, anio, anio, anio, velocidadMaxima, precio);
    }

    private static PickUp crearPickUp(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar el precio del PickUp
        System.out.print("Ingrese el precio del PickUp: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar datos específicos del PickUp
        System.out.print("Número de pasajeros: ");
        int numeroPasajeros = scanner.nextInt();
        System.out.print("Número de puertas: ");
        int numeroPuertas = scanner.nextInt();
        System.out.print("Capacidad de la caja de carga (en litros): ");
        int capacidadCajaCarga = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para los valores introducidos
        if (numeroPasajeros <= 0 || numeroPuertas <= 0 || capacidadCajaCarga <= 0) {
            System.out.println("Los valores deben ser mayores a 0.");
            return null;
        }
    
        // Preguntar por las características opcionales y convertir a enum
        System.out.print("¿El PickUp tiene aire acondicionado? (si/no): ");
        Caracteristica aireAcondicionado = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El PickUp tiene cámara de reversa? (sí/no): ");
        Caracteristica camaraReversa = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El PickUp tiene ABS? (sí/no): ");
        Caracteristica abs = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿El PickUp es 4x4? (sí/no): ");
        Caracteristica es4x4 = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        // Características adicionales
        int numeroBolsasAire = 2; // Número predeterminado, puedes cambiar esto si es necesario
    
        // Asignar valores predeterminados para los atributos restantes
        CondicionVehiculo condicion = CondicionVehiculo.USADO; // Valor predeterminado
        TipoTransmision transmision = TipoTransmision.MANUAL; // Valor predeterminado
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
    
        // Crear el objeto PickUp con todos los datos
        return new PickUp(marca, modelo, condicion, transmision, combustible, null, numeroPasajeros, numeroPuertas,
                aireAcondicionado, camaraReversa, numeroBolsasAire, abs, es4x4, capacidadCajaCarga, precio);
    }

    private static Van crearVan(Scanner scanner, String marca, String modelo, int anio) {
        // Solicitar el precio de la Van
        System.out.print("Ingrese el precio de la Van: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
    
        // Solicitar el número de asientos
        System.out.print("Número de asientos: ");
        int numeroAsientos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para los valores introducidos
        if (numeroAsientos <= 0) {
            System.out.println("El número de asientos debe ser mayor a 0.");
            return null;
        }
    
        // Solicitar el número de puertas
        System.out.print("Número de puertas: ");
        int numeroPuertas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para el número de puertas
        if (numeroPuertas <= 0) {
            System.out.println("El número de puertas debe ser mayor a 0.");
            return null;
        }
    
        // Solicitar la capacidad del maletero
        System.out.print("Capacidad del maletero (en litros): ");
        int capacidadMaletero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        // Validación para la capacidad del maletero
        if (capacidadMaletero <= 0) {
            System.out.println("La capacidad del maletero debe ser mayor a 0.");
            return null;
        }
    
        // Solicitar características opcionales
        System.out.print("¿La Van tiene aire acondicionado? (si/no): ");
        Caracteristica aireAcondicionado = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿La Van tiene cámara de reversa? (si/no): ");
        Caracteristica camaraReversa = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        System.out.print("¿La Van tiene ABS? (si/no): ");
        Caracteristica abs = scanner.nextLine().equalsIgnoreCase("si")
                ? Caracteristica.DISPONIBLE
                : Caracteristica.NO_DISPONIBLE;
    
        // Asignar valores predeterminados para los atributos restantes
        CondicionVehiculo condicion = CondicionVehiculo.USADO; // Valor predeterminado
        TipoTransmision transmision = TipoTransmision.MANUAL; // Valor predeterminado
        TipoCombustible combustible = TipoCombustible.GASOLINA; // Valor predeterminado
        int numeroBolsasAire = 2; // Número predeterminado de bolsas de aire
    
        // Crear el objeto Van con todos los datos
        return new Van(marca, modelo, condicion, transmision, combustible, null, numeroAsientos, numeroPuertas, 
                capacidadMaletero, aireAcondicionado, camaraReversa, numeroBolsasAire, abs, precio);
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del cliente: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, id, correo, direccion, telefono);
        clientes.add(cliente); // Agregar cliente a la lista
        System.out.println("Cliente registrado: " + cliente);
    }

    private static void alquilarVehiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo a alquilar: ");
        String marcaVehiculo = scanner.nextLine();
        System.out.print("Ingrese la fecha del alquiler (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
    
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fechaStr);
            Cliente cliente = buscarClientePorId(idCliente);
            Vehiculo vehiculo = buscarVehiculoPorMarca(marcaVehiculo);
    
            if (vehiculo == null) {
                System.out.println("El vehículo con la marca '" + marcaVehiculo + "' no existe o no está registrado.");
                return; // Salimos si no encontramos el vehículo
            }
    
            if (cliente != null) {
                // Obtener el precio del vehículo
                double precioVehiculo = vehiculo.getPrecio(); // Asegúrate de que este método exista
                double montoAlquiler = calcularMontoAlquiler(precioVehiculo); // Método para calcular el monto
    
                Transaccion transaccion = new Transaccion(empleadoActual, vehiculo, cliente, TipoTransaccion.ALQUILER,
                        fecha, montoAlquiler); // Asegúrate de que Transaccion acepte el monto
                transacciones.add(transaccion);
                System.out.println("Alquiler registrado: " + transaccion);
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
    
    // Método para calcular el monto de alquiler
    private static double calcularMontoAlquiler(double precioVehiculo) {
        // Puedes definir tu lógica aquí. Por ejemplo, un 10% del precio por día.
        double porcentajeAlquiler = 0.10; // 10%
        return precioVehiculo * porcentajeAlquiler; // Monto de alquiler
    }

    private static Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) { // Lista de clientes
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    private static Vehiculo buscarVehiculoPorMarca(String marca) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo != null && vehiculo.getMarca() != null && vehiculo.getMarca().equalsIgnoreCase(marca)) {
                return vehiculo;
            }
        }
        return null; // Si no encuentra el vehículo, devuelve null
    }

    private static void venderVehiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo a vender: ");
        String marcaVehiculo = scanner.nextLine();
    
        Cliente cliente = buscarClientePorId(idCliente);
        Vehiculo vehiculo = buscarVehiculoPorMarca(marcaVehiculo);
    
        if (cliente != null && vehiculo != null) {
            double monto = vehiculo.getPrecio(); // Obtener el precio del vehículo
            Transaccion transaccion = new Transaccion(empleadoActual, vehiculo, cliente, TipoTransaccion.VENTA,
                    new Date(), monto); // Pasar el monto a la transacción
            transacciones.add(transaccion);
            System.out.println("Venta registrada: " + transaccion);
        } else {
            System.out.println("Cliente o vehículo no encontrados.");
        }
    }

    private static void comprarVehiculo() {
        
    }

    private static void verTransacciones() {
        if (transacciones == null || transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("\n--- Transacciones Registradas ---");
            for (Transaccion transaccion : transacciones) {
                System.out.println(transaccion);
            }
        }
    }

    private static Empleado encontrarEmpleadoPorId(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null; // Retorna null si no se encuentra el empleado
    }

    private static void verEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    private static void modificarEmpleado(Scanner scanner) {
        System.out.print("Ingrese el ID del empleado a modificar: ");
        String id = scanner.nextLine();
        Empleado empleado = encontrarEmpleadoPorId(id);

        if (empleado != null) {
            System.out.print("Ingrese el nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo correo: ");
            String correo = scanner.nextLine();
            System.out.print("Ingrese el nuevo teléfono: ");
            String telefono = scanner.nextLine();

            // Modificar la información
            empleado.setNombre(nombre);
            empleado.setCorreo(correo);
            empleado.setTelefono(telefono);

            System.out.println("Empleado modificado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado(Scanner scanner) {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        String id = scanner.nextLine();
        Empleado empleado = encontrarEmpleadoPorId(id);

        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado eliminado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void activarDesactivarEmpleado(Scanner scanner) {
        System.out.print("Ingrese el ID del empleado a activar/desactivar: ");
        String id = scanner.nextLine();
        Empleado empleado = encontrarEmpleadoPorId(id);

        if (empleado != null) {
            empleado.setActivo(!empleado.isActivo()); // Cambiar el estado de activo a inactivo o viceversa
            System.out.println("Empleado actualizado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

}