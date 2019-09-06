package com.example.mentorOnDemand.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mentorOnDemand.dao.MentorDao;
import com.example.mentorOnDemand.dao.UserDao;
import com.example.mentorOnDemand.model.Mentor;
import com.example.mentorOnDemand.model.User;


	@Service
	public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;
		@Autowired
		private MentorDao mentorDao;
		@Override
		public User userLogin(User user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User registerUser(User user) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.save(user);
		}

		@Override
		public List<User> findByemail(String name) {
			// TODO Auto-generated method stub
			return userDao.findByemail(name);
		}

		@Override
		public List<User> getUserList() throws SQLException {
			// TODO Auto-generated method stub
			return userDao.findAll();
		}

		@Override
		public List<Mentor> getMentorList() throws SQLException {
			// TODO Auto-generated method stub
			return mentorDao.findAll();
		}

		@Override
		public User findByregCode(int userId) {
			// TODO Auto-generated method stub
			return userDao.findByregCode(userId);
		}


}
