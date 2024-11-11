import java.lang.reflect.Array;
import java.util.Scanner;

public class Notendurchschnitt {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Anzahl Noten: ");
        int anzahl = scan.nextInt();
        double[] noten = new double[anzahl];

        for (int i = 0; i < anzahl; i++) {
            System.out.print((i + 1) + ". Note eingeben: ");
            double note = scan.nextDouble();
            noten[i] = note;
        }

        System.out.println("Deine Noten:");
        for (int j = 0; j < anzahl; j++) {
            System.out.println((j + 1) + ": " + noten[j]);
        }

        System.out.println("Deine Notendurchschnitt: " + berechneDurchschnitt(noten, anzahl));

    }

    public static double berechneDurchschnitt(double[] noten, int anzahl) {
        double summe = 0;
        for (int i = 0; i < anzahl; i++) {
            summe += noten[i];
        }
        return summe / anzahl;

    }

}
