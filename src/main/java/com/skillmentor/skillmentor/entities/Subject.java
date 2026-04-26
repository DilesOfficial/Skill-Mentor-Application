package com.skillmentor.skillmentor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;
    private String description;

    // Get all getters in one annotation using lombok @Getter
    // Set all setters in one annotation using lombok @Setter
    // Get and Set both in one annotation using lombok @Data
    // Add defualt constructor in one annotation using lombok @NoArgsConstructor
    // Add parameterized constructor in one annotation using lombok @AllArgsConstructor

}
