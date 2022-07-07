package com.pluralsight.conference.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "sessions")
@Data
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	
	private String session_name;
	
	private String session_description;
	
	private Integer session_length;
	
	@ManyToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)

	@JoinTable(
			name = "session_speakers",
			joinColumns = @JoinColumn(name ="session_id"),
			inverseJoinColumns= @JoinColumn(name="speaker_id"))
	private List<Speaker> speakers;
	
	
	
	public Session() {
		
	}
}
