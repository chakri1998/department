package com.mindtree.employee.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionHandler 
{
	@Value("${spring.application.name}")
	private String appliactionName;
	
//	@org.springframework.web.bind.annotation.ExceptionHandler
//	public ResponseEntity<Map<String, Object>> exceptioHandler(ControllerException c)
//	{
//		Map<String, Object> error = new HashMap<String, Object>();
//		
//		error.put("status",HttpStatus.NOT_FOUND.value());
//		error.put("ErrorMessage",c.getMessage());
//		//error.put("Body",dto,list,);
//		 
//		error.put("TimeStamp",new Date());
//		error.put("Application_Name",appliactionName);
//		return new ResponseEntity<Map<String,Object>>(error,HttpStatus.NOT_FOUND);
//		
//	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView exceptionHandler(HttpServletRequest req,ControllerException c) {
		ModelAndView mv= new ModelAndView();
		mv.addObject("status",HttpStatus.NOT_FOUND.value());
		mv.addObject("ErrorMessage",c.getMessage());
		mv.addObject("TimeStamp",new Date());
		mv.addObject("Application_Name",appliactionName);
		mv.setViewName("Error");
		System.out.println(appliactionName);
		return mv;
		
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView exceptionHandler(HttpServletRequest req,Exception e) {
		ModelAndView mv= new ModelAndView();
		mv.addObject("status",HttpStatus.NOT_FOUND.value());
		mv.addObject("ErrorMessage",e.getMessage());
		mv.addObject("TimeStamp",new Date());
		mv.addObject("Application_Name",appliactionName);
		mv.setViewName("Error");
		return mv;
		
	}

	
}