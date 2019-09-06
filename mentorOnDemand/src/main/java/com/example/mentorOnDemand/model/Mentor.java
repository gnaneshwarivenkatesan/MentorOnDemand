package com.example.mentorOnDemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {
	@Override
	public String toString() {
		return "Mentor [regCode=" + regCode + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", linkedIn=" + linkedIn + ", technology=" + technology + ", slotTime=" + slotTime + ", regDateTime="
				+ regDateTime + ", active=" + active + ", experience=" + experience + ", email=" + email + ", password="
				+ password + ", mrequest=" + mrequest + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reg_code")
	private int regCode;
	@Column(name = "name")
	private String name;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "linkedIn")
	private String linkedIn;
	@Column(name = "technology")
	private String technology;
	@Column(name = "slot_time")
	private String slotTime;
	@Column(name = "reg_date_time")
	private String regDateTime;
	@Column(name="active")
	private boolean active;


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "experience")
	private String experience;
	@Column(name = "email")
	private String email;
	@Column(name="password")
private String password;
	@Column(name="request")
	private String mrequest;
	public String getMrequest() {
		return mrequest;
	}

	public void setMrequest(String mrequest) {
		this.mrequest = mrequest;
	}

	public int getRegCode() {
		return regCode;
	}

	public void setRegCode(int regCode) {
		this.regCode = regCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
