package ejecucion;


import java.util.StringTokenizer;

import ejecucion.SimpleACS;
import entrada.CargadorFichero;


import salida.SalidaDeDatos;

public class SimpleACS  {
	SalidaDeDatos salida;
	Tour tour;
	
	public static void main( String args [ ] ) {
		SimpleACS main = new SimpleACS();
	}

	public SimpleACS() {
		
		iniciar();
		ejecutar();
		finalizar();
		
	}
	

	/** Inicializa las variables para la ejecución
	 * 
	 */
	void iniciar(){
		
		this.salida = new SalidaDeDatos();
		String archivo = "eil51.tsp";
		
		// Carga el contenido del archivo formateado
		StringTokenizer contenidoFormateado = CargadorFichero.cargarArchivoFormateado(archivo);
		
		// Inicializa la matriz de Dijkstra
		this.tour = new Tour(salida);
		tour.inicializarTour(contenidoFormateado);
		
	}
	
	/** Ejecuta
	 * 
	 */
	void ejecutar(){
		
		this.tour.ejecutarTMAXVeces();
		
	}
	
	/** Finaliza
	 * 
	 */
	void finalizar(){
		
		salida.mostrar(Integer.toString(tour.getMejorLongitud()));
		salida.mostrar(tour.itinerarioMejorToString());
	}
}
