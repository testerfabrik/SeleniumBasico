package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ejemplo2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        String baseUrl = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver, 10);


        try {
            driver.switchTo().frame("iframeResult");

            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(2000);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alrtWindow = driver.switchTo().alert();
            String alertText = alrtWindow.getText();
            System.out.println(alertText);
            alrtWindow.sendKeys("Gilberto S");
            alrtWindow.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Gilberto")?finalText:"Prueba Fallida!");

        } catch (NoSuchElementException ne) {
            System.err.println("No se encontró el WebElement: " + ne.getMessage());
        }catch(NoSuchFrameException nf){
            System.err.println("No se encontró elframe: " + nf.getMessage());
        }catch(NoAlertPresentException na){
            System.err.println("No se encontró la alerta: " + na.getMessage());
        }catch(TimeoutException te){
            System.err.println("Tiempo de espera excedido: " + te.getMessage());
        }catch (WebDriverException we) {
            System.err.println("WebDriver Falló: " + we.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.quit();
        }
    }
}
