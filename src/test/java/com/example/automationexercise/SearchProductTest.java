package com.example.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        // Step 1: Launch browser (Already handled in BaseTest)

        // Step 2: Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Step 3: Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/products']")).isDisplayed(), "Home page is not visible!");

        // Step 4: Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        // Step 5: Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "User is not navigated to the ALL PRODUCTS page!");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed(), "ALL PRODUCTS page is not visible!");

        // Step 6: Enter product name in search input and click search button
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys("Dress");  // Replace with the desired product name
        driver.findElement(By.id("submit_search")).click();


    }
}
