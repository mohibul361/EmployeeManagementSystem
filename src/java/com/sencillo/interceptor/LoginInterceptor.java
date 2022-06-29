package com.sencillo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		System.out.println("Interceptors...");
		

		System.out.println(">>>"+request.getRequestURI());
                
		if (!request.getRequestURI().contains("login"))
		{
			System.out.println(">>>"+request.getSession().getAttribute("userId"));
			if(request.getSession().getAttribute("userId") == null)
			{
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
		}
		else
		{
			if(request.getSession().getAttribute("userId") != null)
			{
				response.sendRedirect(request.getContextPath()+"/index");
				return false;
			}
		}
		return true;
	}

}

