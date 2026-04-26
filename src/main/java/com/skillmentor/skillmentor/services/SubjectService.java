package com.skillmentor.skillmentor.services;

import com.skillmentor.skillmentor.entities.Subject;
import com.skillmentor.skillmentor.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final List<Subject> subjects = new ArrayList<>();

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject addNewSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}
