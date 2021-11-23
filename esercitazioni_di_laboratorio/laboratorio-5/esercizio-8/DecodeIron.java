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

L'immagine iron-puzzle.png contiene l'immagine di qualcosa di famoso, ma l'immagine e' stata distorta.
L'oggetto famoso e' nei valori di rosso, tuttavia i valori di rosso sono stati tutti divisi per 10, 
quindi sono tutti piu' piccoli di un fattore 10. I valori di blue e verde sono valori casuali senza 
significato ("rumore") aggiunti per oscurare l'immagine reale. Il tuo compito e' "disfare" tutte queste 
distorsioni per rivelare l'immagine reale e scoprire la prima tappa del viaggio di zia Bettina. 
Innanzitutto metti tutti i valori di blu e verde a 0, per eliminarli. Guarda il risultato... se guardi 
bene puoi gia' vedere la vera immagine, anche se e' molto scura. Quindi moltiplica ogni valore di 
rosso per 10 ripristinandolo al valore originale. Di che oggetto famoso si tratta? */
public class DecodeIron {
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
            int red = color.getRed();

            System.out.println(color.toString());
            // Modifico i colori
            red *= 10;

            // Creo un nuovo colore con questi valori RGB
            color = new Color(red, red, red);
            // Metto il nuovo colore nell'immagine in pos (x,y)
            img.set(x, y, color);

         }
      }

      // Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");
   }
}