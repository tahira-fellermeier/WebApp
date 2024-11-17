package main.java.edu.fra.uas;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.controller.NotenController;
import service.NotenService;
import edu.fra.uas.Noten;

@SpringBootApplication
public class NotenDurchschnittApplication {

    @Autowired
    private NotenController notenController;

    public static void main(String[] args) {
        SpringApplication.run(NotenDurchschnittApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Scanner scan = new Scanner(System.in);
                String modul;
                double note;
                boolean run = true;

                while (run) {
                    System.out.print(
                            "Bitte wählen Sie eine Aktion: \n1. Note eintragen\n2. Note ändern\n3. Modulname ändern\n4. Note (und Modul) löschen\n5. Notenliste ausgeben\n6. Notendurchschnitt berechnen\7.Modul aussuchen\n8. Programme beenden");
                    int auswahl = scan.nextInt();

                    switch (auswahl) {
                        case 1:
                            System.out.print("Modulname eintragen: ");
                            modul = scan.next();
                            System.out.print("Note eintragen: ");
                            note = scan.nextDouble();
                            notenController.addNote(modul, note);
                            break;

                        case 2:
                            System.out.print("Modulname eintragen: ");
                            modul = scan.next();
                            if (notenController.noteVorhanden(modul)) {
                                System.out.println("Neue Note eintragen: ");
                                double neueNote = scan.nextDouble();
                                notenController.changeNote(modul, neueNote);
                            } else
                                System.out.println("Modul \"" + modul + "\" nicht vorhanden");
                            break;

                        case 3:
                            System.out.print("Bisherige Modulname eintragen: ");
                            modul = scan.next();
                            if (notenController.noteVorhanden(modul)) {
                                System.out.println("Neue Modulname eintragen: ");
                                String neueModul = scan.next();
                                notenController.changeModul(modul, neueModul);
                            } else
                                System.out.println("Modul \"" + modul + "\" nicht vorhanden");
                            break;

                        case 4:
                            System.out.print("Modulname eingeben, die Sie löschen möchten: ");
                            modul = scan.next();
                            if (notenController.modulVorhanden(modul)) {
                                notenController.deleteNote(modul);
                            } else
                                System.out.println("Modul \"" + modul + "\" nicht vorhanden");
                            break;

                        case 5:
                            if (notenController.checkEmptyList()) {
                                System.out.println("Keine Noten vorhanden");
                            } else
                            notenController.notenListe();
                            break;
                        case 6:
                            if (notenController.checkEmptyList()) {
                                System.out.println("Keine Noten vorhanden");
                            } else
                                notenController.notenDurchschnitt();
                            break;
                        case 7:
                            System.out.print("Modulname eingeben: ");
                            modul = scan.next();
                            if (notenController.modulVorhanden(modul)) {
                                notenController.getNote(modul);
                            } else
                                System.out.println("Note \"" + modul + "\" nicht vorhanden");
                            break;

                        case 8:
                            run = false;
                            System.out.println("Programme beendet");
                            break;
                            scan.close();

                        default:
                            System.out.println("Ungültige eingabe");
                            break;
                    }
                }
                
            }

        };
        return action;
    }
}
