/*
Provate a costruire una classe MyRectangle che simuli il comportamente della classe Rectangle vista a 
lezione (usiamo solo interi per semplicita'). Prevedete che siano presenti 4 variabili d'istanza: due 
per le coordinate x,y e due per larghezza e altezza.

Implementate un costruttore:

public MyRectangle(int posX, int posY, int w, int h);

Implementate i metodi di accesso:

public int getX();

public int getY();

public int getWidth();

public int getHeight();

Implementate i metodi modificatori:

public void resize(double mult); // ridimensiona il rettangolo della quantita' mult (es. se mult=2 le dimensioni raddoppiano, se multi=0.5 si dimezzano);
public void translate(int dx, int dy); //"sposta" il rettangolo in posizione x+dx e y+dy


Implementate il metodo per stampare l'oggetto MyRectangle descrivendone lo stato

public String toString(); // restituisce una stringa che descrive il rettangolo attraverso i valori di x, y, larghezza e altezza (es: "Rettangolo: x=10, y=30, w=50, h=20")
*/
public class MyRectangle {
    private int posX, posY, width, height;

    public MyRectangle(int posX, int posY, int w, int h) {
        this.posX = posX;
        this.posY = posY;
        this.width = w;
        this.height = h;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void resize(double mult) {
        width *= mult;
        height *= mult;
    }

    public void translate(int dx, int dy) {
        posX += dx;
        posY += dy;
    }

    public String toString() {
        return "posX: " + posX + " posY: " + posY + "\nwidth: " + width + " height: " + height;
    }
}
