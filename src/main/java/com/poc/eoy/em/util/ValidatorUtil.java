/**
 * 
 */
package com.poc.eoy.em.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author lugupta
 *
 */
@Component
public class ValidatorUtil {

	private static Pattern pattern;
	private static Matcher matcher;
	private static final String FULLNAME_PATTERN_REGEX = "^[\\p{L} .'-]+$";
	private static final String NUMERIC_PATTERN_REGEX = "^(0|[1-9][0-9]*)$";
	private static final String PD_PATTERN_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";

	private ValidatorUtil() {
	}

	/**
	 * Validate full name of the employee based on the FULL NAME PATTERN REGEX
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean validateFullName(final String inputString) {
		if (!StringUtils.isEmpty(inputString)) {
			pattern = Pattern.compile(FULLNAME_PATTERN_REGEX);
			matcher = pattern.matcher(inputString);
			return matcher.matches();
		}

		return false;
	}

	/**
	 * Check if input string is numeric only based on the NUMERIC PATTERN REGEX
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isNumeric(final String inputString) {
		if (!StringUtils.isEmpty(inputString)) {
			pattern = Pattern.compile(NUMERIC_PATTERN_REGEX);
			matcher = pattern.matcher(inputString);
			return matcher.matches();
		}

		return false;
	}

	/**
	 * Compare if the 2 input strings are equal
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean compareString(final String string1, final String string2) {
		if (!StringUtils.isEmpty(string1) && !StringUtils.isEmpty(string2) && string1.equals(string2)) {
			return true;
		}

		return false;
	}

	/**
	 * Validate password based upon the below policy (1.) Atleast 6 chars and
	 * max of 15 chars, (2.) Contains atleast 1 digit, (3.) Contains atleast 1
	 * lower alpha char and 1 uper alpha char, (4.) Contains atleast 1 char
	 * within a set of special chars (@#%$^ etc.), (5.) Does not contain space,
	 * tab, etc.
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean validatePassword(final String inputString) {
		if (!StringUtils.isEmpty(inputString)) {
			pattern = Pattern.compile(PD_PATTERN_REGEX);
			matcher = pattern.matcher(inputString);
			return matcher.matches();
		}

		return false;
	}

}
