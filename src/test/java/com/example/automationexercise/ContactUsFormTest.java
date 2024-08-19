package com.example.automationexercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ContactUsFormTest extends BaseTest {

    @Test
    public void testContactUsForm() throws InterruptedException {
        // Step 1: Launch browser (Already handled in BaseTest)

        // Step 2: Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Step 3: Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/products']")).isDisplayed(), "Home page is not visible!");

        // Step 4: Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        // Step 5: Verify 'GET IN TOUCH' is visible
        WebElement getInTouchHeader = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(getInTouchHeader.isDisplayed(), "'GET IN TOUCH' is not visible!");

        // Step 6: Enter name, email, subject, and message
        driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys("johndoe@example.com");
        driver.findElement(By.name("subject")).sendKeys("Test Subject");
        driver.findElement(By.name("message")).sendKeys("This is a test message for the contact form.");

        // Step 7: Upload file
//        File file = new File("lib/feedback.txt");  // Replace with the actual file path
//        driver.findElement(By.name("upload_file")).sendKeys(file.getAbsolutePath());

        // Step 8: Click 'Submit' button
        driver.findElement(By.name("submit")).click();

        // Step 9: Click OK button on alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Step 10: Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not visible!");
        Assert.assertTrue(successMessage.getText().contains("Success! Your details have been submitted successfully."), "Success message text is incorrect!");

        // Step 11: Click 'Home' button and verify that landed on the home page successfully
        driver.findElement(By.xpath("//a[text()=' Home']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/products']")).isDisplayed(), "Home page is not visible after clicking 'Home' button!");
    }
}
