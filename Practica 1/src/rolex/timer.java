package rolex;


import java.util.Formatter;

import objetos.ObjetoQueSeEjecuta;
import objetos.ObjetoQueSeMuestra;

public class timer implements ObjetoQueSeEjecuta, ObjetoQueSeMuestra{

	//las variables de la clase reloj
	private int segundos, minutos, horas;

	
	/*
	 * al construir el reloj inicializamos a 0 para que cuando empiece a incrementar
	 * empiece desde 0
	*/
	public timer(){
		this.segundos=0;
		this.minutos=0;
		this.horas=0;
	}
	
	

	//ejecuta añade 1 segundo
	public void ejecuta(){
		segundos++;
		if(segundos==60){
			minutos++;
			segundos=0;
		}
		if(minutos==60){
			horas++;
			minutos=0;
		}
	}

	public String mostrar(){
	    @SuppressWarnings("resource")
		Formatter fmt = new Formatter();
	    
	    fmt.format("Tiempo: %1$02d:%2$02d:%3$02d \n", horas, minutos,segundos);
		return fmt.toString();
	}
	/**
	 * @return the segundos
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}
	 
	
}

