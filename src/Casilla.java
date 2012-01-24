import java.awt.*;
import javax.swing.*;

class Casilla extends JLabel{
final int GROSOR_MURO = 4;
int posX;
int posY;
boolean esTrampa = false;
boolean esSalida = false;
boolean muroArriba = false;
boolean muroAbajo = false;
boolean muroIzda = false;
boolean muroDcha = false;
String imgsrc = "fondo.gif";
Casilla(int f, int c, boolean esTrampa, boolean esSalida, boolean
muroIzq, boolean muroDer, boolean muroArr, boolean muroAba) {
super();
this.posX = c;
this.posY = f;
this.esTrampa = esTrampa;
this.esSalida = esSalida;
this.muroIzda = muroIzq;
this.muroDcha = muroDer;
this.muroArriba = muroArr;
this.muroAbajo = muroAba;
// Poner bordes, dependiendo de los muros
setBorder(BorderFactory.createMatteBorder
((muroArriba ? GROSOR_MURO : 0), // arriba
(muroIzda ? GROSOR_MURO : 0), // izquierda
(muroAbajo ? GROSOR_MURO : 0), // abajo
(muroDcha ? GROSOR_MURO : 0), // derecha
Color.RED // color
));
// Seleccionar la imagen dependiendo del tipo de casilla
if (esTrampa) imgsrc = "trampa.jpg";
if (esSalida) imgsrc = "salida.gif";
// ***** COMPLETAR: dibujar la imagen en el componente *****
setIcon(new ImageIcon(imgsrc));
}
/**
* Indica si hay muro en la casilla,
* en la posición indicada por parámetro
*/
boolean hayMuro(int orientacion) {
boolean hayMuro=false;
switch (orientacion) {
case Laberinto.ARRIBA:
hayMuro = muroArriba;
break;
case Laberinto.ABAJO:
hayMuro = muroAbajo;
break;
case Laberinto.IZDA:
hayMuro = muroIzda;
break;
case Laberinto.DCHA:
hayMuro = muroDcha;
break;
}
return hayMuro;
}
/**
* Elimina el personaje que había en la casilla
* Para ello, simplemente vuelve a poner la imagen de la casilla
* (con lo que desaparece la del personaje)
*/
void quitarPersonaje() { // ***** COMPLETAR MÉTODO *****
// Pone la imagen de la casilla
    setIcon(new ImageIcon(imgsrc));
}
/**
* Sitúa en la casilla al personaje que se pasa como parámetro
*/
void ponerPersonaje(Personaje personaje) {// ***** COMPLETAR MÉTODO *****
// Cambiar la imagen de la casilla por la del personaje
// Comunicar al personaje si ha caído en una casilla activa
// (trampa o salida), invocando a los métodos adecuados.
    setIcon(new ImageIcon(personaje.imgsrc));
    if (esTrampa){
        personaje.caeEnTrampa();
    }
    else if (esSalida){
        personaje.caeEnSalida();
    }
    
}
}

