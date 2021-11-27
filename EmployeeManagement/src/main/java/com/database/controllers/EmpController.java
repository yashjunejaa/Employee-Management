package com.database.controllers;   

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.database.beans.Emp;  
import com.database.dao.EmpDao;  
@Controller
public class EmpController {  

	@Autowired  
	EmpDao dao;

	@RequestMapping("/addemp")  
	public String showform(Model m) {
		m.addAttribute("emp", new Emp());
		return "addEmp";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public String save(@ModelAttribute("emp") @Valid Emp emp, BindingResult br){  
		
		if(br.hasErrors() && emp != null) {
			return "addEmp";
		}
		dao.save(emp);  
		return "redirect:/view";
	}  

	@RequestMapping("/view")  
	public String viewemp(Model m){  
		List<Emp> list=dao.getEmployees();  
		m.addAttribute("list",list);
		return "view";  
	}  

	@RequestMapping(value="/edit/{id}")  
	public String edit(@PathVariable int id, Model m){  
		Emp emp=dao.getEmpById(id);  
		m.addAttribute("emp",emp);
		return "editEmp";  
	}  

	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
	public String editsave(@ModelAttribute("emp") @Valid Emp emp, BindingResult br){ 
		if(br.hasErrors() && emp != null) {
			return "editEmp";
		}
		dao.update(emp);  
		return "redirect:/view";  
	}  

	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
	public String delete(@PathVariable int id){  
		dao.delete(id);  
		return "redirect:/view";  
	}   
}  