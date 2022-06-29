package com.sencillo.controller;

import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sencillo.model.User;
import com.sencillo.service.EmployerService;
import com.sencillo.service.RoleService;
import com.sencillo.service.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;
        
        @Autowired
        private EmployerService employerService;
        
        @Autowired
        private RoleService roleService;

	@ModelAttribute
	public void loadDefault(Model model)
	{
            model.addAttribute("userList", this.userService.getUserList());
            model.addAttribute("empList", this.employerService.listEmployee());
            model.addAttribute("roleList", this.roleService.getRoleList());
            
	}

	@RequestMapping(value = "/user")
	public String loadPage(Model model)
	{
		model.addAttribute("user", new User());
                model.addAttribute("userList", userService.getUserList());
		return "user";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, Model model)
	{
		List<FieldError> errors = bindingResult.getFieldErrors();
		for (FieldError error : errors)
		{
			System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}
		if (bindingResult.hasErrors())
		{
			return "user";
		}
		if (user.getId() == null)
		{
			String salt = getSalt();
			String userPassword = user.getPassword();
			String combined = userPassword + salt;
			String hashedPassword = DigestUtils.sha512Hex(combined);
			user.setPassword(hashedPassword);
			user.setSalt(salt);
			this.userService.save(user);
		}
		else
		{
			this.userService.edit(user);
		}
		model.addAttribute("user", new User());
		return "user";
	}

	public String getSalt()
	{
		String salt = "";
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		salt = org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
		return salt;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") Integer id, Model model)
	{
		model.addAttribute("user", this.userService.getUser(id));
		return "user";
	}

}
