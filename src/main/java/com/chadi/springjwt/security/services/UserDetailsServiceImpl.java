package com.chadi.springjwt.security.services;

import com.chadi.springjwt.entity.Collaborator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadi.springjwt.repository.CollaboratorRepository;

@Service
@RequiredArgsConstructor //lambok will inject the repos for us
@Transactional
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	CollaboratorRepository collaboratorRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collaborator collaborator = collaboratorRepository.findByUsername(username);
		if(collaborator == null){
			log.error("User not found in the db");
			throw new UsernameNotFoundException("User not found in the db");
		}else{
			log.info("User found in the db : {}",username);
		}

		return UserDetailsImpl.build(collaborator);
	}

}
