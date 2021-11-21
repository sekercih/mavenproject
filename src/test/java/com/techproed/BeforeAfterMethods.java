package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterMethods {
    // Bir class oluşturun: BeforeAfterMethods
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    // imageTest => Google resminin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void titleTest(){


        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }

    @Test
    public void imageTest(){

        // Google image locate
        WebElement googleImage = driver.findElement(By.id("hplogo"));
        if(googleImage.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }

    @Test
    public void gmailLinkTest(){

        //Locate gmail link element
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        if(gmailLink.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


    }
    @After
    public void tearDown(){
        driver.close();
        //// Bir class oluşturun: Homework_BeforeAfterAirbnb
        //// Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
        //// titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
        //// logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
        //// helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
        //// Her testten sonra tarayıcıyı kapatin
    }
}
