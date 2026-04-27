package com.skillmentor.skillmentor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubjectDTO {
    @NotBlank(message = "Cannot be Null or Empty")
    private String subjectName;

    @Size(max = 100, message = "Description length should be less than 100")
    private String description;

    @NotNull
    private Long mentorId;
}
