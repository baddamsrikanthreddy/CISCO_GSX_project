package com.cisco.gsx.pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_RegistrationPage {
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

	public static void validateRegistrationPage() {
		CommonUtil.waitForPageload();
		actualMsg = "GSX FY16";
		expectedMsg = CommonUtil.getTitle();
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User loggedin to the GSX successfully";
			expectedMsg = "User should be login to the GSX successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User login is not succeed";
			expectedMsg = "User should be login to the GSX successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void enterContactInformation(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		// CommonUtil.takeScreenShot();
		/*CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.lasvegas"));*/

		CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.preferedfirstname"),
						pojo.getFirstName());
		if (stateField(pojo)) {
			System.out.println("State field");
			
		}
		CommonUtil.enterText(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.county"), pojo
				.getCounty());
		CommonUtil.enterText(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.city"), pojo
				.getCity());
		CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.emergencycontactname"),
						pojo.getContactName());
		CommonUtil
				.enterText(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.emergencycontactphonenumber"),
						pojo.getPhoneNumber());
		String scenario = pojo.getRegCode();
		if ((scenario.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				|| (scenario.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (scenario.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
			// do nthg
		} else {
			CommonUtil
					.enterText(
							elementProperties
									.getProperty("cisco.gsx.registration.contactinfo.emailaddress"),
							pojo.getEmailAddress());
		}
		// CommonUtil.takeScreenShot();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.contactinfo.continue"));

		CommonUtil.waitForPageload();

	}

	public static void validateContactInformation() {
		CommonUtil.waitForPageload();
		// CommonUtil.takeScreenShot();
		actualMsg = "Additional Questions";
		expectedMsg = CommonUtil
				.getText(elementProperties
						.getProperty("cisco.gsx.registration.keyquestions.keyquestionstext"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User entered contact information successfully";
			expectedMsg = "User should enter contact information successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter contact information";
			expectedMsg = "User should enter contact information successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();

	}

	public static boolean stateField(DataPojoClass pojo) {
		System.out.println("Country name is" +pojo.getTravelingFrom());
		String expectedCountry = pojo.getTravelingFrom();
		if(expectedCountry.equalsIgnoreCase("Australia")){
			actualMsg = "STATE";
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.registration.contactinfo.state.text1"));
			System.out.println("State field is present");
		}else{
			actualMsg = "STATE";
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.registration.contactinfo.state.text"));
			System.out.println("States field is present");
		}		
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("State field is present");
			if(expectedCountry.equalsIgnoreCase("Australia")){
				CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.state.dropdown1"),
						pojo.getState());
			}else{
				CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.contactinfo.state.dropdown"),
						pojo.getState());
			}
			return true;
		} else
			return false;
	}

	public static void enterKeyQuestions(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		String scenario1 = pojo.getRegCode();
		if ((scenario1.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.eventstaff")))
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.supportstaff")))
				|| (scenario1.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hubstaff")))) {
			CommonUtil.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.continue"));
		} else {
			CommonUtil.selectValueFromDropDownBox(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.role"),
					pojo.getRole());
			String scenario = pojo.getRegCode();
			if ((scenario.equalsIgnoreCase(commonProperties
					.getProperty("cisco.regcode.attendee")))
					|| (scenario.equalsIgnoreCase(commonProperties
							.getProperty("cisco.regcode.hallfame")))) {
				CommonUtil
						.click(elementProperties
								.getProperty("cisco.gsx.registration.keyquestions.supportpartnerorganization"));
			}
			CommonUtil
					.selectValueFromDropDownBox(
							elementProperties
									.getProperty("cisco.gsx.registration.keyquestions.tshirtsize"),
							pojo.getTshirtSize());
			CommonUtil.click(elementProperties
					.getProperty("cisco.gsx.registration.keyquestions.continue"));
		}
		CommonUtil.waitForPageload();
	}

	public static void validateKeyQuestionsInformation() {
		CommonUtil.waitForPageload();
		actualMsg = "Flight & Onsite Information";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.travelonsiteinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User entered key questions successfully";
			expectedMsg = "User should enter key questions successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter key questions information";
			expectedMsg = "User should enter key questions successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}

	public static void enterTravelAndOnsiteInfo(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		CommonUtil
				.selectValueFromDropDownBox(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.travelarrangements.yes"),
						pojo.getTravelArrangements());
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.travelonsiteinfo.countryTravelingFrom"),
						pojo.getTravelingFrom());
		String scenario = pojo.getCountries();
		if (scenario.equalsIgnoreCase(commonProperties
				.getProperty("cisco.scenario.NonCTN"))) {
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.yes"));
			verifyLinkForInvitationLetter(pojo);
		} else {
			CommonUtil
					.click(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.no"));
		}
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.travelonsiteinfo.dietaryrequirements"),
						pojo.getDietaryRequirements());
		CommonUtil
				.selectValueFromDropDownBox(
						elementProperties
								.getProperty("cisco.gsx.registration.travelonsiteinfo.additionalonsiteassistance"),
						pojo.getAdditionalOnsiteAssistance());
		CommonUtil
				.click(elementProperties
						.getProperty("cisco.gsx.registration.travelonsiteinfo.continue"));

		CommonUtil.waitForPageload();
	}

	public static void validateTravelAndOnsiteInformation() throws InterruptedException {
		CommonUtil.waitForPageload();
		Thread.sleep(4000);
		actualMsg = "Thank you for completing your GSX profile.";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.confirmation.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User entered travel and onsite information successfully";
			expectedMsg = "User should enter travel and onsite information successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User failed to enter travel and onsite information";
			expectedMsg = "User should enter travel and onsite information successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void confirmedRegistrationPage() {
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties
				.getProperty("cisco.gsx.registration.confirmation.yes"));
		CommonUtil.waitForPageload();		
	}
	
	
	public static void verifyLinkForInvitationLetter(DataPojoClass pojo) {
		CommonUtil.waitForPageload();
		actualMsg = "Click here to request your invitation letter and review any additional VISA requirements you may have.  Employees are responsible for ensuring that their passport, entry/exit visas and travel documents are in order and are in alignment with current security requirements.";
		String scenario = pojo.getRegCode();
		if ((scenario.equalsIgnoreCase(commonProperties
				.getProperty("cisco.regcode.attendee")))
				|| (scenario.equalsIgnoreCase(commonProperties
						.getProperty("cisco.regcode.hallfame"))) || (scenario.equalsIgnoreCase(commonProperties
								.getProperty("cisco.regcode.eventstaff")))) {
			expectedMsg = CommonUtil
					.getText(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.linkText"));
		} else {
			expectedMsg = CommonUtil
					.getText(elementProperties
							.getProperty("cisco.gsx.registration.travelonsiteinfo.visainvitationletter.linkText.executive"));
		}

		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Displayed link for invitation letter");
			actualMsg = "Link displayed to get the invitation letter";
			expectedMsg = "Link should display to get the invitation letter";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Link is not displayed for invitation letter");
			actualMsg = "Link is not displayed to get the invitation letter";
			expectedMsg = "Link should display to get the invitation letter";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}

	}

}
