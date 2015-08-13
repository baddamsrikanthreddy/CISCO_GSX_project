package com.cisco.gsx.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_UserBasedRoles {
	
	public static Properties elementProperties=null;
	public static Properties commonProperties=null;
	private static String Mouseoverelement=null;
	private static String actualMsg=null;
	private static String expectedMsg=null;
	private static String status=null;
	private static String Expected=null;
	private static String Expectedclass=null;
	private static List<WebElement> list = null;
	private static List<WebElement> list1 = null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Speakerlist = new ArrayList<String>();
	private static String user=null;
	

	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	
	
//############## User Roles General,Regional/segment,Invited##############################
	
public static void attendeeRole(){
		
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.attende.username"));
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.attende.password"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.isAlertPresent())
		CommonUtil.handleAlert();
		CommonUtil.waitForPageload();
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "Attendee");
}

public static void HallofFame(){
		
		CommonUtil.waitForPageload();
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.halloffame.username"));
		CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.halloffame.password"));
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
		CommonUtil.explicitlyWait(5);
		if(CommonUtil.isAlertPresent())
		CommonUtil.handleAlert();
		CommonUtil.waitForPageload();
		
		GSX_UserBasedRoles.checkUserBasedsessions();
		GSX_UserBasedRoles.validateUserBased(Expected, "HallofFame");
}

public static void ManagerExcellence(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.managerexcellence.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.managerexcellence.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBased(Expected, "ManagerExcellence");
}

public static void chairmansClub(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.chairmansclub.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.chairmansclub.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBased(Expected, "ChairmansClub");
}
	
public static void achiever(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.achiever.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.achiever.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBased(Expected, "Achiever");
	
}

public static void salesChampion(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.saleschampion.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.saleschampion.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBased(Expected, "Saleschampion");
	
}
	
public static void executive(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.executive.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.executive.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBased(Expected, "Executive");
	
}	
//###################### User Roles Invited only ##############
public static void eventStaff(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.eventstaff.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.eventstaff.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	System.out.println(Expected);
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "EventStaff");
	
}

public static void supportStaff(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.supportstaff.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.supportstaff.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	System.out.println(Expected);
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "SupportStaff");
	
}
public static void hubStaff(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.hubstaff.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.hubstaff.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	GSX_UserBasedRoles.validateUserBasedInvitedonly(Expected, "HubStaff");
	
}

//############## User Roles Non Pre-populated sessions###############
public static void auxmeeting(){
	
	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.auxmeeting.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.auxmeeting.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	GSX_UserBasedRoles.checkUserBasedsessions();
	System.out.println(Expected);
	GSX_UserBasedRoles.validateUserBasedInvitedonly1(Expected, "Aux Meeting");
	
}


	
	
	
public static String checkUserBasedsessions(){	
CommonUtil.waitForPageload();

CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
//CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload(); 
CommonUtil.explicitlyWait(5);
System.out.println("my agenda page is loded");

list=CommonUtil.findElements(elementProperties.getProperty("com.cisco.MyGsx.user.MyAgenda.sessionsList1"));
System.out.println(list.size());
Expectedlist.clear();

for(int i=1;i<=list.size();i++){
CommonUtil.click(elementProperties.getProperty("com.cisco.MyGsx.user.MyAgenda.sessionsListLinks1").replaceAll("VarX",Integer.toString(i)));

CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);

list1=CommonUtil.findElements(elementProperties.getProperty("com.cisco.MyGsx.user.MyAgenda.sessiondetails.sessionType1"));
 System.out.println(list1.size());

 for(int j=1;j<=list1.size();j++){
System.out.println(CommonUtil.getText(elementProperties.getProperty("com.cisco.MyGsx.user.MyAgenda.sessiondetails.sessionTypeText1").replaceAll("VarX",Integer.toString(j))));	 
Expectedlist.add(CommonUtil.getText(elementProperties.getProperty("com.cisco.MyGsx.user.MyAgenda.sessiondetails.sessionTypeText1").replaceAll("VarX",Integer.toString(j))));
 }
 CommonUtil.navigateBack();
 CommonUtil.waitForPageload();
 CommonUtil.explicitlyWait(3);
 
}
System.out.println(Expectedlist); 

if(Expectedlist.contains("General Session") && Expectedlist.contains("Region/Segment")&&Expectedlist.contains("Invited Sessions"))
{
 Expected="True";
}else
	Expected="False";
	
return Expected;
}	
	
	
	
	
public static void validateUserBased(String expected, String actual) {
		CommonUtil.waitForPageload();
		actualMsg = actual;
		expectedMsg = expected;
		
		user=actual;
		if (expectedMsg.equalsIgnoreCase("True")) {
			actualMsg =   "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			expectedMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			status = "PASS";
			System.out.println(actualMsg);
			System.out.println(expectedMsg);
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "General Sessions and Regional/Segment Sessions are  Pre-poulated and Invited sessions are Not Dispalyed for "+ user+" Role" ;
			expectedMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
			status = "FAIL";
			System.out.println(actualMsg);
			System.out.println(expectedMsg);
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		
		CommonUtil.waitForPageload();	

		
		
		}

public static void validateUserBasedInvitedonly(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;
	user=actual;
	System.out.println(expectedMsg);
	if (expectedMsg.equalsIgnoreCase("True")) {
		actualMsg =   "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "PASS";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}

public static void validateUserBasedInvitedonly1(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;
	user=actual;
	System.out.println(expectedMsg);
	if (expectedMsg.equalsIgnoreCase("True")) {
		actualMsg =   "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are  Dispalyed for "+ user+" Role" ;
		status = "PASS";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "General Sessions and Regional/Segment Sessions are Pre-poulated and Invited sessions are NOT Dispalyed for "+ user+" Role" ;
		expectedMsg = "General Sessions and Regional/Segment Sessions are NOT Pre-poulated and Invited sessions are NOT Dispalyed for "+ user+" Role" ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}




//######################PrePopulatedSessions ##############################

public static void  globalGeneralSession()
{	
CommonUtil.waitForPageload();	
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.myagenda.generalsession")))
{
Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.myagenda.generallockclass"), "class");

System.out.println(Expected);
GSX_UserBasedRoles.validateglobalGeneralSession(Expected,"lock");

	
}
else{

	System.out.println("global general session not found");
	GSX_UserBasedRoles.validateSessionpresents("Test Opening General Session");
}		
}	
public static void validateglobalGeneralSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Global General Sessions isPre-poulated and Button is unselectable" ;
		expectedMsg = "Global General Sessions isPre-poulated and Button is unselectable" ;
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Global General Sessions is Pre-poulated and Button is selectable" ;
		expectedMsg = "Global General Sessions is Pre-poulated and Button is unselectable";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}	

public static void  mealsSession(){	
CommonUtil.waitForPageload();	
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.myagenda.lunchsession")))
{
Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.myagenda.lunchclockclass"), "class");
System.out.println(Expected);
GSX_UserBasedRoles.validateglobalGeneralSession(Expected,"lock");
	
}
else{
	System.out.println("lunch test not found");
	GSX_UserBasedRoles.validateSessionpresents("LUNCH test");
}
}		
	
public static void validatelunchSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Meals Sessions isPre-poulated and Button is unselectable" ;
		expectedMsg = "Meals Sessions isPre-poulated and Button is unselectable" ;
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Meals Sessions is Pre-poulated and Button is selectable" ;
		expectedMsg = "Meals General Sessions is Pre-poulated and Button is unselectable";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}

public static void  americaSession(){	

	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.americas.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.americas.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	
	
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("america");
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.AmericasRegion")))
{
System.out.println("america session  found");
	Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.AmericasRegionclass"), "class");
System.out.println(Expected);
GSX_UserBasedRoles.validateAmericaSession(Expected,"minus");
	
}
else{
	System.out.println("america session  not found");
GSX_UserBasedRoles.validateSessionpresents("Test Americas Region");

}

}		
	
public static void validateAmericaSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Regional Sessions is Pre-poulated and session is Removed" ;
		expectedMsg = "Regional Sessions is Pre-poulated and session is Removed" ;
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Regional Sessions is Pre-poulated and Button is unselectable" ;
		expectedMsg = "Regional Sessions is Pre-poulated and session is Removed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	

	CommonUtil.waitForPageload();	

	
	
	}

public static void  EmearSession(){	

	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.emear.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.emear.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	
CommonUtil.waitForPageload();	
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("emear");
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.EmearRegion")))
{
	System.out.println("emear session  found");
Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.EmearRegionclass"), "class");
System.out.println(Expected);
GSX_UserBasedRoles.validateEMEARSession(Expected,"minus");
	
}
else
{
	System.out.println("emear session  not found");
GSX_UserBasedRoles.validateSessionpresents("Test EMEAR Region");
}
}		
	
public static void validateEMEARSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Regional Sessions is Pre-poulated and session is Removed" ;
		expectedMsg = "Regional Sessions is Pre-poulated and session is Removed" ;
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Regional Sessions is Pre-poulated and Add/Remove Button not exists" ;
		expectedMsg = "Regional Sessions is Pre-poulated and session is Removed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}
	
	
	CommonUtil.waitForPageload();	

	
	
	}
public static void  invitedSession(){	

	CommonUtil.waitForPageload();
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.username"), commonProperties.getProperty("cisco.gsx.invited.username"));
	CommonUtil.enterText(elementProperties.getProperty("cisco.gsx.password"), commonProperties.getProperty("cisco.gsx.invited.password"));
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.signin"));
	CommonUtil.explicitlyWait(3);
	if(CommonUtil.isAlertPresent())
	CommonUtil.handleAlert();
	CommonUtil.waitForPageload();
	
	
CommonUtil.waitForPageload();	
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.myAgenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("invited");
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.invited")))
{
	System.out.println("invited session  found");
Expected=CommonUtil.getAttribute(elementProperties.getProperty("cisco.gsx.invitedclass"), "class");
System.out.println(Expected);
GSX_UserBasedRoles.validateEMEARSession(Expected,"minus");
	
}
else
	System.out.println("invited session  not found");
GSX_UserBasedRoles.validateSessionpresents("Invited");

}		
	
public static void validateInvitedSession(String expected, String actual) {
	CommonUtil.waitForPageload();
	actualMsg = actual;
	expectedMsg = expected;

	System.out.println(expectedMsg);
	if (expectedMsg.contains(actualMsg)) {
		actualMsg =   "Invited Sessions is Pre-poulated and Button is unselectable";
		expectedMsg = "Invited Sessions is Pre-poulated and Button is unselectable";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Invited Sessions is Pre-poulated and selectable";
		expectedMsg = "Invited Sessions is Pre-poulated and Button is unselectable";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
	
	CommonUtil.waitForPageload();	

	}
public static void validateSessionpresents(String expected) {
	CommonUtil.waitForPageload();
	
	expectedMsg = expected;

	System.out.println(expectedMsg);
	
		actualMsg = expectedMsg+" Session is NOT Pre-poulated " ;
		expectedMsg = expectedMsg+" Session should be Pre-poulated " ;
		status = "FAIL";
		System.out.println(actualMsg);
		System.out.println(expectedMsg);
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
		
	}

//###############  Speakers To dispaly  ################


public static List<String> spekersToDisplay(){ 
	 CommonUtil.waitForPageload();
	 CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	 CommonUtil.waitForPageload();
	 CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	 CommonUtil.waitForPageload();
	 CommonUtil.explicitlyWait(3);
	 CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
	 CommonUtil.explicitlyWait(5);
	 
	 /**
	 CommonUtil.waitForPageload();
	 CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.MyGsx"));
	 CommonUtil.waitForPageload();
	 CommonUtil.explicitlyWait(3);
	 CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.dropdown.MyAgenda"));
	 CommonUtil.waitForPageload();
	 CommonUtil.explicitlyWait(5); 
	 */
	 for(int i=1;i<100;i++){
	    

	   if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.rolebased.speakers.donotdelete")))
	   {
	    CommonUtil.click(elementProperties.getProperty("cisco.gsx.rolebased.speakers.donotdelete"));
	    CommonUtil.waitForPageload();
	    CommonUtil.explicitlyWait(5);
	    break;
	   }
	   else{
	    CommonUtil.click(elementProperties.getProperty("cisco.gsx.rolebased.speaker.nextpage"));
	   CommonUtil.waitForPageload();
	   CommonUtil.explicitlyWait(5); 
	  }
	 }

	list=CommonUtil.findElements(elementProperties.getProperty("cisco.mygsx.myagenda.donotdeletetestsession2.speakersList"));
	System.out.println(list.size());
	Speakerlist.clear();

	for(int i=1;i<=list.size();i++){
	Speakerlist.add(CommonUtil.getText(elementProperties.getProperty("cisco.mygsx.myagenda.donotdeletetestsession2.speakersNames").replaceAll("VarX", Integer.toString(i))));
	}
	System.out.println(Speakerlist);


	return Speakerlist;
	}
	


public static void  surveyOnlySpaeaker(){	
	//pass Tricia Schaller notdisply
	System.out.println(Speakerlist);
	if (!Speakerlist.contains("Tricia Schaller")) {
		actualMsg = "Speakers who are Survey Only are not displayed";
		expectedMsg = "Speakers who are Survey Only are not displayed";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Speakers who are Survey Only are displayed";
		expectedMsg = "Speakers who are Survey Only are not displayed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}

	

}

public static void  moderatorSpaeaker(){	
	//fail Matt Koellner display
	GSX_UserBasedRoles.spekersToDisplay();
	System.out.println(Speakerlist);
	if (Speakerlist.contains("Matt Koellner")) {
		actualMsg = "Speakers who are Moderator are displayed";
		expectedMsg = "Speakers who are Moderator are displayed";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Speakers who are Moderator are not  displayed";
		expectedMsg = "Speakers who are Moderator are displayed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	

	

}

public static void  displayAndSurveySpaeaker(){	
	//pass  Test SPM DO NOT DELETE display
	GSX_UserBasedRoles.spekersToDisplay();
	System.out.println(Speakerlist);
	if (Speakerlist.contains("Test SPM DO NOT DELETE")) {
		actualMsg = "Speakers who are Display and Survey are displayed";
		expectedMsg = "Speakers who are Display and Survey are displayed";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Speakers who are Display and Survey are not  displayed";
		expectedMsg = "Speakers who are Display and Survey are displayed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	

	
}

public static void  displayOnlySpaeaker(){	
	//pass Tina Mena display
	GSX_UserBasedRoles.spekersToDisplay();
	System.out.println(Speakerlist);
	if (Speakerlist.contains("Tina Mena")) {
		actualMsg = "Speakers who are Display Only are displayed";
		expectedMsg = "Speakers who are Display Only are displayed";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Speakers who are Display Only are  not displayed";
		expectedMsg = "Speakers who are Display Only are displayed";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}

	
}


	

	
	
		

	


}
