package com.skillmentor.skillmentor.controllers;

import com.skillmentor.skillmentor.dto.SubjectDTO;
import com.skillmentor.skillmentor.entities.Subject;
import com.skillmentor.skillmentor.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final ModelMapper modelMapper;
    private final SubjectService subjectService;


    @GetMapping
    public List<Subject> getAllSubjects(@RequestParam(name = "name", defaultValue = "all") String name) {
//        String result = subjects.toString();
//        System.out.println(result);
        return subjectService.getAllSubjects();
    }

//    @GetMapping("{id}")
//    public Subject getSubjectById(@PathVariable int id) {
//        System.out.println("Getting subject by id " + id);
//        return subjectService.get(id);
//    }

    @PostMapping
    public Subject createSubject(@Validated @RequestBody SubjectDTO subjectDTO) {

        // Validation to check subject name length
//        if (subject.getSubjectName().length() > 20) {
//            Subject errorSubject = new Subject();
//            errorSubject.setSubjectName("");
//            errorSubject.setDescription("");
//            return errorSubject;
//        }

        // DTO eken karanne code line godak danne nathuwa validation part eka thawa thiyenawa validation kiyanne eka part ekak witharai thawa thiyenawa

//        // Mapping Subject DTO to Subject
//        Subject subject = new Subject();
//        subject.setSubjectName(subjectDTO.getSubjectName());
//        subject.setDescription(subjectDTO.getDescription());

        // Using Model Mapper
        Subject subject = modelMapper.map(subjectDTO, Subject.class);

//        subjects.add(subject);
        return subjectService.addNewSubject(subject);
    }

//    @PutMapping("{id}")
//    public String updateSubject(@RequestBody String updatedSubject) {
//        System.out.println("PUT" + updatedSubject);
//        return "Updated subject";
//    }
//
//    @DeleteMapping("{id}")
//    public String deleteSubject(@PathVariable int id) {
//        System.out.println("DELETE");
//        subjects.remove(id);
//        return subjects.toString();
//    }
}
