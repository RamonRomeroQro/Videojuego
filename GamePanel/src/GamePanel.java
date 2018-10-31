
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PWIDTH = 500;
	private static final int PHEIGHT = 400; //tamaño del panel
	
	private Thread animator; //controla la animación
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;
	private Coordenadas coor;
	
	public GamePanel(){
		coor=null;
		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		readyForTermination();
		
		addMouseListener( new MouseAdapter() { 
			public void mousePressed(MouseEvent e) {
				
				testPress(e.getX(), e.getY());
				
			
			
			
			}
		});
	} //GamePanel()
	
	

	public void addNotify()
	{
		super.addNotify();
		startGame();
	}//addNotify
	
	private void startGame()
	{
		if(animator == null || !running){
			animator = new Thread(this);
			animator.start();                // start busca el run
		}
	}//startGame()
	
	public void stopGame(){
		running = false;
	}//stopGame()
	
	public void run(){
		running = true;
		while(running){
			gameUpdate();
			gameUpdate();
			gameRender();
			paintScreen();
			
			try{
				Thread.sleep(20);
			}catch(InterruptedException ex){}
		}
		System.exit(0);
	}//run()
	
	private void gameUpdate(){
		
		if(!isPaused && !gameOver){
			
		}
		
	}//gameUpdate()
	
	private Graphics dbg;
	private Image dbImage = null;
	
	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}
			dbg.setColor(Color.white);
			dbg.fillRect(0,0,PWIDTH,PHEIGHT);
			
			
	       if(coor!=null){
	    	   this.coor.draw(dbg);
	       
	       

			
			
		}
	}//gameRender()
	
	private void gameOverMessage(){
		Graphics g;
		g=this.getGraphics();
		g.drawString("GameOver",10,10);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}
	
	private void readyForTermination() {
		addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) { 
				int keyCode = e.getKeyCode();
				if ((keyCode == KeyEvent.VK_ESCAPE) ||
					(keyCode == KeyEvent.VK_Q) ||
					(keyCode == KeyEvent.VK_END) ||
					((keyCode == KeyEvent.VK_C) && e.isControlDown()) ) {
					running = false;
				}
			} 
			});
	} // end of readyForTermination()
	
	private void testPress(int cx, int cy){
      if (!gameOver && !isPaused) {
    	  
    	  
    if(coor==null){
    	coor=new Coordenadas(cx,cy);
         System.out.println("X: "+this.coor.x+ " Y: "+this.coor.y);

    }
    else{
    	this.coor.setX(cx);
        this.coor.setY(cy);
        
        System.out.println("X: "+this.coor.x+ " Y: "+this.coor.y);


    }

       
   

      }
  
	}
	
	//recupera del game render
	
	private void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,null);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}
	
	public void pauseGame(){
		isPaused = true;
	}
	
	public void resumeGame(){
		isPaused = false;
	}
	
	public static void main(String args[]){
	 JFrame app = new JFrame("Test");
     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     app.pack();
     app.setResizable(false);  
     app.setVisible(true);
	}



	public Coordenadas getCoor() {
		return coor;
	}



	public void setCoor(Coordenadas coor) {
		this.coor = coor;
	}
}

