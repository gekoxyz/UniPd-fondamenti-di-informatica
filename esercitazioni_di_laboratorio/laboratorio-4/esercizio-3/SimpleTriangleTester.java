public class SimpleTriangleTester {
    public SimpleTriangleTester() {
    }

    public void checkTriangle(int n1, int n2, int n3) {
        int max = Math.max(n1, Math.max(n2, n3));
        int min = Math.min(n1, Math.min(n2, n3));
        int med = n1 + n2 + n3 - max - min;
        if (max < med + min) {
            // catalogazione per lato
            if (max == med && med == min) {
                System.out.println("Il triangolo e` equilatero");
            } else {
                if (max == med || med == min) {
                    System.out.print("Il triangolo e` isoscele");
                } else {
                    System.out.print("Il triangolo e` scaleno");
                }
                // catalogazione per angolo
                if (max * max - min * min - med * med > 0) {
                    System.out.println(" ottusangolo");
                } else if (max * max - min * min - med * med == 0) {
                    System.out.println(" rettangolo");
                } else if (max * max - min * min - med * med < 0) {
                    System.out.println(" acutangolo");
                }
            }
        } else {
            System.err.println("Il triangolo non e` valido");
        }
    }
}
