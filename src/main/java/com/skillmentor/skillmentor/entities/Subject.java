package com.skillmentor.skillmentor.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "subject_name", length = 20)
    private String subjectName;

    @Column(nullable = false)
    private String description;

    // --------- Relationship -------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    @JsonIgnore
    private Mentor mentor;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}

    // Get all getters in one annotation using lombok @Getter
    // Set all setters in one annotation using lombok @Setter
    // Get and Set both in one annotation using lombok @Data
    // Add defualt constructor in one annotation using lombok @NoArgsConstructor
    // Add parameterized constructor in one annotation using lombok @AllArgsConstructor

