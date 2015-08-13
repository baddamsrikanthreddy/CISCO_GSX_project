package com.cisco.gsx.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class SessionCatalog {
	
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	public static String selectinterest = null;
	public static List<WebElement> checkboxes = null;
	
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void validateSessionsPage() {
		
		CommonUtil.waitForPageload();
		actualMsg = "My Account Profile";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.registration.Paymentinfo.text"));
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			actualMsg = "User login succeed";
			expectedMsg = "User successfully logged in";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "User login failed";
			expectedMsg = "User successfully logged in";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	
	public static void clickAgenda() throws InterruptedException {
		
		CommonUtil.waitForPageload();
		Thread.sleep(5000);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.button.viewagenda"));
	}
	public static void switchToNewWindow() {
		  CommonUtil.switchToNewWindow();
		 }
	
	public static void validateSessionHomePage() {
		
		CommonUtil.waitForPageload();	
		actualMsg = "Search";
		expectedMsg = CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.sessioncatalog.button.search"),"value");
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = " Session Home page is displayed ";
			expectedMsg = "Session Home page is displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = " Session Home page failed";
			expectedMsg = " Session Home page is displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
		
		CommonUtil.waitForPageload();
	}
	
	public static void selectInterest() {
		
		CommonUtil.waitForPageload();
		if(CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterestclass"),"class").equalsIgnoreCase("interest interested"))
		{
				System.out.println("class name is verified");
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
				CommonUtil.waitForPageload();
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
				actualMsg = "Add to My Interests";
				expectedMsg = CommonUtil.getText(elementProperties
						.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
				System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
				if (actualMsg.equalsIgnoreCase(expectedMsg))
				{
					System.out.println("Actual and Expected messages are same");
					actualMsg = "Added to My Interests";
					expectedMsg = "Added to My Interests";
					status = "PASS";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
					selectinterest = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.secondsession"));
					
				} 
				else 
				{
					System.out.println("Actual and Expected messages are not same");
					actualMsg = "Add to My Interests failed";
					expectedMsg = "Added to My Interests";
					status = "FAIL";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
			    }
		}
		else
		{
			System.out.println("add to my interests clicked");
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
			actualMsg = "Add to My Interests";
			expectedMsg = CommonUtil.getText(elementProperties
					.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
			System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
			if (actualMsg.equalsIgnoreCase(expectedMsg)) 
			{
				System.out.println("Actual and Expected messages are same");
				actualMsg = "Added to My Interests";
				expectedMsg = "Added to My Interests";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.secondinterest"));
				selectinterest = CommonUtil.getText(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.secondsession"));
				
			} else 
			{
				System.out.println("Actual and Expected messages are not same");
				actualMsg = "Add to My Interests failed";
				expectedMsg = "Added to My Interests";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
				
			}
		}
	}
		
		
		
		
	
	
	public static void clickMyIntrests() {
		
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.myinterests"));
	}
	
	public static void validateMyIntrestsHomePage() {
		
		CommonUtil.waitForPageload();
		actualMsg = "My Interests";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.sessioncatalog.myinterestsheading"));
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = "My Interest Home page is displayed";
			expectedMsg = "My Interest Home page is displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = " My Interest Home page failed";
			expectedMsg = " My Interest Home page is displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();
	}
	
	public static void verifySelectedIntrests() {
		CommonUtil.waitForPageload();	
		List<WebElement> list= CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.sessioncatalog.myintrests.titles"));
		
		for(WebElement s:list)
		{
		  if(s.getText().equalsIgnoreCase(selectinterest))
		  { 
			  System.out.println("passed");
		  }
		  
		}
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.SessionCatalog"));
		CommonUtil.waitForPageload();
	}
	
	

	public static void ValidateSessionType()
	{
		
		checkboxes = CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.checkboxes"));
		System.out.println(checkboxes.size());
		CommonUtil.explicitlyWait(1);
		
		for(int i=0;i<checkboxes.size();i++)
		{	
		
		   checkboxes.get(i).getAttribute("id");
		
				if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("sessionType_1000")) {
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.breakoutcheckbox"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Breakname"), "Breakout (BR)" );
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.breakoutcheckbox"));
					CommonUtil.explicitlyWait(1);
				} 
				/*else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("sessionType_1001")) {
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.GeneralSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Generalsessionname"), "General Session (GS)");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.GeneralSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
					
				} else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("sessionType_1040")) {
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.HubSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.HubSessionname"), "Hub Session");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.HubSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
					
					
				} else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("sessionType_1020")) {
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Region/Segmentcheckbox"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Regionsegmentname"),"Region/Segment (RS)");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Region/Segmentcheckbox"));
					CommonUtil.explicitlyWait(1);
					
				}*/
				else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("sessionType_1021"))
				{
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.SuperSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateSessionTypes(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.Supersessionname"),"Region/Segment (RS)");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.SuperSessioncheckbox"));
					CommonUtil.explicitlyWait(1);
				}
		}
		CommonUtil.waitForPageload();
	}
	
	
	
	
public static void SessionCatalogTrack() {
	
	
	
		/*actualMsg = "Track";
		expectedMsg = CommonUtil.getText(elementProperties
				.getProperty("cisco.gsx.sessioncatalog.catalog.trackcheckbox"));
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Actual and Expected messages are same");
			actualMsg = "Track is displayed in Session catalog";
			expectedMsg = "Track is displayed in Session catalog";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			System.out.println("Actual and Expected messages are not same");
			actualMsg = "Track is not displayed in Session catalog";
			expectedMsg = "Track is displayed in Session catalog";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}*/
		
		checkboxes = CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.Trackboxes"));
		System.out.println(checkboxes.size());
		CommonUtil.explicitlyWait(1);
		
		for(int i=0;i<3;i++)
		{	
		
		  System.out.println(checkboxes.get(i).getAttribute("id"));
		
				if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("profileItem_10314_10576")) {
					System.out.println("sucess");
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.salescultureandtalent"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.salescultureandtalentfirstinterest"));
					CommonUtil.explicitlyWait(1);
					System.out.println(CommonUtil.getAlertText());
					SessionCatalog.validateTrack(elementProperties.getProperty("cisco.gsx.sessioncatalog.track.salestitle"), "Sales Culture and Talent" );
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(1);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.salescultureandtalent"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(1);
					
					
				} else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("profileItem_10314_10577")) {
					System.out.println("stageric");
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.StrategicSelling"));
					System.out.println("click is working");
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.StrategicSellingfirstinterest"));
					CommonUtil.explicitlyWait(1);
					CommonUtil.isAlertPresent();
					SessionCatalog.validateTrack(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.StrategicSellingtitle"), "Strategic Selling" );
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(1);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.StrategicSelling"));
					CommonUtil.explicitlyWait(1);
					
					
				}else if(checkboxes.get(i).getAttribute("id").equalsIgnoreCase("profileItem_10314_10541")) {
					
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.TechnologyInnovation"));
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(2);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.track.technologyfirstinterest"));
					CommonUtil.explicitlyWait(1);
					SessionCatalog.validateTrack(elementProperties.getProperty("cisco.gsx.sessioncatalog.track.technologytitle"), "Technology & Innovation" );
					CommonUtil.waitForPageload();
					CommonUtil.explicitlyWait(1);
					CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.catalog.TechnologyInnovation"));
					CommonUtil.explicitlyWait(1);
				}
		
				CommonUtil.waitForPageload();
		}
}



public static void validateSessionTypes(String sessionTypeXpath, String sessionTypeName) {
	
		CommonUtil.explicitlyWait(1);
		List<WebElement> SessionTitles=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.sessioncatalog.Sessiontype.titles"));
		System.out.println(SessionTitles.size());
		CommonUtil.explicitlyWait(1);
		List<WebElement> sessionTypeNames=CommonUtil.findElements(sessionTypeXpath);
		System.out.println(sessionTypeNames.size());
		actualMsg = Integer.toString(SessionTitles.size());
		expectedMsg = Integer.toString(sessionTypeNames.size());
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) 
		{
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " session type is verified successfully ";
			expectedMsg =  sessionTypeName + " session type is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} 
		else 
		{
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName+ " session type verification is failed";
			expectedMsg =  sessionTypeName + " session type is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
}

public static void validateTrack(String sessionTypeXpath, String sessionTypeName)
{
		CommonUtil.explicitlyWait(1);
		actualMsg = sessionTypeName;
		System.out.println(actualMsg);
		expectedMsg = CommonUtil.getText(sessionTypeXpath);
		System.out.println(expectedMsg);
		
		if (actualMsg.equalsIgnoreCase(expectedMsg)) 
		{
			System.out.println("Actual and Expected messages are same");
			actualMsg = sessionTypeName + " Track is successfully verified";
			expectedMsg =  sessionTypeName + " Track is verified successfully";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessioncatalog.track.close"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(2);
		} 
		else 
		{
			System.out.println("Actual and Expected messages are not same");
			actualMsg = sessionTypeName+ " Track verification is failed";
			expectedMsg =  sessionTypeName + " Track is verified successfully";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
}

}


