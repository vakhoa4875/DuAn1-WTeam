package ui;

import UX_UI.JDialogLogin;
import java.util.ArrayList;
import java.util.List;
import library.Extension;
import model.Sach;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestGetData {

    @BeforeTest
    public void start() {
        System.out.println("start..\n--------------------------------------\n\n");
    }

    @AfterTest
    public void end() {
        System.out.println("\n\n--------------------------------------\ntear down..");
    }

//    @Test(priority = 1)
//    public void loginTest() {
//        System.out.println("hello world");
//    }
//
//    @Test(priority = 2)
//    public void signInTest() {
//        System.out.println("hello ya");
//    }
    
    @DataProvider(name = "BookData")
    public Object[][] getBookData() {
        return new Object[][] {
                { "dune", 1, false, true},
                { "Headfirst Java", 1, false, true},
                { "Witch", 1, false, false},
                { "Rune", 1, false, true},
                { "sense", 1, false, false},
                { "humour", 1, false, false}  
        };
    }

    @Test (dataProvider = "BookData")
    public void testGetListSach(String tenSach, int lim, boolean insertable, boolean truncated) {
        
        ArrayList<Sach> listSach = Extension.getListSachfromOpenLibrary(tenSach, lim, insertable, truncated);
        
//        for (Sach s : listSach) {
//            System.out.println(s.toString());
//        }

        // Assert
        Assert.assertFalse(listSach == null, "Get book failed");
        Assert.assertTrue(listSach != null, "Get book from Open Library should be successful");
    }
    
    @DataProvider(name = "LoginData1")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"noiBo", "123"},
            {"nvqlsach", "abc"},
            {"chauphat2111", "123"},
            {"khoa123", "123"},
            {"reader", "123"}
        };
    }
    
    @Test (dataProvider = "LoginData1")
    public void testLogin(String username, String password) {
        
        int check = Extension.checkUser(username, password);        
        
        // Assert
        Assert.assertFalse(check != 1, "Get book failed");
        Assert.assertTrue(check == 1, "Get book from Open Library should be successful");
        
    }
    
    @DataProvider(name = "LoginData0")
    public Object[][] getLoginData0() {
        return new Object[][] {
            {"noiBo", "abc"},
            {"nvqlsach", "123"},
            {"chauphat2111", "abc"},
            {"khoa123", "abc"},
            {"reader", "abc"}
        };
    }
    
    @Test  (dataProvider = "LoginData0")
    public void testLogin0(String username, String password) {
        
        int check = Extension.checkUser(username, password);        
        
        // Assert
        Assert.assertFalse(check != 0, "Get book failed");
        Assert.assertTrue(check == 0, "Get book from Open Library should be successful");
        
    }
    
    @DataProvider(name = "LoginDataMinus1")
    public Object[][] getLoginDataMinus1() {
        return new Object[][] {
            {"noiBox", "abc"},
            {"xnvqlsach", "123"},
            {"xchauphat2111", "abc"},
            {"xkhoa123", "abc"},
            {"xreader", "abc"}
        };
    }
    
    @Test  (dataProvider = "LoginDataMinus1")
    public void testLoginMinus1(String username, String password) {
        
        int check = Extension.checkUser(username, password);        
        
        // Assert
        Assert.assertFalse(check != -1, "Get book failed");
        Assert.assertTrue(check == -1, "Get book from Open Library should be successful");
        
    }
}
