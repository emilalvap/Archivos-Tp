package test;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.Test;

import salida.SalidaDeDatos;

import ejecucion.ProblemaViajante;
import entrada.CargadorFichero;

public class TestTour {

	@Test
	public void testInicializar() {
		
		SalidaDeDatos salida = new SalidaDeDatos(1);
		StringTokenizer contenidoFormateado = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		StringTokenizer contenidoFormateado2 = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		ProblemaViajante tour1 = new ProblemaViajante(salida);
		ProblemaViajante tour2 = new ProblemaViajante(salida);
		tour1.inicializarTour(contenidoFormateado);
		tour2.inicializarTour(contenidoFormateado2);
		try{

			assertEquals("No coinciden",tour1.itinerarioMejorToString(),tour2.itinerarioMejorToString());
			
		}catch(AssertionError e){
			
			System.out.println(e.getMessage());
			fail();
			
		}
	}
	
	@Test
	public void testGenerar() {
		
		// Se ejecuta 4.000 veces en vez de 50.000 para evitar tiempos de espera
		int tMax= 4000;
		SalidaDeDatos salida = new SalidaDeDatos(1);
		StringTokenizer contenidoFormateado = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		StringTokenizer contenidoFormateado2 = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		ProblemaViajante tour1 = new ProblemaViajante(salida);
		ProblemaViajante tour2 = new ProblemaViajante(salida);
		tour1.inicializarTour(contenidoFormateado);
		tour2.inicializarTour(contenidoFormateado2);
		tour1.ejecutarNVeces(tMax);
		tour2.ejecutarNVeces(0);
		
		try{
			
			assertEquals("No coinciden",tour1.itinerarioMejorToString(),tour2.itinerarioMejorToString());
			
		}catch(AssertionError e){
			
			System.out.println(e.getMessage());
			fail();
			
		}
	}
	
}
