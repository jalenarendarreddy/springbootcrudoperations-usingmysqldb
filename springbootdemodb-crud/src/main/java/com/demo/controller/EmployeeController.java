package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.pojos.Employee;
import com.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/")
	public String addEmployee() {
		return "addEmployee";
	}
	
	@RequestMapping(value="/saveEmp")
	public void saveEmployee(HttpServletRequest req,HttpServletResponse res) {
		String name=req.getParameter("name");
		String designation=req.getParameter("desig");
		String sal=req.getParameter("sal");
		int salary=Integer.parseInt(sal);
		Employee emp=new Employee();
		emp.setName(name);
		emp.setDesignation(designation);
		emp.setSalary(salary);
		employeeService.saveEmployee(emp);
		
		try {
			res.sendRedirect("showEmployees");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@RequestMapping(value = "/showEmployees")
	public String getEmployees(Model model) {
		List<Employee> listEmp=employeeService.getEmployees();
		model.addAttribute("listEmp",listEmp);
		return"showEmployees";
	}
	
	/*@RequestMapping(value="/deleteEmployee")
	public void deleteEmp(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int val=Integer.parseInt(id);
		employeeService.deleteEmp(val);
		try {
			res.sendRedirect("showEmployees");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@RequestMapping(value="/deleteEmployee")
	public void deleteEmp(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int val=Integer.parseInt(id);
		Employee emp=employeeService.getElementById(val);
		employeeService.deleteEmp(emp);
		try {
			res.sendRedirect("showEmployees");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@RequestMapping(value="/editEmployee")
	public String editEmp(HttpServletRequest req,HttpServletResponse res,Model m) {
		System.out.println("test");
		String id=req.getParameter("id");
		System.out.println("test1");
		int val=Integer.parseInt(id);
		System.out.println("test2");
		Employee emp=employeeService.getElementById(val);
		System.out.println("test3");
		m.addAttribute("employee",emp);
		System.out.println("test4");
		return"addEmployee";
		
	}*/
	
	@RequestMapping(value="/editEmployee/{id}")
	public ModelAndView editEmp(HttpServletRequest req,HttpServletResponse res,@PathVariable int id, Model m) {
		Employee emp=employeeService.getElementById(id);		
		System.out.println("designation: "+emp.getDesignation());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("emp",emp);
	    modelAndView.setViewName("updateEmployee");
		return modelAndView;
			
	}
	
	@RequestMapping(value="/updateEmp")
	public void updateEmployee(HttpServletRequest req,HttpServletResponse res) {
		String name=req.getParameter("name");
		String designation=req.getParameter("desig");
		String sal=req.getParameter("sal");
		int salary=Integer.parseInt(sal);
		String idVal=req.getParameter("id");
		int id=Integer.parseInt(idVal);
		Employee emp=new Employee();
		emp.setName(name);
		emp.setDesignation(designation);
		emp.setSalary(salary);
		emp.setId(id);
		
		Employee employee=employeeService.getElementById(id);
		
		if(employee != null) {
		employeeService.updateEmployee(emp);
		}
		
		try {
			res.sendRedirect("showEmployees");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
	}	

}
