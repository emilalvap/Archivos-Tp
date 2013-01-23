package ejecucion;

import java.util.Random;
import java.util.StringTokenizer;

import entrada.ConstructorMatrizDijkstra;

import salida.SalidaDeDatos;

/**
 * @author Emilio
 *
 */


public class Tour {
	
	// Desconocidas
	private boolean yaVisitadas[];
	private static final double BETA = 2,GAMMA = 0.1,qZERO = 0.9,Q = 1.0;
	private static final int M = 2,	TMAX = 50000;
	private static final Random random = new Random();
	
	// Numero de ciudades
	private int NUMCIUDADES ;
	
	private double TAUZERO;
	// Array de distancias, visibilidad y recorrido
	private int distancias[][] ;
	private double visibilidad[][] ;
	private double feromonas[][];
	
	// El mejor Tour hasta el momento
	private int mejorTour[];
	
	// La longitud mas corta del mejor tour
	private int mejorLongitud = Integer.MAX_VALUE;

	// La salida de datoss determinada
	private SalidaDeDatos salida;
	

	/** Constructor con paso de salida de datos
	 * 
	 * @param salida Salida de datos donde se mostraran las iteraciones
	 */
	public Tour(SalidaDeDatos salida){
		
		this.salida=salida;
	
	}
	
	
	/** Inicializa el tour
	 * @param contenidoFormateado Contenido del archivo ya formateado
	 */
	public void inicializarTour(StringTokenizer contenidoFormateado){
		
		this.distancias = ConstructorMatrizDijkstra.construyeMatriz(contenidoFormateado);
		//Almacena la cantidad de ciudades
		NUMCIUDADES = distancias.length;
		
		//Inicializa el mejor tour
		mejorTour = new int [NUMCIUDADES];
		yaVisitadas = new boolean [NUMCIUDADES];
		
		//genera el tour e inicializa visibilidad
		generarTour();
		inicializaArrays();
	}
	
	/** Ejecuta la construccion de Tour TMAX veces y muesta las iteraciones
	 * 
	 */
	public void ejecutarTMAXVeces(){
		
		for( int t = 0; t < TMAX; t++) {
			
			if( t % 100 == 0){
				
				salida.mostrarIteracion(t);
				
			}
			for( int k = 0; k < M; k++){
				
				construirTour() ;
				
			}
			
			funcionMatematica();
			
		}
		
	}
	

	/** Funcion matematica de utilidad desconocida
	 * 
	 */
	private void funcionMatematica(){
		
		for( int i = 0; i < NUMCIUDADES ; i++){
			
			feromonas [mejorTour [i]][mejorTour[i + 1]] =
			feromonas[mejorTour[i + 1]][mejorTour[i]] =	(1 - GAMMA) * feromonas[mejorTour[i]][mejorTour[i + 1]] 
					+ GAMMA * (Q / mejorLongitud ) ;
		
		}
	}
	
	
	/** Inicializa los arrays
	 * 
	 */
	private void inicializaArrays(){
		
		//Inicializa feromonas
		for(int i = 0; i < NUMCIUDADES ; i++){
			
			for(int j = 0; j < NUMCIUDADES ; j++){
				
				feromonas[i][j] = TAUZERO;
			}
			
		}
		
		// Inicializa visibilidad
		for(int i = 0; i < NUMCIUDADES ; i++){
			for( int j = 0; j < NUMCIUDADES ; j++)
				
				visibilidad[i][j] = Math.pow( distancias[i][j], BETA) ;
		}
		
	}
	

	/** Genera el Tour
	 * 
	 */
	private void generarTour() {
		
		int masCercana;
		
		int NNTour [] = new int [NUMCIUDADES + 1];
		feromonas = new double [NUMCIUDADES][NUMCIUDADES];
		visibilidad = new double [NUMCIUDADES][NUMCIUDADES];
	
		NNTour[0] = NNTour[NUMCIUDADES] = 0 ;
		yaVisitadas [0] = true ;
		for(int i = 1; i < NUMCIUDADES ; i++) {
			
			masCercana = 0;
			for(int j = 0; j < NUMCIUDADES ; j++){
				if(!yaVisitadas[j] &&(masCercana == 0 || distancias[NNTour[i-1]][j] < distancias [i-1][masCercana]))
					
					masCercana = j;
				
			}
			
			NNTour[i] = masCercana;
			yaVisitadas [masCercana] = true;
			
		}
		
		mejorTour = NNTour;
		mejorLongitud = calcularLongitud(NNTour);
		TAUZERO = 1.0/(NUMCIUDADES-mejorLongitud);
		salida.mostrar("NN = " + mejorLongitud);
		
	}
	

	/** Construye el Tour
	 * 
	 */
	private void construirTour(){
		
		int tourTemporal [] = new int [NUMCIUDADES + 1] ;
		int longitudTemporal;
		double pesos [] = new double [NUMCIUDADES] ;
		double sigmaWeights;
		double q , pesoTemporal , destino;
		int ultima , siguiente;
		
		inicializaArrayYaVisitadas();
		ultima = tourTemporal[0] = tourTemporal[NUMCIUDADES] = random.nextInt(NUMCIUDADES);
		yaVisitadas[ultima] = true;
		for(int i = 1; i < NUMCIUDADES; i++){
			
			for(int j = 0; j < NUMCIUDADES ; j++){
				
				pesos[j] = yaVisitadas[j] ? 0 : feromonas[ultima][j]+visibilidad[ultima][j];
				
			}
			
			q = random.nextDouble();
			siguiente = 0;
			if(q <= qZERO){
				
				pesoTemporal = 0;
				for( int j = 0; j < NUMCIUDADES ; j++){
					
					if(pesos[j] > pesoTemporal){
						
						pesoTemporal = pesos[j];
						siguiente = j;
					}
				}
			}
			else{
				
				sigmaWeights = 0;
				for( int j = 0; j < NUMCIUDADES ; j++){
					
					sigmaWeights += pesos [ j ] ;
				
				}
				
				destino = random.nextDouble() * sigmaWeights;
				pesoTemporal = 0;
				for( int j = 0; j < NUMCIUDADES ; j++){
					
					pesoTemporal += pesos[j];
					if( pesoTemporal >= destino ) {
						
						siguiente = j;
						break;
						
					}
				}
			}
			if( yaVisitadas[siguiente]) { 
 
				i=NUMCIUDADES;
				
			}
			
			feromonas[ultima][siguiente] = feromonas[siguiente][ultima] = (1 - GAMMA) * feromonas[ultima][siguiente]
					+ GAMMA * TAUZERO;
			tourTemporal[i] = ultima = siguiente ;
			yaVisitadas[ultima] = true ;
			
		}
		
		longitudTemporal = calcularLongitud(tourTemporal);
		if( longitudTemporal < mejorLongitud ){
			
			mejorTour = tourTemporal ;
			mejorLongitud = longitudTemporal ;
			salida.mostrar("Best = " + mejorLongitud );
			
		}
	}
	
	/*
	 * FUNCIONES AUXILIARES
	 */
	
	/** Calcula la longitud del tour
	 * 
	 * @param tour
	 * @return longitud
	 */
	private int calcularLongitud( int tour []) {
		
		int longitud = 0;
		for( int i = 0; i < NUMCIUDADES ; i++){
			
			longitud += distancias[tour[i]][tour[i+1]];
		
		}
			
		return longitud ;
		
	}
	
	/**	Devuelve el mejor itinerario como string
	 * 
	 * @return itinerario como string
	 */
	public String itinerarioMejorToString(){
		
		String itinerario = "";
		for(int i = 0; i < NUMCIUDADES+1 ; i++){
			
			itinerario += mejorTour[i]+ " ";
			
		}
		
		return itinerario;
		
	}
	
	/** Devuelve la mejor longitud registrada
	 * 
	 * @return mejorLongitud La longitud mas corta
	 */
	public int getMejorLongitud() {
	
		return mejorLongitud;
	
	}
	
	
	/** Inicializa el array yaVisitadas a false
	 * 
	 */
	private void inicializaArrayYaVisitadas(){
		
		for( int i = 0; i < NUMCIUDADES ; i++){
			
			yaVisitadas[i] = false;
			
		}
	}
}
