package com.example.mentorOnDemand.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mentorOnDemand.model.Mentor;
import com.example.mentorOnDemand.model.User;


public interface UserService {
	 public User userLogin(User user);
		
		
		public User registerUser(User user) throws SQLException ;
	List<User> findByemail(String name);
	public List<User> getUserList() throws SQLException;


	public List<Mentor> getMentorList() throws SQLException;


	public User findByregCode(int userId);



}
