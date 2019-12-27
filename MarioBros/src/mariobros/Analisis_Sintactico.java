package mariobros;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Analisis_Sintactico {

    static Salida salida;
    static Personaje personaje;
    static ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    static ArrayList<Token> listaTokens = new ArrayList<Token>();
    static ArrayList<Bloque> listaBloques = new ArrayList<Bloque>();
    static ArrayList<Complemento> listaComplementos = new ArrayList<Complemento>();
    int indice = 0;
    String nombre = "";
    int vida = 0;
    int posX = 0;
    int posY = 0;
    int danio = 0;
    String imagen = "";
    Token preanalisis;
    

    public Analisis_Sintactico(ArrayList<Token> listaTokens) {
        this.listaTokens = listaTokens;
        listaTokens.add(new Token("Ultimo", "", ""));
        preanalisis = listaTokens.get(0);

    }

    public void print() {
        System.out.println("-----------------------------------");
        System.out.println("************ Listado 2 ************");
        for (int i = 0; i < listaTokens.size(); i++) {
            System.out.println("Token: " + listaTokens.get(i).token + " Lexema: " + listaTokens.get(i).lexema);
        }

    }

    public void S() {
        if (preanalisis.token.equals("Token <personaje>")) {
            match(preanalisis.token.toString());
            personaje();
            if (preanalisis.token.equals("Token </personaje>")) {
                System.out.println("Personaje: "+nombre+" "+vida+" "+imagen+" "+posX+" "+posY);
                personaje = new Personaje(nombre, vida, imagen, posX, posY);
                match(preanalisis.token.toString());
                S();
            } else {
                errorSintactico(preanalisis);
            }
        } else if (preanalisis.token.equals("Token <bloque>")) {
            match(preanalisis.token.toString());
            bloque();
            if (preanalisis.token.equals("Token </bloque>")) {
                listaBloques.add(new Bloque(posX, posY, imagen));
                match(preanalisis.token.toString());
                S();
            } else {
                errorSintactico(preanalisis);
            }
        } else if (preanalisis.token.equals("Token <enemigo>")) {
            match(preanalisis.token.toString());
            enemigo();
            if (preanalisis.token.equals("Token </enemigo>")) {
                listaEnemigos.add(new Enemigo(nombre, imagen, posX, posY, danio));
                match(preanalisis.token.toString());
                S();
            } else {
                errorSintactico(preanalisis);
            }
        } else if (preanalisis.token.equals("Token <complemento>")) {
            match(preanalisis.token.toString());
            complemento();
            if (preanalisis.token.equals("Token </complemento>")) {
                listaComplementos.add(new Complemento(nombre, imagen, vida, posX, posY));
                match(preanalisis.token.toString());
                S();
            } else {
                errorSintactico(preanalisis);
            }
        } else if (preanalisis.token.equals("Token <salida>")) {
            match(preanalisis.token.toString());
            salida();
            if (preanalisis.token.equals("Token </salida>")) {
                salida = new Salida(imagen, posX, posY);
                match(preanalisis.token.toString());
                S();
            } else {
                errorSintactico(preanalisis);
            }
        }
    }

    private void personaje() {
        if (preanalisis.token.equals("Token <nombre>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Cadena")) {
                nombre = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </nombre>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
           errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Cadena")) {
//                nombre = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            }
        }
        if (preanalisis.token.equals("Token <vida>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                vida = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </vida>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                vida = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </vida>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </vida>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            }
        }
        if (preanalisis.token.equals("Token <imagen>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Ruta")) {
                imagen = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </imagen>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Ruta")) {
//                imagen = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <x>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posY = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </x>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posY = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <y>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posX = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posX = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
    }

    private void errorSintactico(Token token) {
        System.out.println("Se esperaba " + token.token.toString());
        indice++;
        preanalisis = listaTokens.get(indice);
        System.out.println("Entero: " + token.lexema);

    }

    private void match(String token) {
        if (!preanalisis.tipo.equals("Ultimo")) {
            indice++;
            preanalisis = listaTokens.get(indice);
        }
    }

    private void bloque() {
        if (preanalisis.token.equals("Token <x>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posY = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </x>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posY = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <y>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posX = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }                
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posX = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//            }            
        }
        if (preanalisis.token.equals("Token <imagen>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Ruta")) {
                imagen = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </imagen>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Ruta")) {
//                imagen = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
    }

    private void enemigo() {
        if (preanalisis.token.equals("Token <nombre>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Cadena")) {
                nombre = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </nombre>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Cadena")) {
//                nombre = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <imagen>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Ruta")) {
                imagen = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </imagen>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Ruta")) {
//                imagen = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <x>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posY = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </x>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posY = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <y>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posX = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posX = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <daño>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                danio = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </daño>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                danio = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </daño>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </daño>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }

    }

    private void complemento() {
        if (preanalisis.token.equals("Token <nombre>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Cadena")) {
                nombre = preanalisis.lexema;
                nombre = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </nombre>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Cadena")) {
//                nombre = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </nombre>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <imagen>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Ruta")) {
                imagen = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </imagen>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Ruta")) {
//                imagen = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <vida>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                vida = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </vida>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                vida = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </vida>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </vida>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }

        if (preanalisis.token.equals("Token <x>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posY = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </x>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posY = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <y>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posX = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posX = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
       }

    }

    private void salida() {
        if (preanalisis.token.equals("Token <x>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posY = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </x>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posY = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </x>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.token.equals("Token <y>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Entero")) {
                posX = Integer.parseInt(preanalisis.lexema);
                match(preanalisis.token.toString());
                if (preanalisis.token.equals("Token </y>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Entero")) {
//                posX = Integer.parseInt(preanalisis.lexema);
//                match(preanalisis.token.toString());
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.token.equals("Token </y>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
        if (preanalisis.lexema.equals("<imagen>")) {
            match(preanalisis.token.toString());
            if (preanalisis.token.equals("Ruta")) {
                imagen = preanalisis.lexema;
                match(preanalisis.token.toString());
                if (preanalisis.lexema.equals("</imagen>")) {
                    match(preanalisis.token.toString());
                } else {
                    errorSintactico(preanalisis);
                }
            } else {
                errorSintactico(preanalisis);
            }
        } else {
            errorSintactico(preanalisis);
//            if (preanalisis.token.equals("Ruta")) {
//                imagen = preanalisis.lexema;
//                match(preanalisis.token.toString());
//                if (preanalisis.lexema.equals("</imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }
//            } else {
//                errorSintactico(preanalisis);
//                if (preanalisis.lexema.equals("</imagen>")) {
//                    match(preanalisis.token.toString());
//                } else {
//                    errorSintactico(preanalisis);
//                }                
//            }            
        }
    }

//    void imprimirPersonaje() {
//        System.out.println("----------Personaje---------------");
//        System.out.println("Personaje: " + personaje.nombre + " " + personaje.imagen);
//
//    }

    void imprimiEnemigo() {
        System.out.println("----------Enemigos---------------");
        for (int i = 0; i < listaEnemigos.size(); i++) {
            System.out.println("Enemigo: " + listaEnemigos.get(i).nombre + " " + listaEnemigos.get(i).imagen);
        }
    }

    void imprimirBloques() {
        System.out.println("----------Bloques---------------");
        for (int i = 0; i < listaBloques.size(); i++) {
            System.out.println("Bloque " + listaBloques.get(i).imagen + " " + listaBloques.get(i).x);
        }
    }

//    void imprimirSalida() {
//        System.out.println("----------Salida---------------");
//        System.out.println("Salida " + salida.imagen + " " + salida.posX);
//    }

    void imprimirComplemento() {
        System.out.println("----------Complemento---------------");
        for (Complemento complemento : listaComplementos) {
            System.out.println("Complemento: " + complemento.imagen + " " + complemento.nombre);
        }
    }

}
