package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.LeaveType;
import com.sencillo.service.LeaveTypeService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;
    
    @RequestMapping(value = "/leaveTypeList", method = RequestMethod.GET)
    public String listLeaveType(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        model.addAttribute("leaveTypeList", this.leaveTypeService.listLeaveType());
        return "leaveTypeList";
    }
    
    @RequestMapping(value = "/employeeLeaveTypeList", method = RequestMethod.GET)
    public String listEmployeeLeaveType(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        model.addAttribute("employeeLeaveTypeList", this.leaveTypeService.listEmployeeLeaveType());
        return "employeeLeaveTypeList";
    }

    @RequestMapping(value = "/leaveType/add", method = RequestMethod.GET)
    public String loadLeaveTypePage(Model model) {
        LeaveType leaveType = new LeaveType();
        model.addAttribute("leaveType", leaveType);
        model.addAttribute("actionType", "add");
        return "leaveType";
    }

    //For add and update Leave Type both
    @RequestMapping(value = "/leaveType/add", method = RequestMethod.POST)
    public String addLeaveType(@Valid @ModelAttribute("leaveType") LeaveType l, BindingResult result) {

        if(result.hasErrors()){
            return "leaveType";
        }
        this.leaveTypeService.addLeaveType(l);
        return "redirect:/leaveTypeList";

    }
    
    @RequestMapping("employeeLeaveTypeList")
    public String employeeLeaveTypeList(Model model) {
        model.addAttribute("employeeLeaveTypeList", this.leaveTypeService.listEmployeeLeaveType());
        return "employeeLeaveTypeList";
    }

    @RequestMapping(value="leaveType/delete/{id}")
    public String deleteLeaveType( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.leaveTypeService.deleteLeaveType(id);
        return "redirect:/leaveTypeList";
    }

    @RequestMapping(value="leaveType/delete/{id}", method=RequestMethod.POST)
    public String deleteLeaveType(@ModelAttribute("leaveType") LeaveType l, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.leaveTypeService.deleteLeaveType(id);
        return "redirect:/leaveTypeList";
    }

    @RequestMapping("leaveType/edit/{id}")
    public String editLeaveType(@PathVariable("id") int id, Model model) {
        model.addAttribute("leaveType", this.leaveTypeService.getLeaveTypeById(id));
        model.addAttribute("actionType", "edit");
        return "leaveType";
    }

    @RequestMapping(value="leaveType/edit/{id}", method=RequestMethod.POST)
    public String editLeaveType(@ModelAttribute("leaveType") LeaveType l, @PathVariable("id") int id, Model model) {
        this.leaveTypeService.updateLeaveType(l);
        return "redirect:/leaveTypeList";
    }
       

}

