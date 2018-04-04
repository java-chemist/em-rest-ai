/**
 * 
 */
package com.poc.eoy.em.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.poc.eoy.em.constants.GenericConstants;

/**
 * @author lugupta
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	private static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		logger.error("[URL] : {} " + req.getRequestURL(), e);
		errorLogger.error("[URL] : {} " + req.getRequestURL(), e);

		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handleo it
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		// Otherwise setup and send the user to a default error-view.
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(GenericConstants.DEFAULT_ERROR_VIEW);
		return mav;
	}

}