/**
 * 
 */
package com.poc.eoy.em.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.eoy.em.model.EmployeeDetails;

/**
 * @author lugupta
 *
 */
public class EmployeeDetailsMapper implements RowMapper<EmployeeDetails> {

	@Override
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails.setId(rs.getInt("id"));
		employeeDetails.setEmployeeName(rs.getString("name"));
		employeeDetails.setEmployeeNumber(rs.getInt("emp_id"));
		employeeDetails.setPassword(rs.getString("password"));
		employeeDetails.setDesignation(rs.getString("designation"));
		employeeDetails.setServiceLine(rs.getString("service_line"));
		employeeDetails.setRole(rs.getString("role"));

		return employeeDetails;
	}

}