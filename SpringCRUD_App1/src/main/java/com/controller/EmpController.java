 package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Emp;
import com.dao.Empdao;


@RestController
@Controller
@Component("daoBean")
public class EmpController  {
	@Autowired
	Empdao dao;
	
    @RequestMapping(value = "/empform", method = RequestMethod.GET)  
	public String showform(Model m){    
         m.addAttribute("command", new Emp());
        return "empform"; 
	
	 }
	 @RequestMapping(value="/save",method = RequestMethod.POST)    
	   public String save(@RequestBody Emp emp){    
	        dao.save(emp);    
	        return "redirect:/viewemp";   
	    } 
	 @RequestMapping("/viewemp")    
	    public String viewemp(Model m){    
	        List<Emp> list=dao.getEmployees();    
	        m.addAttribute("list",list);  
	        return "viewemp";    
	    } 
	 @RequestMapping(value="/editemp/{id}")    
	    public String edit(@RequestBody int id, Model m){    
	        Emp emp=dao.getEmpById(id);    
	        m.addAttribute("command",emp);  
	        return "empeditform";    
	    }    
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@RequestBody Emp emp){    
	        dao.Update(emp);    
	        return "redirect:/viewemp";    
	    }    

	   @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.id(id);    
	        return "redirect:/viewemp";    
	    }  
	   
	
	
	  @RequestMapping(value="/search",method = RequestMethod.POST) 
	  public String search(@RequestParam("id") int id,Model m) 
	  { 
		  Emp list=dao.getEmpById(id);
		  m.addAttribute("list",list); 
		  return "employee"; 
	  }
	 
	   @RequestMapping("/search")
	   public String searchEmployee() {
	   
		  
		   return "search";
	   }
	 
}
