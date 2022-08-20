package com.chadi.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class EvaluationForm {

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

    private long id;
    private String formName;
    private String createdAt;
    private String targetCollaborator;

    @JsonIgnore
    @OneToMany(mappedBy = "evaluationForm")
    private Collection<Evaluation> evaluations = new ArrayList<>() ;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "form_theme",
            joinColumns = @JoinColumn(name = "form_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id", referencedColumnName = "id"))
    private Collection<Theme> themes = new ArrayList<>();

}
