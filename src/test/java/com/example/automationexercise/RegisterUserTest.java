package com.example.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    @Test
    public void testRegisterUser() throws InterruptedException {
        // Step 1: Launch browser (Already handled in BaseTest)

        // Step 2: Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Step 3: Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/products']")).isDisplayed(), "Home page is not visible!");

        // Step 4: Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        // Step 5: Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed(), "'New User Signup!' is not visible!");

        // Step 6: Enter name and email address
        driver.findElement(By.name("name")).sendKeys("Siddhesh Surve");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sidsur839034@example.com");

        // Step 7: Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // Step 8: Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).isDisplayed(), "'ENTER ACCOUNT INFORMATION' is not visible!");

        // Step 9: Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click(); // Select Title as Mr.
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("1990");

        // Step 10: Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // Step 11: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("company")).sendKeys("Test Company");
        driver.findElement(By.id("address1")).sendKeys("123 Test St.");
        driver.findElement(By.id("address2")).sendKeys("Apt 101");
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        // Step 12: Click 'Create Account' button
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // Step 13: Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).isDisplayed(), "'ACCOUNT CREATED!' is not visible!");

        // Step 14: Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }
}
