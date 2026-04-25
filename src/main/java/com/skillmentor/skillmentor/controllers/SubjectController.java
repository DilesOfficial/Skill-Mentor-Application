package com.skillmentor.skillmentor.controllers;

import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subjects")
public class SubjectController {

    // Path Parameter
    // Query Parameter -> ?name=jon

    // Mock Database
    private final List<String> subjects = new ArrayList<>((
            List.of("Maths", "Science", "History")
    ));

    @GetMapping
    public String getAllSubjects(@RequestParam(name = "name", defaultValue = "all") String name) {
        String result = subjects.toString();
        System.out.println(result);
        return result;
    }

    @GetMapping("{id}")
    public String getSubjectById(@PathVariable int id) {
        System.out.println("Getting subject by id " + id);
        return subjects.get(id);
    }

    @PostMapping
    public String createSubject(@RequestBody String subject) {
        System.out.println("POST");
        subjects.add(subject);
        return "Created subject";
    }

    @PutMapping("{id}")
    public String updateSubject(@RequestBody String updatedSubject) {
        System.out.println("PUT" + updatedSubject);
        return "Updated subject";
    }

    @DeleteMapping("{id}")
    public String deleteSubject(@PathVariable int id) {
        System.out.println("DELETE");
        subjects.remove(id);
        return subjects.toString();
    }
}
