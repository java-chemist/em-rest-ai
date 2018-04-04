/**
 * 
 */
package com.poc.eoy.em.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.eoy.em.model.EmployeeRole;

/**
 * @author lugupta
 *
 */
public class EmployeeRoleMapper implements RowMapper<EmployeeRole> {

	@Override
	public EmployeeRole mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeRole employeeRole = new EmployeeRole();

		employeeRole.setId(rs.getInt("id"));
		employeeRole.setRoleCode(rs.getString("role_code"));
		employeeRole.setRoleName(rs.getString("role_name"));

		return employeeRole;
	}

}