import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Jugador extends Personaje {
    Jugador(int fila, int columna, String rutaImg) {
        super(fila, columna, rutaImg);
    }
    
    void caeEnTrampa() {
// Fin del juego: ha caído en una trampa
        finalizarJuego(false);
    }
    
    void caeEnSalida() {
// Fin de juego: gana
        finalizarJuego(true);
    }
    
    //Finalizar Juego
    /**
     *
     * Presenta un cuadro de diálogo con el mensaje adecuado según el jugador
     * haya ganado (exito==true) o perdido (exito==false)
     *
     * Cuando el jugador pulsa 'aceptar' en el cuadro de diálogo,
     * termina la aplicación.
     */
    void finalizarJuego(boolean exito) { // ***** COMPLETAR MÉTODO *****
        if (exito==true){
            JOptionPane.showMessageDialog(null, "          HAS GANADO!!", "Muy Bien!!", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("mario1.gif"));
        }
        else{
            JOptionPane.showMessageDialog(null, "         Has perdido", "Lo siento!", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Bowser.gif"));
        }
        System.exit(0);
    }
}





