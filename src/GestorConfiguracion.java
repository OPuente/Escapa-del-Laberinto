import java.io.*;
import java.util.*;
/**
* Clase que permite leer la configuración del laberinto de un fichero .txt
*/


class GestorConfiguracion {
/** Devuelve el número de columnas del laberinto */
    private int anchuraLaberinto;
    private int alturaLaberinto;
    private int[] posicionXPerseguidor;
    private int[] posicionYPerseguidor;
    private String[] rutaImgPerseguidor;
    private  int posicionXJugador;
    private int posicionYJugador;
    private String rutaImgJugador;
    private boolean trampas[][];
    private boolean muroArriba[][];
    private boolean muroAbajo[][];
    private boolean muroIzquierda[][];
    private boolean muroDerecha[][];
    private boolean salida[][];
    private int numPerseguidores;
    
public GestorConfiguracion(String nombreFichero)
{
//Falta Codigo. Habría que abrir un fichero, obtener la configuracion y guardarla
//en variables para que los metodos puedan comprobarlas. Ahora mismo esas variables
//las ponemos nosotros (las devolvemos en los return).
    String linea;
    ArrayList<String>config = new ArrayList<String>();
        try{
            File fichero = new File(nombreFichero+".dat");
            FileReader fr=new FileReader(fichero);
            BufferedReader br=new BufferedReader(fr);
            linea=br.readLine();  
            while(linea!=null)
            {
            config.add(linea);
            linea=br.readLine();
            }
            br.close();
        }
        catch(Exception ignorada){}
        String[] datos;
        for (int i=0;i<config.size();i++){
            linea=config.get(i);
            switch (i){
                case 0:
                    datos= linea.split(" ");
                    anchuraLaberinto=Integer.parseInt(datos[0]);
                    alturaLaberinto=Integer.parseInt(datos[1]);
                    break;
                case 1:
                    numPerseguidores=Integer.parseInt(linea);
                    break;
                case 2:
                    datos= linea.split(" ");
                    posicionXPerseguidor=new int[numPerseguidores];
                    for (int j=0;j<numPerseguidores;j++){
                        posicionXPerseguidor[j]=Integer.parseInt(datos[j]);
                    }
                    break;
                case 3:
                    datos= linea.split(" ");
                    posicionYPerseguidor=new int[numPerseguidores];
                    for (int j=0;j<numPerseguidores;j++){
                        posicionYPerseguidor[j]=Integer.parseInt(datos[j]);
                    }
                    break;
                case 4:
                    datos= linea.split(" ");
                    rutaImgPerseguidor=new String[numPerseguidores];
                    for (int j=0;j<rutaImgPerseguidor.length;j++){
                        rutaImgPerseguidor[j]=datos[j];
                    }
                    break;
                case 5:
                    datos= linea.split(" ");
                    posicionXJugador=Integer.parseInt(datos[0]);
                    posicionYJugador=Integer.parseInt(datos[1]);
                    break;
                case 6:
                    rutaImgJugador=linea;
                    break;
                case 7:
                    datos= linea.split(" ");
                    trampas = new boolean[anchuraLaberinto][alturaLaberinto];
                    for (int j=0;j<datos.length;j+=2){
                        trampas[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])]=true;
                        }
                    break;
                case 8:
                    datos= linea.split(" ");
                    muroArriba = new boolean[anchuraLaberinto][alturaLaberinto];
                    muroAbajo = new boolean[anchuraLaberinto][alturaLaberinto];
                    for (int j=0;j<datos.length;j+=2){
                        muroArriba[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])]=true;
                        muroAbajo[Integer.parseInt(datos[j])-1][Integer.parseInt(datos[j+1])]=true;
                    }
                    break;
                case 9:
                    datos= linea.split(" ");
                    for (int j=0;j<datos.length;j+=2){
                        muroAbajo[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])]=true;
                        muroArriba[Integer.parseInt(datos[j])+1][Integer.parseInt(datos[j+1])]=true;
                    }
                    break;
                case 10:
                    datos= linea.split(" ");
                    muroIzquierda = new boolean[anchuraLaberinto][alturaLaberinto];
                    muroDerecha = new boolean[anchuraLaberinto][alturaLaberinto];
                    for (int j=0;j<datos.length;j+=2){
                        muroIzquierda[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])]=true;
                        muroDerecha[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])-1]=true;
                    }
                    break;
                case 11:
                    datos= linea.split(" ");
                    for (int j=0;j<datos.length;j+=2){
                        muroDerecha[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])]=true;
                        muroIzquierda[Integer.parseInt(datos[j])][Integer.parseInt(datos[j+1])+1]=true;
                    }
                    break;
                case 12:
                    datos= linea.split(" ");
                    salida = new boolean[anchuraLaberinto][alturaLaberinto];
                    salida[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])]=true;
                }
            }
                       
    for(int i=0;i<alturaLaberinto;i++) //y
    {
        for(int j=0;j<anchuraLaberinto;j++) //x
        {
            if(j==0)
                muroIzquierda[i][j]=true;
            if(j==anchuraLaberinto-1)
                muroDerecha[i][j]=true;
            if(i==0)
                muroArriba[i][j]=true;
            if(i==alturaLaberinto-1)
                muroAbajo[i][j]=true;
            
        }
    }
    
}

int getAnchuraLaberinto(){
//Falta el codigo
    return anchuraLaberinto;
}
/** Devuelve el número de filas del laberinto */
int getAlturaLaberinto(){
//Falta el codigo
    return alturaLaberinto;
}

/** Indica si la casilla situada en la fila y columna indicadas es trampa */
boolean esTrampa(int fila, int columna) {
//Falta el codigo
    return trampas[fila][columna];
}

/** Indica si la casilla situada en la fila y columna indicadas es salida */
boolean esSalida(int fila, int columna) {
//Falta el codigo
   return salida[fila][columna];
}

/**
* Indica si la casilla situada en la fila y columna indicadas
* tiene muro izquierdo
*/
boolean hayMuroIzq(int fila, int columna) {
//Falta el codigo
    return muroIzquierda[fila][columna];
}

/**
* Indica si la casilla situada en la fila y columna indicadas
* tiene muro derecho
*/
boolean hayMuroDer(int fila, int columna) {
//Falta el codigo
    return muroDerecha[fila][columna];
}

/**
* Indica si la casilla situada en la fila y columna indicadas
* tiene muro arriba
*/
boolean hayMuroArr(int fila, int columna) {
//Falta el codigo
    return muroArriba[fila][columna];
}

/**
* Indica si la casilla situada en la fila y columna indicadas
* tiene muro abajo
*/
boolean hayMuroAba(int fila, int columna) {
//Falta el codigo
    return muroAbajo[fila][columna];
}

/** Devuelve el número de perseguidores */
int getNumeroPerseguidores(){
//Falta el codigo
    return numPerseguidores;
}

/** Devuelve la posición horizontal (columna) inicial del perseguidor i */
int getPosicionXPerseguidor(int i) {
//Falta el codigo
    return posicionXPerseguidor[i];
}

/** Devuelve la posición vertical (fila) inicial del perseguidor i */
int getPosicionYPerseguidor(int i) {
//Falta el codigo
    return posicionYPerseguidor[i];
}

/** Devuelve el nombre de fichero con la imagen del perseguidor i */
String getRutaImagenPerseguidor(int i) {
//Falta el codigo
    return rutaImgPerseguidor[i];
}

/** Devuelve la posición horizontal (columna) inicial del jugador */
int getPosicionXJugador(){
//Falta el codigo
    return posicionXJugador;
}

/** Devuelve la posición vertical (fila) inicial del jugador */
int getPosicionYJugador(){
    return posicionYJugador;
//Falta el codigo
}

/** Devuelve el nombre de fichero con la imagen del jugador */
String getRutaImagenJugador(){
//Falta el codigo
    return rutaImgJugador;
}
}