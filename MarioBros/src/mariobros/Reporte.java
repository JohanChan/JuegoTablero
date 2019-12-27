package mariobros;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Reporte {
    public void reporteTokens(ArrayList<Token> lista){
        System.out.println("Tam "+lista.size());
                File archivo = new File("ReporteTokens.html");
        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
                pw.write("<!Doctype>");
                pw.write("<html>");
                pw.write("<head lan=es>");
                    pw.write("<meta charset=UTF8>");
                    pw.write("<title>"+"Reporte de Tokens"+"</title>");
                pw.write("</head>"); 
                pw.write("<body>");
                pw.write("<h2 align=center>REPORTE DE TOKENS</h2>"); 
                pw.write("<center>");
                    pw.write("<table border = "+"2px"+" >");
                        pw.write("<thead>");
                        pw.write("<tr>");
                            pw.write("<td>"+"TOKEN"+"</td>");
                            pw.write("<td>"+"LEXEMA"+"</td>");
                            pw.write("<td>"+"TIPO"+"</td>");
                        pw.write("</tr>");
                        pw.write("</thead>");
                        for (Token token:lista) {
                            pw.write("<tr>"); 
                            pw.write("<td>"+token.token+"</td>");
                            pw.write("<td>"+token.lexema+"</td>");
                            pw.write("<td>"+token.tipo+"</td>");
                        }
                        pw.write("</tr>");
                    pw.write("</table>");
                    pw.write("</center>");
                pw.write("</body>");
            pw.write("</html>");
            pw.close();
            bw.close();
            openFile(archivo);
            
        }catch(IOException e){
            
        }
           
    }
    public void openFile(File archivo){
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(archivo);
        } catch (IOException ex) {

        }
    }
    public void reporteErrores(ArrayList<Errores> lista){
                System.out.println("Tam "+lista.size());
                File archivo = new File("ReporteTokens.html");
        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
                pw.write("<!Doctype>");
                pw.write("<html>");
                pw.write("<head lan=es>");
                    pw.write("<meta charset=UTF8>");
                    pw.write("<title>"+"Reporte de Errores"+"</title>");
                pw.write("</head>"); 
                pw.write("<body>");
                pw.write("<h2 align=center>REPORTE DE ERRORES</h2>"); 
                pw.write("<center>");
                    pw.write("<table border = "+"2px"+" >");
                        pw.write("<thead>");
                        pw.write("<tr>");
                            pw.write("<td>"+"TOKEN"+"</td>");
                            pw.write("<td>"+"LEXEMA"+"</td>");
                            pw.write("<td>"+"TIPO"+"</td>");
                        pw.write("</tr>");
                        pw.write("</thead>");
                        for (Errores error:lista) {
                            pw.write("<tr>"); 
                            pw.write("<td>"+error.error+"</td>");
                            pw.write("<td>"+error.error+"</td>");
                            pw.write("<td>DESCONOCIDO</td>");
                        }
                        pw.write("</tr>");
                    pw.write("</table>");
                    pw.write("</center>");
                pw.write("</body>");
            pw.write("</html>");
            pw.close();
            bw.close();
            openFile(archivo);
            
        }catch(IOException e){
            
        }
    }    
}
