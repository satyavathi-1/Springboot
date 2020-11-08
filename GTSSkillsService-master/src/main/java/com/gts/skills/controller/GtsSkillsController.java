package com.gts.skills.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gts.skills.exception.ApplicationException;
import com.gts.skills.exception.SkillNotFoundException;
import com.gts.skills.model.GtsSkills;
import com.gts.skills.service.GtsSkillsService;

@RestController
@RequestMapping(value="api/v1/skills")
public class GtsSkillsController {
	
	@Autowired
	private GtsSkillsService gtsSkillsService;
	
	@GetMapping
	public ResponseEntity<List<GtsSkills>> getAll() {
		return new ResponseEntity<>(gtsSkillsService.getAllGtsSkills(),HttpStatus.OK);
	}
	
	@GetMapping("/skill_id")
	public ResponseEntity<GtsSkills> searchById(@RequestParam int skillId) {
		Optional<GtsSkills> gtsSkillId= gtsSkillsService.getGtsSkills(skillId);
		if(!gtsSkillId.isPresent()) {
			throw new SkillNotFoundException("Skill Id not found ");
			}
		return new ResponseEntity<>(gtsSkillId.get(), HttpStatus.OK);

	}
	
	@GetMapping("/skill_name")
	public ResponseEntity<List<GtsSkills>> searchByName(@RequestParam String skillName) {
		
		List<GtsSkills> gtsSkillName= gtsSkillsService.findByName(skillName);
		if(gtsSkillName.isEmpty()) {
			throw new SkillNotFoundException("Skill Name not found ");
			}
		
		return new ResponseEntity<>(gtsSkillsService.findByName(skillName), HttpStatus.OK);		
	}

	@PostMapping
	public ResponseEntity<String> addGtsSkills(@RequestBody GtsSkills gtsSkill) {
		
		if(gtsSkill.getGts_skill_id() != null) {
			throw new ApplicationException("Skill id found, ID is not required to add the data ");
		}
		
		if(gtsSkill.getGts_skill_name() == "" || gtsSkill.getGts_skill_name() == null ) {
			throw new ApplicationException("Skill Name should not be empty ");
		}
		
		return new ResponseEntity<>(gtsSkillsService.addGtsSkills(gtsSkill), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<String> editGtsSkills(@RequestBody GtsSkills gtsSkills){
		
		if(gtsSkills.getGts_skill_id() == null) {
			throw new ApplicationException("Skill id not found, ID is required for update the data ");
		
		} 
		
		Optional<GtsSkills> gtsSkill= gtsSkillsService.getGtsSkills(gtsSkills.getGts_skill_id());
		
		if(!gtsSkill.isPresent()) {
			throw new SkillNotFoundException("Skill Id not found you can't update data ");
		}
		
		
		if(gtsSkills.getGts_skill_name() == "" || gtsSkills.getGts_skill_name() == null ) {
			throw new ApplicationException("Skill Name should not be empty ");
		
		}
			return new ResponseEntity<>(gtsSkillsService.updateGtsSkills(gtsSkills),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/skill_id")
	public ResponseEntity<String> deleteGtsSkills(@RequestBody GtsSkills gtsSkills){
		
		Optional<GtsSkills> gtsSkillId= gtsSkillsService.getGtsSkills(gtsSkills.getGts_skill_id());
		
		if(!gtsSkillId.isPresent()) {	
			throw new SkillNotFoundException("Skill id not found ");
		}
	
		return new ResponseEntity<>(gtsSkillsService.deleteGtsSkills(gtsSkills.getGts_skill_id()),HttpStatus.OK);

	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllRecords(){
		
		return new ResponseEntity<>(gtsSkillsService.deleteAllGtsSkills(),HttpStatus.OK);
		
	}
	
}
