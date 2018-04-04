/**
 * 
 */
package com.poc.eoy.em.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.poc.eoy.em.constants.GenericConstants;
import com.poc.eoy.em.form.EmployeeRegistrationForm;
import com.poc.eoy.em.util.ValidatorUtil;

/**
 * @author lugupta
 *
 */
@Component
public class EmployeeRegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeRegistrationForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName", "register.empname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeNumber", "register.empnumber.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, GenericConstants.STRING_VALUE_NEW_PD,
				"register.newpwd.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "register.confirmpwd.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "register.des.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serviceLine", "register.sl.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "register.role.required");

		EmployeeRegistrationForm employeeRegistrationForm = (EmployeeRegistrationForm) target;

		if (null != employeeRegistrationForm) {

			if (!StringUtils.isEmpty(employeeRegistrationForm.getEmployeeName())
					&& !ValidatorUtil.validateFullName(employeeRegistrationForm.getEmployeeName())) {
				errors.rejectValue("employeeName", "register.empname.invalid");
			}

			if (!StringUtils.isEmpty(employeeRegistrationForm.getEmployeeNumber())
					&& !ValidatorUtil.isNumeric(employeeRegistrationForm.getEmployeeNumber())) {
				errors.rejectValue("employeeNumber", "register.empnumber.invalid");
			}

			if (!StringUtils.isEmpty(employeeRegistrationForm.getNewPassword())
					&& !StringUtils.isEmpty(employeeRegistrationForm.getConfirmPassword())) {

				if (!ValidatorUtil.validatePassword(employeeRegistrationForm.getNewPassword())) {
					errors.rejectValue(GenericConstants.STRING_VALUE_NEW_PD, "register.newpwd.invalid");
				} else if (!ValidatorUtil.compareString(employeeRegistrationForm.getNewPassword(),
						employeeRegistrationForm.getConfirmPassword())) {
					errors.rejectValue(GenericConstants.STRING_VALUE_NEW_PD, "register.pwd.mismatch");
				}
			}
		}
	}

}
