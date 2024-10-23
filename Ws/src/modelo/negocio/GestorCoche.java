package modelo.negocio;

import java.util.List;
import modelo.entidad.Coche;
import modelo.persistencia.DaoCoches;

public class GestorCoche {

    private DaoCoches dcf;

    public GestorCoche() {
        dcf = new DaoCoches(); // Instanciar DaoCoches una vez
    }

    /**
     * Metodo que verifica si la marca o modelo pasado por parametro
     * está vacío o es null
     * @param c Coche a evaluar
     * @return 1 si la marca es inválida, 2 si el modelo es inválido, 3 si se
     *         agrega el coche al fichero, 444 si ocurre una excepción
     */
    public int introducirCoche(Coche c) {
        if (c.getMarca() == null || c.getMarca().isBlank()) {
            return 1; // Marca no válida
        }
        if (c.getModelo() == null || c.getModelo().isBlank()) {
            return 2; // Modelo no válido
        }
        try {
            dcf.addCoche(c); // Agregar coche
            return 3; // Coche agregado con éxito
        } catch (Exception e) {
            return 444; // Error general
        }
    }

    /**
     * Metodo que no permite que el id sea menor que 0
     * @param id id a evaluar
     * @return false en caso que sea menor que 0, true en
     *         caso contrario
     */
    public boolean borrarCochePorId(int id) {
        if (id < 0) {
            return false; // ID inválido
        }
        return dcf.borrarCocheById(id); // Borrar coche por ID
    }

    /**
     * Metodo que lista todos los Coches desde la persistencia (fichero)
     * @return lista de coches, o null si hay problema con la persistencia
     */
    public List<Coche> listarCoches() {
        try {
            return dcf.obtenerCoches(); // Listar todos los coches
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo que muestra un coche a partir del id
     * @param id id del coche
     * @return el Coche, o null si hay problema con la persistencia
     */
    public Coche obtenerCochePorId(int id) {
        try {
            return dcf.getCocheById(id); // Obtener coche por ID
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
