package com.example.mentorOnDemand.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorOnDemand.model.Mentor;

public interface MentorDao extends JpaRepository<Mentor, Integer> {

	List<Mentor> findByemail(String email);
	@Query("select c from Mentor c where c.technology LIKE %:letter%")
	public List<Mentor> findBytechnology(@Param(value="letter") String letter);
	
	@Transactional
    @Modifying
	@Query("update Mentor m set m.active=true where m.regCode=:regCode")
	public void blockById(@Param(value="regCode") int regCode);
	
	@Transactional
    @Modifying
	@Query("update Mentor m set m.active=false where m.regCode=:regCode")
	public void unblockById(@Param(value="regCode")int regCode);
	public Mentor findByregCode(int id);
	
}