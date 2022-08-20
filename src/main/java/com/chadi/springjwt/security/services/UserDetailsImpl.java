package com.chadi.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chadi.springjwt.entity.Collaborator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private String avatar;

	private String code;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;




	public UserDetailsImpl(Long id, String username, String firstName, String lastName, String avatar, String code, String password, List<GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.code = code;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Collaborator collaborator) {
		List<GrantedAuthority> authorities = collaborator.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				collaborator.getId(),
				collaborator.getUsername(),
				collaborator.getFirstName(),
				collaborator.getLastName(),
				collaborator.getAvatar(),
				collaborator.getCode(),
				collaborator.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
