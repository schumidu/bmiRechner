package bmiRechner;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean berechnen = false;
		double gewicht = 0;
		double groesse = 0;
		double bmi = 0;
		boolean tryAndError = false;
		do {
			// einlesen von K�rpergewicht bis g�ltige eingabe
			do {
				System.out.println("Gebe dein K�rpergewicht in kg ein: ");
				try {
				gewicht = sc.nextDouble();
				tryAndError = false;
				}catch(Exception e) {
					System.out.println("Versuche es erneut. Fehlerhafte eingabe!");
					tryAndError = true;
					//Im Fehlerfall StdIn leerlesen
					sc.nextLine();
				}
			}while(tryAndError);

			// einlesen von K�rpergr��e bis g�ltige eingabe
			do {
				System.out.println("Gebe deine K�rpergr��e in m an:");
				try {
					groesse = sc.nextDouble();
					tryAndError = false;
				}catch(Exception e) {
					System.out.println("Versuche es erneut. Fehlerhafte eingabe!");
					tryAndError = true;
					//Im Fehlerfall StdIn leer lesen
					sc.nextLine();
				}
			}while(tryAndError);

			// ergebnis ausgeben + Beurteilung
			bmi = Application.calcBMI(gewicht, groesse);
			
			if(bmi < 15) {
				System.out.println("Sehr ernsthaftes Untergewicht");
			}else if(bmi < 16){
				System.out.println("Ernsthaftes Untergewicht");
			}else if(bmi < 18.5){
				System.out.println("Untergewicht");
			}else if(bmi < 25){
				System.out.println("Normalgewicht");
			}else if(bmi < 30) {
				System.out.println("�bergewicht");
			}else if(bmi < 35) {
				System.out.println("�bergewicht Klasse 1");
			}else if(bmi < 40) {
				System.out.println("�bergewicht Klasse 2");
			}else {
				System.out.println("�bergewicht Klasse 3");
			}

			// nochmal berechnen lassen?
			do {
				System.out.println("M�chtest du nochmal eine Berechnung durchf�hren? \ny - Ja\nn - Nein");
				try {					
				char c = sc.nextLine().charAt(0);
				if(c == 'n') {
					berechnen = false;
					break;
				}else if(c == 'y') {
					berechnen = true;
					break;
				}else {
					throw new Exception();
				}
				}catch(Exception e) {
					System.out.println("Fehler bein eingabe. Erneut eingeben");
					tryAndError = true;
					sc.nextLine();
				}
				
			}while(tryAndError);

		} while (berechnen);
		sc.close();

	}

	public static double calcBMI(double kg, double m) {
		return kg / (m * m);
	}
}
