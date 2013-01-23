package entrada;

import java.util.* ;
import java.io.* ;


public class CargadorFichero {
	
	/* Resumen de los métodos de la clase:
	 * 1. String cargarContenidoFichero(String archivo)				--> Carga el contenido del fichero pasado como parametro.
	 * 2. StringTokenizer formatearContenido(String contenido)		--> Formatea el string pasado por parametro.
	 * 3. StringTokenizer cargarArchivoFormateado(String archivo)	--> Carga el contenido del archivo y lo formatea
	 */

	/** Carga el contenido del fichero pasado como parametro
	 * 
	 * @param archivo
	 * @return contenido como String
	 */
	private static String cargarContenidoFichero(String archivo){
		
		String contenidoFichero = "";
		if( archivo != null ){
			
			BufferedReader bufferLectura;
			try{
				
				bufferLectura = new BufferedReader (new FileReader (archivo));
				while( bufferLectura.ready()){
					
					contenidoFichero += bufferLectura.readLine()+"\n";
				
				}
			}
			//Excepcion si no encuentra el archivo
			catch( FileNotFoundException e ){
				
				System.err.println(e +"\n Archivo no encontrado . " +	" Indtast nyt f i lnavn og p r v igen . " ) ;
				e.printStackTrace();
			
			}
			//Excepcion si hay error en la lectura
			catch ( IOException e ){
			
				System.err.println(e +"\n Error de lectura. " +" Indtast nyt f i lnavn og p r v igen . " ) ;
				e.printStackTrace();
			
			}
		}
		
		//Devuelve el contenido del fichero
		return contenidoFichero;
	}
	
	/** Formatea el string pasado por parametro
	 * 
	 * @param contenido
	 * @return contenido formateado
	 */
	private static StringTokenizer formatearContenido(String contenido){
		
		//Le aplica el formato a la cadena pasada como parametro
		return new StringTokenizer(contenido,"\n\t\r\f");
	
	}
	
	/**	Carga el contenido del archivo y lo formatea
	 * 
	 * @param archivo
	 * @return cadena formateada
	 */
	public static StringTokenizer cargarArchivoFormateado(String archivo){
		
		//Carga el contenido de fichero
		String contenidoFichero = cargarContenidoFichero(archivo);
		//Lo formatea
		StringTokenizer cadenaFormateada = formatearContenido(contenidoFichero); 
		
		return cadenaFormateada;
		
	}
}