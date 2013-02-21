/**
 * 
 */
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.TestBicicleta;
import test.TestCiclista;


/**
 * @author Emilio y Javier
 *
 */

@RunWith(Suite.class)
//Clases que va a ejecutar:
@Suite.SuiteClasses( { TestBicicleta.class , TestCiclista.class , TestReloj.class } )

public class All {
		

}
