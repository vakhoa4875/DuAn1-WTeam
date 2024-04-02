package testchauphat;

import java.util.List;

import library.DocFileExcel;
import model.User;



public class mainClass {
 public static void main(String[] args) {
     List<User> usersFromExcel = new DocFileExcel().docTuExcel("A:/temp/TestCase.xlsx");
     for (User user : usersFromExcel) {
         System.out.println(user);
     }
}
}
