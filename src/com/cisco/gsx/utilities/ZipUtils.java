package com.cisco.gsx.utilities;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import au.com.bytecode.opencsv.CSVReader;

public class ZipUtils {

	public static void deleteZipEntry(File zipFile, String[] files)
			throws IOException {
		// get a temp file
		File tempFile = File.createTempFile(zipFile.getName(), null);
		// delete it, otherwise you cannot rename your existing zip to it.
		tempFile.delete();
		tempFile.deleteOnExit();
		boolean renameOk = zipFile.renameTo(tempFile);
		if (!renameOk) {
			throw new RuntimeException("could not rename the file "
					+ zipFile.getAbsolutePath() + " to "
					+ tempFile.getAbsolutePath());
		}
		byte[] buf = new byte[1024];

		ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
		ZipOutputStream zout = new ZipOutputStream(
				new FileOutputStream(zipFile));

		ZipEntry entry = zin.getNextEntry();
		while (entry != null) {
			String name = entry.getName();
			boolean toBeDeleted = false;
			for (String f : files) {
				if (f.equals(name)) {
					toBeDeleted = true;
					break;
				}
			}
			if (!toBeDeleted) {
				// Add ZIP entry to output stream.
				zout.putNextEntry(new ZipEntry(name));
				// Transfer bytes from the ZIP file to the output file
				int len;
				while ((len = zin.read(buf)) > 0) {
					zout.write(buf, 0, len);
				}
			}
			entry = zin.getNextEntry();
		}
		// Close the streams
		zin.close();
		// Compress the files
		// Complete the ZIP file
		zout.close();
		tempFile.delete();
	}

	public static String ZipFileExtraction(String fName) throws Exception {
		String entryName = null;
		byte[] buf = new byte[1024];
		ZipInputStream zinstream = new ZipInputStream(new FileInputStream(fName
				+ ".zip"));
		ZipEntry zentry = zinstream.getNextEntry();

		while (zentry != null) {
			entryName = zentry.getName();
			System.out.println("Name of  Zip Entry: " + entryName);
			FileOutputStream outstream = new FileOutputStream(entryName);
			int n;
			while ((n = zinstream.read(buf, 0, 1024)) > -1) {
				outstream.write(buf, 0, n);
			}
			System.out.println("Successfully Extracted File Name : "
					+ entryName);
			outstream.close();
			zinstream.closeEntry();
			zentry = zinstream.getNextEntry();
		}
		zinstream.close();
		return entryName;
	}

	// Added by suresh
	public static String ZipFilesExtraction(String zipFileName) {
		String entryName = null;
		try {

			byte[] buf = new byte[1024];
			ZipInputStream zinstream = new ZipInputStream(new FileInputStream(
					zipFileName));
			ZipEntry zentry = zinstream.getNextEntry();

			while (zentry != null) {
				entryName = zentry.getName();
				FileOutputStream outstream = new FileOutputStream(entryName);
				int n;
				while ((n = zinstream.read(buf, 0, 1024)) > -1) {
					outstream.write(buf, 0, n);
				}
				outstream.close();
				zinstream.closeEntry();
				zentry = zinstream.getNextEntry();
			}
			if (entryName.endsWith(".CSV")) {

				entryName = ConvertManager.CSVToXLS(entryName);
			}

			zinstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryName;
	}

	// added By Suresh
	public static String convertCSVToXLS(String fileName) {

		String destFilePath = null;
		try {
			Workbook wb = new HSSFWorkbook();
			CreationHelper helper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("new sheet");

			CSVReader reader = new CSVReader(new FileReader(fileName + ".CSV"));
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
			destFilePath = System.getProperty("user.dir") + File.separator
					+ fileName + ".XLS";
			FileOutputStream fileOut = new FileOutputStream(destFilePath);

			wb.write(fileOut);
			System.out.println("Done");
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return destFilePath;

	}

	@SuppressWarnings("rawtypes")
	public static String CsvToXls(String fName) throws IOException {
		ArrayList arList = null;
		ArrayList al = null;

		String excelFileName = fName.substring(
				fName.lastIndexOf(File.separator) + 1, fName.lastIndexOf("."));
		String thisLine;
		int count = 0;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i = 0;
		arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null) {
			al = new ArrayList();
			String strar[] = thisLine.split(",");
			for (int j = 0; j < strar.length; j++) {
				al.add(strar[j]);
			}
			arList.add(al);
			i++;
		}

		try {
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet("new sheet");
			for (int k = 0; k < arList.size(); k++) {
				ArrayList ardata = (ArrayList) arList.get(k);
				// System.out.println("ardata " + ardata.size());
				HSSFRow row = sheet.createRow((short) 0 + k);
				for (int p = 0; p < ardata.size(); p++) {

					String cellValue = ardata.get(p).toString();

					if (cellValue.contains("\"")) {

						System.out.println("inside if");
						cellValue = cellValue.substring(
								cellValue.indexOf("\"") + 1,
								cellValue.lastIndexOf("\""));
					}
					System.out.print("cellValue....." + cellValue);

					HSSFCell cell = row.createCell(p);
					cell.setCellValue(cellValue);
				}
			}
			FileOutputStream fileOut = new FileOutputStream(
					System.getProperty("user.dir") + "\\" + excelFileName
							+ ".xls");
			hwb.write(fileOut);
			fileOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		} // main method ends
		return excelFileName;
	}

	public static String getXLSheetValues(String fName) throws IOException {
		String rowValues = "";
		String cellValue = "";
		ArrayList arList = null;
		ArrayList al = null;
		String excelFileName = fName.substring(
				fName.lastIndexOf(File.separator) + 1, fName.lastIndexOf("."));
		String thisLine;
		int count = 0;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i = 0;
		arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null) {
			al = new ArrayList();
			String strar[] = thisLine.split(",");
			for (int j = 0; j < strar.length; j++) {
				al.add(strar[j]);
			}
			arList.add(al);
			i++;
		}

		try {
			for (int k = 0; k < arList.size(); k++) {
				ArrayList ardata = (ArrayList) arList.get(k);
				for (int p = 0; p < ardata.size(); p++) {
					cellValue = ardata.get(p).toString();
					rowValues = rowValues + ":" + cellValue;
				}
			}
		} catch (Exception ex) {
		} // main method ends
		return rowValues;
	}

	public static void main(String args[]) throws Exception {

		CsvToXls(System.getProperty("user.dir") + File.separator
				+ "VO_Audit_Report_09APR2013_091000_54638843_1_TS1CTS.xls");

	}

}
