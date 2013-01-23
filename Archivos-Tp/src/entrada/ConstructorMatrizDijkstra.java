package entrada;

import java.util.StringTokenizer;

public class ConstructorMatrizDijkstra {

		/* RESUMEN DE LOS MÉTODOS DE LA CLASE:
		 * 
		 * 1. construyeMatriz(StringTokenizer cadenaFormateada)						--> Recibe la cadena formateada, obtiene 
		 * 																				el numero de ciudades y llama al 
		 * 																				constructor de	la matriz de Dijkstra 
		 * 
		 * 2. construyeMatriz(StringTokenizer cadenaFormateada, int numCiudades)	--> Recibe el numero de ciudades y el texto
		 * 																				formateado y escoge el metodo para 
		 * 																				rellenar la matriz
		 * 
		 * 3. construirDistanciasAlgoritmoDeEuclides(StringTokenizer strTok, int numCiudades) --> Obtiene la matriz mediante
		 * 																						 el algoritmo de Euclides
		 * 
		 * 4. rellenaMatriz(double[][] coordenadas,int distancia, int numCiudades, int X, int Y)--> Rellena la matriz mediante
		 * 																							el algoritmo de Euclides
		 * 
		 * 5.construirDistanciasExplicito( StringTokenizer cadena, int numCiudades )	--> Construye la matriz de 
		 * 																					Dijkstra explicitamente
		 * 
		 * 6. calcularNumCiudades( StringTokenizer cadena)		--> Obtiene el numero de ciudades de la cadena pasada 
		 * 															por argumento
		 */
	
	
	
		/** Recibe la cadena formateada y construye la matriz de Dijkstra a partir de ella
		 * 
		 *  a traves de diversos metodos
		 * @param cadenaFormateada
		 * @return int[][] matrizDeDijkstra construida
		 */
		public static int[][] construyeMatriz(StringTokenizer cadenaFormateada){
			
			//Calcula el numero
			int numCiudades = calcularNumCiudades(cadenaFormateada);
			
			//Devuelve la matriz
			return construyeMatriz(cadenaFormateada,numCiudades);
			
		}
		
		
		/**	Recibe el numero de ciudades y el texto formateado y escoge el metodo para rellenar la matriz
		 * 
		 * @param cadenaFormateada
		 * @param numCiudades
		 * @return matrizAux ya rellena
		 */
		private static int[][] construyeMatriz(StringTokenizer cadenaFormateada, int numCiudades){
			
			//Desconocida su utilidad
			String edgeWeightType = "UNKNOWN";
			
			//Variables temporales
			String cadenaAux = "";
			int matrizAux[][] = new int[0][0];
			boolean siguiente = true;
			
			while(siguiente){
				
				cadenaAux = cadenaFormateada.nextToken();
				if(cadenaAux.equals("EDGE WEIGHT TYPE")){
					
					cadenaFormateada.nextToken();
					cadenaAux = cadenaFormateada.nextToken();
					edgeWeightType = cadenaAux;
					
					if(edgeWeightType.equals("EXPLICIT")){
						
						//Construye la matriz explicitamente
						matrizAux = construirDistanciasExplicito(cadenaFormateada, numCiudades);
						siguiente = false;
						 
					}
					
					else{
						
						//Construye la matriz con el método de Euclides
						matrizAux = construirDistanciasAlgoritmoDeEuclides(cadenaFormateada, numCiudades);
						siguiente = false;
						
					}
				}
				
				else if(cadenaAux.equals("EDGE WEIGHT TYPE:")){
					
					cadenaAux = cadenaFormateada.nextToken();
					edgeWeightType = cadenaAux;
					
					if(edgeWeightType.equals("EXPLICIT")){
						
						// Construye la matriz explicitamente
						matrizAux = construirDistanciasExplicito(cadenaFormateada, numCiudades);
						siguiente = false;
						
					}
					
					else{
						
						// Construye la matriz con el metodo de Euclides
						matrizAux = construirDistanciasAlgoritmoDeEuclides(cadenaFormateada, numCiudades);
						siguiente = false;
						
					}
				}
			}
			
			//Devuelve la matriz definitiva
			return matrizAux;
			
		}
		

		/**	Obtiene la matriz mediante el algoritmo de Euclides
		 * 
		 * @param strTok
		 * @param numCiudades
		 * @return matrizAux rellena
		 */
		private static int[][] construirDistanciasAlgoritmoDeEuclides(StringTokenizer strTok, int numCiudades){
			
			//Desconocida su utilidad
			int contador = 0;
			final int X = 0;
			final int Y = 1;
			
			//Array de coordenadas, desconocida su utilidad
			double coordenadas[][] = new double[numCiudades][2];
			
			//Matriz auxiliar a devolver
			int matrizAux[][] = new int[numCiudades][numCiudades];
			
			String cadenaAux = "";
			
			int distancia = 0;
			
			//Mientras que la cadenaAux no sea "NODE COORD SECTION"
			while(!cadenaAux.equals("NODE COORD SECTION")){
				
				//Selecciona el siguiente Token
				cadenaAux = strTok.nextToken();
				if( cadenaAux.equals("NODE COORD SECTION")){
					
					//Mientras no sea final del archivo
					while( !strTok.nextToken().equals("EOF")){
						//Almacena la coordenadas y aumenta el contador
						coordenadas[contador][X] = Double.parseDouble(strTok.nextToken());
						coordenadas[contador][Y] = Double.parseDouble(strTok.nextToken());
						contador++;
						
					}
				}
			}
			
			//Llama al metodo que rellena la matriz pasandole todos los datos
			matrizAux = rellenaMatriz(coordenadas,distancia,numCiudades,X,Y);
			
			//Devuelve la matriz rellena
			return matrizAux;
		
		}
		
		
		/** Rellena la matriz mediante el algoritmo de Euclides
		 * 
		 * @param coordenadas
		 * @param distancia
		 * @param numCiudades
		 * @param X
		 * @param Y
		 * @return matrizAux ya rellena
		 */
		private static int[][] rellenaMatriz(double[][] coordenadas,int distancia, int numCiudades, int X, int Y){
			
			int matrizAux[][]= new int[numCiudades][numCiudades];
			for(int j = 0; j < coordenadas.length ; j++){
				
				for( int i = j ; i < coordenadas.length ; i++){
					
					distancia = (int)Math.floor(.5 + Math.sqrt(Math.pow(coordenadas[i][X]-coordenadas[j][X], 2.0) +Math.pow(coordenadas[i][Y]-coordenadas[j][Y], 2.0)));
					matrizAux[i][j] = distancia;
					matrizAux[j][i] = distancia;
					
				}
			}
			
			//Devuelve la matriz con distancias
			return matrizAux ;
		}
		
		
		/** Construye la matriz de Dijkstra explicitamente
		 * 
		 * @param cadena
		 * @param numCiudades
		 * @return matrizAux ya rellena
		 */
		private static int[][] construirDistanciasExplicito( StringTokenizer cadena, int numCiudades ){
			
			// Declara la matriz auxiliar a devolver
			// los indices secuenciales contadorI, contadorJ
			// y variable condicion del bucle
			int matrizAux[][] = new int[numCiudades][numCiudades];
			int contadorI = 0;
			int contadorJ = 0;
			String cadenaLeida = "";
			boolean fin;
			
			while(!cadenaLeida.equals("EOF")){
				
				cadenaLeida = cadena.nextToken();
				if(cadenaLeida.equals("EDGE WEIGHT SECTION")){
					
					fin = false;
							
					while(!fin){
						
						cadenaLeida = cadena.nextToken();
						if(cadenaLeida.equals("EOF")){
							
							fin = true;
							
						}
						if(cadenaLeida.equals("0")){
							
							matrizAux[contadorI][contadorJ] = Integer.parseInt(cadenaLeida);
							matrizAux[contadorJ][contadorI] = Integer.parseInt(cadenaLeida);
							contadorI++;
							contadorJ=0;
							
						}
						else{
							
							matrizAux[contadorI][contadorJ] = Integer.parseInt(cadenaLeida);
							matrizAux[contadorJ][contadorI] = Integer.parseInt(cadenaLeida);
							contadorJ++;
						}
					}
				}
			}
			
			return matrizAux;
		}
		

		/** Obtiene el numero de ciudades de la cadena pasada por argumento
		 * 
		 * @param cadena
		 * @return numCiudades Numero de ciudades indicadas en la cadena
		 */
		private static int calcularNumCiudades( StringTokenizer cadena){
			
			int numCiudades;
			String cadenaAux = "";
			boolean noEncontrado = true;
			while(noEncontrado){
				// Busca hasta que encuentra el token DIMENSION o DIMENSION:
				cadenaAux = cadena.nextToken();
				if( cadenaAux.equals("DIMENSION")){
					
					cadena.nextToken();
					cadenaAux = cadena.nextToken();
					noEncontrado=false;
				
				}
				
				else if(cadenaAux.equals("DIMENSION:")){
					
					cadenaAux = cadena.nextToken();
					noEncontrado=false;
				
				}
			}
			// Obtiene el numero de ciudades
			numCiudades = Integer.parseInt(cadenaAux);
			return numCiudades;
		}
}
