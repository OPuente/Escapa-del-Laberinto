abstract class Personaje {
    int posX; // columna en la que está
    int posY; // fila en la que está
    public String imgsrc;
    Personaje(int x, int y, String imgSrc) {
        posX = x;
        posY = y;
        imgsrc = imgSrc;
    }
    
    int getPosX() {
        return posX;
    }
    
    int getPosY() {
        return posY;
    }

    boolean mover1casilla(int direccion, Casilla[][] laberinto) {
        
        boolean puedeMover = !(laberinto[posY][posX].hayMuro(direccion));
        if (puedeMover) {
            laberinto[posY][posX].quitarPersonaje();
            switch (direccion) {
                case Laberinto.ARRIBA:
                    posY--;
                    break;
                case Laberinto.ABAJO:
                    posY++;
                    break;
                case Laberinto.IZDA:
                    posX--;
                    break;
                case Laberinto.DCHA:
                    posX++;
                    break;
            }
            laberinto[posY][posX].ponerPersonaje(this);
        }
        return puedeMover;
    }
    
    /** Caer en trampa tiene distintos efectos según el tipo de personaje */
    abstract void caeEnTrampa();
    
    /** Sólo hace algo si es el jugador */
    void caeEnSalida() {};
}

