
public class Tablero  {
	
	public String intento;
	public String palabrasecreta;
	public String muestra;

	
	public EstadoTablero ingresando = new IngresandoPalabra();
	public EstadoTablero turno1 = new Turno();
	public EstadoTablero turno2 = new Turno();
	public EstadoTablero fin = new Finalizado();
	public EstadoTablero current;
	public boolean win;

	
	public Tablero() {
		this.intento="";
		this.palabrasecreta="";
		this.current =ingresando;
		this.win=false;
	}

	public void empezar() {
		// TODO Auto-generated method stub
		current.empezar(this);
		
	}

	public void input() {
		// TODO Auto-generated method stub
		current.input(this);
	}

	public void esperar() {
		// TODO Auto-generated method stub
		current.empezar(this);
		
	}

	public void ganar() {
		// TODO Auto-generated method stub
		current.ganar(this);
	}

	public String getIntento() {
		return intento;
	}

	public String getPalabrasecreta() {
		return palabrasecreta;
	}

	public EstadoTablero getIngresando() {
		return ingresando;
	}

	public EstadoTablero getTurno1() {
		return turno1;
	}

	public EstadoTablero getTurno2() {
		return turno2;
	}

	public EstadoTablero getFin() {
		return fin;
	}

	public EstadoTablero getCurrent() {
		return current;
	}

	public void setIntento(String intento) {
		this.intento = intento;
	}

	public void setPalabrasecreta(String palabrasecreta) {
		this.palabrasecreta = palabrasecreta;
	}

	public void setIngresando(EstadoTablero ingresando) {
		this.ingresando = ingresando;
	}

	public void setTurno1(EstadoTablero turno1) {
		this.turno1 = turno1;
	}

	public void setTurno2(EstadoTablero turno2) {
		this.turno2 = turno2;
	}

	public void setFin(EstadoTablero fin) {
		this.fin = fin;
	}

	public void setCurrent(EstadoTablero current) {
		this.current = current;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public String getMuestra() {
		return muestra;
	}

	public void setMuestra(String muestra) {
		this.muestra = muestra;
	}
	
	public void run(){
		empezar();
		input();
		ganar();
		ganar();
	}



	

	

}
