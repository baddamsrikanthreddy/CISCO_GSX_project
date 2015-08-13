package com.cisco.gsx.testsuites;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;

import com.cisco.gsx.pageObjects.Attendees;
import com.cisco.gsx.pageObjects.Customizedbuttons;
import com.cisco.gsx.pageObjects.GSX_Allinongoodpage;
import com.cisco.gsx.pageObjects.GSX_FaqPage;
import com.cisco.gsx.pageObjects.GSX_Filters;
import com.cisco.gsx.pageObjects.GSX_HotelReservation;
import com.cisco.gsx.pageObjects.GSX_RegistrationPage;
import com.cisco.gsx.pageObjects.GSX_UserBasedRoles;
import com.cisco.gsx.pageObjects.Globalsearch;
import com.cisco.gsx.pageObjects.LoginPage;
import com.cisco.gsx.pageObjects.MyGsx;
import com.cisco.gsx.pageObjects.SessionCatalog;
import com.cisco.gsx.pageObjects.Sessions;
import com.cisco.gsx.pageObjects.TheHub;

import org.openqa.selenium.html5.SessionStorage;
import org.testng.annotations.Test;

import com.cisco.gsx.excelreader.Dataproviderclass;
import com.cisco.gsx.excelreader.DataPojoClass;
import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX {
	// public static AddressManagementHarnessCodeImpl harness = new
	// AddressManagementHarnessCodeImpl();
	/**
	 * Conformiq Designer generated test case Displays Informational message [in
	 * region To Verify that new siteID is created when user creates n~ install
	 * s~ id with n~ s~ address using a~ management option.] Name Digest
	 * (SHA-1), DO NOT REMOVE: 6d77d4f8db0e1134cef2b6385ada5ffb4233f830
	 */
	static Map<?, ?> map = null;
	static List<String> testlist;
	static int count;
	//private String testCaseName = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	// private boolean Q2O_ADDRESS_MGMT_ADDLINE = false;

	static {

		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	public void setUp(String testcaseName) {
		System.out.println("=============================" + testcaseName
				+ " Started =============================");
		String browserType = "firefox";
		//String browserType = "iexplorer";
		System.out.println("DB - BrowserType" + browserType);
		CommonUtil.openBrowser(browserType);
		CommonUtil.openUrl(commonProperties.getProperty("cisco.gsx.url"));
		CommonUtil.maximizeWindow();
	}

	public void tearDown(String testcaseName) {
		//CommonUtil.click(elementProperties.getProperty("cisco.gsx.logout"));
		CommonUtil.closeBrowser();
		System.out.println("=============================" + testcaseName
				+ " Ended =============================");
	}

//******************************* Login ****************************
	
	@Test
	public void validateinvalidlogin() throws Exception {
		this.setUp("Verify the login page with invalid credentials");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentialsforinvalidlogin();
		
		

		this.tearDown("Verify the login page with invalid credentials");
	}
	
	@Test
	public void validatelogout() throws Exception {
		this.setUp("Verify the logout page");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		LoginPage.Logout();
		
		this.tearDown("Verify the logout page");
	}
	
	
	
	
	
//****************************    THE HUB      ************************************************************
	@Test
	public void verifyTheHubOverview() throws Exception {
		this.setUp("Verify The hub Overview");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Overview();

		this.tearDown("Verify The hub Overview");
	}
	
	@Test
	public void verifyTheHubschedule() throws Exception {
		this.setUp("Verify The hub schedule");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Schedule();

		this.tearDown("Verify The hub schedule");
	}
	
	@Test
	public void verifyTheHubinnovationshowcasepromo() throws Exception {
		this.setUp("Verify The hub innovationshowcasepromo");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Innovationshowcasepromo();

		this.tearDown("Verify The hub innovationshowcasepromo");
	}
	
	@Test
	public void verifyTheHubmegadash() throws Exception {
		this.setUp("Verify The hub megadash");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Megadash();

		this.tearDown("Verify The hub megadash");
	}
	
	@Test
	public void verifyTheHubTheaterpromoandsessionlistings() throws Exception {
		this.setUp("Verify The hub Theaterpromoandsessionlistings");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Theaterpromoandsessionlistings();

		this.tearDown("Verify The hub Theaterpromoandsessionlistings");
	}
	
	@Test
	public void verifyAllInGoodOveriew() throws Exception {
		
			this.setUp("All In On Good Overview page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			GSX_Allinongoodpage.overviewPage();
			
			
			this.tearDown("All In On OverviewPage");
			
		}
	@Test
	public void verifyAllInGoodInTheHub() throws Exception {
		
			this.setUp("All In On Good InTheHub page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			GSX_Allinongoodpage.inTheHubPage();
			
			
			this.tearDown("All In On InTheHub Page");
			
		}
	@Test
	public void verifyAllInGoodGlobalCelebration() throws Exception {
		
			this.setUp("All In On Good GlobalCelebration page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			GSX_Allinongoodpage.globalCelebrationPage();
			
			
			this.tearDown("All In On GlobalCelebration Page");
			
		}
	@Test
	public void verifyFaqPage() throws Exception {
		
			this.setUp("Faq page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			GSX_FaqPage.FAQPage();
			
			
			this.tearDown("Faq Page");
			
		}
	
	@Test
	public void verifyTheHubTheater() throws Exception {
		this.setUp("Verify The hub Theater");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Theater();

		this.tearDown("Verify The hub Theater");
	}
	    
	@Test
	public void verifyTheHubPhotos() throws Exception {
		this.setUp("Verify The hub Photos");
		
		//Validate login page
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
		
		//Verify Overview page
		TheHub.Photos();

		this.tearDown("Verify The hub Photos");
	}
	
	//***************************************  MY GSX *****************************************
	
	@Test
	public void verifyMyAgenda() throws Exception {
		
			this.setUp("verify My Agenda page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.MyAgenda();
			
			
			this.tearDown("verify My Agenda page");
			
		}
	
   @Test
	public void verifySessionInterests() throws Exception {
		
			this.setUp("verify My Session Interests");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.MySessionInterests();
			
			
			this.tearDown("verify My Session Interests");
			
		}
	@Test
	public void verifyMyAccount() throws Exception {
		
			this.setUp("verify My Account");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.MyAccount();
			
			
			this.tearDown("verify My Account");
			
		}
	
	@Test
	public void verifyMyaccounteditmyprofile() throws Exception {
		
			this.setUp("verify My Account edit my profile page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.ValidateMyaccounteditmyprofile();
			
			
			this.tearDown("verify My Account edit my profile page");
			
		}
	
	
	@Test
	public void verifyMyaccountviewmyprofile() throws Exception {
		
			this.setUp("verify My Account view my profile page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.ValidateMyaccountviewmyprofile();
			
			
			this.tearDown("verify My Account view my profile page");
			
		}
	
	
	@Test
	public void verifyMyaccountinbox() throws Exception {
		
			this.setUp("verify My Account inbox page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.ValidateMyaccountinbox();
			
			
			this.tearDown("verify My Account inbox page");
			
		}
	

	@Test
	public void verifyMyaccountnotes() throws Exception {
		
			this.setUp("verify My Account notes page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.ValidateMyaccountnotes();
			
			
			this.tearDown("verify My Account notes page");
			
		}
	
	@Test
	public void verifyMyAgendapageminus() throws Exception {
		
			this.setUp("verify My Agenda minus is highlighted");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			MyGsx.MyAgendapageminusverification();
			
			
			this.tearDown("verify My Agenda minus is highlighted");
			
		}
	
	@Test
	public void verifyMyAgendapageplus() throws Exception {
		
		this.setUp("verify My Agenda plus is highlighted");
		
		
		
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
	
		
		MyGsx.MyAgendapageplusverification();
		
		
		this.tearDown("verify My Agenda plus is highlighted");
		
	}
	
	@Test
	public void verifyMyAgendasessiondetailspage() throws Exception {
		
		this.setUp("verify My Agenda session details page");
		
		
		
		LoginPage.validateLoginPage();
		LoginPage.enterCredentials();
	
		
		MyGsx.verifyMyagendasessiondetails();
		
		
		this.tearDown("verify My Agenda session details page");
		
	}
	
	//************************************************ Sessions ******************************************************
	
	
	@Test
	public void verifysessionfullagenda() throws Exception {
		
			this.setUp("verify sessions full agenda page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Sessions.sessionfullagenda();
			
			
			this.tearDown("verify sessions full agenda page");
			
		}
	
	@Test
	public void verifysessioncategoryguide() throws Exception {
		
			this.setUp("verify sessions recommendations page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.sessioncategoryguides();
			
			
			
			this.tearDown("verify sessions recommendations page");
			
		}
	
	@Test
	public void verifysessiondevnet() throws Exception {
		
			this.setUp("verify sessions devnet page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.sessiondevnet();
			
			
			
			this.tearDown("verify sessions devnet page");
			
		}
	@Test
	public void verifysessionsaddtomyagenda() throws Exception {
		
			this.setUp("verify add to agenda in session details page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.sessionsaddtomyagenda();
			
			
			
			this.tearDown("verify add to agenda in session details page");
			
		}
	
	
	@Test
	public void verifysessionsvenuedetailspage() throws Exception {
		
			this.setUp("verify venue details page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.sessionsvenuedetails();
			
			
			
			this.tearDown("verify venue details page");
			
		}
	
	@Test
	public void verifysessionsspeakerdetailspage() throws Exception {
		
			this.setUp("verify speaker details page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.sessionsspeakerdetails();
			
			
			
			this.tearDown("verify speaker details page");
			
		}
	
	
	@Test
	public void verifysessionsspeakerorder() throws Exception {
		
			this.setUp("verify speaker information order");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
			Sessions.validatesessionspeakerorder();
			
			
			
			this.tearDown("verify speaker information order");
			
		}
	
	//******************************** Attendees *************************************************************
	
	@Test
	public void verifyattendeespage() throws Exception {
		
			this.setUp("verify Attendee page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Attendees.Attendees();
			
			
			
			this.tearDown("verify Attendee page");
			
		}
	
	@Test
	public void verifyattendeeinformation() throws Exception {
		
			this.setUp("verify Attendee information ");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Attendees.verifyAttendeeinformation();
			
			
			
			this.tearDown("verify Attendee information ");
			
		}
//************************************** Global Search ******************************************	
	@Test
	public void validatesearchpage() throws Exception {
		
			this.setUp("verify Global search page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Globalsearch.verifysearchpage();
			
			
			
			this.tearDown("verify Global search page");
			
		}
	
	@Test
	public void validatesearchentrytextlimit() throws Exception {
		
			this.setUp("verify Global search text limit");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Globalsearch.verifysearchentrytextlimit();
			
			
			
			this.tearDown("verify Global search text limit");
			
		}
	
	@Test
	public void validatesearchtext() throws Exception {
		
			this.setUp("verify Global search text");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Globalsearch.verifysearchtext();
			
			
			
			this.tearDown("verify Global search text");
			
		}
	
	@Test
	public void validatesearchresults() throws Exception {
		
			this.setUp("verify Global search page results");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
		
			
		    Globalsearch.verifysearchresults();
			
			
			
			this.tearDown("verify Global search page results");
			
		}
	
	@Test
	public void verifyfullAgendaPage() throws Exception {
		
			this.setUp("Full Agenda  page");
			
			
			//  verify session dates in full agenda
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			Sessions.fullAgendaPage();
			
			
	this.tearDown("Full Agenda Page");
			
		}
	
	@Test
	public void verifyfullAgendaSessionDates() throws Exception {
		
			this.setUp("Full Agenda Session Dates page");
			
			
			//  verify session dates in full agenda
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			Sessions.fullAgendaDatePage();
			
			
	this.tearDown("Full Agenda Session Dates Page");
			
		}
	/*@Test
	public void verifyfullAgendaRemoveSession() throws Exception {
		
			this.setUp("Full Agenda Remove Verifypage");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			// verify remove session in full agenda
			Sessions.fullAgendaPageminusverification();
			
			this.tearDown("Full Agenda Remove verify Page");
			
		}
	@Test
	public void verifyfullAgendaAddSession() throws Exception {
		
			this.setUp("Full Agenda Add verify page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			// verify add session in full agenda
			Sessions.fullAgendapageplusverification();
			
			
		this.tearDown("Full Agenda Add verify Page");
			
		}*/
	@Test
	public void verifyfullAgendaSessionDetails() throws Exception {
		
			this.setUp("Full Agenda Session Details page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session details in full agenda
			Sessions.fullagendaSessionDetailsPage();
			
		
			this.tearDown("Full Agenda Session Details Page");
			
		}
	@Test
	public void verifyfullagendaSessionDetailsLayout() throws Exception {
		
			this.setUp("Full Agenda Session Details Layout page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session details layout in full agenda
			Sessions.sessionDetailsLayout();
			
		
			this.tearDown("Full Agenda Session Details Layout Page");
			
		}
	@Test
	public void verifyfullagendaSessionFilters() throws Exception {
		
			this.setUp("Full Agenda Session Filters");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session filters in full agenda
			GSX_Filters.fullAgendaFilters();
			
			
		
			this.tearDown("Full Agenda Session Details Filters");
			
		}
	@Test
	public void verifySessionCategoryFilters() throws Exception {
		
			this.setUp("  Session Category Filters");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session category filters  in full agenda
			GSX_Filters.fullAgendaCategoryFilters();
			
			
		
			this.tearDown("Full Session category  Filters");
			
		}
	@Test
	public void verifySessionTrackFilters() throws Exception {
		
			this.setUp("  Session Track Filters");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session track filters in full agenda
			GSX_Filters.fullAgendaTrackFilters();
			
			
		
			this.tearDown(" Session track  Filters");
			
		}
	@Test
	public void verifySessionTypeFilters() throws Exception {
		
			this.setUp("  Session Type Filters");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify session type filters in full agenda
			GSX_Filters.fullAgendaTypeFilters();
			
			
		
			this.tearDown(" Session Type  Filters");
			
		}
	@Test
	public void verifyMySessionInterestsPage() throws Exception {
		
			this.setUp("My Session Interests Page");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Page
			MyGsx.MyinterestsPage();
			
			
		
			this.tearDown("My Session Interests Page");
			
		}
	@Test
	public void verifySessionInterstTitleAndTime() throws Exception {
		
			this.setUp("My Session Interests title and time");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests title and time
			MyGsx.Myintereststitleandtime();
			
			
		
			this.tearDown("My Session Interests title and time");
			
		}
	@Test
	public void verifySessionInterestsTimeDetails() throws Exception {
		
			this.setUp("My Session Interests Time Details");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			MyGsx.sessionInterestsTimeDetails();
			
			
		
			this.tearDown("My Session Interests Time Details");
			
		}
	@Test
	public void verifySessionAddRemoveInMyinterests() throws Exception {
		
			this.setUp("Add/remove in My Session Interests Time Details");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			MyGsx.sessionInterestsAddtomyagenda();
			
			
		
			this.tearDown("Add/remove in My Session Interests Time Details");
			
		}
	@Test
	public void verifySessionAddRemoveInMyinterests1() throws Exception {
		
			this.setUp("Add/remove in My Session Interests Time Details");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			MyGsx.sessionInterestsAddtomyagenda1();
			
			
		
			this.tearDown("Add/remove in My Session Interests Time Details");
			
		}
	@Test
	public void verifyClearAllFilters() throws Exception {
		
			this.setUp("clearing all filters");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			GSX_Filters.clearALLFilters();
			
			
		
			this.tearDown("clearing all filters");
			
		}
	@Test
	public void verifyCategoryFilters() throws Exception {
		
			this.setUp("verifying sessions according to selected category filter");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			GSX_Filters.clearALLFilters();
			GSX_Filters.setCategoryFilters();
			GSX_Filters.checkCategoryFilters();
			
			
		
			this.tearDown("verifying sessions according to selected category filter");
			
		}
	@Test
	public void verifyTrackFilters() throws Exception {
		
			this.setUp("verifying sessions according to selected Track filter");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			GSX_Filters.clearALLFilters();
			GSX_Filters.setTrackFilters();
			GSX_Filters.checkTrackFilters();
			
			
		
			this.tearDown("verifying sessions according to selected Track filter");
			
		}
	@Test
	public void verifyTypeFilters() throws Exception {
		
			this.setUp("verifying sessions according to selected Type filter");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			//verify My Session Interests Time Details
			GSX_Filters.clearALLFilters();
			GSX_Filters.setTypeFilters();
			GSX_Filters.checkTypeFilters();
			
			
		
			this.tearDown("verifying sessions according to selected Type filter");
			
		}
	//********************************************  Customized Buttons *******************************************
	
	@Test
	public void verifyrequiredSession() throws Exception {
		
			this.setUp("verifying REQUIRED SESSION");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.requiredSession();
			
			
		
			this.tearDown("verifying REQUIRED SESSION");
			
		}
	
	@Test
	public void verifysessionEnded() throws Exception {
		
			this.setUp("verifying SESSION ENDED");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.sessionEnded();
			
			
		
			this.tearDown("verifying SESSION ENDED");
			
		}
	
	@Test
	public void verifysessionAllmostFull() throws Exception {
		
			this.setUp("verifying session ALMOST FULL");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.sessionAllmostFull();
			
			
		
			this.tearDown("verifying session ALMOST FULL");
			
		}
	
	@Test
	public void verifysessionFull() throws Exception {
		
			this.setUp("verifying SESSION FULL");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.sessionFull();
			
			
		
			this.tearDown("verifying SESSION FULL");
			
		}
	
	@Test
	public void verifyaddMyAgenda() throws Exception {
		
			this.setUp("verifying session added to my agenda");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.addMyAgenda();
			
			
		
			this.tearDown("verifying session added to my agenda");
			
		}
	
	@Test
	public void verifyremovesession() throws Exception {
		
			this.setUp("verify remove session");
			
			
			
			LoginPage.validateLoginPage();
			LoginPage.enterCredentials();
			
			
			Customizedbuttons.validateremovesession();
			
			
		
			this.tearDown("verify remove session");
			
		}
	
	//******************************** Role based permissions *************************************
	
	//################### user based roles ########################	
	
		@Test
		public void verifyAttendeerole() throws Exception {
			
				this.setUp("verifying Attendee Role");
				
				
				GSX_UserBasedRoles.attendeeRole();
				
				this.tearDown("verifying Attendee Role");
				
		}
		
		@Test
		public void verifyHallofFamerole() throws Exception {
			
				this.setUp("verifying HallofFame Role");
				
				
				GSX_UserBasedRoles.HallofFame();
				
				this.tearDown("verifying HallofFame Role");
				
		}
		
		@Test
		public void verifyManagerExcellence() throws Exception {
			
				this.setUp("verifying ManagerExcellence Role");
				
				
				GSX_UserBasedRoles.ManagerExcellence();
				
				this.tearDown("verifying ManagerExcellence Role");
				
		}
		
		@Test
		public void verifychairmansClub() throws Exception {
			
				this.setUp("verifying chairmansClub Role");
				
				
				GSX_UserBasedRoles.chairmansClub();
				
				this.tearDown("verifying chairmansClub Role");
				
		}
		
		@Test
		public void verifyAchiever() throws Exception {
			
				this.setUp("verifying Achiever Role");
				
				
				GSX_UserBasedRoles.achiever();
				
				this.tearDown("verifying Achiever Role");
				
		}
		
		@Test
		public void verifySaleschampion() throws Exception {
			
				this.setUp("verifying Saleschampion Role");
				
				
				GSX_UserBasedRoles.salesChampion();
				
				this.tearDown("verifying Saleschampion Role");
				
		}
		
		@Test
		public void verifyExecutive() throws Exception {
			
				this.setUp("verifying Executive Role");
				
				
				GSX_UserBasedRoles.executive();
				
				this.tearDown("verifying Executive Role");
				
		}
		
		@Test
		public void verifyEventstaff() throws Exception {
			
				this.setUp("verifying Eventstaff Role");
				
				
				GSX_UserBasedRoles.eventStaff();
				
				this.tearDown("verifying Eventstaff Role");
				
		}
		@Test
		public void verifySupportStaff() throws Exception {
			
				this.setUp("verifying SupportStaff Role");
				
				
				GSX_UserBasedRoles.supportStaff();
				
				this.tearDown("verifying SupportStaff Role");
				
		}
		@Test
		public void verifyHubStaff() throws Exception {
			
				this.setUp("verifying HubStaff Role");
				
				
				GSX_UserBasedRoles.hubStaff();
				
				this.tearDown("verifying HubStaff Role");
				
		}
		@Test
		public void verifyAuxMeeting() throws Exception {
			
				this.setUp("verifying AuxMeeting");
				
				
				GSX_UserBasedRoles.hubStaff();
				
				this.tearDown("verifying AuxMeeting");
				
		}
		
		
		
		@Test
		public void verifyGeneralsession() throws Exception {
			
				this.setUp("verify Global General session");
				
				LoginPage.validateLoginPage();
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.globalGeneralSession();
				
				this.tearDown("verify Global General session");
				
		}
		
		@Test
		public void verifyMealssession() throws Exception {
			
				this.setUp("verify Meal session");
				
				LoginPage.validateLoginPage();
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.mealsSession();
				
				this.tearDown("verify Meal session");
				
		}
		
		@Test
		public void verifyAmericaSession() throws Exception {
			
				this.setUp("verify America session");
				
				GSX_UserBasedRoles.americaSession();
				
				this.tearDown("verify America  session");
				
		}
		
		@Test
		public void verifyEMEARSession() throws Exception {
			
				this.setUp("verify EMEAR session");
				
				GSX_UserBasedRoles.EmearSession();
				
				this.tearDown("verify EMEAR  session");
				
		}
		
		@Test
		public void verifyInvited() throws Exception {
			
				this.setUp("verify Invited session");
				
				GSX_UserBasedRoles.invitedSession();
				
				this.tearDown("verify Invited session");
				
		}
		
		@Test
		public void verifySurveyOnlySpaeaker() throws Exception {
			
				this.setUp("verify SurveyOnly Spaeaker");
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.surveyOnlySpaeaker();
				
				this.tearDown("verify SurveyOnly Spaeaker");
				
		}
		@Test
		public void verifymoderatorSpaeaker() throws Exception {
			
				this.setUp("verify Moderator Spaeaker");
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.moderatorSpaeaker();
				
				this.tearDown("verify Moderator Spaeaker");
				
		}
		
		@Test
		public void verifydisplayAndSurveySpaeaker() throws Exception {
			
				this.setUp("verify display And Survey Spaeaker");
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.displayAndSurveySpaeaker();
				
				this.tearDown("verify display And Survey Spaeaker");
				
				
		}
		
		@Test
		public void verifyDisplayOnlySpaeaker() throws Exception {
			
				this.setUp("verify Display Only Spaeaker ");
				LoginPage.enterCredentials();
				GSX_UserBasedRoles.displayOnlySpaeaker();
				
				this.tearDown("verify Display Only Spaeaker");
				
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
}
