import java.awt.Color;
import java.io.IOException;

/* Usare costruttore e metodi della classe SimpleImage
   (fate riferimento alla classe per la descrizione):

public SimpleImage(String filename)
public int height() 
public int width() 
public Color get(int i, int j) 
public void set(int i, int j, Color c)

e i metodi della classe color
public int getRed()
public int getGreen()
public int getBlue()
e il costruttore Color(int r, int g, int b)

L'immagine west-puzzle.png contiene l'immagine di qualcosa di famoso, ma l'immagine e' stata distorta. 
L'oggetto famoso e' nei valori di blu, mentre i valori di rosso e verdi sono rumore casuale. Per scoprire 
l'ultima tappa del viaggio di zia Bettina, oltre a rimuovere il rumore dovrai operare come segue: se 
il valore blu e' minore di  16, moltiplicalo per 16 per farlo tornare al suo valore originale. Se invece 
il suo valore e' 16 o piu', allora e' rumore e deve essere messo a 0. Di che oggetto famoso si tratta?
*/
public class DecodeWest {
    public static void main(String args[]) throws IOException {

        if (args.length != 2) {
            System.out.println("Usage: java DecodeImage inputFileName outputFileName");
            System.exit(0);
        }

        SimpleImage img = new SimpleImage(args[0]);

        for (int y = 0; y < img.height(); y++) {
            for (int x = 0; x < img.width(); x++) {
                Color color = img.get(x, y);

                // Acquisisco i singoli colori e li salvo in varibili int
                int blue = color.getBlue();

                System.out.println(color.toString());
                // Modifico i colori
                blue < 16 ? blue*= 16: blue = 0;
                // Creo un nuovo colore con questi valori RGB
                color = new Color(blue, blue, blue);
                // Metto il nuovo colore nell'immagine in pos (x,y)
                img.set(x, y, color);

            }
        }

        // Saving the modified image
        img.save(args[1]);
        System.out.println("Done...");
    }
}