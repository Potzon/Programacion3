package practica0;

public class CocheJuego extends Coche{
	JLabelCoche atributo;
	
	public CocheJuego() {
		
		super();
		atributo = new JLabelCoche();
		atributo.setLocation((int)getPosX(), (int)getPosY());
		
		
	}
	

}
