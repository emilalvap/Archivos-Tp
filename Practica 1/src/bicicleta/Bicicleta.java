package bicicleta;

public class Bicicleta {
	
	protected int[] platos;
	protected int[] pinyones;
	private int plato,pinyon, maxpinyones,maxplato;
	private final double pi = 3.141592654;
	private double radio;
	//Constructor al que se le pasa piñon,plato,radio de la rueda
	public Bicicleta(int pinyon, int plato, double radio){
		this.pinyon = pinyon;
		this.plato = plato;
		this.radio = radio;
	}
	//Cambia la marcha
	public void cambiarMarcha(int pinyon, int plato){
		this.pinyon=pinyon;
		this.plato=plato;
	}
	//Devuelve la relacion de transmision
	public double relacionTrans(){
		double relacion;
		relacion = (double)platos[plato] / pinyones[pinyon];
		
		return relacion;
	}
	//Devuelve el recorrido lineal de la rueda
	public double recorridoLineal(){
		double recorrido;
		recorrido = pi * radio * 2;
		
		return recorrido;	
	}
	//Devuelve la velocidad en m/s 
	public double aceleracion(){
		return relacionTrans()*recorridoLineal()/100;	
	}
	//Devuelve el num max de pinyones
	public int getMaxpinyones() {
		return maxpinyones;
	}
	//Devuelve el numero maximo de platos
	public int getMaxplato() {
		return maxplato;
	}
	//Modifica el numero maximo de pinyones
	public void setMaxpinyones(int maxpinyones) {
		this.maxpinyones = maxpinyones;
	}
	//Modifica el numero maximo de platos
	public void setMaxplato(int maxplato) {
		this.maxplato = maxplato;
	}
	//Devuelve el plato actual
	public int getPlato() {
		return plato;
	}
	//Devuelve el piñon actual
	public int getpinyon() {
		return pinyon;
	}
	
}
