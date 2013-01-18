/**
 * The class Patient creates a patient extends by a person
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.data;

import java.util.Date;

public class Patient extends Person{
	
	private Integer pid;

	//,city,address,mail,phonenumber,healthInsuranceCompany 
	public Patient (Integer gPid, String gFirstname, String gSurname, Date gDate, String gGenre, String gCity, String gAddress, String gMail, int gPhone, String gHIC){
		super(gFirstname,gSurname,gDate,gGenre,gCity,gAddress,gMail,gPhone,gHIC);
		pid = gPid;
		
	}

	public Integer getPid() {
		return pid;
	}
	
	

}
