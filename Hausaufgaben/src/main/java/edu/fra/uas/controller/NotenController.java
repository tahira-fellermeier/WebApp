package edu.fra.uas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noten")
public class NotenController {

    @Autowired
    private NotenService notenService;

    @GetMapping // Noten
    public String mainPage() {
        return "main";
    }

    @GetMapping("/list") // noten/list
    public String getNotenListe(Model model) {
        List<Note> notenListe = notenService.getNotenListe();
        if (notenListe.isEmpty()) {
            model.addAttribute("message", "Noch keine Noten vorhanden");
        }
        model.addAttribute("notes", notenListe);
        return "list";
    }


     @GetMapping("add")
     public String showAddNoteForm(Model model) {
         model.addAttribute("note", new Note());
         return "add";
     }
 
     @PostMapping("add")
     public String addNote(@RequestParam("modul") String modul, 
                           @RequestParam("note") double note, 
                           Model model) {
         notenService.addNote(modul, note);
         model.addAttribute("message", "Note hinzugefügt: " + modul + " mit Note: " + note);
         model.addAttribute("note", new Note());
         return "add"; // Return the same view with a success message
     }

}

/*
 * 
 * "Bitte wählen Sie eine Aktion: \n1. Note eintragen\n2. bestehende Note ändern\n3. bestehende Modulname ändern\n4. Note (und zugehörige Modul) löschen\n5. Notenliste ausgeben\n6. Notendurchschnitt berechnen\n7. Note für ein bestimmtes Modul ansehen\n8. Programme beenden"
 * );
 * int auswahl = scan.nextInt();
 * List<Note> notenListe = new ArrayList<>();
 * 
 * 
 * 
 * case 2: // Bestehende Note verändern
 * System.out.print("Modulname eintragen: ");
 * modul = scan.next();
 * if (notenService.modulVorhanden(modul)) {
 * System.out.println("Alte " + modul + " Note: " +
 * notenService.getNote(modul));
 * System.out.println("Neue Note eintragen: ");
 * double neueNote = scan.nextDouble();
 * notenService.setNote(modul, neueNote);
 * System.out.println("Neue " + modul + " Note: " +
 * notenService.getNote(modul));
 * ;
 * } else
 * System.out.println("Modul \"" + modul + "\" nicht vorhanden");
 * break;
 * 
 * case 3: // Bestehende Modulname ändern
 * System.out.print("Bisherige Modulname eintragen: ");
 * modul = scan.next();
 * if (notenService.modulVorhanden(modul)) {
 * System.out.println("Neue Modulname eintragen: ");
 * String neueModul = scan.next();
 * notenService.setModul(modul, neueModul);
 * System.out.println("\"" + modul + "\" wurde in \"" + neueModul +
 * "\" geändert");
 * ;
 * } else
 * System.out.println("Modul \"" + modul + "\" nicht vorhanden");
 * break;
 * 
 * case 4: // Note (und zugehörige Modul) löschen
 * System.out.print("Modulname eingeben, die Sie löschen möchten: ");
 * modul = scan.next();
 * if (notenService.modulVorhanden(modul)) {
 * double deletedNote = notenService.getNote(modul);
 * notenService.deleteNote(modul);
 * System.out.println("Note gelöscht: " + modul + " " + deletedNote);
 * } else
 * System.out.println("Modul \"" + modul + "\" nicht vorhanden");
 * break;
 * 
 * case 6: // Notendurchschnitt berechnen
 * if (notenService.checkEmptyList()) {
 * System.out.println("Keine Noten vorhanden");
 * } else
 * System.out.println("Ihr Durchschnitt: " +
 * notenService.getNotenDurchschnitt());
 * break;
 * 
 * case 7: // Note für ein bestimmtes Modul ansehen
 * System.out.print("Modulname eingeben: ");
 * modul = scan.next();
 * if (notenService.modulVorhanden(modul)) {
 * System.out.println(modul + ": " + notenService.getNote(modul));
 * } else
 * System.out.println("Note \"" + modul + "\" nicht vorhanden");
 * break;
 * 
 * case 8: // Programme beenden
 * run = false;
 * System.out.println("Programme beendet");
 * break;
 * 
 * default:
 * System.out.println("Ungültige eingabe");
 * break;
 * }
 * 
 * System.out.println("");
 * 
 * }
 * scan.close();
 * }
 */
