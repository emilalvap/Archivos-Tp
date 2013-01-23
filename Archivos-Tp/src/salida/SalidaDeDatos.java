package salida;

public class SalidaDeDatos {
	
	// VARIABLES DE LA CLASE
	
	//Establece el standar de salida, por comodidad solo se contempla la pantalla
	int estandar;
	
	
	/* RESUMEN DE LOS MÉTODOS DE LA CLASE:
	 * 
	 * 1. SalidaDeDatos()			--> Constructor por defecto establece el estandar como salida por pantalla
	 * 2. SalidaDeDatos(int i)		--> Constructor del objeto salida con el estandar i de salida
	 * 3. mostrar(String mensaje)	--> Muestra el mensaje por el estandar determinado
	 * 4. mostrarIteracion(int n)	--> Muestra la iteracion con formato por el estandar determinado
	 */
	
	
	
	
	/** Constructor por defecto establece el estandar como salida por pantalla
	 * 
	 */
	public SalidaDeDatos(){
		
		estandar=0;
	}
	
	
	/** Constructor del objeto salida con el estandar i de salida
	 * @param estandar Estandar de salida de datos
	 */
	public SalidaDeDatos(int estandar) {
		// TODO Auto-generated constructor stub
		this.estandar = estandar;
	}

	
	/** Muestra el mensaje por el estandar determinado
	 * @param mensaje Mensaje a mostrar
	 */
	public void mostrar(String mensaje){

		switch(estandar){
		
		case 0:
			System.out.println(mensaje);
			break;
			
		}
	}
	
	
	/** Muestra la iteracion con formato por el estandar determinado
	 * @param n Número de la iteración
	 */
	public void mostrarIteracion(int n){
		
		switch(estandar){
		
		case 0:
			System.out.println (" Iteration " + n );
			break;
			
		}
	}
}
