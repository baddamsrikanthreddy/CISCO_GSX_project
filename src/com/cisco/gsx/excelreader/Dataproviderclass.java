package com.cisco.gsx.excelreader;

import java.lang.reflect.Method;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.testng.annotations.DataProvider;

import com.cisco.gsx.excelreader.Readerclass;

public class Dataproviderclass {

	static String Entertestname = null;
	static int columnsize;

	@DataProvider(name = "data-provider")
	public static Object[][] dataProviderMethod(Method m) throws IOException {

		DataPojoClass pojo1 = null;
		List<Object> adddata = new LinkedList();
		List listdata = Readerclass.GetData(m.getName());

		columnsize = listdata.size();
		System.out.println(columnsize);
		if (columnsize == 0) {
			System.out.println("this is methosd name======" + m.getName()
					+ "=========NOT FOUND");
		}
		// List rowlist=(List) listdata.get(1);
		// int rowsize=rowlist.size();

		/*--------------------------------------------------------------------------
		 * Have to change the index value based on the excel sheets columns inserted
		 * -------------------------------------------------------------------------
		 */
		Object[][] retObjArr = new Object[columnsize][27];

		for (int i = 0; i < columnsize; i++) {
			List list = (List) listdata.get(i);
			pojo1 = new DataPojoClass();
			for (int j = 0; j < list.size(); j++) {
				// System.out.println("Displayed from Data Provider class");
				HSSFCell employeeid = (HSSFCell) list.get(j);
				if (j == 0) {
					pojo1.setSno(employeeid.getRichStringCellValue()
							.getString());
				} else if (j == 1) {
					pojo1.setTestname(employeeid.getRichStringCellValue()
							.getString());
				} else if (j == 2) {
					pojo1.setUserName(employeeid.getRichStringCellValue()
							.getString());
				} else if (j == 3) {
					pojo1.setPassword(employeeid.getRichStringCellValue()
							.getString());
				} else if (j == 4) {
					pojo1.setStatus(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 5) {
					pojo1.setFirstName(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 6) {
					pojo1.setCounty(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 7) {
					pojo1.setCity(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 8) {
					pojo1.setContactName(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 9) {
					pojo1.setPhoneNumber(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 10) {
					pojo1.setEmailAddress(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 11) {
					pojo1.setRole(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 12) {
					pojo1.setTshirtSize(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 13) {
					pojo1.setDietaryRequirements(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 14) {
					pojo1.setAdditionalOnsiteAssistance(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 15) {
					pojo1.setTravelingFrom(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 16) {
					pojo1.setRoomShareInfo(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 17) {
					pojo1.setHotelGender(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 18) {
					pojo1.setSmoking(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 19) {
					pojo1.setSearchOrSelectRoommate(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 20) {
					pojo1.setCheckin(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 21) {
					pojo1.setCheckout(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 22) {
					pojo1.setFilterBy(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 23) {
					pojo1.setState(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 24) {
					pojo1.setRegCode(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 25) {
					pojo1.setCountries(employeeid.getRichStringCellValue()
							.getString());
				}
				else if (j == 26) {
					pojo1.setTravelArrangements(employeeid.getRichStringCellValue()
							.getString());
				}
				// retObjArr[i][j]=employeeid.getRichStringCellValue().getString();
				/*
				 * System.out.print(employeeid.getRichStringCellValue().getString
				 * ()); if (j < list.size() - 1) {
				 * System.out.print("           "); }
				 */

			}
			// System.out.println("For loop in Data provider class  ");
			System.out.println("Data is adding to Linkedlist");
			adddata.add(pojo1);
		}
		/*
		 * for(int i=0;i<columnsize;i++){ for(int j=0;j<rowsize;j++){
		 * System.out.print(retObjArr[i][j]); System.out.print(" ");
		 * 
		 * } System.out.println();
		 * 
		 * }
		 */
		// System.out.println("Data provider method in Data provider class");
		return new Object[][] { { adddata } };

	}

}