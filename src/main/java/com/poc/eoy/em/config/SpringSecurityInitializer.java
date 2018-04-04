/**
 * 
 */
package com.poc.eoy.em.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class is used to register the spring security filter chain
 * 
 * @author lugupta
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	public boolean enableHttpSessionEventPublisher() {
		return true;
	}

}