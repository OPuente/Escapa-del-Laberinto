import java.awt.*;
import javax.swing.JPanel;
//Poner imagen de fondo
    public class JPanelConFondo extends JPanel
    {
        private Image imagen;
        
        
        public JPanelConFondo(String rutaImagen)
        {
            imagen = Toolkit.getDefaultToolkit().getImage(rutaImagen);
        }
        public void paint(Graphics g)
        {
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
