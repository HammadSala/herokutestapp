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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conference.models.Session;
import com.pluralsight.conference.models.Speaker;
import com.pluralsight.conference.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
	
	@Autowired
	private  SpeakerRepository speakerRepository;
	
	@GetMapping
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Optional<Speaker> get(@PathVariable Long id) {
		return speakerRepository.findById(id);
	}
	
	@PostMapping
	public Speaker create(@RequestBody Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		speakerRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker oldSpeaker= speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, oldSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(oldSpeaker);
	}

}
