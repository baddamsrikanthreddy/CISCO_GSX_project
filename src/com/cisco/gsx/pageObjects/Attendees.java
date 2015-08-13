package com.cisco.gsx.pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Attendees {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	public static List<WebElement> list = null;
	private static String Expected=null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public static void Attendees()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.attendees"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(8);
		Attendees.Validatattendees(elementProperties.getProperty("cisco.gsx.attendees.attendees.title"),"Attendees");
		
		
	}
	
	public static void verifyAttendeeinformation()
	{
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.attendees"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.attendees.label"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.attendees.label"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(
				CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.attendees.profile.text"))&&
				CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.attendees.profile.image")))
				
		{
			
			Point point1 = CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.attendees.profile.image")).getLocation();
			Point point2 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.attendees.profile.text")).getLocation();
			
			if(point1.y<point2.y){
				Expected= "True";
			}
			else{
				
				Expected="False";
			}
			Attendees.Validateattendeeorder(Expected, "True");	
			
			}
			
		
		
	}
	
	private static void Validatattendees(String expected, String actual) {
		
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =  actual+ "page is displayed successfully";
			expectedMsg = actual+ "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = actual+ "page is not displayed";
			expectedMsg = actual+ "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
	}

	private static void Validateattendeeorder(String expected, String actual) {


		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Attendee Details page Layout is in correct order";
		expectedMsg =  "Attendee Details page Layout is in correct order";
		status = "PASS";
		System.out.println("pass");
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("failed");
		actualMsg = "Attendee Details page Layout is  not in correct order";
		expectedMsg = "Attendee Details page Layout is in correct order";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
		}
	
}
