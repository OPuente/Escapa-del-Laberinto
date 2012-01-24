import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Laberinto extends  JFrame { 
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZDA = 2;
    public static final int DCHA = 3;
    public static int ANCHURA_VENTANA = 300;
    public static int ALTURA_VENTANA = 300;
    public static int TIEMPO_TRAMPA = 3;
    JButton[] controles;
    Casilla[][] laberinto;
    Jugador mario;
    Perseguidor[] bowser;
    GestorConfiguracion gestor;
    JPanelConFondo panelCentral;
    JPanel panelPrincipal;
        
    public Laberinto(String titulo, String nivel) {
        super(titulo);
        gestor = new GestorConfiguracion(nivel);
        crearLaberinto();
        crearControles();
        colocarElementosGraficos();
    }
    /**
     * Inicializa los datos del laberinto,
     * marcando adecuadamente las casillas con trampas y/o muros
     */
    public void crearLaberinto() { // ***** COMPLETAR MÉTODO *****
// Inicializar el tablero de casillas
        panelCentral = new JPanelConFondo("fondogrande.jpg");
        panelCentral.setLayout(new GridLayout(gestor.getAnchuraLaberinto(),gestor.getAlturaLaberinto()));// poner GridLayout
// Crear cada casilla con las características adecuadas
        //Bucle para crear todas las casillas
        laberinto = new Casilla[gestor.getAlturaLaberinto()][gestor.getAnchuraLaberinto()];
        for(int i=0;i<gestor.getAlturaLaberinto();i++) //y
        {
            for(int j=0;j<gestor.getAnchuraLaberinto();j++) //x                
            {
                laberinto[i][j]=new Casilla(i,j,gestor.esTrampa(i,j),gestor.esSalida(i,j),
                        gestor.hayMuroIzq(i,j),gestor.hayMuroDer(i,j),gestor.hayMuroArr(i,j),
                        gestor.hayMuroAba(i,j));
                panelCentral.add(laberinto[i][j]);
            }
        }
// Crear los perseguidores y ponerlos en el laberinto
        bowser = new Perseguidor[gestor.getNumeroPerseguidores()];
        for(int i=0; i<gestor.getNumeroPerseguidores();i++){
            bowser [i] = new Perseguidor (gestor.getPosicionXPerseguidor(i),gestor.getPosicionYPerseguidor(i),gestor.getRutaImagenPerseguidor(i));
            laberinto[bowser[i].posX][bowser[i].posY].ponerPersonaje(bowser[i]);
        }

// Crear el jugador y ponerlo en el laberinto
        mario = new Jugador(gestor.getPosicionXJugador(),gestor.getPosicionYJugador(),gestor.getRutaImagenJugador());
        laberinto[mario.posX][mario.posY].ponerPersonaje(mario);
    }
    
    /** Prepara los botones que controlan el movimiento del jugador */
    
    void crearControles() {  
    // Crear botones
        controles= new JButton[4];
        controles[IZDA]= new JButton(new ImageIcon("left.png"));
         controles[DCHA]= new JButton(new ImageIcon("right.png"));
         controles[ARRIBA]= new JButton(new ImageIcon("up.png"));
         controles[ABAJO]= new JButton(new ImageIcon("down.png"));
    // Preparar oyente
        OyenteAccion oyente=new OyenteAccion();
        controles[ABAJO].addActionListener(oyente);
        controles[ARRIBA].addActionListener(oyente);
        controles[IZDA].addActionListener(oyente);
        controles[DCHA].addActionListener(oyente);
        
    }
    /** Sitúa los componentes gráficos en la ventana */
    void colocarElementosGraficos() { 
        
        // Paneles
        panelPrincipal=new JPanel();        
        panelPrincipal.setLayout(new BorderLayout()); 
        
        
        // Añadir los componentes a los paneles
        panelPrincipal.add(controles[IZDA], BorderLayout.WEST);
        panelPrincipal.add(controles[DCHA], BorderLayout.EAST);
        panelPrincipal.add(controles[ARRIBA], BorderLayout.NORTH);
        panelPrincipal.add(controles[ABAJO], BorderLayout.SOUTH);
        panelPrincipal.add(panelCentral);
        
        add(panelPrincipal);
        pack();
    }
        
     class OyenteAccion implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             //Accion que debe hacer cuando se pulse el raton
          if(e.getSource() == controles[ARRIBA])
          {
              //codigo cuando se pulsa arriba
              mario.mover1casilla(ARRIBA,laberinto);
          }
          else if(e.getSource() == controles[ABAJO])
          {
              //codigo cuando se pulsa abajo
              mario.mover1casilla(ABAJO,laberinto);
          }else if(e.getSource() == controles[IZDA])
          {
              mario.mover1casilla(IZDA,laberinto);
              //codigo cuando se pulsa izquierda
          }
          else
          {
              mario.mover1casilla(DCHA,laberinto);
              //codigo cuando se pulsa derecha
          }
          for(int i=0; i<bowser.length;i++){
              bowser[i].mover(mario,laberinto);
          }
         }
     }
}

