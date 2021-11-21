package com.techproed;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        //fake date oluşturmak
        WebElement searc=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));

        Faker faker=new Faker();
        searc.sendKeys(faker.book().author()+ Keys.ENTER);
        System.out.println(faker.avatar().image());

        WebElement resim=driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"));
        resim.click();
        driver.findElement(By.xpath("//*[@id=\"islrg\"]/div[1]/div[1]/a[1]/div[1]/img")).click();

        driver.findElement(By.xpath("//*[@id=\"Sva75c\"]/div/div/div[3]/div[2]/c-wiz/div[1]/div[1]/div/div[2]/a/img")).click();


    }  }