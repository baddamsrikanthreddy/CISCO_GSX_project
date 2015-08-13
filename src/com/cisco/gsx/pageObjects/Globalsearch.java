package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Globalsearch {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	public static String Requiredelement = null;
	public static List<WebElement> List = null;
	public static ArrayList<String> arrList = new ArrayList<String>();

	private static String status1 =null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void verifysearchpage()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.icon"));
		CommonUtil.waitForPageload();
		Globalsearch.Validateglobalsearch(elementProperties.getProperty("cisco.gsx.search.button"), "Search");
		
	}

	
	public static void verifysearchentrytextlimit()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.icon"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.search.text"), elementProperties.getProperty("cisco.gsx.search.searchentrytext"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.button"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isAlertPresent())
		{
			actualMsg = "Three or more characters are entered successfully to perform search";
			expectedMsg = "Three or more characters are required to perform search";			
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			System.out.println("page is displayed");
		}
		else
		{
			actualMsg = "Please enter at least three characters to perform a search";
			expectedMsg = "Three or more characters are required to perform search";		
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			System.out.println("page is not displayed");
		}
	}
	
	public static void verifysearchtext()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.icon"));
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.search.text"), elementProperties.getProperty("cisco.gsx.search.searchentrytext1"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.button"));
		CommonUtil.waitForPageload();
		
	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.sessiontab")))
	    {
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.sessiontab"));
	    	CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.sessionlist"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.session").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    		{
	    			status1 = "false";
	    		}
	    		arrList.add(status1);
	    		
	    	}
	    	
	    }
	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.speakerstab")))
	    {
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.speakerstab"));
	    	CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.speakerslist"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.speakers").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1")))
	     		{
	    			status1 = "true";
	    		
	    		}
	    		else
	    		   status1 = "false";
	    	    arrList.add(status1);
	    	}		
	    }
	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.venuestab")))
	    {
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.venuestab"));
	    	CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.venueslist"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.venues").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 ="true";	
	    		}
	    		else
	    			status1 = "false";
	    		arrList.add(status1);
	    	}	
	    }
	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.attendeestab")))
	    {
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.attendeestab"));
	    	CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.attendeeslist"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.attendees").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    			status1= "false";
	    	    arrList.add(status1);
	    	}	
	    }
	    if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.search.webtab")))
	    {
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.webtab"));
	    	CommonUtil.explicitlyWait(3);
	    	List=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.search.weblist"));
	    	
	    	for(int i=1;i<=List.size();i++)
	    	{
	    		
	    		if(CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.web").replaceAll("VarX", Integer.toString(i))).toLowerCase().contains(elementProperties.getProperty("cisco.gsx.search.searchentrytext1").toLowerCase()))
	     		{
	    			status1 = "true";	
	    		}
	    		else
	    			status1 = "false";
	    		arrList.add(status1);
	    		
	    	}	
	    }	
	    	
	    System.out.println(arrList);	
	    if (arrList.contains("false")) 
	    {
	    	actualMsg = "Appropriate search results are not diaplayed";
            expectedMsg = "Appropriate search results are diaplayed"; 
            status = "FAIL";
            CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	
	    		
		}
	    else
	    {
	    	actualMsg = "Appropriate search results are diaplayed";
            expectedMsg = "Appropriate search results are diaplayed";   
            status = "PASS";
            CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    }
	    
	    
	}
	
	public static void verifysearchresults()
	{
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.icon"));
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.search.text"),elementProperties.getProperty("cisco.gsx.search.searchentrytext2"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.search.button"));
		CommonUtil.waitForPageload();
		expectedMsg = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.search.heading"));
		System.out.println(expectedMsg);
		actualMsg = "Sorry, could not find matching results for " +elementProperties.getProperty("cisco.gsx.search.searchentrytext2");
		if(expectedMsg.equalsIgnoreCase(actualMsg))
		{
			actualMsg = "No matches found for given text";
			expectedMsg = "No matches found for given text";		
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		else
		{
			actualMsg = "matches found for given text";
			expectedMsg = "No matches found for given text";			
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	
	
		
	
	public static void Validateglobalsearch(String expected, String actual) {
			
			CommonUtil.waitForPageload();
			actualMsg = actual;
			expectedMsg = CommonUtil.getText(expected);
			if (actualMsg.equalsIgnoreCase(expectedMsg)) {
				actualMsg = actual+ "page is displayed successfully";
				expectedMsg = actual+ "page is displayed successfully";			
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				actualMsg = actual+ "page is  not displayed";
				expectedMsg =  actual+ "page is displayed successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
		}
	}
