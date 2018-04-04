/**
 * 
 */
package com.poc.eoy.em.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.eoy.em.dao.EmployeeDAO;
import com.poc.eoy.em.form.EmployeeRegistrationForm;
import com.poc.eoy.em.model.EmployeeDesignation;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.model.EmployeeRole;
import com.poc.eoy.em.model.EmployeeServiceLine;
import com.poc.eoy.em.service.EmployeeRegistrationService;
import com.poc.eoy.em.util.PasswordEncoderGeneratorUtil;
import com.poc.eoy.em.util.ValidatorUtil;

/**
 * @author lugupta
 *
 */
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Map<String, String> getAllDesignationsMap() throws Exception {
		List<EmployeeDesignation> employeeDesignations = employeeDAO.getAllDesignations();
		Map<String, String> designations = new LinkedHashMap<>();

		for (EmployeeDesignation obj : employeeDesignations) {
			designations.put(obj.getDesignationCode(), obj.getDesignationName());
		}

		return designations;
	}

	@Override
	public Map<String, String> getAllServiceLinesMap() throws Exception {
		List<EmployeeServiceLine> employeeServiceLines = employeeDAO.getAllServiceLines();
		Map<String, String> serviceLines = new LinkedHashMap<>();

		for (EmployeeServiceLine obj : employeeServiceLines) {
			serviceLines.put(obj.getServiceLineCode(), obj.getServiceLineName());
		}

		return serviceLines;
	}

	@Override
	public Map<String, String> getAllRolesMap() throws Exception {
		List<EmployeeRole> employeeRoles = employeeDAO.getAllRoles();
		Map<String, String> roles = new LinkedHashMap<>();

		for (EmployeeRole obj : employeeRoles) {
			roles.put(obj.getRoleCode(), obj.getRoleName());
		}

		return roles;
	}

	@Override
	public EmployeeDetails findEmployeeById(String empId) throws Exception {
		if (ValidatorUtil.isNumeric(empId)) {
			return employeeDAO.findEmployeeById(Integer.valueOf(empId));
		}

		return null;
	}

	@Override
	public void saveEmployeeDetails(EmployeeRegistrationForm employeeRegistrationForm) throws Exception {
		employeeDAO.saveEmployeeDetails(this.copyFormToModel(employeeRegistrationForm));
	}

	private EmployeeDetails copyFormToModel(EmployeeRegistrationForm employeeRegistrationForm) throws Exception {
		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails.setEmployeeName(employeeRegistrationForm.getEmployeeName());
		employeeDetails.setEmployeeNumber(Integer.valueOf(employeeRegistrationForm.getEmployeeNumber()));
		employeeDetails.setPassword(
				PasswordEncoderGeneratorUtil.bCryptPasswordEncoder(employeeRegistrationForm.getNewPassword()));
		employeeDetails.setDesignation(employeeRegistrationForm.getDesignation());
		employeeDetails.setServiceLine(employeeRegistrationForm.getServiceLine());
		employeeDetails.setRole(employeeRegistrationForm.getRole());

		return employeeDetails;
	}

}