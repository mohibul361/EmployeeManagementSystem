package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Holiday;
import com.sencillo.service.HolidayService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HolidayController {

    @Autowired
    private HolidayService holidayService;
    
    @RequestMapping(value = "/holidayList", method = RequestMethod.GET)
    public String listHoliday(Model model) {
        model.addAttribute("holiday", new Holiday());
        model.addAttribute("holidayList", this.holidayService.listHoliday());
        return "holidayList";
    }
    
    @RequestMapping(value = "/employeeHolidayList", method = RequestMethod.GET)
    public String listEmployeeHoliday(Model model) {
        model.addAttribute("holiday", new Holiday());
        model.addAttribute("employeeHolidayList", this.holidayService.listEmployeeHoliday());
        return "employeeHolidayList";
    }

    @RequestMapping(value = "/holiday/add", method = RequestMethod.GET)
    public String loadHolidayPage(Model model) {
        Holiday holiday = new Holiday();
        model.addAttribute("holiday", holiday);
        model.addAttribute("actionType", "add");
        return "holiday";
    }

    //For add and update holiday both
    @RequestMapping(value = "/holiday/add", method = RequestMethod.POST)
    public String addHoliday(@Valid @ModelAttribute("holiday") Holiday h, BindingResult result) {

        if(result.hasErrors()){
            return "holiday";
        }
        this.holidayService.addHoliday(h);
        return "redirect:/holidayList";

    }
    
    @RequestMapping("employeeHolidayList")
    public String employeeHolidayList(Model model) {
        model.addAttribute("employeeHolidayList", this.holidayService.listEmployeeHoliday());
        return "employeeHolidayList";
    }

    @RequestMapping(value="holiday/delete/{id}")
    public String deleteHoliday( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.holidayService.deleteHoliday(id);
        return "redirect:/holidayList";
    }

    @RequestMapping(value="holiday/delete/{id}", method=RequestMethod.POST)
    public String deleteHoliday(@ModelAttribute("holiday") Holiday h, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.holidayService.deleteHoliday(id);
        return "redirect:/holidayList";
    }

    @RequestMapping("holiday/edit/{id}")
    public String editHoliday(@PathVariable("id") int id, Model model) {
        model.addAttribute("holiday", this.holidayService.getHolidayById(id));
        model.addAttribute("actionType", "edit");
        return "holiday";
    }

    @RequestMapping(value="holiday/edit/{id}", method=RequestMethod.POST)
    public String editHoliday(@ModelAttribute("holiday") Holiday h, @PathVariable("id") int id, Model model) {
        this.holidayService.updateHoliday(h);
        return "redirect:/holidayList";
    }
       

}
