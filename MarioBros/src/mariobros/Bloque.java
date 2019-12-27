package mariobros;

public class Bloque {
    int x=0,y=0;
    String imagen="";
    public Bloque(int x, int y, String imagen){
        this.x=x;
        this.y=y;
        this.imagen=imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
