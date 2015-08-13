package com.cisco.gsx.pageObjects;



import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cisco.gsx.util.PropertiesFileReader;
import com.cisco.gsx.utilities.CommonUtil;

public class GSX_Filters {

	public static Properties elementProperties=null;
	public static Properties commonProperties=null;
	private static String Mouseoverelement=null;
	private static String actualMsg=null;
	private static String expectedMsg=null;
	private static List<String> actualMsglist = null;
	private static List<String> expectedMsglist = null;
	private static String status=null;
	private static List<String> Expected=null;
	private static List<String> Actual=null;
	private static List<String> Expectedlist = new ArrayList<String>();
	private static List<String> Actuallist = new ArrayList<String>();
	private static String Expected1=null;
	private static String Expectedfilter=null;
	private static String filter=null;
	//new ArrayList<String>();
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	
	public static void fullAgendaFilters(){
		
		System.out.println("entered into fullagenda");
	CommonUtil.waitForPageload();
	
	CommonUtil.explicitlyWait(3);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(7);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	List<WebElement> list=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filterslist"));
	
	System.out.println(list.size());
	
	Expectedlist.clear();
	Actuallist.clear();
	for(WebElement e:list){
		System.out.println(e.getText());
		Expectedlist.add(e.getText());
		
	}

	
	Actuallist.add("Category");
	Actuallist.add("Track");
	Actuallist.add("Type");
	System.out.println(Actuallist);
	System.out.println(Expectedlist);
	
	GSX_Filters.validateFilterTypes(Expectedlist, Actuallist);
	}
	

	public static void validateFilterTypes(List<String> Expected, List<String> Actual) {
		CommonUtil.waitForPageload();
		actualMsglist = Actual;
		expectedMsglist = Expected;
		
		if (actualMsglist.equals(expectedMsglist)) {
			actualMsg = " Three Type categories are dispalyed Successfully ";
			expectedMsg = "Three Type categories are  dispalyed Successfully ";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			actualMsg = "Three Type categories are not  dispalyed Successfully ";
			expectedMsg = "Three Type categoriesare  dispalyed Successfully ";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		}
		CommonUtil.waitForPageload();	
	}
	public static void fullAgendaCategoryFilters(){
		
		
		CommonUtil.waitForPageload();
		
		CommonUtil.explicitlyWait(3);
		CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(3);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(7);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.categoryfilter"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		List<WebElement> list1=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.categorylist"));
		
		System.out.println(list1.size());
		Expectedlist.clear();
		Actuallist.clear();
		
		for(WebElement e:list1){
			System.out.println(e.getText());
			Expectedlist.add(e.getText());
			
		}

		
		Actuallist.add("Cloud/Intercloud");
		Actuallist.add("Collaboration");
		Actuallist.add("Data Center ACI/UCS");
		Actuallist.add("Enterprise Networking");
		Actuallist.add("Other Topics");
		Actuallist.add("Security");
		Actuallist.add("Service Provider Technology");
		Actuallist.add("Services");
		Actuallist.add("Vertical Solutions/IoE");
		
		
		
		System.out.println(Actuallist+"for actual");
		System.out.println(Expectedlist+"for expectd");
		
		GSX_Filters.validateCategoryFilters(Expectedlist, Actuallist);
		}
		

		public static void validateCategoryFilters(List<String> Expected, List<String> Actual) {
			CommonUtil.waitForPageload();
			actualMsglist = Actual;
			expectedMsglist = Expected;
			
			System.out.println(expectedMsglist);
			if (actualMsglist.equals(expectedMsglist)) {
				actualMsg = " CATEGORY  Filters are dispalyed Successfully ";
				expectedMsg = "CATEGORY   Filters are  dispalyed Successfully ";
				status = "PASS";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			} else {
				actualMsg = "CATEGORY  Filters are not  dispalyed Successfully ";
				expectedMsg = "CATEGORY  Filters are dispalyed Successfully ";
				status = "FAIL";
				CommonUtil.logMessage(expectedMsg, actualMsg, status);
			}
			CommonUtil.waitForPageload();	
		}
		
public static void fullAgendaTrackFilters(){
			
			
			CommonUtil.waitForPageload();
			
			CommonUtil.explicitlyWait(3);
			CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(7);
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(3);
			
			CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.trackfilter"));
			CommonUtil.waitForPageload();
			CommonUtil.explicitlyWait(5);
			List<WebElement> list2=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.tracklist"));
			
			System.out.println(list2.size());
			Expectedlist.clear();
			Actuallist.clear();
			
			for(WebElement e:list2){
				System.out.println(e.getText());
				Expectedlist.add(e.getText());
				
			}

			
			Actuallist.add("Sales Culture and Talent");
			Actuallist.add("Strategic Selling");
			Actuallist.add("Technology and Innovation");
			
			
			
			System.out.println(Actuallist+"for actual");
			System.out.println(Expectedlist+"for expectd");
			
			GSX_Filters.validateTrackFilters(Expectedlist, Actuallist);
			}
			

public static void validateTrackFilters(List<String> Expected, List<String> Actual) {
				CommonUtil.waitForPageload();
				actualMsglist = Actual;
				expectedMsglist = Expected;
				
				System.out.println(expectedMsglist);
				if (actualMsglist.equals(expectedMsglist)) {
					actualMsg = " TRACK Type Filters are dispalyed Successfully ";
					expectedMsg = "TRACK Type Filters are  dispalyed Successfully ";
					status = "PASS";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
				} else {
					actualMsg = " TRACK Type Filters are  not dispalyed Successfully ";
					expectedMsg = "TRACK  Type Filters are  dispalyed Successfully ";
					status = "FAIL";
					CommonUtil.logMessage(expectedMsg, actualMsg, status);
				}
				CommonUtil.waitForPageload();	
			}
public static void fullAgendaTypeFilters(){
				
				
	CommonUtil.waitForPageload();
				
				CommonUtil.explicitlyWait(3);
				CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(3);
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(7);
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(5);
				                                                
				CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.typefilter"));
				CommonUtil.waitForPageload();
				CommonUtil.explicitlyWait(5);
				List<WebElement> list3=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.typelist"));
				
				System.out.println(list3.size());
				Expectedlist.clear();
				Actuallist.clear();
				for(WebElement e:list3){
					System.out.println(e.getText());
					Expectedlist.add(e.getText());
					
				}

				
				Actuallist.add("Breakout Session");
				Actuallist.add("General Session");
				Actuallist.add("Hub Session");
				Actuallist.add("Invited Sessions");
				Actuallist.add("Meals");
				Actuallist.add("Region/Segment");
				Actuallist.add("Super Session");
				
				
				
				
				System.out.println(Actuallist+"for actual");
				System.out.println(Expectedlist+"for expectd");
				
				GSX_Filters.validateTypeFilters(Expectedlist, Actuallist);
				}
				

public static void validateTypeFilters(List<String> Expected, List<String> Actual) {
					CommonUtil.waitForPageload();
					actualMsglist = Actual;
					expectedMsglist = Expected;
					
					System.out.println(expectedMsglist);
					if (actualMsglist.equals(expectedMsglist)) {
						actualMsg = "  TYPE Filters are dispalyed Successfully ";
						expectedMsg = " TYPE Filters are  dispalyed Successfully ";
						status = "PASS";
						CommonUtil.logMessage(expectedMsg, actualMsg, status);
					} else {
						actualMsg = "TYPE Filters are  not dispalyed Successfully ";
						expectedMsg = "TYPE Filters are  dispalyed Successfully ";
						status = "FAIL";
						CommonUtil.logMessage(expectedMsg, actualMsg, status);
					}
					CommonUtil.waitForPageload();	
				}


//##################################  Filter Clear #########################################


public static void clearALLFilters(){
	
	
	CommonUtil.waitForPageload();
	
	CommonUtil.explicitlyWait(3);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(7);
	
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.categoryfilter"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	System.out.println("Ready to clear filters");
	
	if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect")))
		{
		
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
		}
	
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect")))
		CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
		
CommonUtil.waitForPageload();
	
	CommonUtil.explicitlyWait(3);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(7);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.trackfilter"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect")))
	{
	
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
	}

if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect")))
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
	
CommonUtil.waitForPageload();
	
	CommonUtil.explicitlyWait(3);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(7);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.typefilter"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	
	if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect")))
	{
	
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxselect"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
	}

if(CommonUtil.isElementPresent1(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect")))
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.allfilterscheckboxdeselect"));
	
	
	CommonUtil.explicitlyWait(3);
	CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(3);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(7);
	CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
	CommonUtil.waitForPageload();
	CommonUtil.explicitlyWait(5);
	
}		

//################################### Set Category Filter #######################
public static void setCategoryFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);

CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.categoryfilter"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("Ready to set filters");

CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.category.datacenterACI/UCS"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.category.security"));
CommonUtil.explicitlyWait(5);

}

public static void setTrackFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);

CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.trackfilter"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("Ready to set filters");

CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.track.SalesCultureandTalent"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.track.StrategicSelling"));
CommonUtil.explicitlyWait(5);

}

public static void setTypeFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(7);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filtersbutton"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);

CommonUtil.click(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.typefilter"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
System.out.println("Ready to set filters");

CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.type.breakoutSession"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.sessions.fullagenda.filters.type.supersession"));
CommonUtil.explicitlyWait(5);

}
//################################### Verify Sessions according to selected filters #######################

public static void checkCategoryFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);

Actuallist.clear();
Actuallist.add("Data Center ACI/UCS");
Actuallist.add("Security");


List<WebElement> filterlist1=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.sesioncategory"));

System.out.println(filterlist1.size());
Expectedlist.clear();
for(WebElement e:filterlist1){
	System.out.println(e.getText());
	Expectedlist.add(e.getText());
	
}


System.out.println(Actuallist);
System.out.println(Expectedlist);

if(Expectedlist.contains(Actuallist.get(0))||Expectedlist.contains(Actuallist.get(1)))
	Expected1="True";
else
	Expected1="false";
	
GSX_Filters.validatefilters(Expected1, "Category");	


}

public static void checkTrackFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);

Actuallist.clear();
Actuallist.add("Sales Culture and Talent");
Actuallist.add("Strategic Selling");
List<WebElement> filterlist2=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.sesioncategory"));

System.out.println(filterlist2.size());
Expectedlist.clear();
for(WebElement e:filterlist2){
	System.out.println(e.getText());
	Expectedlist.add(e.getText());
	
}


System.out.println(Actuallist);
System.out.println(Expectedlist);

if(Expectedlist.contains(Actuallist.get(0))||Expectedlist.contains(Actuallist.get(1)))
	Expected1="True";
else
	Expected1="false";
	
GSX_Filters.validatefilters(Expected1, "Track");	


}


public static void checkTypeFilters(){

	CommonUtil.waitForPageload();

CommonUtil.explicitlyWait(3);
CommonUtil.mouseOverOption(elementProperties.getProperty("cisco.gsx.mygsx.sessions"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.myGsx.sessions.dropdown.fullagenda"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(5);
CommonUtil.selectValueFromDropDownBox(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.dateselect"), "Tuesday, September 1");
CommonUtil.explicitlyWait(5);
CommonUtil.click(elementProperties.getProperty("cisco.gsx.MyGsx.Sessions.FullAgendapage.sessionone"));
CommonUtil.waitForPageload();
CommonUtil.explicitlyWait(3);

Actuallist.clear();

Actuallist.add("Breakout Session");
Actuallist.add("Super Session");


List<WebElement> filterlist3=CommonUtil.findElements(elementProperties.getProperty("cisco.gsx.mygsx.fullagenda.filters.sesioncategory"));

System.out.println(filterlist3.size());
Expectedlist.clear();
for(WebElement e:filterlist3){
	System.out.println(e.getText());
	Expectedlist.add(e.getText());
	
}


System.out.println(Actuallist);
System.out.println(Expectedlist);

if(Expectedlist.contains(Actuallist.get(0))||Expectedlist.contains(Actuallist.get(1)))
	Expected1="True";
else
	Expected1="false";
	
GSX_Filters.validatefilters(Expected1, "Type");	


}


public static void validatefilters (String Expected, String Actual) {
	CommonUtil.waitForPageload();
	actualMsg = "True";
	expectedMsg = Expected;
	filter=Actual;
	if (expectedMsg.equalsIgnoreCase(expectedMsg)) {
		actualMsg =  "Session Are Listed According to Selected "+ filter+ " Filter";
		expectedMsg =   "Session Are Listed According to Selected "+ filter+ " Filter";
		status = "PASS";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	} else {
		actualMsg = "Session Are Not Listed According to Selected "+ filter+ " Filter";
		expectedMsg ="Session Are  Listed According to Selected "+ filter+ " Filter";
		status = "FAIL";
		CommonUtil.logMessage(expectedMsg, actualMsg, status);
	}
	System.out.println(actualMsg);
	System.out.println(expectedMsg);
	CommonUtil.waitForPageload();	
}











}

