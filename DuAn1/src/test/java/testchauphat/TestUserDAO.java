/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testchauphat;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import dao.UserDAO;
import model.User;

import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 *
 * @author Admin
 */
@RunWith(Parameterized.class)
public class TestUserDAO {
	
	private String userID;
    private String userName;
    private String password;
    private String email;
    private Boolean reader, verificated;
    
    
    
//    public static Collection input() {
//    	
//    }
    
	public TestUserDAO(String userID, String userName, String password, String email, Boolean reader,
			Boolean verificated) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.reader = reader;
		this.verificated = verificated;
	}


	@Ignore
    @Test
    public void test1() {
        User user  = new User();
        user.setUserID("abc123");
        user.setUserName("NguoiDungMoi");
        user.setPassword("matkhau");
        user.setEmail("nguoidungmoi@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	@Ignore
    @Test
    public void test2() {
        User user  = new User();
        user.setUserID("");
        user.setUserName("");
        user.setPassword("matkhau");
        user.setEmail("nguoidungmo666i@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	@Ignore
    @Test
    public void test3() {
        User user  = new User();
        user.setUserID("abc121212");
        user.setUserName("NguoiDungMoi123");
        user.setPassword("");
        user.setEmail("nguoidungmoi1@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	@Ignore
    @Test
    public void test4() {
        User user  = new User();
        user.setUserID("abc121212");
        user.setUserName("NguoiDungMoi123");
        user.setPassword("");
        user.setEmail("nguoidungmoi1@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	@Ignore
    @Test
    public void test5() {
        User user  = new User();
        user.setUserID("abc1241213");
        user.setUserName("NguoiDungMoi123".repeat(256));
        user.setPassword("matkhau");
        user.setEmail("nguoidungmoi2@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	@Ignore
    @Test
    public void test6() {
        User user  = new User();
        user.setUserID("abc124");
        user.setUserName("NguoiDungMoi12121212".repeat(256));
        user.setPassword("matkhau".repeat(256));
        user.setEmail("nguoidun1212gmoi2@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
	
    @Test (expected = SQLServerException.class)
    public void test7() throws SQLServerException {
        User user  = new User();
        user.setUserID("abc124");
        user.setUserName("NguoiDungMoi12121212".repeat(256));
        user.setPassword("matkhau".repeat(256));
        user.setEmail("nguoidun1212gmoi2@gmail.com");
        user.setReader(Boolean.TRUE);
        user.setVerificated(Boolean.FALSE);
        new UserDAO().insert(user);
    }
    
}
