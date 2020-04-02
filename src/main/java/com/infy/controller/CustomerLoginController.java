package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.infy.model.CustomerLogin;
import com.infy.model.User;
import com.infy.service.CustomerLoginService;

@Controller
@RequestMapping(value="/bloggerexchange")
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	@PostMapping(value = "/add")
	public ModelAndView authenticateCustomer(@ModelAttribute("user") CustomerLogin customerLogin) throws Exception {
		String b = customerLoginService.authenticateCustomer(customerLogin);
		if (b.equals("Success")) {
			ModelAndView modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("username", customerLogin.getLoginName());
			return modelAndView;
		} else
			return new ModelAndView("error");
	}
	
	@GetMapping(value= "/showtable")
	public ModelAndView showTable() {
		List<User> userList = customerLoginService.showTable();
		ModelAndView modelAndView = new ModelAndView("showtable");
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("name","Shobhit");
		return modelAndView;
		
	}
	
}
