package com.chadi.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class EvaluationRequest {

    @Id //primary key
    @SequenceGenerator(
            name = "evaluation_sequence",
            sequenceName = "collaborator_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY, //we tell how to generate this information of primary key.
            generator = "evaluation_sequence"
    )

    @Column(nullable = false, updatable = false)
    private Long id;
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator;


}
