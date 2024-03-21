package utilTest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcelFile {

	public static void main(String[] args) {
		try {
			// Replace "path/to/your/file.xlsx" with your actual file path
			FileInputStream inputStream = new FileInputStream("testCase.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			// Get the first sheet (you can get sheets by name as well)
			XSSFSheet sheet = workbook.getSheetAt(4);

			// Iterate through rows and cells
			for (Row row : sheet) {
				for (Cell cell : row) {
					// Handle different cell types (numeric, string, etc.)
					switch (cell.getCellType()) {
					case STRING:
						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;
					// Handle other cell types as needed
					default:
						break;
					}
				}
			}

			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Collection testCase(int sheetIndex, int testDataIndex, String... args) {
		try {
			// Replace "path/to/your/file.xlsx" with your actual file path
			FileInputStream inputStream = new FileInputStream("testCase.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			// Get the first sheet (you can get sheets by name as well)
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			ArrayList<String[]> dataList = new ArrayList<>();
			// Iterate through rows and cells
			for (Row row : sheet) {
				if ((row.getCell(0).getStringCellValue()).startsWith("F-")) {
					String data = row.getCell(testDataIndex).getStringCellValue();
					for (int i = 0; i < args.length; i++) {

					}

					String params[] = data.split("\n");
					StringBuilder sb = null;
					for (int i = 0; i < params.length; i++) {
						String paramVal = params[i].indexOf("\n") == -1
								? params[i].substring(params[i].indexOf(":") + 1)
								: params[i].substring(params[i].indexOf(":") + 1, params[i].indexOf("\n"));
						if (params[i].contains(args[0])) {
							sb = new StringBuilder();
							sb.append(paramVal + ">>>newline");
						} else {
							sb.append(paramVal + ">>>newline");
						}
						if (params[i].contains(args[args.length - 1])) {
							String[] vals = sb.substring(0, sb.length() - 10).split(">>>newline");
						}
					}

				}
				for (Cell cell : row) {
					// Handle different cell types (numeric, string, etc.)
					switch (cell.getCellType()) {
					case STRING:
						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;
					// Handle other cell types as needed
					default:
						break;
					}
				}
			}

			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
