package concesionario;

public class Coche extends Vehiculo {
	
	private int numPuertas, capacidadMaletero;
	
	public Coche (String matricula, String numBastidor, String color, int numAsientos, float precio, String marca, String modelo, String fechaFab, int numPuertas, int capacidadMaletero) {
		super(matricula, numBastidor, color, numAsientos, precio, marca, modelo, fechaFab);
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
	}
	
	@Override
	public String toString () {
		System.out.println(super.toString());
		return "N� de puertas: " + numPuertas + "\nCapacidad del maletero: " + capacidadMaletero + "\n";
	}
	
	// GETTERS Y SETTERS
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public int getCapacidadMaletero() {
		return capacidadMaletero;
	}
	
	
	
	
}
