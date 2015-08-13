package com.cisco.gsx.pageObjects;

import java.util.Properties;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class TheHub {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void Overview()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.overview"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.overview"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.overview.title"),Requiredelement);
	}
	
	public static void Schedule()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.schedule"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.schedule"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.schedule.title"),Requiredelement);
	}
	
	public static void Innovationshowcasepromo()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.innovationshowcasepromo"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.innovationshowcasepromo.title"),"Innovations Showcase");
	}
	
	public static void Megadash()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.megadash"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.megadash"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.megadash.title"),Requiredelement);
	}
	public static void Theaterpromoandsessionlistings()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.theaterpromoandsessionlistings"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.theaterpromoandsessionlistings"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.theaterpromoandsessionlistings.title"),Requiredelement);
	}
	
	public static void Theater()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.theatre"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.theatre"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.theatre.title"),"Theater Sessions");
	}
	
	public static void Photos()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.thehub"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.thehub.photos"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.thehub.photos"));
		CommonUtil.waitForPageload();
		TheHub.Validatehub(elementProperties.getProperty("cisco.gsx.thehub.photos.title"),"Professional Photos");
	}
	

	
public static void Validatehub(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Hub"  +actual + "page is displayed successfully";
			expectedMsg = "Hub"  +actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Hub"  +actual + "page is not displayed";
			expectedMsg = "Hub"  +actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}

}
