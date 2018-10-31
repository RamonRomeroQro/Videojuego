import java.awt.Color;
import java.awt.Graphics;

public class Coordenadas {
	
	public int x;

	public int y;
	public Color c;

	public Coordenadas(int x, int y){
		this.x=x;
		this.y=y;
		this.c=new Color(255,0,0);

	}
	
	public Coordenadas(){
		this.x=0;
		this.y=0;
		this.c=new Color(255,0,0);


	}
	public void draw(Graphics g){
		g.setColor(c);
		g.drawString("(x: "+this.x+", y: "+y+")",  this.x,  this.y);
	}
	
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getC() {
		return c;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setC(Color c) {
		this.c = c;
	}

}
