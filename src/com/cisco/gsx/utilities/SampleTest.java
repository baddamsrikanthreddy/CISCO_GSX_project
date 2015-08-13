package com.cisco.gsx.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SampleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * List list1 = new ArrayList();
		 * 
		 * list1.add("Quote #:"); list1.add("34356"); list1.add("Quote Name:");
		 * list1.add("sgsagsag"); list1.add("Quote Status:");
		 * list1.add("sfsdafas"); list1.add("Net Quote Amount:");
		 * list1.add("2523523"); list1.add("Total Fee %:"); list1.add("");
		 * System.out.println(list1);
		 * 
		 * System.out.println("**********"+list1.get(9)+"*************"); List
		 * list2 = new ArrayList();
		 * 
		 * list2.add("Quote #:"); list2.add("34356"); list2.add("Quote Name:");
		 * list2.add("sgsagsag"); list2.add("Quote Status:");
		 * list2.add("sfsdafas"); list2.add("Net Quote Amount:");
		 * list2.add("2523523"); list2.add("Total Fee %:"); list2.add("0");
		 * list2.add("Fee Amount:"); list2.add(""); list2.add("Fee Amount:");
		 * list2.add(""); list2.add("Fee Amount:"); list2.add("");
		 * list2.add("Fee Amount:"); list2.add("");
		 * 
		 * list2.add("Fee Amount:"); list2.add("");list2.add("Fee Amount:");
		 * list2.add("");
		 * 
		 * System.out.println(list2);
		 * 
		 * //boolean s = compareLists(list1, list2);
		 * 
		 * boolean s = compare(list1, list2);
		 * 
		 * System.out.println(s);
		 */

		getMap1Details();

		verifyTheExcelHeaderDetails("Quote_Internal_4254473_without_Discounts.XLS");
	}

	public static Map<String, String> getMap1Details() {
		Map<String, String> map1 = new HashMap<String, String>();

		map1.put("Quote #:", "4254473");
		map1.put("Quote Name:", "");
		map1.put("Quote Status:", "VALID");
		map1.put("Net Quote Amount:", "70");
		map1.put("Total Fee %:", "0");
		map1.put("Fee Amount:", "0");
		map1.put("Quote Net Total and Fee Amount:", "70");
		map1.put("Bill to ID:", "82555");
		map1.put("Customer Number:", "13486");
		map1.put("Channel:", "1T");
		map1.put("Intended Use:", "Resale");
		map1.put("Currency:", "USD");
		map1.put("Deal ID:", "");
		map1.put("Non-Standard:", "N");
		map1.put("Display Partner Discount:", "N");
		map1.put("Taxability Value:", "Internal Use");

		return map1;
	}

	public static boolean compare(List<String> list1, List<String> list2) {
		System.out.println("list1 " + list1.size());
		System.out.println("list2 " + list2.size());
		boolean flag = false;

		for (int i = 0; i < list1.size(); i++) {

			for (int j = i; j < list1.size(); j++) {

				if (list1.get(i).equalsIgnoreCase(list2.get(j))) {
					System.out.println("Both R Found  " + "position :" + i
							+ "  " + list1.get(i) + "*********" + list2.get(j));
					flag = true;
					break;
				} else {
					System.out.println("Both R Found  " + "position :" + i
							+ "  " + list1.get(i) + "*********" + list2.get(j));
					return flag = false;
				}

			}
		}

		if (flag) {
			return flag;
		} else {
			return flag;
		}
	}

	public static int getEmptyRowNumber(HSSFSheet sheet) {

		int emptyRowNumber = 0;
		for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {

			HSSFRow myRow = sheet.getRow(j);
			if (myRow.getLastCellNum() >= 3) {
				// System.out.println("row : " + myRow.getRowNum());
				return myRow.getRowNum();
			}

		}
		return -1;
	}

	public static boolean verifyTheExcelHeaderDetails(String fileName) {

		FileInputStream fis = null;

		boolean isPassed = false;
		try {

			System.out.println("xls FileName for read - " + fileName);
			String fileNamePath = null;
			if (fileName.endsWith(".XLS")) {

				fileNamePath = System.getProperty("user.dir") + File.separator
						+ fileName;
			} else {

				fileNamePath = System.getProperty("user.dir") + File.separator
						+ fileName + ".XLS";
			}

			fis = new FileInputStream(fileNamePath);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);

			int lastRow = getEmptyRowNumber(sheet);
			Map map1 = getMap1Details();
			Map map2 = getHederDetailsFromExcel(sheet, lastRow);

			doComparisionAndPrint(map1, map2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPassed;

	}

	private static boolean doComparisionAndPrint(Map mapA, Map mapB) {

		boolean flag = false;
		System.out
				.println("************ Start ********************************");
		System.out.println("MapA Size : " + mapA.size());
		System.out.println("MapB Size : " + mapB.size());
		System.out.println("MapA : " + mapA);
		System.out.println("MapB : " + mapB);

		if (mapA != null && mapB != null) {
			Iterator mapAIterator = mapA.keySet().iterator();
			while (mapAIterator.hasNext()) {
				String key = mapAIterator.next().toString().trim();
				if (mapB.containsKey(key)) {
					String key1 = mapA.get(key).toString().trim();
					String key2 = mapB.get(key).toString().trim();
					System.out
							.println("***************************************");
					System.out.println("Key : " + key);
					System.out.println("UI VALUE : " + key1);
					System.out.println("EXCEL VALUE : " + key1);
					if (key1.equalsIgnoreCase(key2)) {
						flag = true;
					} else {
						flag = false;
						System.out.println("Values are not matched");
						System.out.println("flag : " + flag);
						System.out
								.println("***************************************");
						return flag;
					}

				}
			}
		}
		System.out.println("flag : " + flag);
		System.out.println("***************************************");
		return flag;
	}

	public static String getNumberFromDecimalNumber(String decimalString) {
		if (decimalString.contains(".")) {
			int dotIndex = decimalString.indexOf(".");

			return decimalString.substring(0, dotIndex);
		} else {

			return decimalString;
		}
	}

	public static Map<String, String> getHederDetailsFromExcel(HSSFSheet sheet,
			int lastRow) {

		Map<String, String> map2 = new HashMap<String, String>();
		for (int j = 0; j < lastRow - 1; j++) {
			HSSFRow myRow = sheet.getRow(j);
			String cellvalue = null;
			cellvalue = getNumberFromDecimalNumber(myRow.getCell(1).toString())
					.trim();
			map2.put(myRow.getCell(0).toString().trim(), cellvalue);
		}
		// System.out.println("Excel header Cloumns and values:" + map2.size());
		// printMap(map2);
		return map2;
	}

	public static void printMap(Map map) {

		Iterator iter = map.keySet().iterator();

		while (iter.hasNext()) {
			String key = (String) iter.next();
			System.out.println(key + " : " + map.get(key));
		}

	}

	public static boolean compareLists(List<String> list1, List<String> list2) {

		System.out.println("***** list1 ******** " + list1);

		System.out.println("***** list2 ******** " + list2);

		for (int i = 0; i < list1.size(); i++) {
			String tempStr = list1.get(i);

			if (!searchValue(tempStr, list2))
				return false;
		}

		return true;

	}

	public static boolean searchValue(String actualVal, List<String> list2) {

		for (String b : list2) {

			if (actualVal.equalsIgnoreCase(b)) {
				System.out.println("Both R Found  " + actualVal + "*********"
						+ b);
				return true;
			}
		}

		return false;
	}

}
