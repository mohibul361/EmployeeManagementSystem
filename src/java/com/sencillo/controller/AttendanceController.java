package com.sencillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.Attendance;
import com.sencillo.service.AttendanceService;
import com.sencillo.service.EmployerService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private EmployerService employerService;

    @RequestMapping(value = "/attendanceList", method = RequestMethod.GET)
    public String listAttendance(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("attendanceList", this.attendanceService.listAttendance());
        return "attendanceList";
    }

    @RequestMapping(value = "/attendance/add", method = RequestMethod.GET)
    public String loadAttendancePage(Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "add");
        return "attendance";
    }

    //For add and update attendance both
    @RequestMapping(value = "/attendance/add", method = RequestMethod.POST)
    public String addAttendance(@ModelAttribute("attendance") Attendance a) {

        this.attendanceService.addAttendance(a);

        return "redirect:/attendanceList";

    }

    @RequestMapping(value="attendance/delete/{id}")
    public String deleteAttendance( @PathVariable("id") int id, Model model) throws Exception 
    {
        this.attendanceService.deleteAttendance(id);
        return "redirect:/attendanceList";
    }

    @RequestMapping(value="attendance/delete/{id}", method=RequestMethod.POST)
    public String deleteAttendance(@ModelAttribute("attendance") Attendance a, @PathVariable("id") int id, Model model) throws Exception 
    {
        this.attendanceService.deleteAttendance(id);
        return "redirect:/attendanceList";
    }

    @RequestMapping("attendance/edit/{id}")
    public String editAttendance(@PathVariable("id") int id, Model model) {
        model.addAttribute("attendance", this.attendanceService.getAttendanceById(id));
        model.addAttribute("empList", this.employerService.listEmployee());
        model.addAttribute("actionType", "edit");
        return "attendance";
    }

    @RequestMapping(value="attendance/edit/{id}", method=RequestMethod.POST)
    public String editAttendance(@ModelAttribute("attendance") Attendance a, @PathVariable("id") int id, Model model) {
        this.attendanceService.updateAttendance(a);
        return "redirect:/attendanceList";
    }
       

}
