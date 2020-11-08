package com.gts.skills.repository;

import java.util.List;

import com.gts.skills.model.GtsSkills;

public interface GtsSkillsDAO<T, S> {
	
	List<GtsSkills> findByName(String skill_name);

}
