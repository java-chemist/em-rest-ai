/**
 * 
 */
package com.poc.eoy.em.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.poc.eoy.em.constants.GenericConstants;

/**
 * @author lugupta
 *
 */
@Component
public class DateUtil {

	private DateUtil() {
	}

	/**
	 * Get today date in String
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateInString(Date date) {
		return new SimpleDateFormat(GenericConstants.SDF_MM_DD_YYYY_HH_MM).format(date);
	}

	/**
	 * Get today day and date in String
	 * 
	 * @param date
	 * @return
	 */
	public static String getDayAndDateInString(Date date) {
		return new SimpleDateFormat(GenericConstants.SDF_E_MM_DD_YYYY).format(date);
	}

}
