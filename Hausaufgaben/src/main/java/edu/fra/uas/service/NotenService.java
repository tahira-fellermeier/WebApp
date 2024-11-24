package edu.fra.uas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.fra.uas.model.Note;

@Service
public class NotenService {
    private List<Note> notenListe = new ArrayList<>();

    public void getModul(String modul) {
        for (Note note : notenListe) {
            if (note.getModul().equals(modul)) {
                System.out.println(note.getModul());
                break;
            }
        }
    }

    public double getNote(String modul) {
        double ergebnis = 0;
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                ergebnis = noten.getNote();
                break;
            }
        }
        return ergebnis;
    }

    public void updateModul(String modul, String neueModul) {
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setModul(neueModul);
                break;
            }
        }
    }

    public void updateNote(String modul, double neueNote) {
        System.out.println("setNote() aufgerufen");
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setNote(neueNote);
                break;
            }
        }
    }

    public List<Note> getNotenListe() {
        return this.notenListe;
    }

    public double getNotenDurchschnitt() {
        double summe = 0;
        for (Note note : notenListe) {
            summe += note.getNote();
        }
        return (summe / notenListe.size());

    }

    public Note addNote(String modul, double note) {
        notenListe.add(new Note(modul, note));
        return notenListe.get(notenListe.size()-1);
    }

    public void deleteNote(String modul) {
        for (Note note : notenListe) {
            if (note.getModul().equals(modul)) {
                notenListe.remove(note);
                break;
            }
        }
    }

    public boolean modulVorhanden(String modul) {
        boolean ergebnis = false;
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                ergebnis = true;
                break;
            }
        }
        return ergebnis;
    }

    public boolean checkEmptyList() {
        return notenListe.isEmpty();
    }

}
