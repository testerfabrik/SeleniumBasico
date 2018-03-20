package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
        //Instanciar un objeto WebDriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //Indicar la localización del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        //System.getProperty("user.dir") = C:\..\..\..\SeleniumBasico
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();

        //Navegar a la página
        driver.get(baseURL);

        //Obtener el título de la página
        actualResult = driver.getTitle();

        //Imprimir el resultado usando el operador ternario
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada! " + actualResult : "Prueba Fallada!");

        driver.close();
    }
}
