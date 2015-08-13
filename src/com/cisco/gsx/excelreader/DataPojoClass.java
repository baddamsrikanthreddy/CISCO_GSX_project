package com.cisco.gsx.excelreader;

public class DataPojoClass {
	
	private String sno;
	private String testname;
	private String userName;
	private String password;
	private String Status;
	private String firstName;
	private String county;
	private String city;
	private String contactName;
	private String phoneNumber;
	private String emailAddress;
	private String role;
	private String tshirtSize;
	private String dietaryRequirements;
	private String additionalOnsiteAssistance;
	private String travelingFrom;
	private String roomShareInfo;
	private String hotelGender;
	private String smoking;
	private String searchOrSelectRoommate;
	private String checkin;
	private String checkout;
	private String filterBy;
	private String state;
	private String regCode;
	private String countries;
	private String travelArrangements;
	
	public String getSno() {
		System.out.println("This is from Data Pojo class get method");
		return this.sno;
	}
	public void setSno(String sno) {
		System.out.println("This is from Data Pojo class set method");
		this.sno = sno;
	}
	public String getTestname() {
		return this.testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String xparam1) {
		this.userName = xparam1;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String xparam2) {
		this.password = xparam2;
	}	
	public String getStatus() {
		return this.Status;
	}
	public void setStatus(String status) {
		this.Status = status;
	}
	
	public void setFirstName(String name){
		this.firstName = name;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setCounty(String County){
		this.county = County;
	}
	public String getCounty() {
		return this.county;
	}
	public void setCity(String City){
		this.city = City;
	}
	public String getCity() {
		return this.city;
	}
	public void setContactName(String contactname){
		this.contactName = contactname;
	}
	public String getContactName() {
		return this.contactName;
	}
	public void setPhoneNumber(String phonenumber){
		this.phoneNumber = phonenumber;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setEmailAddress(String emailaddress){
		this.emailAddress = emailaddress;
	}
	public String getEmailAddress() {
		return this.emailAddress;
	}
	public void setRole(String Role){
		this.role = Role;
	}
	public String getRole() {
		return this.role;
	}
	public void setTshirtSize(String tshirtsize){
		this.tshirtSize = tshirtsize;
	}
	public String getTshirtSize() {
		return this.tshirtSize;
	}
	public void setDietaryRequirements(String dietaryrequirements){
		this.dietaryRequirements = dietaryrequirements;
	}
	public String getDietaryRequirements() {
		return this.dietaryRequirements;
	}
	public void setAdditionalOnsiteAssistance(String additionalOnsiteassistance){
		this.additionalOnsiteAssistance = additionalOnsiteassistance;
	}
	public String getAdditionalOnsiteAssistance() {
		return this.additionalOnsiteAssistance;
	}
	public void setTravelingFrom(String travelingfrom){
		this.travelingFrom = travelingfrom;
	}
	public String getTravelingFrom() {
		return this.travelingFrom;
	}
	public void setRoomShareInfo(String RoomShareInfo){
		this.roomShareInfo = RoomShareInfo;
	}
	public String getRoomShareInfo() {
		return this.roomShareInfo;
	}
	public void setHotelGender(String HotelGender){
		this.hotelGender = HotelGender;
	}
	public String getHotelGender() {
		return this.hotelGender;
	}
	public void setSmoking(String Smoking){
		this.smoking = Smoking;
	}
	public String getSmoking() {
		return this.smoking;
	}
	public void setSearchOrSelectRoommate(String SearchOrSelectRoommate){
		this.searchOrSelectRoommate = SearchOrSelectRoommate;
	}
	public String getSearchOrSelectRoommate() {
		return this.searchOrSelectRoommate;
	}
	public void setCheckin(String Checkin){
		this.checkin = Checkin;
	}
	public String getCheckin() {
		return this.checkin;
	}
	public void setCheckout(String Checkout){
		this.checkout = Checkout;
	}
	public String getCheckout() {
		return this.checkout;
	}
	public void setFilterBy(String FilterBy){
		this.filterBy = FilterBy;
	}
	public String getFilterBy() {
		return this.filterBy;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	public void setRegCode(String regCode){
		this.regCode = regCode;
	}
	public String getRegCode() {
		return this.regCode;
	}
	public void setCountries(String countries){
		this.countries = countries;
	}
	public String getCountries() {
		return this.countries;
	}
	public String getTravelArrangements() {
		return this.travelArrangements;
	}
	public void setTravelArrangements(String travelArrangements) {
		this.travelArrangements = travelArrangements;
	}
}
