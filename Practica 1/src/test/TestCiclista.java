/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import personas.*;
import bicicleta.*;

/**
 * @author Emilio y Javier
 *
 */
public class TestCiclista {

	@Test // (RL = 147.654854738 cm) * (RT= 4) = 5.90619418952 m/s
	public void testDarPedaladaMontanya(){
		Bicicleta bici = new Montanya(0,0,23.5);
		Ciclista ciclista = new Ciclista(50, bici);
		ciclista.darPedalada();
		try {
			assertEquals("Error en testDarPedalada",5.90619418952,ciclista.getVelocidadActual(),0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}
	@Test // (RL = 106.814150236 cm) * (RT= 2.2222222222222223) = 2.3736477830222227 m/s
	public void testDarPedaladaPaseo(){
		Bicicleta bici = new Paseo(0,0,17);
		Ciclista ciclista = new Ciclista(50, bici);
		ciclista.darPedalada();
		try {
			assertEquals("Error en testDarPedalada",2.3736477830222227,ciclista.getVelocidadActual(),0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}

}
