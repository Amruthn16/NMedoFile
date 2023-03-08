package com.hms.nml.genericLibrary.enums;

/**
 * This enum contains common tabs present in the testscripts   
 * @author amruth
 *
 */
public enum TabNames {
	DASHBOARD("Dashboard"),
	BOOKAPPOINTMENT("Book Appointment"),
	APPOINTMENTHISTORY("Appointment History"),
	MEDICALHISTORY("Medical History"),
	DOCTORS("Doctors"),
	USERS("Users"),
	PATIENTS("Patients"),
	CONTACTUSQUEREIS("Conatctus Queries"),
	DOCTORSSESSIONLOGS("Doctor Session Logs"),
	USERSSESSIONLOGS("User Session Logs"),
	REPORTS("Reports"),
	PATIENTSEARCH("Patient Search"),
	MANAGEDOCTORS("Manage Doctors"),
	ADDDOCTOR("Add Doctor"),
	DOCTORSPECIALIZATION("Doctor Specialization"),
	SEARCH(""),
	ADDPATIENT("Add Patient"),
	MANAGEPATIENT("Manage Patient");
	
	
	String tabs;

	/**
	 * 
	 * This is the setter method to modify the tabs
	 * @param tabs
	 */
	private TabNames(String tabs) {
		this.tabs=tabs;
	}
	

	/**
	 * This is the getter method to get the tabs
	 * @return
	 */
	public String getTabNames() {
		return tabs;
	}
	
	
}
