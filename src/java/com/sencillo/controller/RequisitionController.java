package com.sencillo.controller;

import com.sencillo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Requisition;
import com.sencillo.service.EmployerService;
import com.sencillo.service.RequisitionService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RequisitionController {

    @Autowired
    private RequisitionService requisitionService;
    
    @Autowired
    private EmployerService employerService;


    @RequestMapping(value = "/requisitionList", method = RequestMethod.GET)
    public String listRequisition(Model model) {
        model.addAttribute("requisition", new Requisition());
        model.addAttribute("requisitionList", this.requisitionService.listRequisition());
         model.addAttribute("empList", this.employerService.listEmployee());
        return "requisitionList";
    }
    
    @RequestMapping(value = "/pendingRequisitionList", method = RequestMethod.GET)
    public String listPendingRequisition(Model model) {
        model.addAttribute("requisition", new Requisition());
        model.addAttribute("pendingRequisitionList", this.requisitionService.listPendingRequisition());
        return "pendingRequisitionList";
    }

    @RequestMapping(value = "/requisition/add", method = RequestMethod.GET)
    public String loadRequisitionPage(Model model) {
        Requisition requisition = new Requisition();
        model.addAttribute("requisition", requisition);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "add");
        return "requisition";
    }

    //For add and update requisition both
    @RequestMapping(value = "/requisition/add", method = RequestMethod.POST)
    public String addRequisition(@Valid @ModelAttribute("requisition") Requisition r,BindingResult result,HttpSession session) {

        r.setEmployee((Employee) session.getAttribute("employee"));
        r.setStatus("pending");
        r.setApplyDate(new Date());
        if(result.hasErrors()){
            return "requisition";
        }
        this.requisitionService.addRequisition(r);

        return "redirect:/requisitionList";

    }
    
    @RequestMapping("employeeRequisitionProfile")
    public String employeeRequisitionProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employeeRequisitionProfileList", this.requisitionService.listEmployeeRequisitionProfile(employee.getId()));
        return "employeeRequisitionProfile";
    }

    @RequestMapping(value="requisition/delete/{id}")
    public String deleteRequisition( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.requisitionService.deleteRequisition(id);
        return "redirect:/requisitionList";
    }
    
    @RequestMapping(value="requisition/delete/{id}", method=RequestMethod.POST)
    public String deleteRequisition(@ModelAttribute("requisition") Requisition r, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.requisitionService.deleteRequisition(id);
        return "redirect:/requisitionList";
    }
    
    @RequestMapping("pendingRequisitionList")
    public String pendingRequisitionList(Model model) {
        model.addAttribute("pendingLeaveList", this.requisitionService.listPendingRequisition());
        return "pendingRequisitionList";
    }
    
    @RequestMapping(value = "approveRequisition/{id}", method = RequestMethod.GET)
    public String approveRequisition(@PathVariable("id") int id, Model model) {
        Requisition r = this.requisitionService.getRequisitionById(id);
        model.addAttribute("requisition", r);
        return "approveRequisition";
    }

    @RequestMapping(value = "approveRequisition/{id}", method = RequestMethod.POST, params = "approve")
    public String approveRequisition(@ModelAttribute("requisition") Requisition r, Model model) {
        System.out.println("r.getId() = " + r.getId());
        this.requisitionService.updateStatus("approved", r.getId());
        return "redirect:/pendingRequisitionList";
    }

    @RequestMapping("requisition/edit/{id}")
    public String editRequisition(@PathVariable("id") int id, Model model) {
        model.addAttribute("requisition", this.requisitionService.getRequisitionById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "edit");
        return "requisition";
    }

    @RequestMapping(value="requisition/edit/{id}", method=RequestMethod.POST)
    public String editRequisition(@ModelAttribute("requisition") Requisition r, @PathVariable("id") int id, Model model) {
        this.requisitionService.updateRequisition(r);
        return "redirect:/requisitionList";
    }
       

}
