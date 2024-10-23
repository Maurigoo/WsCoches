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
	
    public void addCoche(String marca, String modelo, TipoMotor tipoMotor) {
    	
        Coche coche = new Coche(marca, modelo, tipoMotor);

        coche.setId(ultimoId++);
        coches.add(coche);
        persistirFichero();
    }

	private void persistirFichero() {
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coches.dat"))) {
            out.writeObject(coches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	 public void cargarDesdeFichero() {
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("coches.dat"))) {
	            coches = (List<Coche>) in.readObject();
	            
	            
	            ultimoId = coches.size() > 0 ? coches.get(coches.size() - 1).getId() + 1 : 1;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
	    }
	 
	 
	 public List<Coche> obtenerCoches() {
	        return coches;
	    }
	 
	 
	 public Coche getCocheById(int id) {
		    for (Coche coche : coches) {
		        if (coche.getId() == id) {
		            return coche;
		        }
		    }
		    return null; 
		}

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
