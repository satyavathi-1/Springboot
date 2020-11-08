package com.gts.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gts.skills.model.GtsSkills;

public interface GtsSkillsRepository extends JpaRepository<GtsSkills, Integer>,GtsSkillsDAO<GtsSkills, String> {


}
