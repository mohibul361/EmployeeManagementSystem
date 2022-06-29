package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Salary;
import com.sencillo.service.SalaryService;
import com.sencillo.service.EmployerService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    
    @Autowired 
    private EmployerService employerService;


    @RequestMapping(value = "/salaryList", method = RequestMethod.GET)
    public String listSalary(Model model) {
        model.addAttribute("salary", new Salary());
        model.addAttribute("salaryList", this.salaryService.listSalary());
        return "salaryList";
    }

    @RequestMapping(value = "/salary/add", method = RequestMethod.GET)
    public String loadSalaryPage(Model model) {
        Salary salary = new Salary();
        model.addAttribute("salary", salary);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "add");
        return "salary";
    }

    //For add and update salary both
    @RequestMapping(value = "/salary/add", method = RequestMethod.POST)
    public String addSalary(@Valid @ModelAttribute("salary") Salary s, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("payrollList", this.salaryService.listSalary());
            return "salary";
        }
        this.salaryService.addSalary(s);

        return "redirect:/salaryList";

    }

   @RequestMapping(value="salary/delete/{id}")
    public String deleleSalary( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.salaryService.deleteSalary(id);
        return "redirect:/salaryList";
    }

    @RequestMapping(value="salary/delete/{id}", method=RequestMethod.POST)
    public String deleteSalary(@ModelAttribute("salary") Salary s, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.salaryService.deleteSalary(id);
        return "redirect:/salaryList";
    }

    @RequestMapping("salary/edit/{id}")
    public String editSalary(@PathVariable("id") int id, Model model) {
        model.addAttribute("salary", this.salaryService.getSalaryById(id));
         model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "edit");
        return "salary";
    }

    @RequestMapping(value="salary/edit/{id}", method=RequestMethod.POST)
    public String editSalary(@ModelAttribute("salary") Salary s, @PathVariable("id") int id, Model model) {
        this.salaryService.updateSalary(s);
        return "redirect:/salaryList";
    }
       

}
