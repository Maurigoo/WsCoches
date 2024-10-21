package modelo.entidad;

import java.util.Objects;

public class Coche {

	int id;
	String marca;
	String modelo;
	TIPO_MOTOR motor;
	
	
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
	public TIPO_MOTOR getMotor() {
		return motor;
	}
	public void setMotor(TIPO_MOTOR motor) {
		this.motor = motor;
	}
	
	
	@Override
	public String toString() {
		
		return "Id : " + id + ", marca : " + marca + "  modelo : " + modelo + " y con motor" + motor;
	}	
}