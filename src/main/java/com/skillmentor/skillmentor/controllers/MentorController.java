package com.skillmentor.skillmentor.controllers;

import com.skillmentor.skillmentor.dto.MentorDTO;
import com.skillmentor.skillmentor.entities.Mentor;
import com.skillmentor.skillmentor.services.MentorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mentors")
@RequiredArgsConstructor
@Validated
public class MentorController {

    private final MentorService mentorService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @GetMapping("{id}")
    public Mentor getMentorById(@PathVariable Long id) {
        return mentorService.getMentorById(id);
    }

    @PostMapping
    public Mentor createMentor(@Valid @RequestBody MentorDTO mentorDTO) {
        Mentor mentor = modelMapper.map(mentorDTO, Mentor.class);
        return mentorService.createNewMentor(mentor);
    }

    @PutMapping("{id}")
    public Mentor updateMentor(@PathVariable Long id, @Valid @RequestBody MentorDTO updateMentorDTO) {
        Mentor mentor = modelMapper.map(updateMentorDTO, Mentor.class);
        return mentorService.updateMentorById(id, mentor);
    }

    @DeleteMapping("{id}")
    public void deleteMentorById(@PathVariable Long id) {
        mentorService.deleteMentorById(id);
    }
}
