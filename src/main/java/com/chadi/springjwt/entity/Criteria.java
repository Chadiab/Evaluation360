package com.chadi.springjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Transactional
@Table
public class Criteria {

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
    private String criteriaName;
}
