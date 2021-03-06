package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions {
    static WebDriver driver;
    public static void main(String[] args){

        try{
            String baseUrl = "http://live.guru99.com/index.php/checkout/cart";
            String actualResult = "";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();

            //clic en el link TV
            WebElement lnkTV = driver.findElement(By.linkText("TV"));
            lnkTV.click();

            //clic en boton ADD TO CART
            WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"to\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddToCart.click();

            //obtener el precio
            WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
            actualResult = lblSubtotal.getText();

            if(actualResult.contentEquals(expectedResult)){
                System.out.println("Prueba Pasada! el resultado actual es: " + actualResult + " es igual a " + expectedResult);
            }else{
                System.out.println("Prueba Fallada! el resultado actual es: " + actualResult + " no es igual a " + expectedResult);
            }
        }catch(NoSuchElementException ne){
            System.err.println("No se encontró el WebElement: " + ne.getMessage());
        }catch(WebDriverException we){
            System.err.println("WebDriver Falló: " + we.getMessage());
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            driver.close();
        }
  }
}
