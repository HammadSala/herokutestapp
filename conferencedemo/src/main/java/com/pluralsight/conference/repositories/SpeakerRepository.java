package com.pluralsight.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.conference.models.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
