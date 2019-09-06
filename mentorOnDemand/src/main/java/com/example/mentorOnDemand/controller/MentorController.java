package com.example.mentorOnDemand.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mentorOnDemand.dao.MentorDao;
import com.example.mentorOnDemand.dao.RequestDao;
import com.example.mentorOnDemand.dao.UserDao;
import com.example.mentorOnDemand.model.Mentor;
import com.example.mentorOnDemand.model.User;

@Controller
public class MentorController {
	@Autowired
	private MentorDao mentorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RequestDao reqDao;

	@RequestMapping(value = "/mentorRegister", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		Mentor e = new Mentor();
		model.addAttribute("mentor", e);
		return "mentorSignup";

	}

	@RequestMapping(value = "/mentorRegister", method = RequestMethod.POST)
	public String formHandler(@Valid @ModelAttribute("mentor") Mentor mentor, BindingResult result, Model model)
			throws SQLException {
		System.out.println(mentor);
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("mentor", mentor);
			return "mentorSignup";
		}
		mentorDao.save(mentor);
		// model.addAttribute("name", employee.getName());
		return "redirect:/mentorLogin";
	}

	@RequestMapping(value = "/mentorLogin", method = RequestMethod.GET)
	public String login(ModelMap model) {
		Mentor e = new Mentor();
		model.addAttribute("mentorL", e);
		return "mentorLogin";

	}

	@RequestMapping(path = "/mentorLogin1", method = RequestMethod.POST)
	public ModelAndView mentorUser( @ModelAttribute("mentorL") Mentor mentor, ModelMap model,HttpSession session) throws Exception {

		ModelAndView mav = null;
		System.out.println(mentor);
		String email = mentor.getEmail();

		List<Mentor> user1 = mentorDao.findByemail(email);
		if (user1.isEmpty()) 
		{
			mav = new ModelAndView("mentorLogin", "message", "Invalid Username or Password :(");
		} 
		else 
		{
			Mentor user2 = user1.get(0);
			boolean b=user2.isActive();boolean a=true;
			if(a==b)
			{
				System.out.println("blocked");
				mav = new ModelAndView("mentorLogin", "message", "Account is Blocked :(");
			}
			else if ((mentor.getEmail().equals(user2.getEmail())) && (mentor.getPassword().equals(user2.getPassword())))
			{
				session.setAttribute("mentor",user2);
				mav = new ModelAndView("redirect:/userList");
			} 
			else {
				System.out.println("pswd incorrect");
			 	mav = new ModelAndView("mentorLogin", "message", "Invalid Username or Password :(");
			     }
		}

		return mav;

	}
    @RequestMapping(path = "/userList")
    public ModelAndView getuserList() throws Exception {
           ModelAndView mv = new ModelAndView();
           mv.setViewName("mentorLandingPage");
           mv.addObject("userList", userDao.findAll());
           
           System.out.println(userDao.findAll());
           return mv;
    }
    @RequestMapping(path="/confirm")
    public ModelAndView updateStatus(@RequestParam("id") int id,@RequestParam("userId") int userId, Mentor mentor){
           ModelAndView mav=new ModelAndView();
           Mentor mentor1=mentorDao.findByregCode(id);
           //mentorDao.save(mentor);
           User user=userDao.findByregCode(userId);
           
            user.setRequest("Approved");
           mentor1.setMrequest("Approved");
           mentorDao.save(mentor1);
           userDao.save(user);
           mav=new ModelAndView("redirect:/userList");
           return mav;
    }


}
