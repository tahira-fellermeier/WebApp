package edu.fra.uas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.fra.uas.Note;

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

    public void getNote(String modul) {
        for (Note noten : notenListe) {
            if (noten.getModul() == (modul)) {
                System.out.println(noten.getNote());
                break;
            }
        }
    }

    public void setModul(String modul, String neueModul) {
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setModul(neueModul);
                break;
            }
        }
    }

    public void setNote(String modul, double neueNote) {
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setNote(neueNote);
                break;
            }
        }
    }

    public List<Note> getNotenListe() {
        /*int i = 1;
        System.out.println("Ihre Noten: ");
        for (Noten note : notenListe) {
            System.out.print(i + ". ");
            System.out.println(note.toString());
            ;
            i++;
        }*/
        return this.notenListe;
    }

    public void getNotenDurchschnitt() {
        double summe = 0;
        for (Note note : notenListe) {
            summe += note.getNote();
        }
        double durchschnitt = summe / notenListe.size();
        System.out.println("Ihr Notendurchschnitt: " + durchschnitt);
    }

    public void addNote(String modul, double note) {
        notenListe.add(new Note(modul, note));
        for (Note noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                System.out.println("Neue Note hinzugefügt: " + noten.toString());
                break;
            }
        }
    }

    public void deleteNote(String modul) {
        for (Note note : notenListe) {
            if (note.getModul().equals(modul)) {
                System.out.println("Note gelöscht: " + note.toString());
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

