package bicicleta;

public class Paseo extends Bicicleta{
	//Constructor de bicicleta paseo 
	public Paseo(int pinyon, int plato, double radio) {
		super(pinyon, plato, radio);
		super.setMaxpinyones(1);
		super.setMaxplato(1);
		inicializaPlatosypinyones();
		// TODO Auto-generated constructor stub
	}
	//Inicializa los valores de los platos y piñones de la bicicleta de paseo
	private void inicializaPlatosypinyones(){
		platos = new int[1];
		pinyones = new int[1];
		
		platos[0]=40;

		
		pinyones[0]=18;

	}

}
