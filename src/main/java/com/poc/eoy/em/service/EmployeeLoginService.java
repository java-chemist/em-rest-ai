/**
 * 
 */
package com.poc.eoy.em.service;

import com.poc.eoy.em.model.EmployeeDetails;

/**
 * @author lugupta
 *
 */
// NOSONAR
public interface EmployeeLoginService {

	EmployeeDetails findEmployeeById(Integer empId) throws Exception;

	EmployeeDetails findEmployeeById(String empId) throws Exception;

}
