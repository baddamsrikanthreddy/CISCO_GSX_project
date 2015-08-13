package com.cisco.gsx.pageObjects;

import java.util.Properties;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_FaqPage {
	
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void FAQPage(){
		
		CommonUtil.waitForPageload();	
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.faq"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		String faqPageTitle= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.faq.title"));
		System.out.println(faqPageTitle);
		GSX_FaqPage.validateFaq(faqPageTitle,"FAQ");
		CommonUtil.waitForPageload();	
		
		}
	public static void validateFaq(String Expected, String Actual) {
		CommonUtil.waitForPageload();
		actualMsg = Actual;
		expectedMsg = Expected;
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = Actual+"  page is displayed successfully";
			expectedMsg = Actual+"  page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = Actual+" page is display failed";
			expectedMsg = Actual+"  page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
		
		}
	
	
	
	
	
	
	


