package modelo;

public abstract class Vehiculo {
	
	private String matricula, color, numBastidor, marca, modelo, a�oFab, numSerie;
	private int numAsientos;
	private float precio;
	
	public Vehiculo (String matricula, String numBastidor, String color, int numAsientos, float precio, String marca, String modelo, String a�oFab) {
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.numAsientos = numAsientos;
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
		this.a�oFab = a�oFab;
		this.numSerie = marca + modelo + a�oFab;
	}
	
	@Override
	public String toString () {
		return "Matr�cula: " + matricula + "\nN� de bastidor: " + numBastidor + "\nColor: " + color + "\nN� de asientos: "
		+ numAsientos + "\nPrecio: " + precio + "\nN� de serie: " + numSerie;
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

	public String getA�oFab() {
		return a�oFab;
	}

	public void setA�oFab(String a�oFab) {
		this.a�oFab = a�oFab;
	}
	
	
	
}
