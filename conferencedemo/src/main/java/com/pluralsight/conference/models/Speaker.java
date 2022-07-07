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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "speakers")
@Data
@NoArgsConstructor
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speaker_id;
	private String first_name;
	private String last_name;
	private String title;
	private String company;
	private String speaker_bio;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] speaker_photo;
//	
//	@ManyToMany(mappedBy ="speakers",fetch = FetchType.EAGER)
//	private List<Session> sessions;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	@JoinTable(name = "speaker_session", joinColumns = @JoinColumn(name = "speaker_id"), inverseJoinColumns = @JoinColumn(name = "session_id"))
	private List<Session> sessions;
	

}
