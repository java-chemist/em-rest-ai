/**
 * 
 */
package com.poc.eoy.em.service;

import java.util.Map;

import com.poc.eoy.em.form.EmployeeRegistrationForm;
import com.poc.eoy.em.model.EmployeeDetails;

/**
 * @author lugupta
 *
 */
public interface EmployeeRegistrationService {

	Map<String, String> getAllDesignationsMap() throws Exception;

	Map<String, String> getAllServiceLinesMap() throws Exception;

	Map<String, String> getAllRolesMap() throws Exception;

	EmployeeDetails findEmployeeById(String empId) throws Exception;

	void saveEmployeeDetails(EmployeeRegistrationForm employeeRegistrationForm) throws Exception;

}
