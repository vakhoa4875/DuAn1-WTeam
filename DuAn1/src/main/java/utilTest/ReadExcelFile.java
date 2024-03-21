package utilTest;

import java.io.FileInputStream;
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
}
