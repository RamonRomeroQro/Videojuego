import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Turno implements EstadoTablero {

	
	
	@Override
	public void empezar(Tablero t) {
		// TODO Auto-generated method stub
		t.setCurrent(t.getIngresando());
		
	}

	@Override
	public void input(Tablero t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void esperar(Tablero t) {
		// TODO Auto-generated method stub
		System.out.println("Espera y cambio.");

	  	if(t.getCurrent().equals(t.getTurno1())){
		  	System.out.println("Adivina j2:");

			t.setCurrent(t.getTurno2());

		}
		else if(t.getCurrent().equals(t.getTurno2())){
		  	System.out.println("Adivina j1:");

			t.setCurrent(t.getTurno1());

		}
		
	}
	
	

	@Override
	public void ganar(Tablero t) {
		// TODO Auto-generated method stub
		
		showblack(t);
		
	  	System.out.println("Adivina j1:");

		do {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	    
	  	String  s= in.nextLine();
	  	t.setIntento(s);

	  	
		if(t.getIntento().equals(t.getPalabrasecreta())){
			if(t.getCurrent().equals(t.getTurno1())){
			  	System.out.println("Felicidades J1:");


			}
			else if(t.getCurrent().equals(t.getTurno2())){
			  	System.out.println("Adivina J2:");


			}
			
			
		  	t.setWin(true);

			t.setCurrent(t.getFin());
		}
		
		else if(t.getPalabrasecreta().contains(s.substring(0, 1))){
			
			char prueba = s.substring(0, 1).charAt(0);
			char [] ciclo = t.getPalabrasecreta().toCharArray();
			char [] show = t.getMuestra().toCharArray();
			
			for(int i =0; i< t.getMuestra().length(); i++){
				
				if(show[i]=='*'){
					if (prueba == ciclo[i]){
						show[i]=prueba;
					}
					
				}
				
			}
			
			String nueva="";
			for(int i =0; i< t.getMuestra().length(); i++){
				nueva=nueva+show[i];
			
				
			}
			
			
			
			
			t.setMuestra(nueva);
			
			System.out.println(nueva);
			
			if (nueva.equals(t.getPalabrasecreta())){
			
				
				if(t.getCurrent().equals(t.getTurno1())){
				  	System.out.println("Felicidades J1:");


				}
				else if(t.getCurrent().equals(t.getTurno2())){
				  	System.out.println("Adivina J2:");


				}
				
				t.setWin(true);

				t.setCurrent(t.getFin());
				
				
				
			}

			
			
			
			
			
			
		
		}
		
		
		
		
		else{
		  esperar(t);
		}
		}while (t.isWin()==false);
		
	}
	
	
	public void showblack(Tablero t){
		String show="";
		for(int i =0; i< t.getPalabrasecreta().length(); i++){
			show=show+"*";
		}
		t.setMuestra(show);
		System.out.println(show);
	
	}
	
	
	
	
	
	
	
}
