/**
 * 
 */
package com.poc.eoy.em.model;

/**
 * @author lugupta
 *
 */
public class EmployeeServiceLine {

	private Integer id;
	private String serviceLineCode;
	private String serviceLineName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceLineCode() {
		return serviceLineCode;
	}

	public void setServiceLineCode(String serviceLineCode) {
		this.serviceLineCode = serviceLineCode;
	}

	public String getServiceLineName() {
		return serviceLineName;
	}

	public void setServiceLineName(String serviceLineName) {
		this.serviceLineName = serviceLineName;
	}

}
