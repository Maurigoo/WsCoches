package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.TipoMotor;

public class DaoCoches {

	private List<Coche> coches;
	private int ultimoId;

	public DaoCoches() {
		coches = new ArrayList<>();
		ultimoId = 1;
	}

	/***
	 * Este metodo se encarga de añadir un coche en el fichero, tambien asigna el id de forma automatica a los coches
	 * @param marca Marca del coche a persistir
	 * @param modelo El modelo que se va a guardar
	 * @param tipoMotor El tipo de motor a guardar
	 */
	public void addCoche(Coche coche) {

		coche.setId(ultimoId++);
		coches.add(coche);
		persistirFichero();
	}

	/***
	 * Esta función se encarga de escribir el objeto en un fichero binario
	 */
	private void persistirFichero() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coches.dat"))) {
			out.writeObject(coches);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * Leer los objetos del fichero binario
	 */
	public void cargarDesdeFichero() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("coches.dat"))) {
			coches = (List<Coche>) in.readObject(); // casting del objeto que devuelva para q sea de tipo list coches

			ultimoId = coches.size() > 0 ? coches.get(coches.size() - 1).getId() + 1 : 1;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
			coches = new ArrayList<>();
			ultimoId = 1;
		}
	
		
	}

	/***
	 * Se encarga de devolver una lista con todos los coches del fichero
	 * @return una lista con todos los coches
	 */
	public List<Coche> obtenerCoches() {
		return coches;
	}

	/***
	 * Busca en la lista de coches si se encuentra el coche, utilizando un algoritmo de busqueda por su id
	 * @param id El identificador por el que se va a buscar
	 * @return Un objeto de tipo coche si lo encuentra y null en caso contrario
	 */
	public Coche getCocheById(int id) {
		for (Coche coche : coches) {
			if (coche.getId() == id) {
				return coche;
			}
		}
		return null;
	}

	/**
	 * Se encarga de borrar un coche con el id pasado por parametro
	 * @param id El identificador con el cual se va a poder localizar el coche y así borrarlo
	 * @return Devuelve true si se ha podido borrar y false en caso contrario
	 */
	public boolean borrarCocheById(int id) {

		for (Coche coche : coches) {
			if (coche.getId() == id) {
				coches.remove(coche);
				persistirFichero();
				return true;
			}
		}
		return false;
	}
}
