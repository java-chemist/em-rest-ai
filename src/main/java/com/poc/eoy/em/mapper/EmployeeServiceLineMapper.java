/**
 * 
 */
package com.poc.eoy.em.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.eoy.em.model.EmployeeServiceLine;

/**
 * @author lugupta
 *
 */
public class EmployeeServiceLineMapper implements RowMapper<EmployeeServiceLine> {

	@Override
	public EmployeeServiceLine mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeServiceLine employeeServiceLine = new EmployeeServiceLine();

		employeeServiceLine.setId(rs.getInt("id"));
		employeeServiceLine.setServiceLineCode(rs.getString("sl_code"));
		employeeServiceLine.setServiceLineName(rs.getString("sl_name"));

		return employeeServiceLine;
	}

}