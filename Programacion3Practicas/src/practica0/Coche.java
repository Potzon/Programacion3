package practica0;

public class Coche {
	private double miVelocidad = 0; 
	protected double miDireccionActual;
	protected double posX; 
	protected double posY; 
	private String piloto; 
	public Coche() {
		this.miVelocidad = 0;
		this.miDireccionActual = 0;
		this.posX = 0;
		this.posY = 0;
		this.piloto = "";
	}

	public double getMiVelocidad() {
		return miVelocidad;
	}
	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public double getMiDireccionActual() {
		return miDireccionActual;
	}
	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Coche [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + ", piloto=" + piloto + "]";
	}
	
	 public void acelera( double aceleracion ) {
		 miVelocidad += aceleracion;
	 }
	 
	 public void gira( double giro ) {
		 setMiDireccionActual(miDireccionActual + giro);
	 }
	 
	 public void mueve( double tiempoDeMovimiento ) { 
		 setPosX(posX + miVelocidad * Math.cos(miDireccionActual / 180 * Math.PI)* tiempoDeMovimiento);
		 setPosY(posY + miVelocidad * Math.sin(miDireccionActual / 180 * Math.PI)* tiempoDeMovimiento);
	 }


	
}
