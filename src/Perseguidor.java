import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Perseguidor extends Personaje {
    int tiempoEspera;    // número de turnos sin mover (cuando está en trampa)

    Perseguidor(int posX, int posY, String rutaImg) {
        super(posX, posY, rutaImg);
        tiempoEspera = 0;
    }

    /**
     * Mueve al perseguidor, siguiendo las siguientes normas:
     *
     * 1º intenta acercarse al jugador en horizontal
     * Si no puede (porque hay un muro) o ya está en la misma columna que el
     * jugador, intenta moverse en vertical.
     * Si no puede moverse tampoco en vertical (porque haya un muro),
     * pasa su turno.
     *
     * No es "inteligente", es decir, no intenta evitar las trampas,
     * ni los muros...
     *
     * El método debe comprobar si se ha alcanzado al protagonista,
     * en cuyo caso se invoca al método finalizarJuego.
     *
     * Si está en una trampa, pasa el turno sin mover,
     * simplemente disminuye el tiempo de espera
     */
    void mover(Jugador mario, Casilla[][] laberinto) {

//      ***** COMPLETAR *****
        boolean puede;

        if (tiempoEspera > 0) {
            tiempoEspera--;
        }
        else{
            for (int i = 0; (i < 2)  && (tiempoEspera<=0); i++) {
                puede = false;
                if (mario.posX < posX) {
                    puede = mover1casilla(Laberinto.IZDA, laberinto);
                } else if (mario.posX > posX) {
                    puede = mover1casilla(Laberinto.DCHA, laberinto);
                }
                if (!puede) {
                    if (mario.posY < posY) {
                        mover1casilla(Laberinto.ARRIBA, laberinto);
                    } else if (mario.posY > posY) {
                        mover1casilla(Laberinto.ABAJO, laberinto);
                    }
                }

                if ((mario.posX == posX) && (mario.posY == posY)) {
                    mario.finalizarJuego(false);
                }
            }
        }
    }

    void caeEnTrampa() {
        tiempoEspera = Laberinto.TIEMPO_TRAMPA;
    }
}
