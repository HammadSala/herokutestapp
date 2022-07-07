package com.pluralsight.conference.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.conference.models.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {



}
