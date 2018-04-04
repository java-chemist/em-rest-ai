/**
 * 
 */
package com.poc.eoy.em.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.form.EmployeeDashboardForm;
import com.poc.eoy.em.service.EmployeeDashboardService;
import com.poc.eoy.em.util.DateUtil;

/**
 * This class renders the Employee Dashboard screen
 * 
 * @author lugupta
 */
@Controller
public class EmployeeDashboardController {

	private static final Logger logger = Logger.getLogger(EmployeeDashboardController.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	EmployeeDashboardService employeeDashboardService;

	/**
	 * This method shows the list of all the employees
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_DASHBOARD, method = RequestMethod.GET)
	public String showEmployeeDashboard(Model model) {
		try {
			int countOfPages = this.getCountOfPages(employeeDashboardService.getEmployeesCount());
			List<EmployeeDashboardForm> employeeDashboardForms = employeeDashboardService.getPaginatedEmployees(0);

			model.addAttribute("countOfPages", countOfPages);
			model.addAttribute("employeeDashboardForms", employeeDashboardForms);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: EmployeeDashboardController. Error in loading Employee Dashboard page: " + e);
			logger.error("Error in loading Employee Dashboard page: " + e);
			model.addAttribute("message",
					"Error in loading Employee Dashboard page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_DASHBOARD;
	}

	/**
	 * This method implements pagination and displays the no of records based on
	 * the selected page
	 * 
	 * @param pageid
	 * @param model
	 * @param redir
	 * @return
	 */
	@RequestMapping(value = "/pagination/{pageid}", method = RequestMethod.GET)
	public String paginationHandlerPOST(@PathVariable int pageid, Model model) {
		try {
			int countOfPages = this.getCountOfPages(employeeDashboardService.getEmployeesCount());
			int recordNum = (pageid - 1) * GenericConstants.TOTAL_RECORDS_DISPLAY_PAGINATION;
			List<EmployeeDashboardForm> employeeDashboardForms = employeeDashboardService
					.getPaginatedEmployees(recordNum);

			model.addAttribute("countOfPages", countOfPages);
			model.addAttribute("employeeDashboardForms", employeeDashboardForms);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error(
					"Classname: EmployeeDashboardController. Error in pagination of Employee Dashboard page: " + e);
			logger.error("Error in pagination of Employee Dashboard page: " + e);
			model.addAttribute("message",
					"Error in pagination of Employee Dashboard page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_DASHBOARD;
	}

	/**
	 * Get the total number of pages to display based upon the total records in
	 * the database
	 * 
	 * @param totalRecordsCount
	 * @return
	 */
	private Integer getCountOfPages(Integer totalRecordsCount) {
		int totalRecordsToDisplay = GenericConstants.TOTAL_RECORDS_DISPLAY_PAGINATION;
		int totalCountOfPages;

		if ((totalRecordsCount % totalRecordsToDisplay) == 0) {
			totalCountOfPages = totalRecordsCount / totalRecordsToDisplay;
		} else {
			totalCountOfPages = (totalRecordsCount / totalRecordsToDisplay) + 1;
		}

		return totalCountOfPages;
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
			errorLogger.error("Classname: EmployeeDashboardController. Guest login: " + e);
			return "Welcome <b>Guest</b>";
		}
	}
}
