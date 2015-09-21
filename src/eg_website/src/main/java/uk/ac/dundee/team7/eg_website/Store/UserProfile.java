package uk.ac.dundee.team7.eg_website.Store;

public class UserProfile {

	private String firstName;
	private String lastName;
	private String mobile;
	private String contactNumber;
	private String yearOfStudy;
	private String matricNumber;
	private Boolean youngES_FLAG;
	private String country;
	private String institution;
	private String status;
	private String college;
	private String degree;

    public UserProfile(String firstName, String lastName, String mobile, String contactNumber, String yearOfStudy, String matricNumber, Boolean youngES_FLAG, String country, String institution, String status, String college, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.contactNumber = contactNumber;
        this.yearOfStudy = yearOfStudy;
        this.matricNumber = matricNumber;
        this.youngES_FLAG = youngES_FLAG;
        this.country = country;
        this.institution = institution;
        this.status = status;
        this.college = college;
        this.degree = degree;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public Boolean getYoungES_FLAG() {
        return youngES_FLAG;
    }

    public void setYoungES_FLAG(Boolean youngES_FLAG) {
        this.youngES_FLAG = youngES_FLAG;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

        
}