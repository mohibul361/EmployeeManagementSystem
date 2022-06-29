package com.sencillo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.sencillo.model.User;
import com.sencillo.service.PageService;
import com.sencillo.service.UserService;
import java.util.Map;

@Controller
public class LoginController
{
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

        @Autowired
        private PageService pageService;

        @RequestMapping("/index")
	public String index(Map<String, Object> map, HttpSession session)
	{		
		return "index";
	}
        
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getCustomLogin(ModelMap model, HttpSession session)
	{		
		model.addAttribute("customLogin", new User());
                return "login";
	}

	@RequestMapping(value = "/login-post", method = RequestMethod.POST)
	public String customLogin(@ModelAttribute("customLogin") User user, ModelMap model, HttpSession session   )
	{
		System.out.println("hello login post");
		if (user.getUserName().isEmpty() && user.getPassword().isEmpty())
		{
			model.addAttribute("msg", "User name and password can not blank!");
			return "login";
		}
		if (user.getUserName().isEmpty())
		{
			model.addAttribute("msg", "User name can not blank!");
			return "login";
		}
		if (user.getPassword().isEmpty())
		{
			model.addAttribute("msg", "Password can not blank!");
			return "login";
		}

		User dbUser = this.userService.getUser(user.getUserName());
		if (dbUser == null)
		{
			logger.info("User does not exist: "+user.getUserName());
			model.addAttribute("msg", "User does not exist!");
			model.addAttribute("customLogin", new User());
			return "login";
		}
		if(!dbUser.isActive())
		{
			logger.info("User is not active: "+user.getUserName());
			model.addAttribute("msg", "User is not Active!");
			model.addAttribute("customLogin", new User());
			return "login";
		}
		String dbPassword = dbUser.getPassword();
		String dbSalt = dbUser.getSalt();
		String combined = user.getPassword() + dbSalt;
		String hashedPassword = DigestUtils.sha512Hex(combined);

		if (hashedPassword.equals(dbPassword))
		{
			System.out.println("authenticated..");
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userId", dbUser.getId());
                        session.setAttribute("employee", dbUser.getEmployee());
                        System.out.println("dbUser.getRole() = " + dbUser.getRole());
                        session.setAttribute("pageList", this.pageService.getPageListMapByRole(dbUser.getRole().getId()));
		
			logger.info("Login successful by user: "+user.getUserName());
			
			return "redirect:/index";
		}
		else
		{
			logger.info("Password did not match for user: "+user.getUserName());
			model.addAttribute("msg", "Password did not match!");
			model.addAttribute("customLogin", new User());
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String customLogout(ModelMap model, HttpServletRequest request)
	{
		System.err.println("HELLO LOGOUT");
		
		/*HttpSession session = request.getSession(false);*/
		
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null)
		{
			session.removeAttribute("userName");
		}
		if (session.getAttribute("userId") != null)
		{
			session.removeAttribute("userId");
		}
		if (session.getAttribute("pageList") != null)
		{
			session.removeAttribute("pageList");
		}
		
		session.invalidate();
		
		return "redirect:/login";
        }
	
}