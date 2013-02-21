package objetos;

import java.util.List;

public class SacarDatos implements ObjetoQueSeEjecuta{
	List<ObjetoQueSeMuestra> mostrables;
	
	/**
	 * @param args
	 */
	//Recibe la lsita de objetos mostrables
	public SacarDatos(List<ObjetoQueSeMuestra> lista){
		mostrables= lista;
	}


	@Override
	//Se ejecuta mostrando los objetos de la lista
	public void ejecuta() {
		int random;
		String mensaje="";
		// TODO Auto-generated method stub
		//random que decide la probabilidad de mostrar
		random = (int) Math.round((Math.random()*50));
		
		if(random > 49){
			for(ObjetoQueSeMuestra m : mostrables){
				mensaje+=m.mostrar();	
			}
			System.out.print(mensaje+" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n\n");
		}
	}

}
