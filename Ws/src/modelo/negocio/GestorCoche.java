package modelo.negocio;

public class GestorCoche {
	
	/**
	 * Metodo que verifica si la marca o modelo pasado por parametro
	 * esta vacio o es null
	 * @param marca marca a evaluar
	 * @param modelo modelo a evaluar
	 * @return <b>1<b> si la marca esta vacia, solo con espacios en
	 * blanco o null <b>2<b> si el modelo esta vacio, solo con espacios
	 * 
	 */
	public int estaVacio(String marca, String modelo) {
		if(marca == null || marca.isBlank()) {
			return 1;	
		}
		if(modelo == null || modelo.isBlank()) {
			return 2;
		}
		return 3;
	}
	
	/**
	 * Metodo que no permite que el id sea menor que 0
	 * @param id id a evaluar
	 * @return false en caso que sea menor que 0, true en
	 * caso contrario
	 */
	public boolean esNegativo(int id) {
		if(id < 0) {
			return false;	
		}
		return true;
		
	}

}
