package mariobros;

public class Enemigo {
    String nombre="";
    String imagen="";
    int posX;
    int posY;
    int danio;
    public Enemigo(String nombre,String imagen, int posX,int posY,int danio){
        this.imagen=imagen;
        this.danio=danio;
        this.nombre=nombre;
        this.posX=posX;
        this.posY=posY;
    }
        
}
