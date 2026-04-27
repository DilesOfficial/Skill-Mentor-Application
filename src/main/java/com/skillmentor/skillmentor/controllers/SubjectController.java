package com.skillmentor.skillmentor.controllers;

import com.skillmentor.skillmentor.dto.SubjectDTO;
import com.skillmentor.skillmentor.entities.Subject;
import com.skillmentor.skillmentor.services.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final ModelMapper modelMapper;
    private final SubjectService subjectService;


    @GetMapping
    public List<Subject> getAllSubjects() {
//        String result = subjects.toString();
//        System.out.println(result);
        return subjectService.getAllSubjects();
    }

    @GetMapping("{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@Valid @RequestBody SubjectDTO subjectDTO) {

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
        return subjectService.addNewSubject(subjectDTO.getMentorId(), subject);
    }

    @PutMapping("{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody SubjectDTO updatedSubjectDTO) {
        Subject subject = modelMapper.map(updatedSubjectDTO, Subject.class);
        return subjectService.updateSubjectById(id, subject);
    }

    @DeleteMapping("{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
