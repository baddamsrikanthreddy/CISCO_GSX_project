package com.cisco.gsx.pageObjects;

import java.util.Properties;



import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_Allinongoodpage {
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	public static void overviewPage(){
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.allinongood"));
		CommonUtil.explicitlyWait(6);
		Mouseoverelement=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.overview"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.allinongood.overview"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		String overviewPageTitle= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.overview.title"));
		System.out.println(overviewPageTitle);
		GSX_Allinongoodpage.validateTheHub(overviewPageTitle,"Overview");
		CommonUtil.waitForPageload();	
		
		
}
public static void inTheHubPage(){
	
	CommonUtil.waitForPageload();	
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.allinongood"));
	CommonUtil.explicitlyWait(6);
	Mouseoverelement=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.inthehub"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(6);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.allinongood.inthehub"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		String inHubPageTitle= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.inthehub.title"));
		System.out.println(inHubPageTitle);
		GSX_Allinongoodpage.validateTheHub(inHubPageTitle, "At The Hub");
		CommonUtil.waitForPageload();	
}
public static void globalCelebrationPage(){
	CommonUtil.waitForPageload();	
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.allinongood"));
	CommonUtil.explicitlyWait(6);
	Mouseoverelement=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.globalcelebration"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.allinongood.globalcelebration"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(6);
	String globalCelebrationPageTitle= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.allinongood.globalcelebration.title"));
	System.out.println(globalCelebrationPageTitle);
	GSX_Allinongoodpage.validateTheHub(globalCelebrationPageTitle, "At The Global Celebration");
	CommonUtil.waitForPageload();	
	
}

public static void validateTheHub(String Expected, String Actual) {
	CommonUtil.waitForPageload();
	actualMsg = Actual;
	expectedMsg = Expected;
	if (actualMsg.equalsIgnoreCase(expectedMsg)) {
		actualMsg = "All In On Good  "  +Actual + "page is displayed successfully";
		expectedMsg = "All In On Good  "  +Actual + "page is displayed successfully";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "All In On Good  "  +Actual + "page is display failed";
		expectedMsg = "All In On Good  "  +Actual + "page is displayed successfully";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	CommonUtil.waitForPageload();	
}
	
	}

