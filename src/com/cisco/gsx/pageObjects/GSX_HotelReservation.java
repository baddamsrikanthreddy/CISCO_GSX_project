package com.cisco.gsx.pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_HotelReservation {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;

	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public static void validateRegistration() {
		CommonUtil.waitForPageload();
		actualMsg = "Room Information";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.roominformation.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User registered to GSX successfully";
			expectedMsg = "User should register to GSX successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to register to GSX";
			expectedMsg = "User should register to GSX successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}

	public static void enterRoomInfo(DataPojoClass pojo) {
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.edit.travelandhotel.editbutton"));
		CommonUtil.waitForPageload();
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.registration.hotels.button.makehotelreservation"));
		CommonUtil.waitForPageload();
		validateRegistration();
		if (pojo.getRoomShareInfo()
				.equalsIgnoreCase(
						commonProperties
								.getProperty("cisco.gsx.roominfo.autoassignmearoommate"))) {
			System.out
					.println("********Auto Assign Me a Roommate*************");
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"),
							pojo.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.smoking"),
							pojo.getSmoking());
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.continue"));
		} else if (pojo.getRoomShareInfo().equalsIgnoreCase(
				commonProperties
						.getProperty("cisco.gsx.roominfo.iwantmyownroom"))) {
			System.out.println("********I Want My Own Room*************");
			CommonUtil.selectValueFromDropDownBox(elementProperties
					.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"), pojo
					.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.singleroomrequest.payingrateonown"));
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.smoking"),
							pojo.getSmoking());
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.continue"));
		} else {
			System.out
					.println("********I Will Choose My Own Roommate*************");
			// System.out.println(pojo.getRoomShareInfo());
			// System.out.println(commonProperties.getProperty("cisco.gsx.roominfo.autoassignmearoommate"));
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.roomshareinfo"),
							pojo.getRoomShareInfo());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.gender"),
							pojo.getHotelGender());
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.smoking"),
							pojo.getSmoking());
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.selectarommate.click"));
			CommonUtil
					.enterText(
							elementProperties
									.getProperty("cisco.gsx.registration.roominformation.selectarommate.text"),
							pojo.getSearchOrSelectRoommate());
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.roominformation.continue"));
		}
		CommonUtil.waitForPageload();

	}

	public static void validateRoomShareInfo() {
		CommonUtil.waitForPageload();
		actualMsg = "Select Your Dates";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selectyourdates.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User provided room share info and selected rommate successfully";
			expectedMsg = "User should able to select room share info and select roomate accordingly";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to provided room share info and selected rommate";
			expectedMsg = "User should able to select room share info and select roomate accordingly";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}

	public static void selectDates(DataPojoClass pojo) {
		/*CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.edit.travelandhotel.editbutton"));
		CommonUtil.waitForPageload();
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.hotels.button.makehotelreservation"));*/
		CommonUtil.waitForPageload();
		CommonUtil.selectValueFromDropDownBox(elementProperties
				.getProperty("cisco.gsx.registration.selectyourdates.checkin"),
				pojo.getCheckin());
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.selectyourdates.checkout"),
						pojo.getCheckout());
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.selectyourdates.continue"));
		CommonUtil.waitForPageload();
	}

	public static void validateCheckinCheckoutInfo() throws InterruptedException {
		CommonUtil.waitForPageload();
		Thread.sleep(4000);
		actualMsg = "Please select the hotel you wish to stay:";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.text"));
		System.out.println("*************exp"+expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected check-in and check-out dates successfully";
			expectedMsg = "User should able to select check-in and check-out dates successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select check-in and check-out dates";
			expectedMsg = "User should able to select check-in and check-out dates successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}	

	public static void selectaHotel(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		/*CommonUtil.selectValueFromDropDownBox(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.filterby"),
				pojo.getFilterBy());*/
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.select"));
		CommonUtil.waitForPageload();
	}
	
	public static void validateSelectHotelInfo(){
		CommonUtil.waitForPageload();
		actualMsg = "Please confirm the below details";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.selecthotel.bookhotel.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected a hotel successfully";
			expectedMsg = "User should able to select a hotel successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select a hotel";
			expectedMsg = "User should able to select a hotel successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}
	
	public static void bookaHotel(DataPojoClass pojo) {
		CommonUtil.waitForPageload();	
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.selecthotel.bookhotel.booknow"));
		CommonUtil.waitForPageload();
	}

	public static void validateHotelBookingInfo() {
		CommonUtil.waitForPageload();
		actualMsg = "Please confirm the below details";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User selected a hotel successfully";
			expectedMsg = "User should able to select a hotel successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to select a hotel";
			expectedMsg = "User should able to select a hotel successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}

	public static void enterPaymentInfo(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.Paymentinfo.processhotelreservation"));
		CommonUtil.waitForPageload();
	}
	
	public static void validatePaymentInfo() {
		CommonUtil.waitForPageload();
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User registration succeed";
			expectedMsg = "User should able to register successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User registration failed";
			expectedMsg = "User should able to register successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
}
