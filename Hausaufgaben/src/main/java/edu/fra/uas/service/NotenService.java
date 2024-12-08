package edu.fra.uas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.fra.uas.model.Grade;

@Service
public class NotenService {
    private List<Grade> notenListe = new ArrayList<>();

    public void getModul(String modulName) {
        for (Grade note : notenListe) {
            if (note.getModulName().equals(modulName)) {
                System.out.println(note.getModulName());
                break;
            }
        }
    }

    public double getNote(String modulName) {
        double ergebnis = 0;
        for (Grade noten : notenListe) {
            if (noten.getModulName().equals(modulName)) {
                ergebnis = noten.getGrade();
                break;
            }
        }
        return ergebnis;
    }

    public void updateModul(String modulName, String neueModulName) {
        for (Grade noten : notenListe) {
            if (noten.getModulName().equals(modulName)) {
                noten.setModulName(neueModulName);
                break;
            }
        }
    }

    public void updateNote(String modulName, double neueNote) {
        System.out.println("setNote() aufgerufen");
        for (Grade noten : notenListe) {
            if (noten.getModulName().equals(modulName)) {
                noten.setGrade(neueNote);
                break;
            }
        }
    }

    public List<Grade> getNotenListe() {
        return this.notenListe;
    }

    public double getNotenDurchschnitt() {
        double summe = 0;
        for (Grade note : notenListe) {
            summe += note.getGrade();
        }
        return (summe / notenListe.size());

    }

    public Grade addNote(int id, String modulName, double grade, int cp) {
        notenListe.add(new Grade(id, modulName, grade, cp));
        return notenListe.get(notenListe.size() - 1);
    }

    public Grade getGradeObject(String modulName) {
        Grade grade = null;
        for (Grade note : notenListe) {
            if (note.getModulName().equals(modulName)) {
                grade = note;
                break;
            }
        }
        return grade;
    }

    public boolean deleteNote(String modulName) {
        boolean ergebnis = false;
        for (Grade note : notenListe) {
            if (note.getModulName().equals(modulName)) {
                notenListe.remove(note);
                ergebnis = true;
                break;
            }
        }
        return ergebnis;
    }

    public boolean modulVorhanden(String modulName) {
        boolean ergebnis = false;
        for (Grade noten : notenListe) {
            if (noten.getModulName().equals(modulName)) {
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
