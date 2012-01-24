import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class IntroLaberinto extends JFrame{
 
    JButton inicio,botonAyuda,salir;
    JMenuItem inicia,sal,itemAyuda,acerca;
    Nivel lvl;
        
    public IntroLaberinto(String titulo) {
        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenu ayuda = new JMenu("Ayuda");
        inicia = new JMenuItem("Iniciar");
        sal = new JMenuItem("Salir");
        itemAyuda = new JMenuItem("Ayuda");
        acerca = new JMenuItem("Acerca de");
        inicio=new JButton (new ImageIcon ("inicio.jpg"));
        salir=new JButton (new ImageIcon ("salir.png"));
        botonAyuda=new JButton (new ImageIcon("ayuda.png"));
                
        JPanelConFondo principal = new JPanelConFondo("Laberinto.jpg");
        principal.setLayout(new BorderLayout());
        JPanel botones = new JPanel();
                    
        setJMenuBar(barra);
        barra.add(archivo);
        barra.add(ayuda);
        archivo.add(inicia);
        archivo.add(sal);
        ayuda.add(itemAyuda);
        ayuda.add(acerca);

        Dimension d = new Dimension(40,40);
        botones.setOpaque(false);
        salir.setPreferredSize(d);
        botonAyuda.setPreferredSize(d);
        inicio.setPreferredSize(new Dimension(34,60));
        botones.add(inicio);
        botones.add(salir);
        botones.add(botonAyuda);
        principal.add(botones, BorderLayout.SOUTH);
                
        add(principal);

       //EVENTOS
       OyenteAccion oyente = new OyenteAccion();
       inicio.addActionListener(oyente);
       salir.addActionListener(oyente);
       botonAyuda.addActionListener(oyente);
       inicia.addActionListener(oyente);
       sal.addActionListener(oyente);
       itemAyuda.addActionListener(oyente);
       acerca.addActionListener(oyente);
               
        setTitle(titulo);
        setFocusable(true);
        setResizable(false);
   }
  
    class OyenteAccion implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton boton = new JButton();
            JMenuItem item = new JMenuItem();
             if(e.getSource().getClass().equals(boton.getClass())){
                boton= (JButton) e.getSource();
            }
            else{
                item= (JMenuItem) e.getSource();
            }
            if (boton.equals(inicio) || item.equals(inicia)){
                lvl = new Nivel();
                inicio.getTopLevelAncestor().setVisible(false);
                
            }
            if (boton.equals(botonAyuda) || item.equals(itemAyuda)){
                AyudaLaberinto v2 = new AyudaLaberinto();
                v2.setLocationRelativeTo(null);
            }
                    else if (item.equals(acerca)){
                        JOptionPane.showMessageDialog(null,"Escapa del Laberinto 1.0 Beta 3\nCreado por: Oscar Puente","Acerca de",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("raziel2.jpg"));
                    }
                        else if (boton.equals(salir) || item.equals(sal)){
                            int confirmado = JOptionPane.showConfirmDialog(null,"Realmente desea salir?","Salir",JOptionPane.YES_NO_OPTION,0,new ImageIcon("para.png"));
                                if (JOptionPane.OK_OPTION==confirmado)
                                    System.exit(0);
                        }
               }
}
}
