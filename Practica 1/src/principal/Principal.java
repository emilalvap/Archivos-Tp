package principal;

import java.util.ArrayList;
import java.util.List;
import personas.Ciclista;
import objetos.*;
import bicicleta.*;
import rolex.*;

public class Principal {
	private int segundos,minutos,horas;
	timer miReloj;
	Bicicleta bici;
	Ciclista ciclista;
	SacarDatos salida;
	List<ObjetoQueSeEjecuta> ejecutables;
	
	void principal(){
		
	}
	
	
	public void inicializa(){
		//Establece la duracion de la prueba
		this.segundos=0;
		this.minutos=0;
		this.horas=10;
		//Inicializa el resto de elementos
		this.miReloj	= new timer();
		this.bici		= new Montanya(0,0,23.5);
		this.ciclista	= new Ciclista(80,this.bici);
		
		//Crea las listas
		this.ejecutables = new ArrayList<ObjetoQueSeEjecuta>();
		List<ObjetoQueSeMuestra> mostrables = new ArrayList<ObjetoQueSeMuestra>();
		//Crea la listade mostrables y los añade a SacarDatos
		mostrables.add(this.ciclista);
		mostrables.add(this.miReloj);
		this.salida=new SacarDatos(mostrables);
		//Añade los objetos ejecutables a la lista de ejecutables
		ejecutables.add(this.ciclista);
		ejecutables.add(this.miReloj);
		ejecutables.add(this.salida);
		
	
		
		System.out.println("Se inicia el recorrido.");
		System.out.print(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n\n");
	}
	
	public void ejecuta(){
		

		
		
		//Inicia el bucle principal
		do{
			
			for(ObjetoQueSeEjecuta e : ejecutables){
				
				e.ejecuta();

			}
	
		//Duracion de la prueba 
		}while(!((this.miReloj.getSegundos()==this.segundos)&&(this.miReloj.getMinutos()==this.minutos)&&(this.miReloj.getHoras()==this.horas)));
	}
	
	public void finaliza(){
		
		System.out.println("Recorrido finalizado.");
		
	}
	
	public static void main(String[] args0){
		
		Principal arranque = new Principal();
		
		arranque.inicializa();
		arranque.ejecuta();
		arranque.finaliza();
	}
}
