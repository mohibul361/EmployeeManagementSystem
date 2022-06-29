package com.sencillo.controller;

import com.sencillo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Promotion;
import com.sencillo.service.DesignationService;
import com.sencillo.service.EmployerService;
import com.sencillo.service.PromotionService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private EmployerService employerService;
    
    @Autowired
    private DesignationService designationService;


    @RequestMapping(value = "/promotionList", method = RequestMethod.GET)
    public String listPromotion(Model model) {
        model.addAttribute("promotion", new Promotion());
        model.addAttribute("promotionList", this.promotionService.listPromotion());
        return "promotionList";
    }

    @RequestMapping(value = "/pendingPromotionList", method = RequestMethod.GET)
    public String listPendingPromotion(Model model) {
        model.addAttribute("promotion", new Promotion());
        model.addAttribute("pendingPromotionList", this.promotionService.listPendingPromotion());
        return "pendingPromotionList";
    }

    @RequestMapping(value = "/promotion/add", method = RequestMethod.GET)
    public String loadPromotionPage(Model model) {
        Promotion promotion = new Promotion();
        model.addAttribute("promotion", promotion);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("designationList", this.designationService.listDesignation());
        model.addAttribute("actionType", "add");
        return "promotion";
    }

    //For add and update Leave both
    @RequestMapping(value = "/promotion/add", method = RequestMethod.POST)
    public String addPromotion(@Valid @ModelAttribute("promotion") Promotion p, HttpSession session, BindingResult result) {
        Employee employee = (Employee) session.getAttribute("employee");
        p.setEmployee(employee);
        p.setStatus("pending");
        p.setDateOfApplication(new Date());
        p.setJoinDate(employee.getJoiningDate());
        p.setDesignationDuringApplication(employee.getDesignation().getDesignationName());
        if(result.hasErrors()){
            return "promotion";
        }
        this.promotionService.addPromotion(p);

        return "redirect:/promotionList";

    }

    @RequestMapping(value = "promotion/delete/{id}")
    public String deletePromotion(@PathVariable("id") int id, Model model) throws Exception {
        this.promotionService.deletePromotion(id);
        return "redirect:/promotionList";
    }

    @RequestMapping(value = "promotion/delete/{id}", method = RequestMethod.POST)
    public String deletePromotion(@ModelAttribute("promotion") Promotion p, @PathVariable("id") int id, Model model) throws Exception {
        this.promotionService.deletePromotion(id);
        return "redirect:/promotionList";
    }

    @RequestMapping("pendingPromotionList")
    public String pendingPromotionList(Model model) {
        model.addAttribute("pendingPromotionList", this.promotionService.listPendingPromotion());
        return "pendingPromotionList";
    }
    
    @RequestMapping("employeePromotionProfile")
    public String employeePromotionProfile(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("employeePromotionProfileList", this.promotionService.listEmployeePromotionProfile(employee.getId()));
        return "employeePromotionProfile";
    }

    @RequestMapping(value = "approvePromotion/{id}", method = RequestMethod.GET)
    public String approvePromotion(@PathVariable("id") int id, Model model) {
        Promotion p = this.promotionService.getPromotionById(id);
        model.addAttribute("promotion", p);
        return "approvePromotion";
    }

    @RequestMapping(value = "approvePromotion/{id}", method = RequestMethod.POST, params = "approve")
    public String approvePromotion(@ModelAttribute("promotion") Promotion p, Model model) {
        System.out.println("p.getId() = " + p.getId());
        this.promotionService.updateStatus("approved", p.getId());
        this.promotionService.updateDesignation(p);
        return "redirect:/pendingPromotionList";
    }

    @RequestMapping(value = "approvePromotion/{id}", method = RequestMethod.POST, params = "reject")
    public String rejectPromotion(@ModelAttribute("promotion") Promotion p, Model model) {

        this.promotionService.updateStatus("rejected", p.getId());
        return "redirect:/pendingPromotionList";
    }
            
}
