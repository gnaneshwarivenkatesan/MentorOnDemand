package com.example.mentorOnDemand.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mentorOnDemand.dao.MentorDao;
import com.example.mentorOnDemand.dao.SkillDao;
import com.example.mentorOnDemand.dao.UserDao;
import com.example.mentorOnDemand.model.Mentor;
import com.example.mentorOnDemand.model.Skill;
import com.example.mentorOnDemand.model.User;
import com.example.mentorOnDemand.service.UserService;
@Transactional
@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private MentorDao mentorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SkillDao skillDao;
	@RequestMapping(path="/userdb")
	public ModelAndView getUserList() throws Exception {
	     ModelAndView mv=new ModelAndView();
	     mv.setViewName("userdb");
	     mv.addObject("userdb",userService.getUserList());
	     return mv;
	}

	@RequestMapping(path="/mentordb")
	public ModelAndView getmentorList() throws Exception {
	     ModelAndView mv=new ModelAndView();
	     mv.setViewName("mentordb");
	     mv.addObject("mentordb",userService.getMentorList());
	     return mv;
	}
	
	@RequestMapping(value = "/blockmentor")
	public String blockMentor(ModelMap model, @RequestParam("id") int regCode,
			@ModelAttribute("mentordb") Mentor mentor) {
		System.out.println(regCode);
		boolean a=mentor.isActive();
		System.out.println(a);
		if(a==false)
		{		
			mentorDao.blockById(regCode);
		}
		System.out.println(a);
		return "redirect:/mentordb";
	}
	@RequestMapping(value = "/Unblockmentor")
	public String unblockMentor(ModelMap model, @RequestParam("id") int regCode,
			@ModelAttribute("mentordb") Mentor mentor) {
		System.out.println(regCode);
		boolean a=mentor.isActive();a=true;	
		System.out.println(a);
		
		if(a==true)
		{				

			mentorDao.unblockById(regCode);
		}
		System.out.println(a);
		return "redirect:/mentordb";
	}
	@RequestMapping(value = "/blockuser")
	public String blockuser(ModelMap model, @RequestParam("id") int regCode,
			@ModelAttribute("userdb") User user) {
		System.out.println(regCode);
		boolean a=user.isActive();
		System.out.println(a);
		if(a==false)
		{		
			userDao.blockById(regCode);
		}
		System.out.println(a);
		return "redirect:/userdb";
	}
	@RequestMapping(value = "/Unblockuser")
	public String unblockUser(ModelMap model, @RequestParam("id") int regCode,
			@ModelAttribute("userdb") User user) {
		System.out.println(regCode);
		boolean a=user.isActive();a=true;	
		System.out.println(a);
		
		if(a==true)
		{				

			userDao.unblockById(regCode);
		}
		System.out.println(a);
		return "redirect:/userdb";
	}
	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add employee");
		Skill e = new Skill();
	
		model.addAttribute("skill", e);
		return "addSkill";

	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	public String formHandler(@Valid Skill skill, BindingResult result, Model model) throws SQLException {
		System.out.println(skill);
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("skill", skill);
			return "addSkill";
		}
skillDao.save(skill);
		
		// model.addAttribute("name", employee.getName());
		return "redirect:/skillList";
	}
	@RequestMapping(path = "/skillList")
	public ModelAndView getSkillList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("skillList");
		mv.addObject("skillList", skillDao.findAll());
		return mv;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSkill(ModelMap model, @RequestParam("id") int id,
			@ModelAttribute("skill") Skill skill) {
		skillDao.deleteByskillId(id);
		
		return "redirect:/skillList";
	}
	@RequestMapping(value = "/update")
	public ModelAndView updateSkill(ModelMap model, @RequestParam("skillId") int skillId,
			@ModelAttribute("skill1") Skill skill) {
ModelAndView mew=null;
skill = skillDao.findByskillId(skillId);
		model.addAttribute("skill1", skill);
		mew=new ModelAndView("updateSkill");
		return mew;
	}

	@RequestMapping(value = "/updateSkill", method = RequestMethod.POST)
	public String updateSkill1(@ModelAttribute("skill1") Skill skill, int skillId, Model model)
			throws SQLException {
		 skillDao.save(skill);
		return "redirect:/skillList";

	}
}
