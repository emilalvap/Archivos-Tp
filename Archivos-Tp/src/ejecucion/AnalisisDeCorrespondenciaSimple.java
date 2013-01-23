package ejecucion;


import java.util.StringTokenizer;

import ejecucion.AnalisisDeCorrespondenciaSimple;
import entrada.CargadorFichero;


import salida.SalidaDeDatos;

public class AnalisisDeCorrespondenciaSimple  {
	
	// VARIABLES DE LA CLASE
	
	SalidaDeDatos salida;
	ProblemaViajante tour;
	
	
	/* RESUMEN DE LOS M�TODOS DE LA CLASE:
	 * 
	 * 1. main(String args[])	--> Main de la clase.
	 * 2. SimpleACS()	 		--> Constructor por defecto.
	 * 3. iniciar()				--> Declaraci�n e inicializaci�n de variables.
	 * 4. ejecutar() 			--> Ejecuci�n del programa.
	 * 5. finalizar()			--> Finaliza la ejecuci�n .
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
	

	/** Declaraci�n e inicializaci�n de variables para la ejecuci�n
	 * 
	 */
	void iniciar(){
		
		// Inicializa la salida de datos, por defecto por pantalla
		this.salida = new SalidaDeDatos();

		// Carga el contenido del archivo formateado
		String archivo = "eil51.tsp";
		StringTokenizer contenidoFormateado = CargadorFichero.cargarArchivoFormateado(archivo);
		
		// Inicializa la matriz de Dijkstra
		this.tour = new ProblemaViajante(salida);
		tour.inicializarTour(contenidoFormateado);

	}
	
	/** Ejecuci�n del programa
	 * 
	 */
	void ejecutar(){
		
		//TMax numero de veces que se ejecuta el generador de tours
		int tMAX = 50000;
		this.tour.ejecutarNVeces(tMAX);
		
	}
	
	/** Finaliza la ejecuci�n
	 * 
	 */
	void finalizar(){
		
		salida.mostrar(Integer.toString(tour.getMejorLongitud()));
		salida.mostrar(tour.itinerarioMejorToString());
		
	}
}
