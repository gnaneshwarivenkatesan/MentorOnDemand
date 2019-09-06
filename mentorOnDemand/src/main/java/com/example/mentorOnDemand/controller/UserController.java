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
import com.example.mentorOnDemand.model.Request;
import com.example.mentorOnDemand.model.User;
import com.example.mentorOnDemand.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MentorDao mentorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RequestDao reqDao;
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add user");
		User e = new User();
		model.addAttribute("e2", e);
		return "signUp";

	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String formHandler(@Valid @ModelAttribute("e2")User user, 
			BindingResult result, Model model) throws SQLException {
		System.out.println(user);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("e2", user);
			return "signUp";
		}
		userService.registerUser(user);
		//model.addAttribute("name", employee.getName());
		 return "redirect:/login";
	}
	
	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("logged in");
		User e = new User();
		model.addAttribute("login1", e);
		return "login";

	}
	
	@RequestMapping(path = "/login1", method = RequestMethod.POST)
    public ModelAndView loginUser(@ModelAttribute("login1") User user,ModelMap model,HttpSession session) throws Exception {

           ModelAndView mav = null;
                
           String email = user.getEmail();
           List<User> user1 = userService.findByemail(email);
           if(user1.isEmpty())
           {
        	   mav = new ModelAndView("login", "message", "Invalid Username or Password");}
           else
           {
           User user2 = user1.get(0);
          
			boolean b=user2.isActive();boolean a=true;
			if(a==b)
			{
				System.out.println("blocked");
				mav = new ModelAndView("login", "message", "Account is Blocked :(");
			}
           else if ((user.getEmail().equals(user2.getEmail())) && (user.getPassword().equals(user2.getPassword()))) {
        	 
                  if (user2.getUserType().equals("Admin")) {
                        mav = new ModelAndView("adminLandingPage");
                  } else {
                	  session.setAttribute("user", user2);  
                        mav = new ModelAndView("userLandingPage");
                  }
           } else {

                  mav = new ModelAndView("login", "message", "Invalid Username or Password :(");
           }
           
           }
           return mav;

    }
	@RequestMapping(path = "/searchMentor", method = RequestMethod.GET)
    public String searchMentor(ModelMap model) {
           Mentor mentor = new Mentor();
           model.addAttribute("search", mentor);
           return "searchMentor";
    }


	@RequestMapping(path = "/searchMentor1", method = RequestMethod.POST)
    public ModelAndView searchMentor1(Mentor mentor,ModelMap model) {
           ModelAndView mav = new ModelAndView(); 
           mav.setViewName("searchList");
          System.out.println(mentorDao.findBytechnology(mentor.getTechnology()));
                    mav.addObject("searchList", mentorDao.findBytechnology(mentor.getTechnology()));
           return mav;
    }
    @RequestMapping(path="/request")
    public ModelAndView updateStatus(@RequestParam("id") int id,@RequestParam("userId") int userId, Mentor mentor){
           ModelAndView mav=new ModelAndView();
           Mentor mentor1=mentorDao.findByregCode(id);
           //mentorDao.save(mentor);
           User user=userDao.findByregCode(userId);
           
           user.setRequest("RequestPending");
           mentor1.setMrequest("RequestSent");
           Request r=new Request();
           r.setMentorId(id);
           r.setUserId(userId);
           r.setStatus("1");
           reqDao.save(r);
           mentorDao.save(mentor1);
           userDao.save(user);
           mav=new ModelAndView("redirect:/searchList");
           return mav;
    }

	
}
