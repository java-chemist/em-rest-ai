/**
 * 
 */
package com.poc.eoy.em.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.dao.EmployeeDAO;
import com.poc.eoy.em.mapper.EmployeeDesignationMapper;
import com.poc.eoy.em.mapper.EmployeeDetailsMapper;
import com.poc.eoy.em.mapper.EmployeeRoleMapper;
import com.poc.eoy.em.mapper.EmployeeServiceLineMapper;
import com.poc.eoy.em.model.EmployeeDesignation;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.model.EmployeeRole;
import com.poc.eoy.em.model.EmployeeServiceLine;

/**
 * @author lugupta
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	/* Fetch employee details based on employee number */
	@Override
	public EmployeeDetails findEmployeeById(Integer empId) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("empId", empId);

		String sql = "SELECT * FROM employees WHERE emp_id=:empId";

		EmployeeDetails employeeDetailsObj = null;

		try {
			employeeDetailsObj = namedParameterJdbcTemplate.queryForObject(sql, params, new EmployeeDetailsMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No employee found with this id " + e);
			logger.error(e);
			return null;
		}

		return employeeDetailsObj;
	}

	/* Fetch all designations code and full name */
	@Override
	public List<EmployeeDesignation> getAllDesignations() throws Exception {
		String sql = "SELECT * FROM designations";
		return namedParameterJdbcTemplate.query(sql, new EmployeeDesignationMapper());
	}

	/* Fetch all service lines code and full name */
	@Override
	public List<EmployeeServiceLine> getAllServiceLines() throws Exception {
		String sql = "SELECT * FROM service_lines";
		return namedParameterJdbcTemplate.query(sql, new EmployeeServiceLineMapper());
	}

	/* Fetch all roles code and full name */
	@Override
	public List<EmployeeRole> getAllRoles() throws Exception {
		String sql = "SELECT * FROM roles";
		return namedParameterJdbcTemplate.query(sql, new EmployeeRoleMapper());
	}

	/* Save new employee details */
	@Override
	public void saveEmployeeDetails(EmployeeDetails employeeDetails) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO employees (name, emp_id, password, designation, service_line, role) "
				+ "VALUES ( :name, :empId, :password, :designation, :serviceLine, :role)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(employeeDetails), keyHolder);
		employeeDetails.setId(keyHolder.getKey().intValue());
	}

	/* Fetch designation name by code */
	@Override
	public EmployeeDesignation findDesignationByCode(String desCode) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("desCode", desCode);

		String sql = "SELECT * FROM designations WHERE des_code=:desCode";

		EmployeeDesignation employeeDesignationObj = null;

		try {
			employeeDesignationObj = namedParameterJdbcTemplate.queryForObject(sql, params,
					new EmployeeDesignationMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No designation found with this code " + e);
			logger.error(e);
			return null;
		}

		return employeeDesignationObj;
	}

	/* Fetch service line name by code */
	@Override
	public EmployeeServiceLine findServiceLineByCode(String slCode) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("slCode", slCode);

		String sql = "SELECT * FROM service_lines WHERE sl_code=:slCode";

		EmployeeServiceLine employeeServiceLineObj = null;

		try {
			employeeServiceLineObj = namedParameterJdbcTemplate.queryForObject(sql, params,
					new EmployeeServiceLineMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No service line found with this code " + e);
			logger.error(e);
			return null;
		}

		return employeeServiceLineObj;
	}

	/* Fetch role name by code */
	@Override
	public EmployeeRole findRoleByCode(String roleCode) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("roleCode", roleCode);

		String sql = "SELECT * FROM roles WHERE role_code=:roleCode";

		EmployeeRole employeeRoleObj = null;

		try {
			employeeRoleObj = namedParameterJdbcTemplate.queryForObject(sql, params, new EmployeeRoleMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No role found with this code " + e);
			logger.error(e);
			return null;
		}

		return employeeRoleObj;
	}

	/* Get total number of registered employees */
	@Override
	public Integer getAllEmployeesCount() throws Exception {
		String sql = "SELECT * FROM employees ORDER BY id";
		List<EmployeeDetails> employeeDetailsList = namedParameterJdbcTemplate.query(sql, new EmployeeDetailsMapper());

		return employeeDetailsList.size();
	}

	/* Get employee details for a selected number of records */
	@Override
	public List<EmployeeDetails> getSelectedEmployees(int recordNum) throws Exception {
		String sql = "SELECT * FROM employees OFFSET " + recordNum + " ROWS FETCH NEXT "
				+ GenericConstants.TOTAL_RECORDS_DISPLAY_PAGINATION + " ROWS ONLY";
		return namedParameterJdbcTemplate.query(sql, new EmployeeDetailsMapper());
	}

	private SqlParameterSource getSqlParameterByModel(EmployeeDetails employeeDetails) throws Exception {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("id", employeeDetails.getId());
		paramSource.addValue("name", employeeDetails.getEmployeeName());
		paramSource.addValue("empId", employeeDetails.getEmployeeNumber());
		paramSource.addValue("password", employeeDetails.getPassword());
		paramSource.addValue("designation", employeeDetails.getDesignation());
		paramSource.addValue("serviceLine", employeeDetails.getServiceLine());
		paramSource.addValue("role", employeeDetails.getRole());

		return paramSource;
	}

}
