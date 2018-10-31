import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IngresandoPalabra implements EstadoTablero{

	@Override
	public void empezar(Tablero t) {
		// TODO Auto-generated method stub
		t.setCurrent(t.getIngresando());
		
	}

	@Override
	public void input(Tablero t) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	  	System.out.println("Mago Roberto, ingrese su palabra secreta:");

	    
	  	String  s= in.nextLine();
	  	t.setPalabrasecreta(s);
	  	
	  	if(s!=null){
	  		t.setCurrent(t.getTurno1());
	  	}
		
	}

	@Override
	public void esperar(Tablero t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ganar(Tablero t) {
		// TODO Auto-generated method stub
		
	}

	
}
