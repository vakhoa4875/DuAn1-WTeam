package library;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import model.User;

public class DocFileExcel {
	
	// Đọc danh sách người dùng từ Excel
    public static List<User> docTuExcel(String tenFile) {
        List<User> users = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(tenFile))) {
            Sheet sheet = workbook.getSheetAt(2);

            // Bỏ qua header row
            for (int i = 4; i <= 13; i++) {
                Row row = sheet.getRow(i);
                String userID = row.getCell(3).getStringCellValue();
                String userName = row.getCell(4).getStringCellValue();
                String password = row.getCell(5).getStringCellValue();
                String email = row.getCell(6).getStringCellValue();
                Boolean reader = row.getCell(7).getBooleanCellValue();
                Boolean verificated = row.getCell(8).getBooleanCellValue();
                
                users.add(new User(userID, userName, password, email, reader, verificated));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
