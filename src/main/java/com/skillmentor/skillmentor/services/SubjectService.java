package com.skillmentor.skillmentor.services;

import com.skillmentor.skillmentor.entities.Mentor;
import com.skillmentor.skillmentor.entities.Subject;
import com.skillmentor.skillmentor.repositories.MentorRepository;
import com.skillmentor.skillmentor.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final MentorRepository mentorRepository;
    private final ModelMapper modelMapper;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll(); // SELECT * FROM subject
    }

    public Subject addNewSubject(Long mentorId, Subject subject) {
        Mentor mentor = mentorRepository.findById(mentorId).get();
        subject.setMentor(mentor);
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    public Subject updateSubjectById(Long id, Subject updatedSubject) {
        Subject subject = subjectRepository.findById(id).get();
        subject.setSubjectName(subject.getSubjectName());
        subject.setDescription(subject.getDescription());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

}
