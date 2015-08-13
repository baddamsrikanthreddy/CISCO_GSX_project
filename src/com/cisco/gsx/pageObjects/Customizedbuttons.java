package com.cisco.gsx.pageObjects;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class Customizedbuttons {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	private static String Expected=null;
	public static List<WebElement> list = null;
	public static List<WebElement> plus = null;
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	 public static void requiredSession() throws Exception
	    {
	    	
		 CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Monday, August 31");
	        CommonUtil.waitForPageload();
	        CommonUtil.explicitlyWait(3);
	    	list = CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.customized.required"));
	    	System.out.println(list.size());
	    	if(list.size()!=0)
	    	{
	    		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.customized.requiredlock"),"class").contains("lock"))
	    		{
	    			actualMsg = "The button is unselectable";
	    			expectedMsg = "The button is unselectable";
	    			status = "PASS";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    		else
	    		{
	    			actualMsg = "The button is in select mode";
	    			expectedMsg = "The button is unselectable";
	    			status = "FAIL";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    			
	           
	    	}
	    	else
	    	{
	    		actualMsg = "No matching Elements found for SESSION REQUIRED ";
    			expectedMsg = "matching Elements found for SESSION REQUIRED";
    			status = "FAIL";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	}
	    		
	    	 	
	    }
	 
	 
	 public static void sessionEnded() throws Exception
	    {
		 CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "25 June, 2015");
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
	    	if(CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.customized.sessionend")).isDisplayed())
	    	{
	    		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.customized.sessionendlock"),"class").contains("lock"))
	    		{
	    			actualMsg = "The button is unselectable";
	    			expectedMsg = "The button is unselectable";
	    			status = "PASS";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    		else
	    		{
	    			actualMsg = "The button is in select mode";
	    			expectedMsg = "The button is unselectable";
	    			status = "FAIL";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    			
	           
	    	}
	    	else
	    	{
	    		actualMsg = "No matching Elements found for SESSION ENDED ";
    			expectedMsg = "matching Elements found for SESSION ENDED ";
    			status = "FAIL";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	}
	    		
	    }
	 
	 
	 public  static void sessionAllmostFull() throws Exception
	    {
	    	
		 CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Wednesday, September 2");
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
	    	if(CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.customized.almostfull")).isDisplayed())
	    	{
	    		System.out.println("success");
	    		actualMsg = "Matches are found for ALMOST FULL";
    			expectedMsg = "Matches are found for ALMOST FULL";
    			status = "PASS";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	}
	    	else
	    	{
	    		actualMsg = "Matches are notfound for ALMOST FULL";
    			expectedMsg = "Matches are found for ALMOST FULL";
    			status = "FAIL";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	}
	    	
	    }
	 
	 public static  void sessionFull() throws Exception
	    {
		    CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
	    	if(CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.customized.sessionfull")).isDisplayed())
	    	{
	    		System.out.println("entered into session");
	    		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.customized.sessionfulllock"),"class").contains("lock"))
	    		{
	    			System.out.println("success");
	    			actualMsg = "The button is unselectable";
	    			expectedMsg = "The button is unselectable";
	    			status = "PASS";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    		else
	    		{
	    			actualMsg = "The button is in select mode";
	    			expectedMsg = "The button is unselectable";
	    			status = "FAIL";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    			
	           
	    	}
	    	else
	    	{
	    		actualMsg = "No matching Elements found for SESSION FULL ";
    			expectedMsg = "matching Elements found for SESSION FULL ";
    			status = "FAIL";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    	}
	    }
	 
	 public static void addMyAgenda() throws Exception
	    {
		    CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Wednesday, September 2");
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.customized.plusbutton"));
	    	CommonUtil.explicitlyWait(4);
	    	System.out.println(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.customized.plusbutton"), "class"));
	    	if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.customized.plusbutton"), "class").contains("minus"))
	    	{
    			actualMsg = "The button is unselectable";
    			expectedMsg = "The button is unselectable";
    			status = "PASS";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
    			
    		}
	    	
    		else
    		{
    			actualMsg = "The button is in select mode";
    			expectedMsg = "The button is unselectable";
    			status = "FAIL";
    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
    		}
	    	CommonUtil.click(elementProperties.getProperty("cisco.gsx.customized.plusbutton"));
	    	CommonUtil.handleAlert();
	    	CommonUtil.waitForPageload();
	    	
    		
	    }
	 
	 public static void validateremovesession() throws Exception
	    {
		    CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			list = CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.customized.minusbutton1"));
			CommonUtil.waitForPageload();
			if(list.size()!=0)
	        {
				String str = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.customized.minusbutton2"));
				list.get(0).click();
				CommonUtil.explicitlyWait(3);
				CommonUtil.handleAlert();
				CommonUtil.explicitlyWait(3);
				String str1=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.customized.plusbutton2"));
				if(str.equals(str1))
	    		{
					actualMsg = "- button changed to + button successfully";
	    			expectedMsg = "- button changed to + button successfully";
	    			status = "PASS";
	    			CommonUtil.logMessage(expectedMsg, actualMsg, status);
	    		}
	    		else
	    			actualMsg = "- button not changed to + button";
    				expectedMsg = "- button changed to + button successfully";
    				status = "FAIL";
    				CommonUtil.logMessage(expectedMsg, actualMsg, status);
	        }  	
	    	else
	    	{
	    		plus = CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.customized.plusbutton1"));
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.customized.plusbutton1"));
	    	}
			
	        }
			
			}
	       


