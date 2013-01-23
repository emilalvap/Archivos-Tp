package test;

import static org.junit.Assert.*;

import java.util.* ;
import java.io.* ;

import org.junit.Test;

import entrada.CargadorFichero;

public class TestCargadorFichero {

	@Test
	public void testCargarArchivoFormateado() {
		StringTokenizer contenidoTestFormateado = CargadorFichero.cargarArchivoFormateado("test.txt");
		try{
			assertEquals("No coinciden",false, contenidoTestFormateado.hasMoreTokens() );
		}catch(AssertionError e){
			System.out.println(e.getMessage());
			fail("Error en TestCargadorFichero");
		}
	}

}
