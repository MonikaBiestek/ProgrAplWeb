package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.company.enroller.controllers.participants;
import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;

@Component("participantService")
public class ParticipantService {
	Session session;
	public ParticipantService() {
		session = DatabaseConnector.getInstance().getSession();
	}

	public Collection<Participant> getAll() {
		return session.createCriteria(Participant.class).list();
	}

	public Participant findByLogin(String login) {
		return (Participant) session.get(Participant.class, login);
	}

	public Participant add(Participant participant) {
		Transaction transaction = this.session.beginTransaction();
		session.save(participant);
		transaction.commit();
		return participant;
	}
	
	
	public void  delete(Participant participant) {
		Transaction transaction = this.session.beginTransaction();
		session.delete(participant);
		transaction.commit();
	}
	
	
	
	
	

}
