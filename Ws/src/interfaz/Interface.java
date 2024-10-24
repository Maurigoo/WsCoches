package interfaz;

import java.util.List;
import java.util.Scanner;
import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;
import modelo.negocio.GestorCoche;

public class Interface {

    private GestorCoche gc;
    private Scanner scString = new Scanner(System.in); // Para leer texto
    private Scanner scInt = new Scanner(System.in); // Para leer números

    public Interface() {
        gc = new GestorCoche();
    }

    public void mostrarMenu() {
        int opcion = 0;
        String coche = "🚗";
        String feliz = "😀";
        do {
            System.out.println("Bienvenido/a a nuestra app de coches " + coche);
            System.out.println(" A continuación elija una opción: " + feliz);
            System.out.println("");
            System.out.println(" 1. Introducir coche");
            System.out.println(" 2. Obtener coche por ID");
            System.out.println(" 3. Borrar coche por ID");
            System.out.println(" 4. Listar todos los coches");
            System.out.println(" 5. Salir");
            opcion = scInt.nextInt();

            switch (opcion) {
            case 1:
                introducirCoche();
                break;
            case 2:
                obtenerCochePorId();
                break;
            case 3:
                borrarCochePorId();
                break;
            case 4:
                listarCoches();
                break;
            case 5:
                System.out.println("Saliendo del programa... Bye!");
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void introducirCoche() {
        System.out.println("Introduzca la marca del coche: ");
        String marca = scString.nextLine();

        System.out.println("Introduzca el modelo del coche: ");
        String modelo = scString.nextLine();

        TipoMotor tipoMotor = seleccionarTipoMotor();

        Coche coche = new Coche();
        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setTipoMotor(tipoMotor);

        int resultado = gc.introducirCoche(coche);
        switch (resultado) {
        case 1:
            System.out.println("La marca no es válida.");
            break;
        case 2:
            System.out.println("El modelo no es válido.");
            break;
        case 3:
            System.out.println("Coche agregado con éxito.");
            break;
        case 444:
            System.out.println("Error al agregar el coche.");
            break;
        }
    }

    private TipoMotor seleccionarTipoMotor() {
        TipoMotor tipoMotor = null;
        boolean valido = false;

        do {
            System.out.println("Seleccione el tipo de motor:");
            System.out.println("1. Gasolina");
            System.out.println("2. Diesel");
            System.out.println("3. Hidrógeno");
            System.out.print("Elija una opción: ");
            int opcion = scInt.nextInt();

            switch (opcion) {
            case 1:
                tipoMotor = TipoMotor.GASOLINA;
                valido = true;
                break;
            case 2:
                tipoMotor = TipoMotor.DIESEL;
                valido = true;
                break;
            case 3:
                tipoMotor = TipoMotor.HIDROGENO;
                valido = true;
                break;
            default:
                System.out.println("Opción no válida, seleccione nuevamente.");
            }
        } while (!valido);

        return tipoMotor;
    }

    private void obtenerCochePorId() {
        System.out.println("Introduzca el ID del coche: ");
        int id = scInt.nextInt();

        Coche coche = gc.obtenerCochePorId(id); // Pasar el ID
        if (coche != null) {
            System.out.println("Datos del coche: " + coche);
        } else {
            System.out.println("No se encontró ningún coche con ese ID.");
        }
    }

    private void borrarCochePorId() {
        System.out.println("Introduzca el ID del coche a borrar: ");
        int id = scInt.nextInt();

        boolean resultado = gc.borrarCochePorId(id); // Pasar el ID
        if (resultado) {
            System.out.println("Coche borrado con éxito.");
        } else {
            System.out.println("No se encontró ningún coche con ese ID.");
        }
    }

    private void listarCoches() {
        System.out.println("Lista de todos los coches:");
        List<Coche> coches = gc.listarCoches(); // Llamar al método corregido
        if (coches != null && !coches.isEmpty()) {
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        } else {
            System.out.println("No hay coches registrados.");
        }
    }
}
