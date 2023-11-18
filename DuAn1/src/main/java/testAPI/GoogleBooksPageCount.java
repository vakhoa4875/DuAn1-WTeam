/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleBooksPageCount {
    public static void main(String[] args) {
        // Set the path to the location of your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Replace "BOOK_URL" with the actual URL of the Google Books page
        String bookUrl = "http://books.google.com.vn/books?id=gikXAAAAYAAJ&printsec=frontcover&dq=java&hl=&as_brr=7&cd=1&source=gbs_api";

        // Navigate to the Google Books page
        driver.get(bookUrl);

        // Locate the element containing the page count (or any other information you need)
        WebElement pageCountElement = driver.findElement(By.cssSelector(".pageCount"));

        // Get the text content of the element
        String pageCount = pageCountElement.getText();

        // Output the page count
        System.out.println("Page Count: " + pageCount);

        // Close the browser
        driver.quit();
    }
}
