package com.infy.dao;

import java.util.List;

import com.infy.model.CustomerLogin;
import com.infy.model.User;

public interface CustomerLoginDAO {
	public CustomerLogin getCustomerLoginByLoginName(String loginName);
	public List<User> showTabel();
}
