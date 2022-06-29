package com.sencillo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sencillo.model.Employee;
import com.sencillo.model.User;
import com.sencillo.service.DepartmentService;
import com.sencillo.service.DesignationService;
import com.sencillo.service.EmployerService;
import com.sencillo.service.GradeTypeService;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DesignationService designationService;

    @Autowired
    private GradeTypeService gradeTypeService;

    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    public String listEmployee(Model model) {
        model.addAttribute("empList", this.employerService.listEmployee());
        return "employeeList";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.GET)
    public String loadEmployeePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departmentList", this.departmentService.listDepartment());
        model.addAttribute("designationList", this.designationService.listDesignation());
        model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
        model.addAttribute("actionType", "add");
        return "employee";
    }

    @RequestMapping(value = "/employeeProfile", method = RequestMethod.GET)
    public String getEmployeeProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("departmentList", this.departmentService.listDepartment());
        model.addAttribute("designationList", this.designationService.listDesignation());
        model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
        model.addAttribute("employeeProfile", employee);
        return "employeeProfile";
    }

    //For add and update employee both
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute("employee") Employee e, BindingResult result, Model model) {

        e.setJoiningDate(new Date());
        if (result.hasErrors()) {

            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println("fieldError.getValue = " + fieldError.getField() + ">" + fieldError.getDefaultMessage());
            }
            model.addAttribute("ageLimitErrorMessage", "Age should be greater than 22!");
            model.addAttribute("departmentList", this.departmentService.listDepartment());
            model.addAttribute("designationList", this.designationService.listDesignation());
            model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
            return "employee";
        }
        try {
            LocalDate dateofBirth = e.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate joiningDate = e.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if ((dateofBirth != null) && (joiningDate != null)) {
                int age = Period.between(dateofBirth, joiningDate).getYears();
                System.out.println("age = " + age);
                if (age < 22) {
                    model.addAttribute("ageLimitErrorMessage", "Age should be greater than 22!");
                    model.addAttribute("departmentList", this.departmentService.listDepartment());
                    model.addAttribute("designationList", this.designationService.listDesignation());
                    model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
                    return "employee";
                }
            }
            Employee dbEmployee = this.employerService.getEmployee(e.getEmail());
            if (dbEmployee != null) {
                model.addAttribute("emailErrorMessage", "Email Already exists!");
                model.addAttribute("departmentList", this.departmentService.listDepartment());
                model.addAttribute("designationList", this.designationService.listDesignation());
                model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
                return "employee";
            }

            this.employerService.addEmployee(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/employeeList";

    }

    @RequestMapping(value = "employee/delete/{id}")
    public String deleleEmployee(@PathVariable("id") int id, Model model) throws Exception {
        this.employerService.deleteEmployee(id);
        return "redirect:/employeeList";
    }

    @RequestMapping(value = "employee/delete/{id}", method = RequestMethod.POST)
    public String deleteEmployee(@ModelAttribute("employee") Employee e, @PathVariable("id") int id, Model model) throws Exception {
        this.employerService.deleteEmployee(id);
        return "redirect:/employeeList";
    }

    @RequestMapping("employee/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employerService.getEmployeeById(id));
        model.addAttribute("departmentList", this.departmentService.listDepartment());
        model.addAttribute("designationList", this.designationService.listDesignation());
        model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
        model.addAttribute("actionType", "edit");
        return "employee";
    }

    @RequestMapping(value = "employee/edit/{id}", method = RequestMethod.POST)
    public String editEmployee(@Valid @ModelAttribute("employee") Employee e, @PathVariable("id") int id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            
            model.addAttribute("ageLimitErrorMessage", "Age should be greater than 22!");
            model.addAttribute("departmentList", this.departmentService.listDepartment());
            model.addAttribute("designationList", this.designationService.listDesignation());
            model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
            return "employee";
        }
        try {
            LocalDate dateofBirth = e.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate joiningDate = e.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if ((dateofBirth != null) && (joiningDate != null)) {
                int age = Period.between(dateofBirth, joiningDate).getYears();
                System.out.println("age = " + age);
                if (age < 22) {
                    model.addAttribute("ageLimitErrorMessage", "Age should be greater than 22!");
                    model.addAttribute("departmentList", this.departmentService.listDepartment());
                    model.addAttribute("designationList", this.designationService.listDesignation());
                    model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
                    return "employee";
                }
            }
            Employee dbEmployee = this.employerService.getEmployee(e.getEmail());
            if (dbEmployee != null) {
                model.addAttribute("emailErrorMessage", "Email Already exists!");
                model.addAttribute("departmentList", this.departmentService.listDepartment());
                model.addAttribute("designationList", this.designationService.listDesignation());
                model.addAttribute("gradeTypeList", this.gradeTypeService.getGradeTypeList());
                return "employee";
            }

            this.employerService.addEmployee(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/employeeList";
    }

}
