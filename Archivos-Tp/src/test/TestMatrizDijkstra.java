package test;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.Test;

import entrada.CargadorFichero;
import entrada.ConstructorMatrizDijkstra;

public class TestMatrizDijkstra {

	@Test
	public void test() {
		StringTokenizer contenidoFichero1 = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		StringTokenizer contenidoFichero2 = CargadorFichero.cargarArchivoFormateado("eil51.tsp");
		int resultado1[][];
		int resultado2[][];
		resultado1 = ConstructorMatrizDijkstra.construyeMatriz(contenidoFichero1);
		resultado2 = ConstructorMatrizDijkstra.construyeMatriz(contenidoFichero2);
		try{
			assertArrayEquals("No coinciden",resultado1, resultado2);
		}catch(AssertionError e){
			System.out.println(e.getMessage());
			fail();
		}
	}

}
