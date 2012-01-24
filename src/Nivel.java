import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Nivel extends JFrame{
        
        JRadioButton lvl1,lvl2,lvl3;
        JPanelConFondo gral;
        JPanel botones;
        Laberinto lab;
        
        public  Nivel(){
            gral = new JPanelConFondo("Laberinto.gif");
            botones = new JPanel();
            lvl1 = new JRadioButton("Nivel 1");
            lvl2 = new JRadioButton("Nivel 2");
            lvl3 = new JRadioButton("Nivel 3");
                                         
            OyenteAccion oyente = new OyenteAccion();
            lvl1.addItemListener(oyente);
            lvl2.addItemListener(oyente);
            lvl3.addItemListener(oyente);
            
            gral.setLayout(new BorderLayout());

            botones.setLayout(new GridLayout(3,1));
            botones.add(lvl1);
            lvl1.setOpaque(false);
            lvl1.setForeground(Color.white);
            botones.add(lvl2);
            lvl2.setOpaque(false);
            lvl2.setForeground(Color.white);
            botones.add(lvl3);
            lvl3.setOpaque(false);
            lvl3.setForeground(Color.white);
            gral.add(botones, BorderLayout.WEST);
            botones.setOpaque(false);
            add(gral);
                        
            setTitle("E L I G E  N I V E L");
            setSize(290,190);
            setResizable(false);
            setLocationRelativeTo(null);
            setIconImage(Toolkit.getDefaultToolkit().getImage("raziel.gif"));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

 public class OyenteAccion implements ItemListener{
        public void itemStateChanged(ItemEvent e) {
            if (lvl1.isSelected()){
                lab = new Laberinto("Laberinto","configuracion");
            }
            else if(lvl2.isSelected()){
                lab = new Laberinto("Laberinto","configuracion2");
            }
            else if (lvl3.isSelected()){
                lab = new Laberinto("Laberinto","configuracion3");
            }
            lab.setIconImage(Toolkit.getDefaultToolkit().getImage("raziel.gif"));
            lab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lab.setLocationRelativeTo(null);
            lab.setVisible(true);
            lvl1.getTopLevelAncestor().setVisible(false);
        }
 }
}