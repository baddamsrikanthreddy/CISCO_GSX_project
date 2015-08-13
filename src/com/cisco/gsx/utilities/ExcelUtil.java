package com.cisco.gsx.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	public static void updateExcelData(Map<String, List<String>> insertMap,
			String fileName) {

		Map<String, Integer> colMap = new HashMap<String, Integer>();
		InputStream myxls;
		String value = null;
		List<String> colValues = null;
		try {
			myxls = new FileInputStream(System.getProperty("user.dir")
					+ File.separator + fileName);

			HSSFWorkbook wb = new HSSFWorkbook(myxls);
			HSSFSheet sheet = wb.getSheetAt(0);

			int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int i = 0; i < noOfColumns; i++) {
				sheet.createRow(i + 1);
				value = sheet.getRow(0).getCell(i).getRichStringCellValue()
						.toString();
				// System.out.println(" Value : i" + i + "-" + value);
				colMap.put(value, i);
				// colMap.put(value, i);

			}
			for (String s : insertMap.keySet()) {
				colValues = insertMap.get(s);
				System.out.println(colValues.size());
				for (int i = 0; i < colValues.size(); i++) {
					// System.out.println(" i :" + i);
					HSSFRow row = sheet.getRow(i + 1);

					HSSFCell cell = row.getCell(colMap.get(s));

					if (null != colValues.get(i)) {
						System.out.println("Col Value" + colValues.get(i));
						cell = row.createCell(colMap.get(s));
						cell.setCellValue(colValues.get(i));
					}

				}
			}
			FileOutputStream fileOut = new FileOutputStream(
					System.getProperty("user.dir") + File.separator + fileName);
			wb.write(fileOut);
			fileOut.close();
			myxls.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean verifyExcelColumnHeader(String colName,
			String fileName) {

		InputStream myxls;
		boolean flag = false;
		try {
			myxls = new FileInputStream(System.getProperty("user.dir")
					+ File.separator + fileName);

			HSSFWorkbook wb = new HSSFWorkbook(myxls);
			HSSFSheet sheet = wb.getSheetAt(0);
			int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int i = 0; i < noOfColumns; i++) {
				String value = sheet.getRow(0).getCell(i)
						.getRichStringCellValue().toString();
				System.out.println(" Value : i" + i + "-" + value);
				if (colName.equalsIgnoreCase(value))
					flag = true;

			}

			myxls.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static String verifyExcelColumnHeader(String[] colNames,
			String fileName) {

		InputStream myxls;
		String result = "";
		try {
			myxls = new FileInputStream(System.getProperty("user.dir")
					+ File.separator + fileName);

			HSSFWorkbook wb = new HSSFWorkbook(myxls);
			HSSFSheet sheet = wb.getSheetAt(0);

			int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			List<String> lValue = new ArrayList<String>();
			for (int i = 0; i < noOfColumns; i++) {
				String value = sheet.getRow(0).getCell(i)
						.getRichStringCellValue().toString();
				lValue.add(value);
			}

			for (int j = 0; j < colNames.length; j++) {
				// System.out.println(" Value : j" + j + "-" + colNames[j]);
				if (!lValue.contains(colNames[j]))
					result = result + colNames[j] + "; ";

			}

			myxls.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// added by suresh
	public static boolean verifyTheExcelHeaderDetails(String fileName)
			throws IOException {

		boolean flag = false;
		int columnValue = 0;
		boolean isDpdValue = false;
		boolean isDpdColoumn = false;
		boolean isDPD = false;
		FileInputStream fis = null;

		try {
			System.out.println("xlsFileName - " + fileName);
			fis = new FileInputStream(System.getProperty("user.dir")
					+ File.separator + fileName + ".XLS");
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);

			for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {

				HSSFRow myRow = sheet.getRow(j);

				// System.out.println(myRow.getPhysicalNumberOfCells());
				ArrayList<String> cellStoreArrayList = new ArrayList<String>();
				String cellvalue = null;
				for (int i = 0; i < myRow.getPhysicalNumberOfCells(); i++) {

					HSSFCell myCell = myRow.getCell(i);

					if (myCell != null) {

						if (myCell.getCellType() == myCell.CELL_TYPE_STRING) {

							cellvalue = myCell.getStringCellValue();

							cellStoreArrayList.add(cellvalue);
						} else {
							double cellvalue1 = myCell.getNumericCellValue();
							cellvalue = Double.toString(cellvalue1);

							cellStoreArrayList.add(cellvalue);
						}
					}

				}

				if (cellStoreArrayList.size() == 2) {

					if (cellStoreArrayList.get(0).toString().trim()
							.equals("Display Partner Discount:")) {
						/*
						 * System.out.println("************" +
						 * cellStoreArrayList.get(0).toString().trim() + ":" +
						 * cellStoreArrayList.get(1).toString().trim());
						 */

						if (cellStoreArrayList.get(1).toString().trim()
								.equals("Y")) {
							isDpdValue = true;
						}

					}
				} else {

					if (flag) {
						if (cellStoreArrayList.get(columnValue).isEmpty()) {
							break;
						} else {
							// Get Value of cell
							// System.out.println(cellStoreArrayList.get(columnValue).toString().trim());
						}
					} else {
						for (int z = 0; z < cellStoreArrayList.size() - 1; z++) {

							// System.out.println(cellStoreArrayList.get(z).toString().trim());
							if (cellStoreArrayList.get(z).toString().trim()
									.equals("EFFECTIVE TOTAL DISC%")) {
								/*
								 * System.out.println(
								 * "**********************************************************************************"
								 * );
								 */
								columnValue = z;
								isDpdColoumn = true;
								flag = true;
								break;
							}
						}
					}
				}
			}

			if (isDpdValue && isDpdColoumn) {
				isDPD = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDPD;

	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(verifyExcelColumnHeader("INSTANCE NUMBER",
	 * "UploadExcel.xls"));
	 * 
	 * String a[] = { "INSTANCE NUMBER", "abc" };
	 * System.out.println(verifyExcelColumnHeader(a, "UploadExcel.xls")); }
	 */
}
