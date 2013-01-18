/**
 * The class Person creates a person
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.data;

import java.io.Serializable;
import java.util.Date;



public class Person implements Serializable {

	protected String firstName = "";
	private String lastName = "";
	private String city = "";
	private String mail = "";
	private Date birthdate;
	private Integer phoneNumber;
	private String address = "";
	private String healthInsuranceCompany = "";
	private String genre;

	public Person() {
	}

	public Person(String gFirstName, String gLastname, String gCity,
			String gMail, Date gBirthdate, Integer gPhoneNumber,
			String gAddress, String gHIC) {
		firstName = gFirstName;
		lastName = gLastname;
		city = gCity;
		mail = gMail;
		birthdate = gBirthdate;
		phoneNumber = gPhoneNumber;
		address = gAddress;
		healthInsuranceCompany = gHIC;

	}

	public Person(String gFirstname, String gSurname, Date gBirthdate,
			String gGenre) {
		firstName = gFirstname;
		lastName = gSurname;
		birthdate = gBirthdate;
		genre = gGenre;
	}

	public Person(String gFirstname, String gSurname, Date gBirthdate,
			String gGenre, String gCity, String gAddress, String gMail,
			int gPhone, String gHIC) {
		firstName = gFirstname;
		lastName = gSurname;
		birthdate = gBirthdate;
		genre = gGenre;
		city = gCity;
		mail = gMail;
		phoneNumber = gPhone;
		address = gAddress;
		healthInsuranceCompany = gHIC;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGenre() {
		return genre;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHealthInsuranceCompany() {
		return healthInsuranceCompany;
	}

	public void setHealthInsuranceCompany(String healthInsuranceCompany) {
		this.healthInsuranceCompany = healthInsuranceCompany;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
