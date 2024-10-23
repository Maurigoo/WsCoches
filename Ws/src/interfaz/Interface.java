package interfaz;


import java.util.Scanner;
import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Interface {
	
	    private GestorCoche gc = null;
	    private Scanner scString = new Scanner(System.in); // Para leer texto
	    private Scanner scInt = new Scanner(System.in);    // Para leer números
	    
	    public void mostrarInterface() {
	    	System.out.println("Bienvenido/a a nuestra app de coches");
	    	gc = new GestorCoche();
	    	int respuesta = 0;
	    	
	    }

}
