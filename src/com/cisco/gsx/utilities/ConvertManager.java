package com.cisco.gsx.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import au.com.bytecode.opencsv.CSVReader;

public class ConvertManager {

	// added By Suresh
	public static String CSVToXLS(String csvFileName) {

		String destFilePath = null;
		String xlsFileName = null;
		try {
			Workbook wb = new HSSFWorkbook();
			CreationHelper helper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("new sheet");

			CSVReader reader = new CSVReader(new FileReader(csvFileName));
			String[] line;
			int r = 0;
			while ((line = reader.readNext()) != null) {
				Row row = sheet.createRow((short) r++);

				for (int i = 0; i < line.length; i++) {
					// System.out.println(line[i]);
					if (line[i].startsWith("=")) {

						line[i] = line[i].substring(2);
						// System.out.println(line[i]);

						row.createCell(i).setCellValue(
								helper.createRichTextString(line[i]));
					} else {
						row.createCell(i).setCellValue(
								helper.createRichTextString(line[i]));
					}
				}
			}

			// Write the output to a file

			int indexCount = csvFileName.indexOf(".CSV");
			csvFileName = csvFileName.substring(0, indexCount);
			System.out.println("csvFileName : - " + csvFileName);
			xlsFileName = csvFileName + ".XLS";
			destFilePath = System.getProperty("user.dir") + File.separator
					+ xlsFileName;
			FileOutputStream fileOut = new FileOutputStream(destFilePath);

			wb.write(fileOut);
			System.out.println("Done");
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return xlsFileName;

	}

}
