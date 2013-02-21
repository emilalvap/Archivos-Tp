/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import rolex.timer;

/**
 * @author Emilio y Javier
 *
 */
public class TestReloj {

	@Test //Crea el reloj, lo ejecuta y tiene que devolver 1 segundo
	public void testReloj() {
		timer miReloj = new timer();
		miReloj.ejecuta();
		try{
			assertEquals("Error en testReloj",1,miReloj.getSegundos());
		}catch ( AssertionError e ){
			System.err.println(e.getMessage());
			fail();
		}
	}

}
