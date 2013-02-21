package personas;
import objetos.*;
import bicicleta.Bicicleta;
import java.text.DecimalFormat;


public class Ciclista extends Persona implements ObjetoQueSeEjecuta, ObjetoQueSeMuestra{
	private Bicicleta bicicleta;
	private double Recorrido;
	private double VelocidadActual, VelocidadMedia, Registros;
	private boolean pedalada;
	
	//Inicializa el ciclista
	public Ciclista(int Peso, Bicicleta bici){
		super(Peso);
		Recorrido=0;
		bicicleta = bici;
		VelocidadActual = 0;
		VelocidadMedia=0;
		Registros=0;
		pedalada=false;
	}
	
	// EJECUCION
	public void ejecuta(){
		
		int randomPedalada = (int)(Math.random()*100);
		int randomCambiarMarcha=(int)(Math.random()*100);
		int piñon;
		int plato;
		
		if(randomPedalada > 75){
			darPedalada();
			//Importante:Que de pedalada no significa que aumente la velocidad
			pedalada=true;
			//Si el random es mayor que 80 cambia marcha, la marcha se escge de manera aleatoria
			//dentro del rango maxpiñones y maxplato
			//Se incluye dentro del randomPedalada porque para cambiar de marcha hay que pedalear
			if(randomCambiarMarcha>80){
				piñon=(int)(Math.round(Math.random()*(bicicleta.getMaxpinyones()-1)));
				plato=(int)(Math.round(Math.random()*(bicicleta.getMaxplato()-1)));
				bicicleta.cambiarMarcha(piñon, plato);
			}
		}
		//No da pedalada, disminuye la velocidad a un ritmo constante de 0.8 m/s --> 2,88 km/h
		//La desacelaracion es un valor estipulado
		else{
			pedalada=false;
			VelocidadActual = (VelocidadActual > 0.8) ? VelocidadActual-0.8: 0;
		}
		Recorrido += VelocidadActual;
		VelocidadMedia += VelocidadActual;
		Registros++;
	}
	
	public void darPedalada(){ //Actualiza la velocidad con una pedalada en el plato
		//y piñon actual, si la ACELERACION es superior a la VELOCIDAD ACTUAL - DESACELERACION,
		//actualiza el valor, si no lo "desacelera"
		this.VelocidadActual = (bicicleta.aceleracion()>(VelocidadActual-0.8)) ?  bicicleta.aceleracion():VelocidadActual-0.8;
		
	}
	//Muestra 
	public String mostrar(){
		String patron = "##.##";
		DecimalFormat formato = new DecimalFormat(patron);
		String pedaleado= (pedalada) ? "Si":"No";
		return "Piñon: " + (bicicleta.getpinyon()+1) + "\t\tPlato: " + (bicicleta.getPlato()+1) + "\t\t\tDistancia recorrida: "+ formato.format(Recorrido/1000) + " km\t" +
						   "\nVelocidad: " + formato.format((VelocidadActual*3600)/1000) + " km/h\tPedalada: " + pedaleado + " \t" + "Velocidad media: " + formato.format(((VelocidadMedia/Registros)*3600)/1000) + " km/h\t";
		
		
	}

	public double getVelocidadActual() {
		// TODO Auto-generated method stub
		return VelocidadActual;
	}
}
