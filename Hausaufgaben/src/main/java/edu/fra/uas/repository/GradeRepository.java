package edu.fra.uas.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import edu.fra.uas.model.Grade;

@Repository
public class GradeRepository extends HashMap<Long, Grade> {

}
