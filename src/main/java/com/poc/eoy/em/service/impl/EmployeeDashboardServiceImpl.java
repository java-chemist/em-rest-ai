/**
 * 
 */
package com.poc.eoy.em.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.dao.EmployeeDAO;
import com.poc.eoy.em.form.EmployeeDashboardForm;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.service.EmployeeDashboardService;
import com.poc.eoy.em.util.ValidatorUtil;

/**
 * @author lugupta
 *
 */
@Service
public class EmployeeDashboardServiceImpl implements EmployeeDashboardService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Integer getEmployeesCount() throws Exception {
		return employeeDAO.getAllEmployeesCount();
	}

	@Override
	public List<EmployeeDashboardForm> getPaginatedEmployees(int recordNum) throws Exception {
		List<EmployeeDetails> employeeDetailsList = employeeDAO.getSelectedEmployees(recordNum);
		List<EmployeeDashboardForm> employeeDashboardFormsList = new ArrayList<>();

		for (EmployeeDetails modelObj : employeeDetailsList) {
			EmployeeDashboardForm formObj = this.copyModelToForm(modelObj);

			employeeDashboardFormsList.add(formObj);
		}

		return employeeDashboardFormsList;
	}

	@Override
	public String findEmployeeById(String empId) throws Exception {
		if (ValidatorUtil.isNumeric(empId)) {
			return employeeDAO.findEmployeeById(Integer.valueOf(empId)).getEmployeeName();
		}

		return GenericConstants.STRING_EMPTY;
	}

	private EmployeeDashboardForm copyModelToForm(EmployeeDetails employeeDetails) throws Exception {
		EmployeeDashboardForm employeeDashboardForm = new EmployeeDashboardForm();

		employeeDashboardForm.setEmployeeNumber(String.valueOf(employeeDetails.getEmployeeNumber()));
		employeeDashboardForm.setEmployeeName(employeeDetails.getEmployeeName());
		employeeDashboardForm.setDesignation(this.getDesignationName(employeeDetails.getDesignation()));
		employeeDashboardForm.setServiceLine(this.getServiceLineName(employeeDetails.getServiceLine()));
		employeeDashboardForm.setRole(this.getRoleName(employeeDetails.getRole()));

		return employeeDashboardForm;
	}

	private String getDesignationName(String designationCode) throws Exception {
		return employeeDAO.findDesignationByCode(designationCode).getDesignationName();
	}

	private String getServiceLineName(String serviceLineCode) throws Exception {
		return employeeDAO.findServiceLineByCode(serviceLineCode).getServiceLineName();
	}

	private String getRoleName(String roleCode) throws Exception {
		return employeeDAO.findRoleByCode(roleCode).getRoleName();
	}

}
