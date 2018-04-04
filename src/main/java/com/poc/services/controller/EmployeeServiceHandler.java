package com.poc.services.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.services.pojo.AssistanceDetails;

@RestController
public class EmployeeServiceHandler {
	private static final Logger logger = Logger.getLogger(EmployeeServiceHandler.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@RequestMapping(value = GenericConstants.URL_REST_SERVICE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AssistanceDetails assistRestService(@RequestBody AssistanceDetails assistanceDetails) {
		try {
			logger.error("<============= Successfull entry to assistRestService ==========>");
			return assistanceDetails;
		} catch (Exception e) {
			errorLogger.error("Classname: EmployeeDashboardController. Error in loading Employee Dashboard page: " + e);
			logger.error("Error in loading Employee Dashboard page: " + e);

			return assistanceDetails;
		}
	}
}
