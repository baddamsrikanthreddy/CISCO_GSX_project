package com.cisco.gsx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.TestNG;

public class IdeabytesTestRunner {

	private static Set<String> methodSet = new HashSet<String>();
	public static Properties commonProperties = null;

	static {

		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}

	@SuppressWarnings("unchecked")
	public static void runGSXTestCases() {

		try {

			Set<String> testMethodSet = null;			
			
			
			
//**************************** Login ****************************
			
			//methodSet.add("validateinvalidlogin");
			//methodSet.add("validatelogout");			
			
// ********************** The Hub ************************************************ 
		   //methodSet.add("verifyTheHubOverview");
		     /*methodSet.add("verifyTheHubschedule");*/
		   //methodSet.add("verifyTheHubinnovationshowcasepromo");
		   //methodSet.add("verifyTheHubmegadash");
		   /*methodSet.add("verifyTheHubTheaterpromoandsessionlistings");*/
		   //methodSet.add("verifyTheHubTheater");
		   //methodSet.add("verifyTheHubPhotos");
			
// ************************* All In Good *******************************************
 
 
			//methodSet.add("verifyAllInGoodOveriew");
		    //methodSet.add("verifyAllInGoodInTheHub");
		    //methodSet.add("verifyAllInGoodGlobalCelebration");
			
//*****************************  FAQ  ************************************************
			
			//methodSet.add("verifyFaqPage");
			
//****************************************** My Gsx **********************************	
			
			//methodSet.add("verifyMyAgenda");
			//methodSet.add("verifySessionInterests");
			//methodSet.add("verifyMyAccount");
			
			
		    //methodSet.add("verifyMyaccounteditmyprofile");
			//methodSet.add("verifyMyaccountviewmyprofile");
			//methodSet.add("verifyMyaccountinbox");
			//methodSet.add("verifyMyaccountnotes");
			//methodSet.add("verifyMyAgendapageminus");
			//methodSet.add("verifyMyAgendapageplus");
			//methodSet.add("verifyMyAgendasessiondetailspage");
			
			
			methodSet.add("verifySessionInterstTitleAndTime");
			//methodSet.add("verifySessionInterestsTimeDetails");
			//methodSet.add("verifySessionAddRemoveInMyinterests");
			//methodSet.add("verifySessionAddRemoveInMyinterests1");
			
//****************************************** Sessions ************************************
			
			//methodSet.add("verifysessionfullagenda");
			//methodSet.add("verifysessioncategoryguide");
			  //methodSet.add("verifysessiondevnet");
			//methodSet.add("verifysessionsaddtomyagenda");
			//methodSet.add("verifysessionsvenuedetailspage");
			//methodSet.add("verifysessionsspeakerdetailspage");
			//methodSet.add("verifysessionsspeakerorder");
			//methodSet.add("verifyfullAgendaSessionDates");
																/*methodSet.add("verifyfullAgendaRemoveSession");
																methodSet.add("verifyfullAgendaAddSession");*/
			//methodSet.add("verifyfullAgendaSessionDetails");
			//methodSet.add("verifyfullagendaSessionDetailsLayout");
			
//*********************************************** Attendees *********************************
			
			//methodSet.add("verifyattendeespage");
			//methodSet.add("verifyattendeeinformation");
			
//************************************************ Global Search ***************************
			
		    //methodSet.add("validatesearchpage");
			//methodSet.add("validatesearchentrytextlimit");
		    // methodSet.add("validatesearchtext");
			//methodSet.add("validatesearchresults");
			
//************************************************ Filters ***************************
			
			
           // methodSet.add("verifyfullagendaSessionFilters");
			//methodSet.add("verifySessionCategoryFilters");
			//methodSet.add("verifySessionTrackFilters");
			//methodSet.add("verifySessionTypeFilters");
			//methodSet.add("verifyCategoryFilters");
			//methodSet.add("verifyTrackFilters");
			//methodSet.add("verifyTypeFilters");
			
//******************************************* Customized buttons *******************************
			
			//methodSet.add("verifyrequiredSession");
		                                                   /*methodSet.add("verifysessionEnded");*/
		//	methodSet.add("verifysessionAllmostFull");
		//	methodSet.add("verifysessionFull");
		  //  methodSet.add("verifyaddMyAgenda");
		//	methodSet.add("verifyremovesession");
			
//********************************************** Role based permissions ****************************
			 
			
			   
			  //methodSet.add("verifyAttendeerole");
			  //methodSet.add("verifyHallofFamerole");
			  //methodSet.add("verifyManagerExcellence");
			  //methodSet.add("verifychairmansClub");
			  //methodSet.add("verifyAchiever");
			  //methodSet.add("verifySaleschampion");
			  //methodSet.add("verifyExecutive");
			   
			   
		        //methodSet.add("verifyEventstaff");
			   //methodSet.add("verifySupportStaff");
			   //methodSet.add("verifyHubStaff");
			   //methodSet.add("verifyAuxMeeting");
			   //methodSet.add("verifyGeneralsession");
			   
			   //methodSet.add("verifyMealssession");
			   //methodSet.add("verifyAmericaSession");
			   //methodSet.add("verifyEMEARSession");
			   //methodSet.add("verifyInvited");
			   
			  // methodSet.add("verifySurveyOnlySpaeaker");
			   //methodSet.add("verifymoderatorSpaeaker");
			   //methodSet.add("verifydisplayAndSurveySpaeaker");
			   //methodSet.add("verifyDisplayOnlySpaeaker");

//*********************************************************************************************************************************			
			Map<String, Set<String>> q2oTestCasesMap = new HashMap<String, Set<String>>();
			q2oTestCasesMap.put("com.cisco.gsx.testsuites.GSX", methodSet);
			System.out.println("0.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			TestNG testng = new TestNG();
			System.out.println("1.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			Class classObj[] = new Class[q2oTestCasesMap.keySet().size()];
			System.out.println("2.test case map size:"
					+ q2oTestCasesMap.keySet().size());
			int i = 0;

			for (Iterator iterator = q2oTestCasesMap.keySet().iterator(); iterator
					.hasNext(); i++) {
				String className = (String) iterator.next();
				System.out.println("vv:" + className);
				classObj[i] = Class.forName(className.trim());

				 methodSet.addAll(q2oTestCasesMap.get(className));
			}

			testng.setTestClasses(classObj);
			testng.addListener(new com.cisco.gsx.reports.IdeabytesListener());

			System.out.println("MethodSet :" + methodSet.size());
			testng.setMethodInterceptor(new IMethodInterceptor() {

				@Override
				public List<IMethodInstance> intercept(
						List<IMethodInstance> inMethod, ITestContext arg1) {
					List<IMethodInstance> methodList = new ArrayList<IMethodInstance>();

					for (IMethodInstance m : inMethod) {
						String methodName = m.getMethod().getMethodName();
						System.out.println("x:" + methodName);
						if (methodSet.contains(methodName)) {
							methodList.add(m);
							System.out.println("If loop in Ideabytes Test RUnner");
						}
						System.out.println("For loop in Ideabytes Test RUnner");
					}
					System.out.println("intercept function in Ideabytes Test RUnner");
					return methodList;
				}
			});
			System.out.println("Testng is about to run"); 
			testng.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
