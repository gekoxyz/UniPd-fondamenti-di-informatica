import java.util.Scanner;

public class Main {

    /**
     * Method to compute how many tiles with pattern b|g|w|g|b|g|w|g|b (black, grey,
     * white) can there be on the wall (pattern must start and end with black)
     * 
     * @param totalWidth
     * @param tileWidth
     * @return tiles number minus exceeding tiles if there are any
     */
    public static int countTiles(double totalWidth, double tileWidth) {
        int tilesNumber = (int) (totalWidth / tileWidth);
        int exceedingTiles = (tilesNumber - 1) % 4;
        // if there are no exceeding tiles i can use that number, else i need to remove
        // the offset from the tiles that could fit in the space
        return tilesNumber - exceedingTiles;
    }

    /**
     * Method to compute remaining gap on the wall
     * 
     * @param totalWidth
     * @param tileWidth
     * @param tilesNumber
     * @return the remaining gap between wall and tiles
     */
    public static double computeGap(double totalWidth, double tileWidth, int tilesNumber) {
        return totalWidth - (tilesNumber * tileWidth);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("insert wall total width");
        double totalWidth = scan.nextDouble();
        System.out.println("insert tile width");
        double tileWidth = scan.nextDouble();
        scan.close();

        int tilesNumber = countTiles(totalWidth, tileWidth);
        double gapSize = computeGap(totalWidth, tileWidth, tilesNumber);

        System.out.println("You are going to need " + tilesNumber + " tiles and there will be a gap of " + gapSize);
    }
}