package com.chadi.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
public class SelectedCollaborator {
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
    private Long id;

    private String selectedCollaboratorUsername;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="manager_id")
    private Collaborator manager;

}
