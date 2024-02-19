package ui;

import java.util.ArrayList;
import java.util.List;
import library.Extension;
import model.Sach;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest {

    @BeforeTest
    public void loginToApplication() {
        System.out.println("start..");
    }

    @AfterTest
    public void logoutApplication() {
        System.out.println("tear down..");
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

    @Test
    public void testPerformLogin() {

        // Act
        List<Sach> listSach = new ArrayList<>();
        Extension.getSachfromOpenLibrary("dune", listSach, 1, true);

        // Assert
        Assert.assertTrue(listSach.size() >= 1, "Login should be successful");
    }
}
