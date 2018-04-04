/**
 * 
 */
package com.poc.eoy.em.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.poc.eoy.em.constants.GenericConstants;

/**
 * This class tracks the numbe of active sessions in the application
 * 
 * @author lugupta
 */
public class SessionListener implements HttpSessionListener {

	private static final Logger logger = Logger.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.debug("==== Session is created ====");
		event.getSession().setMaxInactiveInterval(GenericConstants.SESSION_TIMEOUT);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.debug("==== Session is destroyed ====");
	}
}