package com.room.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_details")
public class MemberDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int member_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mobileno")
	private String mobileno;
	
	@Column(name = "aadharno")
	private String aadharno;
	
	@Column(name = "address")
	private String address;
	
	public MemberDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDetails(int member_id, String name, int age, String gender, String mobileno, String aadharno,
			String address) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileno = mobileno;
		this.aadharno = aadharno;
		this.address = address;
	}
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "MemberDetails [member_id=" + member_id + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", mobileno=" + mobileno + ", aadharno=" + aadharno + ", address=" + address + "]";
	}
	
}
