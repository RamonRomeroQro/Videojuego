import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public int x;

	public int y;
	public int width;
	public int height;
	public Color c;
	
	public Ball(){
	this.x=50;
	this.y=50;
	this.width=30;
	this.height=30;
		this.c= new Color(255,255,0);
	}
	
	public void moveRight(){
		this.x=this.x+1;
	}
	public void moveLeft(){
		this.x=this.x-1;

	}
	public void moveUp(){
		this.y=this.y+1;

	}
	public void moveDown(){
		this.y=this.y-1;

	}
	
	public void draw(Graphics g){
		g.setColor(c);
		g.fillOval( this.x, this.y, this.width, this.height);
	}
	
	
	

}
