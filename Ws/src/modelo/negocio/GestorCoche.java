package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoches;

public class GestorCoche {
	
	private DaoCoches dcf;
	
	/**
	 * Metodo que verifica si la marca o modelo pasado por parametro
	 * esta vacio o es null
	 * @param marca marca a evaluar
	 * @param modelo modelo a evaluar
	 * @return <b>1<b> si la marca esta vacia, solo con espacios en
	 * blanco o null <b>2<b> si el modelo esta vacio, solo con espacios
	 * <b>3<b> agrega el coche al fichero <b>444<b> si ocurre alguna excepción
	 * 
	 */
	public int introducirCoche(Coche c) {
		dcf = new DaoCoches();
		try {
			Coche coche = dcf.getCocheById(c.getId());
			if(c.getMarca() == null || c.getMarca().isBlank()) {
				return 1;	
			}
			if(c.getModelo() == null || c.getModelo().isBlank()) {
				return 2;
			}
			dcf.addCoche(c);
			return 3;
			
		} catch (Exception e) {
			return 444;
		}
		
	}
	
	/**
	 * Metodo que no permite que el id sea menor que 0
	 * @param id id a evaluar
	 * @return false en caso que sea menor que 0, true en
	 * caso contrario
	 */
	public boolean borrarCochePorId(Coche c) {
		dcf = new DaoCoches();
		if(c.getId() < 0) {
			return false;
		}
		dcf.borrarCocheById(c.getId());
		return true;
		
	}
	
	/**
	 * Metodo que lista todos los Coches desde la persistencia (fichero)
	 * @return lista de coches, o <b>null<b> si hay problema con la persistencia
	 */
	public List<Coche> listarCoche() {
		try {
			return dcf.obtenerCoches();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * Metodo que muestra un coche a partir del id
	 * @param c Coche pasado por parametro
	 * @return el Coche, o <b>null<b> si hay problema con la persistencia
	 */
	public Coche obtenerCochePorId(Coche c) {
		try {
			return dcf.getCocheById(c.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
