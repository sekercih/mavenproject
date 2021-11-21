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

public class BestBuy {
    //Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    //Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    // titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    //Her testten sonra tarayıcıyı kapatin
    //@Before ve @After metotlarini kullanarak yapalim.
    WebDriver driver;
    @Before
   public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

    }


    @Test
    public void tittleTest(){
      String actueltitle= driver.getTitle();
      String expect="Best";
      if (actueltitle.contains(expect)){
          System.out.println("Pass");
      }else {
          System.out.println("Fail");
      }



    }
    @Test
    public void logoTest(){
      WebElement logo=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/img"));
      if (logo.isDisplayed()){
          System.out.println("Pass");
      }else{
          System.out.println("Fail");
      }


    }
    @Test
    public void mexicoLinkTest(){
        WebElement mexicolink=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/a[3]/img"));
        if (mexicolink.isDisplayed()){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }
    @After
    public void tearDown(){
       driver.close();

    }
}
