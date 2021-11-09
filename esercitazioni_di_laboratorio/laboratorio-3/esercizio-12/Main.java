/*
Implementate un programma MyRectangleTester.java per testare le funzionalita' della vostra classe. 
Create uno o piu' oggetti MyRectangle, invocate i metodi e ispezionate i risultati stampando in output 
i valori delle variabili d'istanza (attraverso i metodi di accesso o attraverso il metodo toString()).
*/
public class Main {
    public static void main(String args[]){
        MyRectangle myRectangle = new MyRectangle(0, 0, 2, 4);
	System.out.println("myRectangle data:");
	System.out.println(myRectangle.toString());
	MyRectangle myRectangle2 = new MyRectangle(1, 1, 6, 9);
	System.out.println("myRectangle2 data:");
	System.out.println(myRectangle.toString());
    }
}
