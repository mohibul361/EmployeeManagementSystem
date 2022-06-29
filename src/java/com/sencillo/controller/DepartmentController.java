package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Department;
import com.sencillo.service.DepartmentService;
import com.sencillo.service.EmployerService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployerService employerService;

    
    @RequestMapping(value = "/departmentList", method = RequestMethod.GET)
    public String listDepartment(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("departmentList", this.departmentService.listDepartment());
        return "departmentList";
    }

    @RequestMapping(value = "/department/add", method = RequestMethod.GET)
    public String loadDepartmentPage(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "add");
        return "department";
    }

    //For add and update department both
    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addDepartment(@Valid @ModelAttribute("department") Department d, BindingResult result, Model model) {

        if(result.hasErrors()){
            return "department";
        }
        Department dbDepartment = this.departmentService.getDepartment(d.getDepartmentEmail());
        if (dbDepartment != null) {
            model.addAttribute("emailErrorMessage", "Email Already exists!");
            return "department";
        }
        this.departmentService.addDepartment(d);
        return "redirect:/departmentList";

    }

    @RequestMapping(value="department/delete/{id}")
    public String deleteDepartment( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.departmentService.deleteDepartment(id);
        return "redirect:/departmentList";
    }

    @RequestMapping(value="department/delete/{id}", method=RequestMethod.POST)
    public String deleteDepartment(@ModelAttribute("department") Department d, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.departmentService.deleteDepartment(id);
        return "redirect:/departmentList";
    }

    @RequestMapping("department/edit/{id}")
    public String editDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.departmentService.getDepartmentById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "edit");
        return "department";
    }

    @RequestMapping(value="department/edit/{id}", method=RequestMethod.POST)
    public String editDepartment(@ModelAttribute("department") Department d, @PathVariable("id") int id, Model model) {
        this.departmentService.updateDepartment(d);
        return "redirect:/departmentList";
    }
       

}
