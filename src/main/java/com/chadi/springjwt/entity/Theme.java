package com.chadi.springjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Transactional
@Table
public class Theme {
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
    private String themeName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "theme_criteria",
            joinColumns = @JoinColumn(name = "theme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "criteria_id", referencedColumnName = "id"))
    private Collection<Criteria> criterias = new ArrayList<>();
}
