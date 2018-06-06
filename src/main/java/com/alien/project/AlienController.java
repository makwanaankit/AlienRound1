package com.alien.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alien.project.dao.AlienDao;
import com.alien.project.entity.Alien;
import com.mysql.fabric.xmlrpc.base.Member;

@Controller
public class AlienController 
{
		@Autowired
		AlienDao alienDao;
	
		@RequestMapping("insert")
		public ModelAndView insertAlien(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView modelAndView=new ModelAndView();
			String name=request.getParameter("alienName");
			int age=Integer.parseInt(request.getParameter("age"));
			String city=request.getParameter("city");
			int marks=Integer.parseInt(request.getParameter("marks"));
			Alien alien=new Alien();
			alien.setAge(age);
			alien.setAlienName(name);
			alien.setCity(city);
			alien.setMarks(marks);
			
			alienDao.insert(alien);
			System.out.println(alien);
			modelAndView.setViewName("viewData.jsp");
			modelAndView.addObject(alien);
			return modelAndView;
		}
		
		@RequestMapping("/show")
		public ModelAndView showAlien(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView modelAndView=new ModelAndView();
			System.out.println(alienDao.getTopAlien());
			modelAndView.addObject("AlienList",alienDao.getTopAlien());
			modelAndView.setViewName("show.jsp");
			
			return modelAndView;
		}
		
		@RequestMapping("/showAll")
		public ModelAndView showAllAlien(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView modelAndView=new ModelAndView();
			System.out.println(alienDao.getTopAlien());
			modelAndView.addObject("Allalien",alienDao.getAllAlien());
			modelAndView.setViewName("ShowAllAlien.jsp");
			
			return modelAndView;
		}
		
}
