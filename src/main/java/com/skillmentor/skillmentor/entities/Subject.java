package com.skillmentor.skillmentor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "subject_name", length = 20)
    private String subjectName;

    @Column(nullable = false)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    // Get all getters in one annotation using lombok @Getter
    // Set all setters in one annotation using lombok @Setter
    // Get and Set both in one annotation using lombok @Data
    // Add defualt constructor in one annotation using lombok @NoArgsConstructor
    // Add parameterized constructor in one annotation using lombok @AllArgsConstructor

}
