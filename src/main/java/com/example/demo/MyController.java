package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired IHDHDDao Dao;

	@RequestMapping("/")
	public String root() {
		
		return "NewFile";
	}


	@RequestMapping("/s")
	public String aaa( Model model ) {
	
	model.addAttribute("list",Dao.select());
	
	return "Test";
	}
	
	@RequestMapping(value="/addMember", method=RequestMethod.GET)
	public String addMember( 
			               @RequestParam("id") String id,
			               @RequestParam("writer") String writer, 
			               @RequestParam("title") String title, 
			               @RequestParam("content") String content,
			      
			               Model model ) throws Exception{
						   System.out.println(id);
		
		
		                   Dao.insert_one(id, writer, title , content);
		                   
		                   model.addAttribute("list",Dao.select());
			                     
		return "Test";
		

	}
	
	@RequestMapping(value="/updateMember", method=RequestMethod.GET)
	public String updateMember( 
			               @RequestParam("id") String id,
			               @RequestParam("writer") String writer, 
			               @RequestParam("title") String title, 
			               @RequestParam("content") String content,
			      
			               Model model ) throws Exception{
		
		                   Dao.update(id, writer, title , content);
		                   
		                   model.addAttribute("list",Dao.select());
			                     
		return "Test";
		

	}
	
	@RequestMapping(value="/deleteMember", method=RequestMethod.GET)
	public String deleteMember( 
			               @RequestParam("id") String id,
			      
			               Model model ) throws Exception{
		
		                   Dao.delete(id);
		                   
		                   model.addAttribute("list",Dao.select());
			                     
		return "Test";
		

	}
	
	@RequestMapping("/insert")
	public String insert( Model model ) {
	
		return "insert";
	}
	
	@RequestMapping("/delete")
	public String delete(	@RequestParam("id") String id,
							Model model ) {
		
		model.addAttribute("list",Dao.select_one(id));
	
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update(	@RequestParam("id") String id,
							Model model ) {
		
		model.addAttribute("list",Dao.select_one(id));
	
		return "update";
	}




}
