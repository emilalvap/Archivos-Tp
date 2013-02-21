package bicicleta;



public class Montanya extends Bicicleta{
	//Constructor de bicicleta montaña, inicualiza platos a 3 y piñones a 7
	public Montanya(int pinyon, int plato, double radio) {
		super(pinyon, plato, radio);
		super.setMaxpinyones(7);
		super.setMaxplato(3);
		inicializaPlatosypinyones();
		// TODO Auto-generated constructor stub
	}
	//Inicializa los valores de los platos y piñones de la bicicleta de montaña
	private void inicializaPlatosypinyones(){
		platos = new int[3];
		pinyones = new int[7];
		
		platos[0]=40;
		platos[1]=50;
		platos[2]=60;
		
		pinyones[0]=10;
		pinyones[1]=12;
		pinyones[2]=14;
		pinyones[3]=16;
		pinyones[4]=18;
		pinyones[5]=20;
		pinyones[6]=22;
	}

}
