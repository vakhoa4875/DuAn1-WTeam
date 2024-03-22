package utilTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDealer {

	public static void main(String[] args) {
//		Collection<Object[]> list = getTestCaseInfo("test-case.xlsx", 0, 3, 3, "username", "pass");
//
//		for (Object[] ss : list) {
//			for (Object s : ss) {
//				System.out.println(s.toString());
//			}
//		}

		System.out.println(getOutputResult("<[account not foun]d> but was"));

	}

	public static void writeStatus(String fileName, int sheetIndex, int rowIndex, int colIndex) throws IOException {

	}

	public static void writeActualResult(String fileName, int sheetIndex, int actualIndex, int rowIndex,
			String actualResult, boolean status) throws IOException {
		FileInputStream fis = new FileInputStream(new File(fileName));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(sheetIndex); // assuming you're interested in the first sheet

		// Let's say you want to write to the 5th row (index 4) and "Actual Result"
		// column is the 4th (index 3)
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}

		Cell cell = row.getCell(actualIndex);
		if (cell == null) {
			cell = row.createCell(actualIndex);
		}
		cell.setCellValue(actualResult);

		row.getCell(actualIndex + 1).setCellValue((status) ? "Passed" : "Failed");

		fis.close();

		FileOutputStream fos = new FileOutputStream(new File(fileName));
		workbook.write(fos);
		fos.close();
	}

	public static String getOutputResult(String res) {
		return String.join("", res.substring(res.indexOf("[") + 1, res.indexOf(">")).split("]"));
	}

	public static void writeTestDefect(String fileName, int sheetIndex, String tcID, String defect) throws IOException {
		FileInputStream fis = new FileInputStream(new File(fileName));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(sheetIndex);

		String[] arr = defect.split(":");
		String summary = arr[0];
		String expected = getOutputResult(arr[2]);
		String actual = getOutputResult(arr[3]);
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		for (int i = 1; i < 100; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				row = sheet.createRow(i);
			}

			Cell defectCell = row.getCell(2);
			if (defectCell == null) {
				defectCell = row.createCell(2);
			}

			if (defectCell.getStringCellValue().equals(defect)) {
				System.out.println("bruh");
				break;
			}
			System.out.println(defectCell.getStringCellValue() + "|defect:" + defect);

			Cell cell = row.getCell(0);
			if (cell == null) {
				cell = row.createCell(0);
			}
			if (!cell.getStringCellValue().isEmpty()) {
				continue;
			}
			cell.setCellValue(tcID);

			cell = row.getCell(1);
			if (cell == null) {
				cell = row.createCell(1);
			}
			cell.setCellValue(summary);

			cell = row.getCell(2);
			if (cell == null) {
				cell = row.createCell(2);
			}
			cell.setCellValue(defect);

			cell = row.getCell(5);
			if (cell == null) {
				cell = row.createCell(5);
			}
			cell.setCellValue("Pending");

			cell = row.getCell(6);
			if (cell == null) {
				cell = row.createCell(6);
			}
			cell.setCellValue(date);

			cell = row.getCell(11);
			if (cell == null) {
				cell = row.createCell(11);
			}
			cell.setCellValue(expected);

			cell = row.getCell(12);
			if (cell == null) {
				cell = row.createCell(12);
			}
			cell.setCellValue(actual);
			break;
		}

		fis.close();

		FileOutputStream fos = new FileOutputStream(new File(fileName));
		workbook.write(fos);
		fos.close();
	}

	public static Collection<Object[]> getTestCaseInfo(String file, int sheetIndex, int testDataIndex, int rowIndex,
			String... args) {
		try {
			FileInputStream inputStream = new FileInputStream(file);// create input stream with the file of
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);// get the sheet at sheetIndex
			Collection<Object[]> dataList = null;// init null to check if the rowIndex is true or not

			Row row = sheet.getRow(rowIndex);
			if ((row.getCell(0).getStringCellValue()).startsWith("F-")) {
				dataList = new ArrayList<>();
				String datas = row.getCell(testDataIndex).getStringCellValue();
				String expectedResults = row.getCell(testDataIndex + 1).getStringCellValue();

				String params[] = datas.split("\n");// containing params of method
				String eRes[] = expectedResults.split("\n");// containing expected Results
				StringBuilder sb = new StringBuilder();

				// declare relative variables
				String paramVal, ex;
				int count = 0;
				for (int i = 0; i < params.length; i++) {
					paramVal = params[i].indexOf("\n") == -1 ? params[i].substring(params[i].indexOf(":") + 1)
							: params[i].substring(params[i].indexOf(":") + 1, params[i].indexOf("\n"));
					if (params[i].contains(args[0])) {
						sb.append(paramVal + ">>>newline");
					} else {
						sb.append(paramVal + ">>>newline");
					}
					if (params[i].contains(args[args.length - 1])) {
						ex = (eRes[count++].split(":"))[1].trim();
						sb.append(ex);
						String[] vals = sb.toString().split(">>>newline");
						dataList.add(vals);
						sb = new StringBuilder();
					}
				}

//				for (String e : eRes) {
//					e.
//				}
			}

			workbook.close();
			inputStream.close();
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
