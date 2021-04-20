package modelo;

public abstract class Vehiculo {
	
	private String matricula, color, numBastidor, marca, modelo, añoFab, numSerie;
	private int numAsientos;
	private float precio;
	
	public Vehiculo (String matricula, String numBastidor, String color, int numAsientos, float precio, String marca, String modelo, String añoFab) {
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.numAsientos = numAsientos;
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
		this.añoFab = añoFab;
		this.numSerie = marca + modelo + añoFab;
	}
	
	@Override
	public String toString () {
		return "Matrícula: " + matricula + "\nNº de bastidor: " + numBastidor + "\nColor: " + color + "\nNº de asientos: "
		+ numAsientos + "\nPrecio: " + precio + "\nNº de serie: " + numSerie;
	}
	
	// GETTERS Y SETTERS
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

	public String getMatricula() {
		return matricula;
	}

	public String getColor() {
		return color;
	}

	public String getNumBastidor() {
		return numBastidor;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public float getPrecio() {
		return precio;
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

	public String getAñoFab() {
		return añoFab;
	}

	public void setAñoFab(String añoFab) {
		this.añoFab = añoFab;
	}
	
	
	
}
