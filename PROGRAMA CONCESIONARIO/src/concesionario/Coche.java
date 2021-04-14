package concesionario;

public class Coche extends Vehiculo {
	
	private int numPuertas, capacidadMaletero;
	
	public Coche (String matricula, String numBastidor, String color, int numAsientos, float precio, String numSerie, int numPuertas, int capacidadMaletero) {
		super(matricula, numBastidor, color, numAsientos, precio, numSerie);
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
	}
	
	@Override
	public String toString () {
		System.out.println(super.toString());
		return "Nº de puertas: " + numPuertas + "\nCapacidad del maletero: " + capacidadMaletero + "\n";
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}
	
	
	
}
