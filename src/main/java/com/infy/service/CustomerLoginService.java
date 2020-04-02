package com.infy.service;

import java.util.List;

import com.infy.model.CustomerLogin;
import com.infy.model.User;

public interface CustomerLoginService {
	public String authenticateCustomer(CustomerLogin customerLogin);
	public List<User> showTable();
}
