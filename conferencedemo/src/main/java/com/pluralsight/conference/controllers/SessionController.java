package com.pluralsight.conference.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conference.models.Session;
import com.pluralsight.conference.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping
	public List<Session> list() {
		return sessionRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Optional<Session> get(@PathVariable Long id) {
		return sessionRepository.findById(id);
	}
	
	@PostMapping
	public Session create(@RequestBody Session session ) {
		return sessionRepository.saveAndFlush(session);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session oldSession= sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, oldSession, "session_id");
		return sessionRepository.saveAndFlush(oldSession);
	}
	
	
	
	

}
