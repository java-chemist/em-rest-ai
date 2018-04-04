/**
 * 
 */
package com.poc.eoy.em.authentication;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.dao.EmployeeDAO;
import com.poc.eoy.em.model.EmployeeDetails;

/**
 * This class implements Spring Security User Details Service to load user
 * specific data of the Employee based on Employee Number
 * 
 * @author lugupta
 */
@Service
public class CustomAuthenticationService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomAuthenticationService.class);
	private static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public UserDetails loadUserByUsername(String employeeNumber) {

		try {
			logger.debug("START loadUserByUsername() in CustomAuthenticationService.class");

			EmployeeDetails employeeDetails = employeeDAO.findEmployeeById(Integer.valueOf(employeeNumber));

			if (null == employeeDetails) {
				errorLogger.error("Classname: CustomAuthenticationService. Employee Detail with employee number "
						+ employeeNumber + " not present in the database");
				logger.error("Employee number " + employeeNumber + " not found in the db");

				throw new UsernameNotFoundException(
						"Employee Details with employee number " + employeeNumber + " was not found in the database");
			}

			logger.debug("Employee Name: " + employeeDetails.getEmployeeName());

			List<GrantedAuthority> grantList = new ArrayList<>();
			GrantedAuthority authority = new SimpleGrantedAuthority(
					GenericConstants.ROLE_UNDERSCORE + GenericConstants.ROLE_ADMIN);
			grantList.add(authority);

			UserDetails userDetails = (UserDetails) new User(employeeDetails.getEmployeeNumber().toString(),
					employeeDetails.getPassword(), grantList);

			logger.debug("END loadUserByUsername() in CustomAuthenticationService.class");

			return userDetails;
		} catch (Exception e) {
			errorLogger.error("Classname: CustomAuthenticationService. Employee Details with employee number "
					+ employeeNumber + " was not found in the database" + e);
			logger.error("Emp Num " + employeeNumber + " not available" + e);

			throw new UsernameNotFoundException("Employee ID " + employeeNumber + " missing");
		}
	}

}