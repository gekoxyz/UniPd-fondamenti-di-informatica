import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci 3 stringhe");
		System.out.println("Stringa 1: ");
		String s1 = scan.next();
		System.out.println("Stringa 2: ");
		String s2 = scan.next();
		System.out.println("Stringa 3: ");
		String s3 = scan.next();
		scan.close();
		if (s1.compareTo(s2) < 0) {
			// se 1 prima di 2 1-2
			if (s3.compareTo(s1) < 0) {
				// se 3 prima di 1 3-1-2
				// order = 312
				System.out.println(s3);
				System.out.println(s1);
				System.out.println(s2);
			} else {
				// se 3 dopo 1 1-2?3
				if (s2.compareTo(s3) < 0) {
					// order = 123
					System.out.println(s1);
					System.out.println(s2);
					System.out.println(s3);
				} else {
					// order = 132
					System.out.println(s1);
					System.out.println(s3);
					System.out.println(s2);
				}
			}
		} else {
			// se 2 prima di 1 2-1
			if (s3.compareTo(s2) < 0) {
				// se 3 prima di 2 3-2-1
				// order = 321
				System.out.println(s3);
				System.out.println(s2);
				System.out.println(s1);
			} else {
				// se 3 dopo 2 2-1?3
				if (s1.compareTo(s3) < 0) {
					// se 1 prima di 3
					// order = 213
					System.out.println(s2);
					System.out.println(s1);
					System.out.println(s3);
				} else {
					// se 3 prima di 1
					// order = 231
					System.out.println(s2);
					System.out.println(s3);
					System.out.println(s1);
				}
			}
		}

	}
}
