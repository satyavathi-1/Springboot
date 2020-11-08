package com.gts.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="gts_skills")
public class GtsSkills {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="gts_skill_id")
	private Integer gts_skill_id;
	
	@Column(name="gts_skill_name" )
	private String gts_skill_name;
	
	@Column(name="gts_skill_description")
	private String gts_skill_description;
	
	@Column(name="gts_skill_status")
	private boolean gts_skill_status;
	
	public GtsSkills() {
		
	}
	
	public GtsSkills(Integer gts_skill_id) {
		super();
		this.gts_skill_id = gts_skill_id;
	}
	
	public GtsSkills(String gts_skill_name) {
		super();
		this.gts_skill_name = gts_skill_name;
	}

	public GtsSkills(Integer gts_skill_id, String gts_skill_name, String gts_skill_description,
			boolean gts_skill_status) {
		super();
		this.gts_skill_id = gts_skill_id;
		this.gts_skill_name = gts_skill_name;
		this.gts_skill_description = gts_skill_description;
		this.gts_skill_status = gts_skill_status;
	}

	public Integer getGts_skill_id() {
		return gts_skill_id;
	}

	public void setGts_skill_id(Integer gts_skill_id) {
		this.gts_skill_id = gts_skill_id;
	}

	public String getGts_skill_name() {
		return gts_skill_name;
	}

	public void setGts_skill_name(String gts_skill_name) {
		this.gts_skill_name = gts_skill_name;
	}

	public String getGts_skill_description() {
		return gts_skill_description;
	}

	public void setGts_skill_description(String gts_skill_description) {
		this.gts_skill_description = gts_skill_description;
	}

	public boolean isGts_skill_status() {
		return gts_skill_status;
	}

	public void setGts_skill_status(boolean gts_skill_status) {
		this.gts_skill_status = gts_skill_status;
	}
	
}
