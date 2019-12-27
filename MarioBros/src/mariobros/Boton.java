
package mariobros;

public class Boton extends javax.swing.JLabel{
    public Boton(int x,int y,int ancho,int largo){
        this.setBounds(x,y,ancho,largo); 
        this.setToolTipText(x+","+y); 
        //this.setEnabled(false);
        //this.setBorderPainted(false);
    } 
}
