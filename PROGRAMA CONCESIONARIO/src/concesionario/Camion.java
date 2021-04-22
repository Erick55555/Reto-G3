package concesionario;

public class Camion extends Vehiculo {
	
private float carga;
private char tipoMercancia;
	
	public Camion (String matricula, String numBastidor, String color, int numAsientos, float precio, String marca, String modelo, String fechaFab,
					float carga, char tipoMercancia) {
		super(matricula, numBastidor, color, numAsientos, precio, marca, modelo, fechaFab);
		this.carga = carga;
		this.tipoMercancia = tipoMercancia;
	}
	
	@Override
	public String toString () {
		System.out.println(super.toString());
		return "Carga: " + carga + "\nTipo de mercancia: " + tipoMercancia + "\n";
	}
	
	// GETTERS Y SETTERS
	public void setCarga(float carga) {
		this.carga = carga;
	}

	public void setTipoMercancia(char tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}

	public float getCarga() {
		return carga;
	}

	public char getTipoMercancia() {
		return tipoMercancia;
	}
	
	
	
	
}
