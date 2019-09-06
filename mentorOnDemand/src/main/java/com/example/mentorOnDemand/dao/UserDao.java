package com.example.mentorOnDemand.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorOnDemand.model.Mentor;
import com.example.mentorOnDemand.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	  
	List<User> findByemail(String name);
	
	@Query("select c.name,c.phoneNumber,c.linkedIn,c.technology from Mentor c where c.technology LIKE %:letter%")
	public List<Mentor> findBytechnology(@Param(value="letter") String letter);
	@Transactional
    @Modifying
	@Query("update User m set m.active=true where m.regCode=:regCode")
	public void blockById(@Param(value="regCode") int regCode);
	
	@Transactional
    @Modifying
	@Query("update User m set m.active=false where m.regCode=:regCode")
	public void unblockById(@Param(value="regCode")int regCode);

	public User findByregCode(int userId);
}
