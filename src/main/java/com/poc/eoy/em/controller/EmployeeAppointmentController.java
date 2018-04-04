/**
 * 
 */
package com.poc.eoy.em.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.service.EmployeeDashboardService;
import com.poc.eoy.em.util.DateUtil;

/**
 * This class renders the Employee Dashboard screen
 * 
 * @author lugupta
 */
@Controller
public class EmployeeAppointmentController {

	private static final Logger logger = Logger.getLogger(EmployeeAppointmentController.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	EmployeeDashboardService employeeDashboardService;

	/**
	 * This method shows the list of all the appointments
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_APPOINTMENT, method = RequestMethod.GET)
	public String showEmployeeAppointments(Model model) {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(this.getFileWithUtil(GenericConstants.FILE_NAME_APPOINTMENT_JSON));
			JSONObject jsonObject = (JSONObject) obj;

			model.addAttribute("appointmentJson", jsonObject);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error(
					"Classname: EmployeeAppointmentController. Error in loading Employee Appointment page: " + e);
			logger.error("Error in loading Employee Appointment page: " + e);
			model.addAttribute("message",
					"Error in loading Employee Appointment page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_APPOINTMENT;
	}

	/**
	 * Get the Full Name and Current Date of the logged in user
	 * 
	 * @return
	 */
	private String getLoggedInUserAndDate() {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return "Welcome <b>" + employeeDashboardService.findEmployeeById(user.getUsername()) + "</b>. " + "\t"
					+ " Logged on: " + DateUtil.getDayAndDateInString(new Date());
		} catch (Exception e) {
			errorLogger.error("Classname: EmployeeAppointmentController. Guest login: " + e);
			return "Welcome <b>Guest</b>";
		}
	}

	/**
	 * Read the JSON file for appointments list
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileWithUtil(String fileName) {
		String result = "";
		ClassLoader classLoader = getClass().getClassLoader();

		try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			errorLogger
					.error("Classname: EmployeeAppointmentController. Error reading JSON file for appointments: " + e);
		}

		return result;
	}
}
