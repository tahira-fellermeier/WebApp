package edu.fra.uas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.model.Grade;
import edu.fra.uas.service.NotenService;

@RestController
@RequestMapping("/api")
public class GradeController {

    @Autowired
    private NotenService notenService;

    @GetMapping(value = "/grades", produces = MediaType.APPLICATION_JSON_VALUE) // List of Grades
    public ResponseEntity<List<Grade>> list() {
        System.out.println("list Methode aufgerufen");
        // Grade firstGrade = notenService.addNote(1, "Statistik", 1, 5);
        // System.out.println("Statstik grade erstellt");
        List<Grade> notenListe = notenService.getNotenListe();
        if (notenListe.isEmpty()) {
            System.out.println("List is empty");
            // return ResponseEntity.noContent().build();
            return new ResponseEntity<List<Grade>>(new ArrayList<>(), HttpStatus.OK);
        }
        System.out.println("Methode abgearbeitet");
        return new ResponseEntity<List<Grade>>(notenListe, HttpStatus.OK);
    }

    @GetMapping(value = "/grades/{modulName}", produces = MediaType.APPLICATION_JSON_VALUE) // Find a specific grade using ModulName
    public ResponseEntity<?> findGrade(@PathVariable("modulName") String modulName) {
        Grade grade = notenService.getGradeObject(modulName);
        if (grade == null) {
            return new ResponseEntity<Grade>(new Grade(), HttpStatus.OK);
        }
        return new ResponseEntity<Grade>(grade, HttpStatus.OK);
    }

    public void initStatistik() { // returns a Grade-Object using ModulName
        Grade firstGrade = notenService.addNote(1, "Statistik", 1, 5);
        System.out.println("Statstik grade erstellt");
    }

    // @GetMapping("/add") // Add a Grade
    // public String showAddNoteForm(Model model) {
    // model.addAttribute("note", new Grade());
    // return "add";
    // }

    // @PostMapping("/add")
    // public String addNote(@RequestParam("id") int id,
    // @RequestParam("modulName") String modulName,
    // @RequestParam("grade") double grade,
    // @RequestParam("cp") int cp,
    // Model model) {
    // notenService.addNote(id, modulName, grade, cp);
    // model.addAttribute("message", "Note hinzugefügt ");
    // model.addAttribute("note", new Grade());
    // return "add"; //
    // }

    // @GetMapping("/delete") // Note (und zugehörige Modul) löschen
    // public String showDeleteNoteForm(Model model) {
    // return "delete";
    // }

    // @PostMapping("/delete")
    // public String deleteNote(@RequestParam("modul") String modul, Model model) {
    // boolean isDeleted = notenService.deleteNote(modul);
    // if (isDeleted) {
    // model.addAttribute("message", "Note für Modul '" + modul + "' wurde
    // erfolgreich gelöscht.");
    // } else {
    // model.addAttribute("message", "Keine Note gefunden für Modul '" + modul +
    // "'.");
    // }
    // return "delete";
    // }

}
