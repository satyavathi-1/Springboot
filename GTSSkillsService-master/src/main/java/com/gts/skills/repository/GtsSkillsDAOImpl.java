package com.gts.skills.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gts.skills.model.GtsSkills;

@Repository
@Transactional
public class GtsSkillsDAOImpl implements GtsSkillsDAO<GtsSkills, String> {

	@Autowired
	 EntityManager entityManager;
	    
	@Override
	public List<GtsSkills> findByName(String skillName) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query<GtsSkills> query=currentSession.createQuery("FROM GtsSkills where gts_skill_name = :skillName",GtsSkills.class);
		
		query.setParameter("skillName", skillName);
		
		return query.getResultList();
		
	}
}


