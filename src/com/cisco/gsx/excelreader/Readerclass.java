package com.cisco.gsx.excelreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Readerclass {

	public static List GetData(String testname) {
		FileInputStream fileIn;
		Properties prop = new Properties();
		List<List> sheetData = null;
		POIFSFileSystem fs;
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")
					+ System.getProperty("file.separator") + "ExcelTestData"
					+ System.getProperty("file.separator")
					+ "Resource.properties"));

			// test file is located in your project path
			String path = System.getProperty("user.dir")
					+ System.getProperty("file.separator") + "ExcelTestData"
					+ System.getProperty("file.separator")
					+ "CiscoTestData.xls";

			fileIn = new FileInputStream(path);

			// read file

			fs = new POIFSFileSystem(fileIn);

			HSSFWorkbook filename = new HSSFWorkbook(fs);
			// open sheet 0 which is first sheet of your worksheet
			HSSFSheet sheet = filename.getSheetAt(0);

			// we will search for column index containing string
			// "Your Column Name" in the row 0 (which is first row of a
			// worksheet
			String columnWanted = prop.getProperty("column");

			Integer statusColumnNo = null;

			// output all not null values to the list
			sheetData = new ArrayList<List>();

			Row firstRow = sheet.getRow(0);

			for (Cell cell : firstRow) {
				if (cell.getStringCellValue().equals(columnWanted)) {
					statusColumnNo = cell.getColumnIndex();
				}
			}

			if (statusColumnNo != null) {

				for (Row row : sheet) {
					Cell statuscolumnData = row.getCell(statusColumnNo);

					if (statuscolumnData == null
							|| statuscolumnData.getCellType() == Cell.CELL_TYPE_BLANK) {
						// Nothing in the cell in this row, skip it
					} else {
						if (statuscolumnData.getStringCellValue()
								.equalsIgnoreCase(
										prop.getProperty("statusvalue"))) {
							// Nothing in the cell in this row, skip it
						} else {

							Row r = statuscolumnData.getRow();
							Iterator rowCell = r.cellIterator();
							List data = new ArrayList();
							while (rowCell.hasNext()) {
								HSSFCell hssCell = (HSSFCell) rowCell.next();
								
								//Converts int to string during excel reading
								hssCell.setCellType(Cell.CELL_TYPE_STRING);
								// System.out.println(
								// hssCell.getStringCellValue());
								data.add(hssCell);
							}
							for (Object s : data) {
								if (s.toString().contains(testname)) {
									sheetData.add(data);
								}

							}
						}
					}
					// System.out.println(columnNo);
				}
			}

			else {
				System.out.println("could not find column " + columnWanted
						+ " in first row of " + fileIn.toString());
			}
			for (int i = 0; i < sheetData.size(); i++) {
				List list = (List) sheetData.get(i);
				for (int j = 0; j < list.size(); j++) {
					HSSFCell employeeid = (HSSFCell) list.get(j);
					System.out.println("--------------------------------");
					System.out.print(employeeid.getRichStringCellValue()
							.getString());
					if (j < list.size() - 1) {
						// System.out.print("           ");
					}
				}
				System.out.println("  ");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Your Enter file is not Existed in Directory");
		}
		return sheetData;
	}

	/*
	 * public static Object ArrayForm() throws IOException {
	 * 
	 * List listdata=Readerclass.GetData("test Case 3"); int
	 * columnsize=listdata.size(); List rowlist=(List) listdata.get(1); int
	 * rowsize=rowlist.size();
	 * 
	 * Object[][] retObjArr=new Object
	 * 
	 * [columnsize][rowsize];
	 * 
	 * for (int i = 0; i <columnsize; i++) { List list = (List) listdata.get(i);
	 * for (int j = 0; j < rowsize; j++) { HSSFCell employeeid = (HSSFCell)
	 * list.get(j);
	 * retObjArr[i][j]=employeeid.getRichStringCellValue().getString();
	 * /*System.out.print(employeeid.getRichStringCellValue().getString()); if
	 * (j < list.size() - 1) { System.out.print("           "); }
	 * 
	 * } // System.out.println("  "); } /* for(int i=0;i<columnsize;i++){
	 * for(int j=0;j<rowsize;j++){ System.out.print(retObjArr[i][j]);
	 * System.out.print(" ");
	 * 
	 * } System.out.println();
	 * 
	 * }
	 */
	/*
	 * return retObjArr; } /*public static void main(String...arg) throws
	 * Exception { ArrayForm(); }
	 */
	/*
	 * public static void main(String... arg) throws Exception {
	 * GetData("test Case 3");
	 * 
	 * GetData("Test Case 4"); GetData("Test Case 2"); }
	 */
}
