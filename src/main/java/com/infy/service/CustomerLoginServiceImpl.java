package com.infy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.CustomerLoginDAO;
import com.infy.dao.CustomerLoginDAOImpl;
import com.infy.model.CustomerLogin;
import com.infy.model.User;

@Service
@Transactional
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginDAO customerLoginDao;

	public String authenticateCustomer(CustomerLogin customerLogin)
			 {
		String toRet = null;
		
		CustomerLogin customerLoginFromDao = customerLoginDao
				.getCustomerLoginByLoginName(customerLogin.getLoginName());
		if (customerLoginFromDao.getLoginName()!=null) {
			toRet = "Success";
		} else {
			toRet = "Failed";
		}
		return toRet;
	}

	@Override
	public List<User> showTable() {
		return customerLoginDao.showTabel();
	}
}
