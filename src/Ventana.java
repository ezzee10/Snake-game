import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final int ANCHO = 600, ALTO = 600;
	private Juego lamina;
	private int encendido = 0;
	
	public Ventana() {
		
		//ventana
		setTitle("Snake2D");
		setSize(ANCHO,ALTO);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//panel
		lamina = new Juego();
		add(lamina);
		
		//mov = new Movimiento();
		//mov.movimiento();
		
		
		//eventoTeclado
		addKeyListener(lamina);
		
		//no se puede ejecutar mas de un frame a la vez
		
		if(encendido == 0) {
			setVisible(true);
			encendido = 1;
			System.out.println("Valor: "+ encendido);
		}else {
			//JOptionPane.showMessageDialog(null, "No se permite instanciar más de una vez la ventana");
			System.out.println("No se puede abrir más de un frame a la vez");
		}	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
