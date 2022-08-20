package com.chadi.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
public class Evaluation {


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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="evaluationForm_id")
    private EvaluationForm evaluationForm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator;

}
