package mariobros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Archivo {
    public void abrirArchivo(){
        
    }
    public void guardar(JTextArea area, String archivo){
        try{
        File file = new File(archivo);
        
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            bf.write(area.getText()); 
            bf.write("\n");
            bf.close();
        }catch(Exception e){ 
            
        }
    }
    public void guardarComo(JFileChooser save,JTextArea area){
        try{
        save.setApproveButtonText("Guardar");
        save.showSaveDialog(null);
        File archivo = new File(save.getSelectedFile().toString());
        
            BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
            bf.write(area.getText()); 
            bf.write("\n"); 
            bf.close();
        }catch(Exception e){ 
            
        }
    }
    public void leerArchivo(JTextArea area, String archivo){
                String texto="";
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            while((texto=br.readLine())!=null){
                area.append(texto); 
                area.append("\n");
                
            }
            br.close();
        } catch (Exception ex) {
            //Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
