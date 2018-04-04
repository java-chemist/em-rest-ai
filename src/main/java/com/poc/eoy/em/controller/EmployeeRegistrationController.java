/**
 * 
 */
package com.poc.eoy.em.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.form.EmployeeRegistrationForm;
import com.poc.eoy.em.model.EmployeeDetails;
import com.poc.eoy.em.service.EmployeeRegistrationService;
import com.poc.eoy.em.validator.EmployeeRegistrationValidator;

/**
 * This class renders the Employee Registration screen
 * 
 * @author lugupta
 *
 */
@Controller
public class EmployeeRegistrationController {

	private static final Logger logger = Logger.getLogger(EmployeeRegistrationController.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	EmployeeRegistrationValidator employeeRegistrationValidator;

	@Autowired
	EmployeeRegistrationService employeeRegistrationService;

	/**
	 * Display page to register a new employee
	 * 
	 * @param employeeRegistrationForm
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = { GenericConstants.URL_REGISTRATION }, method = RequestMethod.GET)
	public String showEmployeeRegistrationPage(
			@ModelAttribute("employeeRegistrationForm") EmployeeRegistrationForm employeeRegistrationForm,
			Model model) {
		try {
			this.populateEmployeeRegistrationPageDefaults(model);
			model.addAttribute("employeeRegistrationForm", employeeRegistrationForm);

			if (model.asMap().containsKey(GenericConstants.STRING_VALUE_RESULT)) {
				model.addAttribute("org.springframework.validation.BindingResult.employeeRegistrationForm",
						model.asMap().get(GenericConstants.STRING_VALUE_RESULT));
			}
			return GenericConstants.PAGE_REGISTRATION;
		} catch (Exception e) {
			errorLogger.error(
					"Classname: EmployeeRegistrationController. Error in loading Employee Registration page: " + e);
			logger.error("Error in loading Employee Registration page: " + e);
			model.addAttribute("message",
					"Error in loading Employee Registration page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}
	}

	/**
	 * Validate the employee details and save the employee details in the
	 * database
	 * 
	 * @param response
	 * @param employeeRegistrationForm
	 * @param model
	 * @param result
	 * @param redir
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_PROCESS_REGISTRATION, params = GenericConstants.PARAM_BUTTON_REGISTER, method = RequestMethod.POST)
	public String employeeRegistrationHandlerPOST(
			@ModelAttribute("employeeRegistrationForm") EmployeeRegistrationForm employeeRegistrationForm, Model model,
			BindingResult result, RedirectAttributes redir) {

		try {
			populateEmployeeRegistrationPageDefaults(model);
			employeeRegistrationValidator.validate(employeeRegistrationForm, result);

			EmployeeDetails existingEmployee = employeeRegistrationService
					.findEmployeeById(employeeRegistrationForm.getEmployeeNumber());

			if (null != existingEmployee && existingEmployee.getId() > 0) {
				result.rejectValue("employeeNumber", "register.empnumber.exist");
			}

			if (result.hasErrors()) {
				redir.addFlashAttribute("errors", "errors");
				redir.addFlashAttribute(GenericConstants.STRING_VALUE_RESULT, result);
				redir.addFlashAttribute("employeeRegistrationForm", employeeRegistrationForm);

				return "redirect:" + GenericConstants.URL_REGISTRATION;
			}

			employeeRegistrationService.saveEmployeeDetails(employeeRegistrationForm);
			redir.addFlashAttribute("success", "Employee Registration successful.");

			return "redirect:" + GenericConstants.URL_REGISTRATION;
		} catch (Exception e) {
			errorLogger.error("Classname: EmployeeRegistrationController. Error in Employee Registration: " + e);
			logger.error("Error in Employee Registration: " + e);
			model.addAttribute("message",
					"Error in Employee Registration. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}
	}

	/**
	 * Populate the values in the dropdown boxes
	 * 
	 * @param model
	 * @throws Exception
	 */
	private void populateEmployeeRegistrationPageDefaults(Model model) throws Exception {
		Map<String, String> designations = employeeRegistrationService.getAllDesignationsMap();
		Map<String, String> serviceLines = employeeRegistrationService.getAllServiceLinesMap();
		Map<String, String> roles = employeeRegistrationService.getAllRolesMap();

		model.addAttribute("designations", designations);
		model.addAttribute("serviceLines", serviceLines);
		model.addAttribute("roles", roles);
	}

}
