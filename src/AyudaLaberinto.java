
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class AyudaLaberinto extends JFrame{
        JButton volver;
        JTextArea areaTexto;
        JScrollPane scroll;
        public  AyudaLaberinto(){
            volver = new JButton ("Volver");
            areaTexto = new JTextArea(27,26);
            scroll= new JScrollPane(areaTexto);
            JPanel gral = new JPanel();

            add(gral);

            gral.add(scroll,BorderLayout.NORTH);
            gral.add(volver,BorderLayout.SOUTH);

            OyenteAccion oyente = new OyenteAccion();
            volver.addActionListener(oyente);

            setTitle("Ayuda");
            setSize(345,520);
            setFocusable(true);
            setResizable(false);
            setIconImage(Toolkit.getDefaultToolkit().getImage("raziel.gif"));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            VentanaAyuda();
            areaTexto.setEditable(false);

            setVisible(true);
        }

 public void VentanaAyuda(){

     try{
        File fichero = new File("Instrucciones.txt");
        FileReader fr=new FileReader(fichero);
        BufferedReader br=new BufferedReader(fr);
        String linea=br.readLine();

        while(linea!=null){
            areaTexto.append(linea+"\n");
            linea=br.readLine();
        }
        br.close();
        }
    catch(Exception ignorada){}
 }

 class OyenteAccion implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
}
}
 }