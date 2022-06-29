package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.AnnualLeave;
import com.sencillo.model.Employee;
import com.sencillo.service.AnnualLeaveService;
import com.sencillo.service.EmployerService;
import com.sencillo.service.LeaveTypeService;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AnnualLeaveController {

    @Autowired
    private AnnualLeaveService annualLeaveService;

    @Autowired
    private EmployerService employerService;
    
    @Autowired
    private LeaveTypeService leaveTypeService;

    
    @RequestMapping(value = "/annualLeaveList", method = RequestMethod.GET)
    public String listAnnualLeave(Model model) {
        model.addAttribute("annualLeave", new AnnualLeave());
        model.addAttribute("annualLeaveList", this.annualLeaveService.listAnnualLeave());
        return "annualLeaveList";
    }

    @RequestMapping(value = "/annualLeave/add", method = RequestMethod.GET)
    public String loadAnnualLeavePage(Model model) {
        AnnualLeave annualLeave = new AnnualLeave();
        model.addAttribute("annualLeave", annualLeave);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("leaveTypeList", this.leaveTypeService.listLeaveType());
        model.addAttribute("actionType", "add");
        return "annualLeave";
    }

    //For add and update AnnualLeave both
    @RequestMapping(value = "/annualLeave/add", method = RequestMethod.POST)
    public String addAnnualLeave(@ModelAttribute("annualLeave") AnnualLeave a, HttpSession session, Model model) {
        
        a.setCummulativeDaysTaken(0);
        a.setRemainingDays(0);
        this.annualLeaveService.addAnnualLeave(a);
        return "redirect:/annualLeaveList";

    }
    
    @RequestMapping("employeeAnnualLeaveProfile")
    public String employeeAnnualLeaveProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employeeAnnualLeaveProfileList", this.annualLeaveService.listEmployeeAnnualLeaveProfile(employee.getId()));
        return "employeeAnnualLeaveProfile";
    }

    @RequestMapping(value="annualLeave/delete/{id}")
    public String deleteAnnualLeave( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.annualLeaveService.deleteAnnualLeave(id);
        return "redirect:/annualLeaveList";
    }

    @RequestMapping(value="annualLeave/delete/{id}", method=RequestMethod.POST)
    public String deleteAnnualLeave(@ModelAttribute("annualLeave") AnnualLeave a, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.annualLeaveService.deleteAnnualLeave(id);
        return "redirect:/annualLeaveList";
    }

    @RequestMapping("annualLeave/edit/{id}")
    public String editAnnualLeave(@PathVariable("id") int id, Model model) {
        model.addAttribute("annualLeave", this.annualLeaveService.getAnnualLeaveById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("leaveTypeList", this.leaveTypeService.listLeaveType());
        model.addAttribute("actionType", "edit");
        return "annualLeave";
    }

    @RequestMapping(value="annualLeave/edit/{id}", method=RequestMethod.POST)
    public String editAnnualLeave(@ModelAttribute("annualLeave") AnnualLeave a, @PathVariable("id") int id, Model model) {
        this.annualLeaveService.updateAnnualLeave(a);
        return "redirect:/annualLeaveList";
    }
       

}
