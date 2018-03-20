package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
    static WebDriver driver;

    public static void main(String[] args) {
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseURL = "http://newtours.demoaut.com/";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try {
            driver.findElement(By.linkText("REGISTER")).click();

            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Gil");
            Thread.sleep(1500);
            txtFirstName.clear();
            Thread.sleep(1500);
            txtFirstName.sendKeys("Gilberto");

            driver.findElement(By.name("address1")).sendKeys("Test Address");

            Select drpCountry = new Select(driver.findElement(By.name("country")));
            Thread.sleep(2000);
            drpCountry.selectByVisibleText("MEXICO");

            driver.findElement(By.id("email")).sendKeys("gilberto@mail.com");
            driver.findElement(By.name("password")).sendKeys("123");

            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("123");
            txtConfirmPass.submit();

            System.out.println("Prueba Exitosa! " + driver.findElement(By.xpath("//*[contains(text(),'Note:')]")).getText());

        } catch (NoSuchElementException ne) {
            System.err.println("No se encontró el WebElement: " + ne.getMessage());
        } catch (WebDriverException we) {
            System.err.println("WebDriver Falló: " + we.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.quit();
        }
    }
}
