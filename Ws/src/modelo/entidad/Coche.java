package modelo.entidad;

import java.io.Serializable;

public class Coche implements Serializable {
    private int id;
    private String marca;
    private String modelo;
    private TipoMotor tipoMotor;

    public Coche(String marca, String modelo, TipoMotor tipoMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
    }

   public Coche() {
	   
   }
   
   public void setId(int id) {
       this.id = id;  
   }
   
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor + "]";
	}

   
}