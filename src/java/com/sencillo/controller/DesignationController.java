package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Designation;
import com.sencillo.service.DesignationService;
import com.sencillo.service.EmployerService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DesignationController {

    @Autowired
    private DesignationService designationService;
    
    @Autowired
    private EmployerService employerService;


    @RequestMapping(value = "/designationList", method = RequestMethod.GET)
    public String listDesignation(Model model) {
        model.addAttribute("designation", new Designation());
        model.addAttribute("designationList", this.designationService.listDesignation());
        return "designationList";
    }

    @RequestMapping(value = "/designation/add", method = RequestMethod.GET)
    public String loadDesignationPage(Model model) {
        Designation designation = new Designation();
        model.addAttribute("designation", designation);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "add");
        return "designation";
    }

    //For add and update designation both
    @RequestMapping(value = "/designation/add", method = RequestMethod.POST)
    public String addDesignation(@Valid @ModelAttribute("designation") Designation d, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("empList", this.employerService.listEmployee());
            return "designation";
        }
        this.designationService.addDesignation(d);
        return "redirect:/designationList";

    }
    
    @RequestMapping(value="designation/delete/{id}")
    public String deleteDesignation( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.designationService.deleteDesignation(id);
        return "redirect:/designationList";
    }

    @RequestMapping(value="designation/delete/{id}", method=RequestMethod.POST)
    public String deleteDesignation(@ModelAttribute("designation") Designation d, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.designationService.deleteDesignation(id);
        return "redirect:/designationList";
    }
    

    @RequestMapping("designation/edit/{id}")
    public String editDesignation(@PathVariable("id") int id, Model model) {
        model.addAttribute("designation", this.designationService.getDesignationById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "edit");
        return "designation";
    }

    @RequestMapping(value="designation/edit/{id}", method=RequestMethod.POST)
    public String editDesignation(@ModelAttribute("designation") Designation d, @PathVariable("id") int id, Model model) {
        this.designationService.updateDesignation(d);
        return "redirect:/designationList";
    }
       

}
