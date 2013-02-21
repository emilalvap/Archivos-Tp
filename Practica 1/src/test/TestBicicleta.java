/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bicicleta.*;

/**
 * @author Emilio y Javier
 *
 */
public class TestBicicleta {

	@Test // 2(r=23.5 cm) * 3,141592654 = 147.654854738 cm<--Recorrido lineal de la rueda
	public void testRecorridoLinealMontanha() {
		Bicicleta bici = new Montanya(0,0,23.5);
		try {
			assertEquals("Error en testRecorridoLinealMontanya\n",147.654854738, bici.recorridoLineal(), 0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}
	
	@Test // 2(r=17 cm) * 3,141592654 = 106.814150236 cm <-- Recorrido lineal de la rueda
	public void testRecorridoLinealPaseo() {
		Bicicleta bici = new Paseo(0,0,17);
		try {
			assertEquals("Error en testRecorridoLinealPaseo\n",106.814150236, bici.recorridoLineal(), 0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}
	
	@Test // (platos[0]=40)/(piñones[0]=10) = 4 <--Relacion de Transmision
	public void testRTMontanha() {
		Bicicleta bici = new Montanya(0,0,23.5);
		try {
			assertEquals("Error en testRTMontanya\n",4, bici.relacionTrans(), 0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}
	
	@Test // (platos[0]=40)/(piñones[0]=18) = 2.2222222222222223 <-- Relacion de Transmision
	public void testRTPaseo() {
		Bicicleta bici = new Paseo(0,0,17);
		try {
			assertEquals("Error en testRTPaseo\n",2.2222222222222223, bici.relacionTrans(), 0.0001);
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			fail();
		}
	}

}
