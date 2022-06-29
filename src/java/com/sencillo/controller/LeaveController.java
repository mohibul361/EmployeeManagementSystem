package com.sencillo.controller;

import com.sencillo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Leave;
import com.sencillo.model.LeaveReportForm;
import com.sencillo.service.EmployerService;
import com.sencillo.service.LeaveService;
import com.sencillo.service.LeaveTypeService;
import com.sencillo.service.AnnualLeaveService;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private AnnualLeaveService annualLeaveService;

    @RequestMapping(value = "/leaveList", method = RequestMethod.GET)
    public String listLeave(Model model) {
        model.addAttribute("leave", new Leave());
        model.addAttribute("leaveList", this.leaveService.listLeave());
        return "leaveList";
    }

    @RequestMapping(value = "/pendingLeaveList", method = RequestMethod.GET)
    public String listPendingLeave(Model model) {
        model.addAttribute("leave", new Leave());
        model.addAttribute("pendingLeaveList", this.leaveService.listPendingLeave());
        return "pendingLeaveList";
    }

    @RequestMapping("employeeLeaveProfile")
    public String employeeLeaveProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employeeLeaveProfileList", this.leaveService.listEmployeeLeaveProfile(employee.getId()));
        return "employeeLeaveProfile";
    }

    @RequestMapping(value = "/leaveReport", method = RequestMethod.GET)
    public String listLeaveReport(Model model) {
        model.addAttribute("leaveReportForm", new LeaveReportForm());
        return "leaveReport";
    }

    @RequestMapping(value = "/leaveReport", method = RequestMethod.POST)
    public String listLeaveReport(@ModelAttribute("leaveReportForm") LeaveReportForm leaveReportForm, Model model) {
        Date fromDate = leaveReportForm.getFromDate();
        Date toDate = leaveReportForm.getToDate();
        System.out.println("fromDate = " + fromDate);
        List<Leave> leaveList = this.leaveService.listLeaveReport(fromDate, toDate);
        model.addAttribute("leaveList", leaveList);
        return "leaveReport";
    }

    @RequestMapping(value = "/leave/add", method = RequestMethod.GET)
    public String loadLeavePage(Model model) {
        Leave leave = new Leave();
        model.addAttribute("leave", leave);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("leaveTypeList", this.leaveTypeService.listLeaveType());
        model.addAttribute("actionType", "add");
        return "leave";
    }

    //For add and update Leave both
    @RequestMapping(value = "/leave/add", method = RequestMethod.POST)
    public String addLeave(@Valid @ModelAttribute("leave") Leave l, HttpSession session, BindingResult result, Model model) {

        l.setEmployee((Employee) session.getAttribute("employee"));
        l.setStatus("pending");
        l.setDateOfApplication(new Date());
        if (result.hasErrors()) {
            return "leave";
        }
        this.leaveService.addLeave(l);
        return "redirect:/leaveList";

    }

    @RequestMapping(value = "leave/delete/{id}")
    public String deleteLeave(@PathVariable("id") int id, Model model) throws Exception {
        this.leaveService.deleteLeave(id);
        return "redirect:/leaveList";
    }

    @RequestMapping(value = "leave/delete/{id}", method = RequestMethod.POST)
    public String deleteLeave(@ModelAttribute("leave") Leave l, @PathVariable("id") int id, Model model) throws Exception {
        this.leaveService.deleteLeave(id);
        return "redirect:/leaveList";
    }

    @RequestMapping("pendingLeaveList")
    public String pendingLeaveList(Model model) {
        model.addAttribute("pendingLeaveList", this.leaveService.listPendingLeave());
        return "pendingLeaveList";
    }

    @RequestMapping(value = "approveLeave/{id}", method = RequestMethod.GET)
    public String approveLeave(@PathVariable("id") int id, Model model) {
        Leave l = this.leaveService.getLeaveById(id);
        model.addAttribute("leave", l);
        return "approveLeave";
    }

    @RequestMapping(value = "approveLeave/{id}", method = RequestMethod.POST, params = "approve")
    public String approveLeave(@ModelAttribute("leave") Leave l, Model model) {
        System.out.println("l.getId() = " + l.getId());
        this.leaveService.updateStatus("approved", l.getId());
        this.annualLeaveService.updateAnnualLeaveAfterLeaveApproval(l);
        return "redirect:/pendingLeaveList";
    }

    @RequestMapping(value = "approveLeave/{id}", method = RequestMethod.POST, params = "reject")
    public String rejectLeave(@ModelAttribute("leave") Leave l, Model model) {

        this.leaveService.updateStatus("rejected", l.getId());
        return "redirect:/pendingLeaveList";
    }
    
    @RequestMapping("getLeaveTypeBalance/{id}")
    public @ResponseBody String getLeaveTypeBalance(@PathVariable("id") int leaveTypeId, HttpSession session) {
        Employee e = (Employee) session.getAttribute("employee");
        System.out.println("leaveTypeId = " + leaveTypeId);
        int remainingDays = annualLeaveService.getLeaveTypeBalanceByEmployee(leaveTypeId, e.getId());
        System.out.println("remainingDays = " + remainingDays);
        String message;
        if (remainingDays >0)
        {
             message = "Your current balance is "+remainingDays;
        }
        else
        {
            message = "No leave is allocated for this type! Please contact admin";
        }
        return message;
    }
}
