import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.MouseMotionListener;
  
public class Pong extends JFrame implements ActionListener, MouseMotionListener{

int pongballx = 400, pongbally = 300, paddle = 0, speedy = 4, speedx =2;
boolean gameOver = true;

     public Pong () {
	  

	  setContentPane(new DrawPane());
	  
	  setSize(800, 600);//size set of JFrame

	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  setVisible(true);//sets whole JFrame visilbe
	  
	  addMouseMotionListener(this); //allows user to move paddle with mouse motion


	  
     }

      
      class DrawPane extends JPanel{//new class
	public void paintComponent(Graphics g){//graphics placed here
       
	  if(gameOver)//boolean is set as true, following graphics are outputted
	  {
	  
	   g.setColor(Color.BLACK);
	   g.fillRect(0, 0, 800, 600);
	   
	   g.setColor (Color.WHITE);
	   g.fillRect(750,paddle,15,150);
	   
	   g.setColor (Color.WHITE);
	   g.drawLine (400,0,400,600);
	   
	   g.setColor(Color.WHITE);
	   g.fillOval (pongballx,pongbally,40,40);
	   
	   Font font = new Font ("Courier New", 1, 90); //Initializes the font

	    g.setColor (Color.WHITE); //Sets the color of the font
	    g.setFont (font); //Sets the font
	    g.drawString ("PONG", 290, 90); //Outputs the string
	 }
	 
	 else//if boolean is false then these graphics are outputted
	 {
	
	   g.setColor(Color.BLACK);//background
	   g.fillRect(0, 0, 800, 600);
	 
	   g.setColor (Color.WHITE);//halfway line
	   g.drawLine (400,0,400,600);
	    
	   g.setColor(Color.WHITE);//pong ball graphics
	   g.fillOval (pongballx,pongbally,40,40);
	   
	   Font font = new Font ("Courier New", 1, 90); //Initializes the font
	    
	   g.setColor (Color.WHITE); //Sets the color of the font
	   g.setFont (font); //Sets the font
	   g.drawString ("Game over!!",100,200);//tells user game is over
	    
	    
	     
	   }
	   }
     }

     public static void main(String args[]){
	    
	    Pong ball = new Pong();
	    
	    Timer t = new Timer(10,ball);//timer sets speed of ball
	    t.start();//enables timer
	    
	    
     }
     public void actionPerformed(ActionEvent e) {
     pongballx = pongballx + speedx;//following equation sets speed of the ball's x coordinate
     pongbally = pongbally + speedy;//following equation sets speed of the ball's y coordinate
     
    
     if (pongbally>=510)//following if statements change balls direction if it bounces of a wall or paddle
     {
     speedy = -4;
     }
      if (pongballx >= 720&&pongbally>=paddle&&pongbally<=paddle+150)//paddle
     {
     speedx = -2;
     }
     if (pongballx <= 0)
     {
     speedx = 2;
     }
     
     if (pongbally <=0)
     {
     speedy = 4;
     }
     repaint();
     
     if (pongballx>750)
     {
     speedx=0;
     speedy=0;
     gameOver=false;//if the ball crosses this wall boolean is set as false outputting the gameOver graphics
     
     }
     
     }
     public void mouseDragged(MouseEvent e) {//called mouseDragged
     }
     public void mouseMoved(MouseEvent e )//called mouseMoved
     {
     paddle = e.getY()-100;//mouse moves up and down 
     repaint();//repaints the movement of mouse
     }
     

  }
