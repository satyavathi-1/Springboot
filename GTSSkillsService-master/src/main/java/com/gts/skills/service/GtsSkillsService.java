package com.gts.skills.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gts.skills.model.GtsSkills;
import com.gts.skills.repository.GtsSkillsRepository;

@Service
public class GtsSkillsService{

	@Autowired
	private GtsSkillsRepository gtsSkillsRepository;	

	public List<GtsSkills> getAllGtsSkills() {
		List<GtsSkills> gtsSkills = new ArrayList<>();
		gtsSkillsRepository.findAll().forEach(gtsSkills::add);
		return gtsSkills;
	}

	public Optional<GtsSkills> getGtsSkills(int id) {
		return gtsSkillsRepository.findById(id);
	}
	
	public List<GtsSkills> findByName(String skill_name) {
        
		return gtsSkillsRepository.findByName(skill_name);

	}

	public String addGtsSkills(GtsSkills gtsSkills) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsSkillsRepository.save(gtsSkills);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Skill created successfully");
			jsonObject.put("status_code", HttpStatus.CREATED.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();

	}

	public String updateGtsSkills(GtsSkills gtsSkills) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsSkillsRepository.save(gtsSkills);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Skill updated successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public String deleteGtsSkills(int id) {

		JSONObject jsonObject = new JSONObject();
		try {
			gtsSkillsRepository.deleteById(id);
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Skill deleted successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public String deleteAllGtsSkills() {
		
		JSONObject jsonObject = new JSONObject();
		try {
			gtsSkillsRepository.deleteAll();
			jsonObject.put("success", Boolean.TRUE);
			jsonObject.put("message", "Skill deleted successfully");
			jsonObject.put("status_code", HttpStatus.OK.value());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
}
