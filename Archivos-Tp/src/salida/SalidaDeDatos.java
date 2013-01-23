package salida;

public class SalidaDeDatos {
	
	
	//Estable el standar de salida, por comodidad solo se contempla la pantalla
	int estandar;
	
	/** Constructor por defecto establece el estandar como salida por pantalla
	 * 
	 */
	public SalidaDeDatos(){
		
		estandar=0;
	}
	
	/** Crea el objeto salida con el estandar i de salida
	 * @param i
	 */
	public SalidaDeDatos(int i) {
		// TODO Auto-generated constructor stub
		estandar = i;
	}

	/** Muestra el mensaje por el estandar determinado
	 * @param mensaje
	 */
	public void mostrar(String mensaje){

		switch(estandar){
		
		case 0:
			System.out.println(mensaje);
			break;
			
		}
	}
	
	/** Muestra la iteracion con formato por el estandar determinado
	 * @param n
	 */
	public void mostrarIteracion(int n){
		
		switch(estandar){
		
		case 0:
			System.out.println (" Iteration " + n );
			break;
			
		}
	}
}
