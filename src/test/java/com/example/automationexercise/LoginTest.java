package com.example.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        // Navigate to the Login page
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        // Fill in the login form
        driver.findElement(By.name("email")).sendKeys("sidsur839034@example.com");
        driver.findElement(By.name("password")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        // Verify login by checking for a logged-in element
        WebElement loggedInUser = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        Assert.assertTrue(loggedInUser.isDisplayed(), "User is not logged in!");
    }
}
