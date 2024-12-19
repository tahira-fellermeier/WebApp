package edu.fra.uas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import org.springframework.stereotype.Controller;

import edu.fra.uas.model.Grade;
import edu.fra.uas.service.NotenService;

@Controller
@SchemaMapping(typeName = "Grade")
public class GradeController {

    @Autowired
    private NotenService notenService;

    @QueryMapping(name = "gradeList")
    public List<Grade> gradeList() {
        Iterable<Grade> gradeIter = notenService.getNotenListe();
        List<Grade> grades = new ArrayList<>();
        for (Grade grade : gradeIter) {
            grades.add(grade);
        }
        return grades;
    }

    @QueryMapping(name = "findGrade")
    public double findGradeByName(@Argument String modulName) {
        return notenService.getNote(modulName);
    }

    @QueryMapping(name = "gradeListSpecific")
    public List<Grade> gradeListSpecific(@Argument int count, @Argument int offset) {
        if (count < 0 || offset < 0) {
            System.out.println("Invalid count or offset values");
            return null;
        }
        Iterable<Grade> gradeIter = notenService.getNotenListe();
        List<Grade> grades = new ArrayList<>();
        for (Grade grade : gradeIter) {
            grades.add(grade);
        }

        if (count > 0) {
            return grades.stream().skip(offset).limit(count).collect(Collectors.toList());
        } else {
            return grades.stream().skip(offset).collect(Collectors.toList());
        }
    }

    // addGrade(id: Int!, modulName: String!, grade: Float!, cp: Int!) User!
    // updateGrade(id: Int!, modulName: String!, grade: Float!, cp: Int!) User!
    // deleteGrade(id: Int!): String!
    // average(modulName: String!) Float!

}
