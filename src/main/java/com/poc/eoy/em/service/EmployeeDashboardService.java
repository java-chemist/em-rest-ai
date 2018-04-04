/**
 * 
 */
package com.poc.eoy.em.service;

import java.util.List;

import com.poc.eoy.em.form.EmployeeDashboardForm;

/**
 * @author lugupta
 *
 */
public interface EmployeeDashboardService {

	Integer getEmployeesCount() throws Exception;

	List<EmployeeDashboardForm> getPaginatedEmployees(int recordNum) throws Exception;

	String findEmployeeById(String empId) throws Exception;

}
