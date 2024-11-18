package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.service.NotenService;


@Component
public class NotenController {

    @Autowired
    private NotenService notenService;

    public void changeModul(String modul, String neueModul) {
        notenService.setModul(modul, neueModul);
    }

    public void changeNote(String modul, double neueNote) {
        notenService.setNote(modul, neueNote);
    }

    public void getModul(String modul) {
        notenService.getModul(modul);
    }

    public void getNote(String modul) {
        notenService.getNote(modul);
    }

    public void notenListe() {
        notenService.getNotenListe();
    }

    public void notenDurchschnitt() {
        notenService.getNotenDurchschnitt();
    }

    public void addNote(String modul, double fach) {
        notenService.addNote(modul, fach);
    }

    public void deleteNote(String modul) {
        notenService.deleteNote(modul);
    }

    public boolean modulVorhanden(String modul) {
        return notenService.modulVorhanden(modul);
    }

    public boolean checkEmptyList() {
        return notenService.checkEmptyList();
    }
}
