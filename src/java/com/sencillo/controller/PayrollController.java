package com.sencillo.controller;

import com.sencillo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Payroll;
import com.sencillo.service.EmployerService;
import com.sencillo.service.PayrollService;
import com.sencillo.service.GradeTypeService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private GradeTypeService gradeTypeService;
    
    @Autowired
    private EmployerService employerService;
    

    @RequestMapping(value = "/payrollList", method = RequestMethod.GET)
    public String listPayroll(Model model) {
        model.addAttribute("payroll", new Payroll());
        model.addAttribute("payrollList", this.payrollService.listPayroll());
        return "payrollList";
    }

    @RequestMapping(value = "/payroll/add", method = RequestMethod.GET)
    public String loadPayrollPage(Model model) {
        Payroll payroll = new Payroll();
        model.addAttribute("payroll", payroll);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
        model.addAttribute("actionType", "add");
        return "payroll";
    }
    
    @RequestMapping("employeePayrollProfile")
    public String employeePayrollProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employeePayrollProfileList", this.payrollService.listEmployeePayrollProfile(employee.getId()));
        return "employeePayrollProfile";
    }

    //For add and update payroll both
    @RequestMapping(value = "/payroll/add", method = RequestMethod.POST)
    public String addPayroll(@Valid @ModelAttribute("payroll") Payroll p, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("payrollList", this.payrollService.listPayroll());
            return "payroll";
        }
        this.payrollService.addPayroll(p);

        return "redirect:/payrollList";

    }

    @RequestMapping(value="payroll/delete/{id}")
    public String deletePayroll( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.payrollService.deletePayroll(id);
        return "redirect:/payrollList";
    }

    @RequestMapping(value="payroll/delete/{id}", method=RequestMethod.POST)
    public String deletePayroll(@ModelAttribute("payroll") Payroll p, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.payrollService.deletePayroll(id);
        return "redirect:/payrollList";
    }
    

    @RequestMapping("payroll/edit/{id}")
    public String editPayroll(@PathVariable("id") int id, Model model) {
        model.addAttribute("payroll", this.payrollService.getPayrollById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
        model.addAttribute("actionType", "edit");
        return "payroll";
    }

    @RequestMapping(value="payroll/edit/{id}", method=RequestMethod.POST)
    public String editPayroll(@ModelAttribute("payroll") Payroll p, @PathVariable("id") int id, Model model) {
        this.payrollService.updatePayroll(p);
        return "redirect:/payrollList";
    }
       
    @RequestMapping("getGradeSalary/{id}")
    public @ResponseBody Double getGradeSalary(@PathVariable("id") int id) {
        System.out.println("id = " + id);
        return gradeTypeService.getGradeTypeSalaryByEmployee(id);
    }
}
