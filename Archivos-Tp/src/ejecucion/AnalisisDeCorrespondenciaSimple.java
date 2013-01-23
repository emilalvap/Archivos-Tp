package ejecucion;


import java.util.StringTokenizer;

import ejecucion.AnalisisDeCorrespondenciaSimple;
import entrada.CargadorFichero;


import salida.SalidaDeDatos;

public class AnalisisDeCorrespondenciaSimple  {
	
	//Variables de la clase
	SalidaDeDatos salida;
	Tour tour;
	
	/* Resumen de métodos de la clase:
	 * 1. main(String args[])	--> Main de la clase.
	 * 2. SimpleACS()	 		--> Constructor por defecto.
	 * 3. iniciar()				--> Declaración e inicialización de variables.
	 * 4. ejecutar() 			--> Ejecución del programa.
	 * 5. finalizar()			--> Finaliza la ejecución .
	 */
	
	/** Main de la clase
	 * @param args
	 */
	public static void main( String args[] ) {
		AnalisisDeCorrespondenciaSimple main = new AnalisisDeCorrespondenciaSimple();
	}

	/** Constructor por defecto
	 * 
	 */
	public AnalisisDeCorrespondenciaSimple() {
		
		iniciar();
		ejecutar();
		finalizar();
		
	}
	

	/** Declaración e inicialización de variables para la ejecución
	 * 
	 */
	void iniciar(){
		
		// Inicializa la salida de datos, por defecto por pantalla
		this.salida = new SalidaDeDatos();

		// Carga el contenido del archivo formateado
		String archivo = "eil51.tsp";
		StringTokenizer contenidoFormateado = CargadorFichero.cargarArchivoFormateado(archivo);
		
		// Inicializa la matriz de Dijkstra
		this.tour = new Tour(salida);
		tour.inicializarTour(contenidoFormateado);

	}
	
	/** Ejecución del programa
	 * 
	 */
	void ejecutar(){
		
		//TMax numero de veces que se ejecuta el generador de tours
		int tMAX = 50000;
		this.tour.ejecutarNVeces(tMAX);
		
	}
	
	/** Finaliza la ejecución
	 * 
	 */
	void finalizar(){
		
		salida.mostrar(Integer.toString(tour.getMejorLongitud()));
		salida.mostrar(tour.itinerarioMejorToString());
		
	}
}
