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

L'immagine copper-puzzle.png contiene l'immagine di qualcosa di famoso, ma l'immagine e' stata distorta. 
L'oggetto famoso e' nei valori di blu e verde, tuttavia tali valori sono stati tutti divisi per 19, 
quindi sono tutti piu' piccoli di un fattore 19. I valori di rosso sono valori casuali senza 
significato ("rumore") aggiunti per oscurare l'immagine reale. Per scoprire la seconda tappa del viaggio 
devi "disfare" le distorsioni in modo analogo a quanto fatto prima. Di che oggetto famoso si tratta? */
public class DecodeCopper {
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
                int green = color.getGreen();

                System.out.println(color.toString());
                // Modifico i colori
                blue *= 19;
                green *= 19;
                int grey = (blue + green) / 2;
                // Creo un nuovo colore con questi valori RGB
                color = new Color(grey, grey, grey);
                // Metto il nuovo colore nell'immagine in pos (x,y)
                img.set(x, y, color);

            }
        }

        // Saving the modified image
        img.save(args[1]);
        System.out.println("Done...");
    }
}