/**
 * 
 */
package com.poc.eoy.em.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.eoy.em.model.EmployeeDesignation;

/**
 * @author lugupta
 *
 */
public class EmployeeDesignationMapper implements RowMapper<EmployeeDesignation> {

	@Override
	public EmployeeDesignation mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeDesignation employeeDesignation = new EmployeeDesignation();

		employeeDesignation.setId(rs.getInt("id"));
		employeeDesignation.setDesignationCode(rs.getString("des_code"));
		employeeDesignation.setDesignationName(rs.getString("des_name"));

		return employeeDesignation;
	}

}