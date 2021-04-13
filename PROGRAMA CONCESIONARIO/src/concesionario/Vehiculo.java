package concesionario;

public abstract class Vehiculo {
	
	private String matricula, color, numBastidor, numSerie;
	private int numAsientos;
	private float precio;
	
	public Vehiculo (String matricula, String numBastidor, String color, int numAsientos, float precio, String numSerie) {
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.numAsientos = numAsientos;
		this.precio = precio;
		this.numSerie = numSerie;
	}
	
	@Override
	public String toString () {
		return "Matrícula: " + matricula + "\nNº de bastidor: " + numBastidor + "\nColor: " + color + "\nNº de asientos: "
		+ numAsientos + "\nPrecio: " + precio + "\nNº de serie: " + numSerie;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setNumBastidor(String numBastidor) {
		this.numBastidor = numBastidor;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
