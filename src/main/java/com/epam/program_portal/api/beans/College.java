package com.epam.program_portal.api.beans;

public class College {
	private String collegeId="";
	private String collegeName = "";
	private String group = "";
	private String city = "";
	private String ptoName = "";
	private String ptoEmail = "";
	private String ptoMobile = "";
	private String status=null;
	
	
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPtoName() {
		return ptoName;
	}
	public void setPtoName(String ptoName) {
		this.ptoName = ptoName;
	}
	public String getPtoEmail() {
		return ptoEmail;
	}
	public void setPtoEmail(String ptoEmail) {
		this.ptoEmail = ptoEmail;
	}
	public String getPtoMobile() {
		return ptoMobile;
	}
	public void setPtoMobile(String ptoMobile) {
		this.ptoMobile = ptoMobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public College()
	{
		
	}
	College(String name, String group, String city, String ptoName, String ptoEmail, String mobile)
	{
		this.collegeName = name;
		this.group = group;
		this.city = city;
		this.ptoName = ptoName;
		this.ptoEmail= ptoEmail;
		this.ptoMobile = mobile;
	}
	public static boolean isTwoCollegesEqual(College firstCollege, College secondCollege)
	{
		return firstCollege.getCollegeName().equals(secondCollege.getCollegeName()) &&
				firstCollege.getCity().equals(secondCollege.getCity())&&
				firstCollege.getGroup().equals(secondCollege.getGroup()) &&
				firstCollege.getPtoName().equals(secondCollege.getPtoName())&&
				firstCollege.getPtoEmail().equals(secondCollege.getPtoEmail());
	}
}
