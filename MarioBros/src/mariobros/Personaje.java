package mariobros;

public class Personaje {
    String nombre="",imagen="";
    int vida=0,x=0,y=0;
    
    public Personaje(String nombre, int vida, String imagen, int x, int y){
        this.imagen=imagen;
        this.nombre=nombre;
        this.vida=vida;
        this.x=x;
        this.y=y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
