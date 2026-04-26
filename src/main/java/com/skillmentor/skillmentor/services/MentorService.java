package com.skillmentor.skillmentor.services;

import com.skillmentor.skillmentor.entities.Mentor;
import com.skillmentor.skillmentor.repositories.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorService {

    private final MentorRepository mentorRepository;
    private final ModelMapper modelMapper;

    public Mentor createNewMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id).get();
    }

    public Mentor updateMentorById(Long id, Mentor updatedMentor) {
        Mentor mentor = mentorRepository.findById(id).get();
        modelMapper.map(updatedMentor, mentor);
        return mentorRepository.save(mentor);
    }

    public void deleteMentorById(Long id) {
        mentorRepository.deleteById(id);
    }
}
