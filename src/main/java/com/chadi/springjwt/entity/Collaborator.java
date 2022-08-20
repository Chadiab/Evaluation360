package com.chadi.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Collaborator {
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
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String avatar;
	public String code;
	@ManyToMany(fetch = EAGER)
	private Collection<Role> roles = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "collaborator")
	private Collection<Evaluation> evaluations = new ArrayList<>() ;

	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private Collection<SelectedCollaborator> selectedCollaborators = new ArrayList<>() ;

	@JsonIgnore
	@OneToMany(mappedBy = "collaborator")
	private Collection<EvaluationRequest> requests = new ArrayList<>() ;



	public Collaborator(String username, String password, String firstName, String lastName, String avatar, String code) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.code =code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Collection<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
}

