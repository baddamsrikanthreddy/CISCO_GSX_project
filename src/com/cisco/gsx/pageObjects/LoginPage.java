package com.cisco.gsx.pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class LoginPage {
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
	
	public static void validateLoginPage(){
		CommonUtil.waitForPageload();	
		actualMsg = "Sign In Page";
		expectedMsg = CommonUtil.getTitle();
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("In If loop");
			actualMsg = "LoginPage is displayed to the user";
			expectedMsg = "LoginPage should be displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Not In If loop");
			actualMsg = "LoginPage is not Display to User";
			expectedMsg = "LoginPage should Display to User";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	
	
	
	
	public static void enterCredentials() throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.login.username"));
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.login.password"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.isAlertPresent())
			CommonUtil.handleAlert();
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		
	}
	
	public static void enterCredentialsforinvalidlogin() throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.login.username1"));
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.login.password1"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.username")).isDisplayed())
		{
			actualMsg = "Login unsuccessfull";
			expectedMsg = "Login unsuccessfull";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		else
		{
			actualMsg = "Login successfull";
			expectedMsg = "Login unsuccessfull";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}

	public static void Logout() throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logout"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.logout.message")).isDisplayed())
		{
			System.out.println("Success");
			actualMsg = "User logged out successfully";
			expectedMsg = "User logged out successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		else
		{
			System.out.println("fail");
			actualMsg = "Unsuccessfull logout";
			expectedMsg = "User logged out successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
		
		
}

