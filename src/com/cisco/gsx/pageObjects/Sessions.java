package com.cisco.gsx.pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class Sessions {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	public static String expected = null;
	private static String Expected=null;
	//public static List<WebElement> list = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	
	public static void sessionfullagenda()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.sessions.fullagendapage"),Requiredelement);
	}
	
	public static void sessioncategoryguides()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.mygsx.sessions.categoryguide"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.categoryguide"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.mygsx.sessions.categoryguidepage"),Requiredelement);
	}
	
	public static void sessiondevnet()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.sessions.devnet"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.devnet"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.sessions.devnetpage"),Requiredelement);
	}
	
	public static void sessionsaddtomyagenda()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "1 September, 2015");
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.fullagendapage.secondsessionlist"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")) || CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus" )))
		{
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")))
		{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"));
			CommonUtil.waitForPageload();
			if(CommonUtil.isAlertPresent())
			{
				actualMsg = "Observed alert when two sessions scheduled at the same time";
				expectedMsg = "Observed alert when two sessions scheduled at the same time";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				System.out.println("success");
			}
			else
			{
			CommonUtil.explicitlyWait(3);
			Sessions.Validateaddtomyagenda(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus1"),"minus");
			}
		}
		else
		{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus"));
			CommonUtil.handleAlert();
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			Sessions.Validateaddtomyagenda(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus1"), "plus");
			}
		}
		else
		{
			System.out.println("failed");
			actualMsg = "Lock icon is present instead of plus or minus to add the session to my agenda";
			expectedMsg = "Plus or minus is present to add the session to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		}
	
	
	public static void sessionsvenuedetails()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "1 September, 2015");
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.fullagendapage.secondsessionlist"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.timeandplace")))
		{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.session.timeandplace.tab"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.venuedetails"),"Venue Details");
		}
		else
		{
			actualMsg = "Time and place is not displayed in session details page";
			expectedMsg = "Time and place is displayed in session details page";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	
	
	public static void sessionsspeakerdetails()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "1 September, 2015");
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.fullagendapage.secondsessionlist"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.sessions.speaker")))
		{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.session.speakers.tab"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.speakerdetails"),"Speaker Details");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.speakerdetails.firstsesssion"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.sessions.sessiondetailspage"),"Session Details");
			
		}
		else
		{
			actualMsg = "Speakers is not displayed in session details page";
			expectedMsg = "Speakers is displayed in session details page";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	}
	
	
	public static void validatesessionspeakerorder()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "1 September, 2015");
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.fullagendapage.secondsessionlist"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.sessions.speaker")))
		{
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.session.speakers.tab"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			Sessions.ValidateSessions(elementProperties.getProperty("cisco.gsx.speakerdetails"),"Speaker Details");
			if(
					CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.tile"))&&
					CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.image"))&&
					CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.timeandplace"))&&
					CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.description")))
			{
				
				Point point1 = CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.tile")).getLocation();
				Point point2 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.imagee")).getLocation();
				Point point3 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.timeandplace")).getLocation();
				Point point4 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.fullagenda.sessions.speakers.description")).getLocation();
				if(point1.y<point2.y&&point2.y<point3.y&&point3.y<point4.y){
					expected= "True";
				}
				else{
					
					expected="False";
				}
				Sessions.Validatefullagendasessionspeakeroder(expected, "True");	
				
				}
				
			else{
				System.out.println("Speaker information is not accurate");
				actualMsg = "Speaker information is not accurate"; 
				expectedMsg = "Speaker information is accurate";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
		}
	}
	
	
public static void ValidateSessions(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Sessions"  +actual + "page is displayed successfully";
			expectedMsg = "Sessions"  +actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Sessions"  +actual + "page is not displayed";
			expectedMsg = "Sessions"  +actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}


public static void Validateaddtomyagenda(String expected, String actual) {
	
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = CommonUtil.getAttribute(expected, "class");
	if (expectedMsg.contains(actualMsg)) {
		actualMsg = "Session successfully added to my Agenda";
		expectedMsg = "Session successfully added to my Agenda";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Session is not added to my Agenda";
		expectedMsg = "Session successfully added to my Agenda";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	CommonUtil.waitForPageload();	
}


private static void Validatefullagendasessionspeakeroder(String expected, String actual) {


		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
			actualMsg =   "Session Details page Layout is in correct order";
			expectedMsg =  "Session Details page Layout is in correct order";
			status = "PASS";
			System.out.println("pass");
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Details page Layout is  not in correct order";
			expectedMsg = "Session Details page Layout is in correct order";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
		
		}


//##################### FULLAGENDA PAGE VALIDATION###############################################

public static void fullAgendaPage(){
	CommonUtil.waitForPageload();
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	Mouseoverelement=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	String fullAgendaPageTitle="Full Agenda";
	CommonUtil.explicitlyWait(5);
	System.out.println(fullAgendaPageTitle);
	Sessions.validateFullAgendaPage(fullAgendaPageTitle, Mouseoverelement);
	
	
}

public static void validateFullAgendaPage(String Expected, String Actual) {
	CommonUtil.waitForPageload();
	actualMsg = Actual;
	expectedMsg = Expected;
	if (actualMsg.equalsIgnoreCase(expectedMsg)) {
		actualMsg =  Actual + "page is displayed successfully";
		expectedMsg =   Actual + "page is displayed successfully";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = Actual + "page is display failed";
		expectedMsg =Actual + "page is displayed successfully";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	CommonUtil.waitForPageload();	
}

//########################## SESSION TIME VALIDATION IN FULL AGENDA PAGE###############################	

public static void fullAgendaDatePage(){
	  
	  CommonUtil.waitForPageload();
	  CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	  CommonUtil.waitForPageload();
	  CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	  CommonUtil.waitForPageload();
	  CommonUtil.explicitlyWait(3);
	  
	  List<WebElement> list=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
	  for(int i=1;i<=list.size();i++){
	   
	   Expected= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1").replaceAll("VarX", Integer.toString(i)));
	   System.out.println(Expected);
	   Sessions.validateThesessionDates(Expected, "25 Jun");
	  }
	  
	  
	  CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "31 August, 2015");
	  CommonUtil.explicitlyWait(5);
	  List<WebElement>list1=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
	  for(int i=1;i<=list1.size();i++){
	   Expected= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1").replaceAll("VarX", Integer.toString(i)));
	   System.out.println(Expected);
	   Sessions.validateThesessionDates(Expected, "31 Aug");
	  }
	  CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "1 September, 2015");
	  CommonUtil.explicitlyWait(5);
	  List<WebElement> list2=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
	  for(int i=1;i<=list2.size();i++){
	   Expected= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1").replaceAll("VarX", Integer.toString(i)));
	   System.out.println(Expected);
	   Sessions.validateThesessionDates(Expected, "1 Sep");
	  }
	  CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "2 September, 2015");
	  CommonUtil.explicitlyWait(5);
	  List<WebElement>list3=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
	  for(int i=1;i<=list3.size();i++){
	   Expected= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1").replaceAll("VarX", Integer.toString(i)));
	   System.out.println(Expected);
	   Sessions.validateThesessionDates(Expected, "2 Sep");
	  }
	  CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "4 September, 2015");
	  CommonUtil.explicitlyWait(5);
	  List<WebElement> list4=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionlist"));
	  for(int i=1;i<=list4.size();i++){
	   Expected= CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.datedetails1").replaceAll("VarX", Integer.toString(i)));
	   System.out.println(Expected);
	   Sessions.validateThesessionDates(Expected, "4 Sep");
	  }
	  
	 CommonUtil.waitForPageload(); 
	  
	  
	 }
	

public static void validateThesessionDates(String Expected, String Actual) {
	CommonUtil.waitForPageload();
	actualMsg = Actual;
	expectedMsg = Expected.split(",")[0];
	
	if (actualMsg.equalsIgnoreCase(expectedMsg)) {
		actualMsg = " Session Time Details displaced successfully ";
		expectedMsg = "Session Time Details displaced successfully";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Session Time Details not Displayed";
		expectedMsg = "Session Time Details displaced successfully";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	CommonUtil.waitForPageload();	
}



//############################ SESSION DETAILS PAGE VALIDATION ####################

public static void fullagendaSessionDetailsPage(){
	
	CommonUtil.waitForPageload();
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	Expected=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionsdetailspagetitle"));
	Sessions.validateFullAgendaSessionDetailsPage(Expected, "Session Details");


	CommonUtil.waitForPageload();
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "31 August, 2015");
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	Expected=CommonUtil.getText(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionsdetailspagetitle"));
	Sessions.validateFullAgendaSessionDetailsPage(Expected, "Session Details");


}

public static void validateFullAgendaSessionDetailsPage(String Expected, String Actual) {
			CommonUtil.waitForPageload();
			actualMsg = Actual;
			expectedMsg = Expected;
			
			if (actualMsg.equalsIgnoreCase(expectedMsg)) {
				actualMsg = Actual + " page is displayed successfully";
				expectedMsg = Actual + " page is displayed successfully";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				actualMsg = Actual + " page is display failed";
				expectedMsg = Actual + "page is displayed successfully";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
			}



//###################### SESSION ADD/REMOVE VALIDATION #####################################

/*public static void fullAgendaPageminusverification()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);

CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "31 August, 2015");
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
List<WebElement> listminus=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.session.minus"));
System.out.println(listminus.size());
System.out.println(listminus.get(0).getAttribute("class"));	
listminus.get(0).click();
CommonUtil.handleAlert();
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
Sessions.Validatefullagendaplusminus(listminus.get(0).getAttribute("class"),"plus");
System.out.println(listminus.get(0).getAttribute("class"));	

}

public static void fullAgendapageplusverification()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "31 August, 2015");
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
List<WebElement> listplus=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.plus"));
System.out.println(listplus.size());

System.out.println(listplus.get(listplus.size()-1).getAttribute("class"));
System.out.println(1);
listplus.get(listplus.size()-1).click();
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
CommonUtil.explicitlyWait(5);
List<WebElement> listminus1=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.session.minus"));



Sessions.Validatefullagendaplusminus(listplus.get(listplus.size()-1).getAttribute("class"),"minus");
System.out.println(listplus.get(listplus.size()-1).getAttribute("class"));	

}*/

private static void Validatefullagendaplusminus(String expected, String actual) {
	
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
		actualMsg =  actual+ "is highlighted successfully";
		expectedMsg = actual+ "is highlighted successfully";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
		actualMsg = actual+ "is not highlighted";
		expectedMsg = actual+ "is highlighted successfully";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
		}


//########################### SESSION DETAILS PAGE VALIDATION############################


public static void sessionDetailsLayout(){

CommonUtil.waitForPageload();
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.tile"))&&
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.timeandplace"))&&	
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.speakers"))&&
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.description")))
{
	
	Point point1 = CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.tile")).getLocation();
	Point point2 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.timeandplace")).getLocation();
	Point point3 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.speakers")).getLocation();
	Point point4 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.description")).getLocation();
	System.out.println(point1.y);
	System.out.println(point2.y);
	System.out.println(point3.y);
	System.out.println(point4.y);
	
	
	if(point1.y<point2.y&&point2.y<point3.y&&point3.y<point4.y){
	Expected= "True";
	}
	else{
		
		Expected="False";
	}
	Sessions.Validatefullagendasessionlayout(Expected, "True");	
	
	}


CommonUtil.waitForPageload();
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.logo"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "31 August, 2015");
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.tile"))&&
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.timeandplace"))&&	
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.speakers"))&&
		CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.description")))
{
	
	Point point1 = CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.tile")).getLocation();
	Point point2 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.timeandplace")).getLocation();
	Point point3 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.sessionlayout.speakers")).getLocation();
	Point point4 =CommonUtil.findElement(elementProperties.getProperty("cisco.gsx.mygsx.fullagennda.session.description")).getLocation();
	System.out.println(point1.y);
	System.out.println(point2.y);
	System.out.println(point3.y);
	System.out.println(point4.y);
	
	
	if(point1.y<point2.y&&point2.y<point3.y&&point3.y<point4.y){
	Expected= "True";
	}
	else{
		
		Expected="False";
	}
	Sessions.Validatefullagendasessionlayout(Expected, "True");	
	
	}
	
else{
	
	
	
	Sessions.Validatefullagendasessioninformation("false", "True");
}


}


private static void Validatefullagendasessionlayout(String expected, String actual) {


		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Session Details page Layout is in correct order";
		expectedMsg =  "Session Details page Layout is in correct order";
		status = "PASS";
		System.out.println("pass");
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
		actualMsg = "Session Details page Layout is  not in correct order";
		expectedMsg = "Session Details page Layout is in correct order";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		
		}

private static void Validatefullagendasessioninformation(String expected, String actual) {


	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;
	if (expectedMsg.contains(actualMsg)) {
	actualMsg =   "Session Details page Layout is in correct order";
	expectedMsg =  "Session Details page Layout is in correct order";
	status = "PASS";
	CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
	actualMsg = "Session information is not accurate";
	expectedMsg = "Session information should be accurate " ;
	status = "FAIL";
	System.out.println("Session information not accurate  " );
	CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	CommonUtil.waitForPageload();	
	
	}





}
