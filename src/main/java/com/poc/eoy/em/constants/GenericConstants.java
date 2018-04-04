/**
 * 
 */
package com.poc.eoy.em.constants;

/**
 * @author lugupta
 *
 */
public class GenericConstants {

	/* APPLICATION CONSTANTS */
	public static final String LOGGER_ERROR_NAME = "errorfile";
	public static final String STRING_EMPTY = "";
	public static final String ROLE_UNDERSCORE = "ROLE_";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String SDF_MM_DD_YYYY_HH_MM = "MM/dd/yyyy HH:mm";
	public static final String SDF_E_MM_DD_YYYY = "EEEE, MM/dd/yyyy";
	public static final int MAX_SESSIONS = 1;
	public static final String STRING_VAL_MESSAGE = "message";
	public static final String STRING_VALUE_RESULT = "result";
	public static final String STRING_VALUE_NEW_PD = "newPassword";
	// Session Timeout - 5 * 60 = 5 minutes
	public static final int SESSION_TIMEOUT = 5 * 60;
	// Max records to display on dashboard screen
	public static final int TOTAL_RECORDS_DISPLAY_PAGINATION = 5;
	public static final String FILE_NAME_APPOINTMENT_JSON = "appointments.json";

	/* REQUEST MAPPING URL */
	public static final String URL_SLASH = "/";
	public static final String URL_LOGIN = "/login";
	public static final String URL_LOGOUT = "/logout";
	public static final String URL_LOGOUTSUCCESS = "/logoutSuccessful";
	public static final String URL_ACCESSDENIED = "/403";
	public static final String URL_INVALIDSESSION = "/invalidSession";
	public static final String URL_SESSIONEXPIRED = "/sessionExpired";
	public static final String URL_DASHBOARD = "/dashboard";
	public static final String URL_REGISTRATION = "/registration";
	public static final String URL_PROCESS_REGISTRATION = "/processEmployeeRegistrationForm";
	public static final String URL_APPOINTMENT = "/appointment";
	public static final String URL_REST_SERVICE = "/assist";

	/* VIEW PAGE NAME */
	public static final String PAGE_LOGIN = "loginPage";
	public static final String PAGE_ACCESSDENIED = "403Page";
	public static final String PAGE_INVALIDSESSION = "invalidSessionPage";
	public static final String PAGE_SESSIONEXPIRED = "sessionExpiredPage";
	public static final String PAGE_ERROR = "errorPage";
	public static final String PAGE_REGISTRATION = "registrationPage";
	public static final String PAGE_DASHBOARD = "dashboardPage";
	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String PAGE_APPOINTMENT = "appointmentPage";

	/* CONTROLLER PARAMS */
	public static final String PARAM_BUTTON_REGISTER = "employeeRegistration";

	private GenericConstants() {
	}

}
