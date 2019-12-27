package mariobros;

import java.util.ArrayList;
import java.util.Arrays;

public class Scanner {

    String[] palabrasReservadas = {"<personaje>", "<nombre>", "<vida>", "<imagen>", "<x>", "<y>", "<bloque>", "<salida>", "<enemigo>", "<daño>", "<complemento>", "</personaje>", "</nombre>", "</vida>", "</imagen>", "</x>", "</y>", "</bloque>", "</salida>", "</enemigo>", "</daño>", "</complemento>"};
    String[] simbolos = {"'"};
    static ArrayList<Token> listaTokens = new ArrayList<Token>();
    static ArrayList<Errores> listaErrores = new ArrayList<Errores>();

    public Scanner(String texto) {
        this.texto = texto;
    }

    public Scanner() {
        //this.texto = texto;
    }
    String texto;
    String palabras;

    public void limpiarTexto() {
        palabras = texto;
        String textoLimpio = "";
        for (int i = 0; i < palabras.length(); i++) {
            char caracter = palabras.charAt(i);
            switch (caracter) {
                case '\r':
                case '\t':
                case '\n':
                case '\b':
                case '\f':
                    break;
                default:
                    textoLimpio += caracter;
                    break;
            }
        }

        //System.out.println(textoLimpio);
        scanner(textoLimpio);
    }

    public void scanner(String textoLimpio) {

        int indice = -1;
        String lexema = "";
        int estado = 0;
        while (indice < textoLimpio.length() - 1) {
            indice++;
            char caracter = textoLimpio.charAt(indice);
            switch (estado) {
                case 0:
                    if (Character.isWhitespace(caracter)) {

                    } else if (caracter == '<') {
                        estado = 1;
                        lexema += caracter;
                    } else if (Character.isDigit(caracter)) {
                        estado = 2;
                        lexema += caracter;
                    } else if (caracter == '"') {
                        estado = 5;
                        lexema += caracter;
                    } else if (caracter == '\'') {
                        lexema += caracter;
                        estado = 6;
                    }
                    break;
                case 1:
                    if (Character.isLetter(caracter)) {
                        lexema += caracter;
                        estado = 1;
                    } else if (Character.isDigit(caracter)) {
                        lexema += caracter;
                        estado = 1;
                    } else if (caracter == '/') {
                        lexema += caracter;
                        estado = 1;
                    } else if (caracter == '>') {
                        lexema += caracter;
                        String evaluador = lexema.toLowerCase();
                        if (Arrays.asList(palabrasReservadas).contains(evaluador)) {
                            System.out.println("Lexema "+lexema);
                            agregarToken("Token "+lexema, lexema, "Palabra Reservada");
                            lexema = "";
                            estado = 0;
                            indice--;
                        }
                    }

                    break;
                case 2:
                    if (Character.isDigit(caracter)) {
                        estado = 2;
                        lexema += caracter;
                    } else if (caracter == '.') {
                        estado = 3;
                        lexema += caracter;
                    } else {
                        estado = 0;
                        indice--;
                        System.out.println("Entero " + lexema);
                        agregarToken("Entero", lexema, "Otro");
                        lexema = "";
                    }
                    break;
                case 3:
                    if (Character.isDigit(caracter)) {
                        lexema += caracter;
                        estado = 4;
                    } else {
                        //System.out.println("Mistake");
                    }
                    break;
                case 4:
                    if (Character.isDigit(caracter)) {
                        lexema += caracter;
                        estado = 4;
                    } else {
                        estado = 0;
                        //System.out.println("Decimal " + lexema);
                        lexema = "";
                    }
                    break;
                case 5:
                    if (caracter == '"') {
                        lexema += '"';
                        estado = 0;
                        agregarToken("Cadena", lexema, "Otro");
                        lexema = "";
                    } else {
                        lexema += caracter;
                    }

                    break;
                case 6:
                    if (caracter == '\'') {
                        lexema += "'";
                        agregarToken("Ruta", lexema, "Otro");
                        lexema = "";
                        estado = 0;

                    } else {
                        lexema += caracter;
                    }

                    break;
                default:
                    listaErrores.add(new Errores(lexema));
                    estado = 0;
                    indice--;
                    lexema = "";
                    //System.out.println("Pooto te confundiste");
                    break;
            }

        }

    }

    private void agregarToken(String token, String lexema, String tipo) {
        listaTokens.add(new Token(token, lexema, tipo));
    }

    public void imprimirLista() {
        for (int i = 0; i < listaTokens.size(); i++) {
            System.out.println("Token: " + listaTokens.get(i).token + " Lexema: " + listaTokens.get(i).lexema);
        }
    }

    public void imprimirListaErrores() {
        System.out.println("Errores-------------------------");
        for (int i = 0; i < listaErrores.size(); i++) {
            System.out.println("Error: " + listaErrores.get(i).error);
        }
    }

}
