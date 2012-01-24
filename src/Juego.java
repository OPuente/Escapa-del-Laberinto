import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;

public class Juego {
   
       public static void main(String[] args) {
                IntroLaberinto juego = new IntroLaberinto("Huida del laberinto");
//manejador de evento de la ventana principal con clase adaptadora
// para salir si se aprieta el botón de cerrar ventana (clase anónima)
		juego.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		//da un tamaño a la ventana y hazla visible
                
		juego.setSize(Laberinto.ANCHURA_VENTANA, Laberinto.ALTURA_VENTANA);
		juego.setLocationRelativeTo(null);
		juego.setIconImage(Toolkit.getDefaultToolkit().getImage("raziel.gif"));
                juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                juego.setVisible(true);
	}
}