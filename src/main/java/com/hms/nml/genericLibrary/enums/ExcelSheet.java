package com.hms.nml.genericLibrary.enums;
/**
 * This enum contains sheet name of excel file
 * @author Amruth N
 *
 */
public enum ExcelSheet {
	USER("User"), ADMIN("Admin"), DOCTOR("Doctor");
	
	String key;
	
	/**
	 * 
	 * This is the setter method to modify the key
	 * @param key
	 */
	private ExcelSheet (String key) {
		this.key=key;
	}
	
	
	/**
	 * This is the getter method to get the sheet name
	 * @return
	 */
	public String getSheetName(){
		return key;
	}
	
}
