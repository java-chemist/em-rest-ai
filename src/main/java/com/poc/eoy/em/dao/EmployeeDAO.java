/**
 * 
 */
package com.poc.eoy.em.dao;

import java.util.List;

import com.poc.eoy.em.model.EmployeeDesignation;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.model.EmployeeRole;
import com.poc.eoy.em.model.EmployeeServiceLine;

/**
 * @author lugupta
 *
 */
public interface EmployeeDAO {

	EmployeeDetails findEmployeeById(Integer empId) throws Exception;

	List<EmployeeDesignation> getAllDesignations() throws Exception;

	List<EmployeeServiceLine> getAllServiceLines() throws Exception;

	List<EmployeeRole> getAllRoles() throws Exception;

	void saveEmployeeDetails(EmployeeDetails employeeDetails) throws Exception;

	EmployeeDesignation findDesignationByCode(String desCode) throws Exception;

	EmployeeServiceLine findServiceLineByCode(String slCode) throws Exception;

	EmployeeRole findRoleByCode(String roleCode) throws Exception;

	Integer getAllEmployeesCount() throws Exception;

	List<EmployeeDetails> getSelectedEmployees(int recordNum) throws Exception;

}
