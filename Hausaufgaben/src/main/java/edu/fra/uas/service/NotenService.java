package edu.fra.uas.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.fra.uas.Noten;

@Service
public class NotenService {
    private ArrayList<Noten> notenListe = new ArrayList<>();

    public void getModul(String modul) {
        for (Noten note : notenListe) {
            if (note.getModul().equals(modul)) {
                System.out.println(note.getModul());
                break;
            }
        }
    }

    public void getNote(double note) {
        for (Noten noten : notenListe) {
            if (noten.getNote() == (note)) {
                System.out.println(noten.getNote());
                break;
            }
        }
    }

    public void setModul(String modul, String neueModul) {
        for (Noten noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setModul(neueModul);
                break;
            }
        }
    }

    public void setNote(String modul, double neueNote) {
        for (Noten noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                noten.setNote(neueNote);
                break;
            }
        }
    }

    public void getNotenListe() {
        int i = 1;
        System.out.println("Ihre Noten: ");
        for (Noten note : notenListe) {
            System.out.print(i + ". ");
            System.out.println(note.toString());
            ;
            i++;
        }
    }

    public void getNotenDurchschnitt() {
        double summe = 0;
        for (Noten note : notenListe) {
            summe += note.getNote();
        }
        double durchschnitt = summe / notenListe.size();
        System.out.println("Ihr Notendurchschnitt: " + durchschnitt);
    }

    public void addNote(String modul, double note) {
        notenListe.add(new Noten(modul, note));
        for (Noten noten : notenListe) {
            if (noten.getModul().equals(modul)) {
                System.out.println("Neue Note hinzugefügt: " + noten.toString());
                break;
            }
        }
    }

    public void deleteNote(String modul) {
        for (Noten note : notenListe) {
            if (note.getModul().equals(modul)) {
                System.out.println("Note gelöscht: " + note.toString());
                notenListe.remove(note);
                break;
            }
        }
    }

    public boolean modulVorhanden(String modul) {
        boolean ergebnis = false;
        for (Noten noten : notenListe) {
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
