/**
 * 
 */
package com.poc.eoy.em.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.eoy.em.dao.EmployeeDAO;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.service.EmployeeLoginService;
import com.poc.eoy.em.util.ValidatorUtil;

/**
 * @author lugupta
 *
 */
@Service
public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public EmployeeDetails findEmployeeById(Integer empId) throws Exception {
		return employeeDAO.findEmployeeById(empId);
	}

	@Override
	public EmployeeDetails findEmployeeById(String empId) throws Exception {
		if (ValidatorUtil.isNumeric(empId)) {
			return employeeDAO.findEmployeeById(Integer.valueOf(empId));
		}

		return null;
	}

}
