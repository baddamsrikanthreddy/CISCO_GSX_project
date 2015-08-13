package com.cisco.gsx.pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class MyGsx {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String Mouseoverelement = null;
	private static String Requiredelement = null;
	private static String Expected=null;
	
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	public static void MyAgenda()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(4);
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		System.out.println(Requiredelement);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(10);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx.myAgend.title"),Requiredelement);
		
	}
	
	public static void MyAgendapageminusverification()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.minus")))
		{
		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.minus"), "class").contains("minus"))
		{
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.minus"));
		CommonUtil.handleAlert();
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.Validatemyagendapage(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.plus"),"plus");
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.plus"));
		}
		else
		{
			actualMsg = "Session is not added to my agenda";
			expectedMsg = "Session is  added to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		}
		else
		{
			System.out.println("failed");
			actualMsg = "Add/Remove +/- next to a session is not displayed";
			expectedMsg = "Add/Remove +/- next to a session is  displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
	}
	
	public static void MyAgendapageplusverification()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.plus")))
		{
		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.plus"), "class").contains("plus"))
		{
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.plus"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		MyGsx.Validatemyagendapage(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session.minus"),"minus");
	
		
		}
		else
		{
			actualMsg = "Session is not added to my agenda";
			expectedMsg = "Session is  added to my agenda";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		}
		else
		{
			System.out.println("failed");
			actualMsg = "Add/Remove +/- next to a session is not displayed";
			expectedMsg = "Add/Remove +/- next to a session is  displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
		
	}
	
	public static void verifyMyagendasessiondetails()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.session"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsx.myagenda.sessiondetailspage"),"Session Details");
	}
	
	

	public static void MySessionInterests()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx.mySessionInterest"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.mySessionInterest"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx.mySesionInterest.title"),Requiredelement);
	}
	
	public static void MyAccount()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		Requiredelement = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.myGsx.myAccount.title"),Requiredelement);
	}
	
	public static void ValidateMyaccounteditmyprofile() throws InterruptedException
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount.editmyprofile"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.getTitle().equals("Sign In Page"))
		{
			System.out.println("failed");
			actualMsg = "Edit my profile page is not re-directed successfully";
			expectedMsg = "Edit my profile page is re-directed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		else
		{
		CommonUtil.explicitlyWait(3);
		CommonUtil.switchToFrame(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.editmyprofile.frame"));
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.editmyprofile.title")," Ideabytes Testing10001 ");
		}
		
	}
	
	public static void  ValidateMyaccountviewmyprofile()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.viewmyprofile"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.viewmyprofile.title"),"Attendee Details");
	}
	
	public static void  ValidateMyaccountinbox()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.inbox"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.inbox.title"),"Inbox");
	}
	
	public static void  ValidateMyaccountnotes()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.myGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAccount"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.notes"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(6);
		MyGsx.ValidateMyGsx(elementProperties.getProperty("cisco.gsx.mygsx.myaccount.notes.title"),"My Notes");
	}
	
	
	public static void MyinterestsPage()
	{
		CommonUtil.waitForPageload();
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MySessionInterest"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		
		
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests")))
			Expected= "True";
		else
			Expected= "false";
			
		MyGsx.ValidateMyinterests(Expected, "True");
				
		
	}
	public static void ValidateMyinterests(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "List of sessions intesests  displayed in My Interests page";
			expectedMsg = "List  of sessions intesests displayed in My Interests page";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "List  of sessions intesests not dispayed in My Interests page";
			expectedMsg ="List of sessions intesests displayed in My Interests page" ;
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}



public static void Myintereststitleandtime()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MySessionInterest"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
System.out.println("1");
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.title"))
		&&CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.timeandplace")))
	Expected= "True";
else
	Expected= "false";
	
MyGsx.ValidateMyinterststimes(Expected, "True");
		

}
public static void ValidateMyinterststimes(String expected, String actual) {

CommonUtil.waitForPageload();
actualMsg = actual;
expectedMsg = expected;
System.out.println(actualMsg);
System.out.println(expectedMsg);
if (actualMsg.equalsIgnoreCase(expectedMsg)) {
	actualMsg = "Title and session times are displayed successfully for selected interest ";
	expectedMsg = "Title and session times are displayed successfully for selected interest";
	status = "PASS";
	CommonUtil.logMessage(expectedMsg, actualMsg, status);
} else {
	actualMsg = "Title and session times are not listed for selected interest";
	expectedMsg ="Title and session times are displayed successfully for selected interest" ;
	status = "FAIL";
	CommonUtil.logMessage(expectedMsg, actualMsg, status);
}
CommonUtil.waitForPageload();	
}

public static void sessionInterestsTimeDetails()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MySessionInterest"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session.times")))
		{
	if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session.timesandplace")))
			{
			
		
				
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session.description")))
		{
		if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session.speakers")))
		{
			  Expected="True";
			  MyGsx.validateInterestsTime(Expected, "True");
		}         
			else
				MyGsx.validateInterestsLayout("Speakers", "False");
		}
		else
			MyGsx.validateInterestsLayout("Descrption", "False");
		}
		else
			MyGsx.validateInterestsLayout("Time And Place", "False");
		}
		
		else
			MyGsx.validateInterestsLayout("Session Times", "False");
		}		
			
			


public static void validateInterestsTime(String expected, String actual) {

		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "Session Interest Details Page displayed all information";
			expectedMsg = "Session Interest Details Page displayed all information";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Session Interest Details Page displayed only Some Information";
			expectedMsg ="Session Interest Details Page displayed all information" ;
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		}
public static void validateInterestsLayout(String expected, String actual) {

CommonUtil.waitForPageload();
actualMsg = actual;
expectedMsg = expected;
System.out.println(actualMsg);
System.out.println(expectedMsg);

	
	actualMsg = expectedMsg+" section not displayed in Session Interest Details";
	expectedMsg ="Session Interest Details Page displayed all information" ;
	status = "FAIL";
	CommonUtil.logMessage(expectedMsg, actualMsg, status);

CommonUtil.waitForPageload();	

}

public static void sessionInterestsAddtomyagenda()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MySessionInterest"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);

if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")) || CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus" )))
{
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")))
{
	System.out.println("plus found");
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(10);
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
	MyGsx.Validateaddsessiontomyinterest(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus1"),"minus");
	}
}
else
{
	System.out.println("plus not found");
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus"));
	System.out.println("clicked minus");
	CommonUtil.explicitlyWait(10);
	CommonUtil.handleAlert();
	CommonUtil.explicitlyWait(3);
	System.out.println("clicking plus");
	MyGsx.Validateremovesessiontomyinterest(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus1"),"plus");
	
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

public static void sessionInterestsAddtomyagenda1()
{
CommonUtil.waitForPageload();
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MySessionInterest"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.myintersests.session"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")) || CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus" )))
{
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus")))
{
	System.out.println("plus found");
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(10);
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
	MyGsx.Validateaddsessiontomyinterest(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus1"),"minus");
	}
}
else
{
	System.out.println("plus not found");
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.minus"));
	System.out.println("clicked minus");
	CommonUtil.explicitlyWait(10);
	CommonUtil.handleAlert();
	CommonUtil.explicitlyWait(3);
	System.out.println("clicking plus");
	MyGsx.Validateremovesessiontomyinterest(elementProperties.getProperty("cisco.gsx.mygsx.sessions.mysessioninterests.plus1"), "plus");
	
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

public static void Validateaddsessiontomyinterest(String expected, String actual) {

		CommonUtil.waitForPageload();
		System.out.println("session is added");
		actualMsg = actual;
		expectedMsg = CommonUtil.getAttribute(expected, "class");
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		if (expectedMsg.contains(actualMsg)) {
		actualMsg = "Session successfully Removed from My interest session times";
		expectedMsg = "Session successfully Removed from My interest session times";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
		actualMsg = "Session not  Removed from My interest session times";
		expectedMsg = "Session successfully Removed from My interest session times";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
		}
public static void Validateremovesessiontomyinterest(String expected, String actual) {

CommonUtil.waitForPageload();
System.out.println("session is removed");
actualMsg = actual;
expectedMsg = CommonUtil.getAttribute(expected, "class");
System.out.println(actualMsg);
System.out.println(expectedMsg);
if (expectedMsg.contains(actualMsg)) {
actualMsg = "Session successfully Removed from My interest session times";
expectedMsg = "Session successfully Removed from My interest session times";
status = "PASS";
CommonUtil.logMessage(expectedMsg, actualMsg, status);
} else {
actualMsg = "Session successfully Removed from My interest session times";
expectedMsg = "Session not Removed from My interest session times";
status = "FAIL";
CommonUtil.logMessage(expectedMsg, actualMsg, status);
}
CommonUtil.waitForPageload();	
}









	
public static void ValidateMyGsx(String expected, String actual) {
		
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = CommonUtil.getText(expected);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "MyGsx"  +actual + "page is displayed successfully";
			expectedMsg = "MyGsx"  +actual + "page is displayed successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "MyGsx"  +actual + "page is not displayed";
			expectedMsg = "MyGsx"  +actual + "page is displayed successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}


private static void Validatemyagendapage(String expected, String actual) {
	
	
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = CommonUtil.getAttribute(expected,"class");
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





}



