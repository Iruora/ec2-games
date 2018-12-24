package com.atn.demo.mvc.module.Internalisation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.atn.commons.persistence.jpa.BaseDaoJpa;
import com.atn.demo.mvc.module.Internalisation.entity.Internalisation;

@Component
public class InternalisationDaoJpa extends BaseDaoJpa<Internalisation, Long> implements InternalisationDao{

	public InternalisationDaoJpa() {
		super(Internalisation.class);
		
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Cacheable("message")
	public String getMessage(String messageKey, String language) throws NoResultException {
		String queryText = "SELECT m.text FROM Internalisation m ,Langue l WHERE m.messageKey='" + messageKey
				+ "' AND l.id =m.langue.id " + " and l.langueLibelle = '" + language + "'";
		String result = entityManager.createQuery(queryText, String.class).getSingleResult();

		return result;
	}

	@Override
	public List<Internalisation> findMessagesByCriteria(String value) {
		String queryText = "SELECT m FROM Internalisation m  WHERE m.messageKey='" + value + "' or m.text='" + value
				+ "' and m.deletingDate=NULL";
		List<Internalisation> result = entityManager.createQuery(queryText, Internalisation.class).getResultList();
		return result;
	}

	@Override
	public List<Internalisation> getMessages(String messageKey) {
		String queryText = "SELECT m FROM Message m WHERE m.messageKey='" + messageKey + "'";
		List<Internalisation> result = entityManager.createQuery(queryText,Internalisation.class).getResultList();
		return result;
	}


}
