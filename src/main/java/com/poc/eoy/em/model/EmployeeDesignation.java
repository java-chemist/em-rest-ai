/**
 * 
 */
package com.poc.eoy.em.model;

/**
 * @author lugupta
 *
 */
public class EmployeeDesignation {

	private Integer id;
	private String designationCode;
	private String designationName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

}
