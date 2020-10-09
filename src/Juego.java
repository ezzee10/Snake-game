import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Juego extends JPanel implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	static ArrayList<JLabel> serpiente = new ArrayList<JLabel>();
	private int x,y;
	private final int desplazamiento = 20;
	private Timer tiempo;
	private int con = 0;
	private int coordenadax,coordenaday = 0;
	private Rectangle serp;
	private Rectangle manzana;
	private int perdio = 0;
	private JLabel puntuacion;
	private JLabel youLost;
	private int contador = 0;

	public Juego() {
		//setBackground(Color.BLUE);	
		setLayout(null);
		fondo = new JLabel();
		fondo.setSize(600,600);
		fondo.setIcon(new ImageIcon("img/fondo.jpg"));
		add(fondo);
		JLabel aux = new JLabel();
		aux.setLocation(290, 290);
		aux.setSize(20, 20);
		aux.setIcon(new ImageIcon("img/2.png"));
		serpiente.add(aux);
		add(serpiente.get(0),0);
		
		JLabel comida = new JLabel();
		comida.setIcon(new ImageIcon("img/6.png"));
		comida.setSize(20,20);
		add(comida,0);
		
		Random aleatorio = new Random();
		coordenadax = aleatorio.nextInt(540);
		coordenaday = aleatorio.nextInt(540);
		comida.setLocation(coordenadax, coordenaday);
		comida.repaint();
		
			
		serp = new Rectangle(serpiente.get(0).getBounds());
		manzana = new Rectangle(comida.getBounds());
		
		puntuacion = new JLabel();
		puntuacion.setFont(new Font("Arial", Font.PLAIN, 25));
		puntuacion.setText("Puntaje: "+ contador);
		puntuacion.setBounds(10,500, 200, 100);
		puntuacion.setForeground(Color.MAGENTA);
		add(puntuacion, 0);
		
		youLost = new JLabel();
		youLost.setBounds(150,180, 300, 200);
		youLost.setForeground(Color.BLACK);
		youLost.setFont(new Font("Serif", Font.PLAIN, 50));
		youLost.setHorizontalAlignment(SwingConstants.CENTER);
		add(youLost,0);
		
		tiempo = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manzana.setBounds(comida.getBounds());
				serp.setBounds(serpiente.get(0).getBounds());
				if(serpiente.get(0).getX() > 570) {
					perdio = 1;
					youLost.setText("GAME OVER");
					puntuacion.repaint();
					
				}
				
				if(serpiente.get(0).getX() < 0) {
					perdio = 1;
					youLost.setText("GAME OVER");
					puntuacion.repaint();
				}
				
				if(serpiente.get(0).getY() > 570) {
					perdio = 1;
					youLost.setText("GAME OVER");
					puntuacion.repaint();
				}
				
				if(serpiente.get(0).getY() <0 ) {
					perdio = 1;
					youLost.setText("GAME OVER");
					puntuacion.repaint();
				}
				
				if(perdio == 1) {
					tiempo.stop();
					youLost.setText("GAME OVER");
					puntuacion.repaint();
				}
				
				if(manzana.intersects(serp)) {
					Random aleatorio = new Random();
					coordenadax = aleatorio.nextInt(540);
					coordenaday = aleatorio.nextInt(540);
					comida.setLocation(coordenadax, coordenaday);
					comida.repaint();
					JLabel aux = new JLabel();
					aux.setLocation(200,200);
					aux.setSize(20, 20);
					aux.setIcon(new ImageIcon("img/1.png"));
					serpiente.add(aux);
					add(serpiente.get(serpiente.size()-1), 0);
					contador += 10;
					puntuacion.setText("Puntaje: "+ contador);
					puntuacion.repaint();
				}
				
				for(int i=serpiente.size()-1; i>0; i--) {
					serpiente.get(i).setLocation(serpiente.get(i-1).getLocation());
					serpiente.get(i).repaint();
				}
				
				serpiente.get(0).setLocation(serpiente.get(0).getX()+x, serpiente.get(0).getY()+y);
				
			}
		
		});
			
	}	

	@Override
	public void keyPressed(KeyEvent e) {
		

			int id = e.getKeyCode();

			if (id == KeyEvent.VK_W) {
				System.out.println("arriba");
				
				if(serpiente.get(0).getY() > 0) {
					y = -desplazamiento;
					x = 0;
					serpiente.get(0).setIcon(new ImageIcon("img/5.png"));
				}
				
				if(con == 0) {
					tiempo.start();
					con = 1;
				}
			}

			if (id == KeyEvent.VK_S) {
				System.out.println("abajo");
				if(serpiente.get(0).getY() < 600) {
					y = desplazamiento;
					x = 0;
					serpiente.get(0).setIcon(new ImageIcon("img/3.png"));
				}
				if(con == 0) {
					tiempo.start();
					con = 1;
				}
			}

			if (id == KeyEvent.VK_A) {
				System.out.println("izquierda");
				if(serpiente.get(0).getX() > 0) {
					x = -desplazamiento;
					y = 0;
					serpiente.get(0).setIcon(new ImageIcon("img/4.png"));
				}
				if(con == 0) {
					tiempo.start();
					con = 1;
				}
			}

			if (id == KeyEvent.VK_D) {
				System.out.println("derecha");
				if(serpiente.get(0).getY() < 600) {
					x = desplazamiento;
					y = 0;
					serpiente.get(0).setIcon(new ImageIcon("img/2.png"));
				}
				if(con == 0) {
					tiempo.start();
					con = 1;
				}
			}

		}
		
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
