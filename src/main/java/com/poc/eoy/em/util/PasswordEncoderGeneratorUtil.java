/**
 * 
 */
package com.poc.eoy.em.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lugupta
 *
 */
@Component
public class PasswordEncoderGeneratorUtil {

	private PasswordEncoderGeneratorUtil() {
	}

	/**
	 * Encode the input string using BCryptPasswordEncoder algorithm
	 * 
	 * @param password
	 * @return
	 */
	public static String bCryptPasswordEncoder(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

}
