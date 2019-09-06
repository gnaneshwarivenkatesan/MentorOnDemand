package com.example.mentorOnDemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorOnDemand.model.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {

@Transactional
	public void deleteByskillId(int id);

public Skill findByskillId(int id);

}
