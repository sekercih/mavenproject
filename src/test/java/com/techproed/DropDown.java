package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void dropdownTest() {
        //Dropdown icin Select class'i kullanilir.

        //Dropdown'u id ile locate edelim
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        //Select classinda obje olusturup, selectelementi pass edelim
        Select options = new Select(selectElement);
        ////Artik olusturulan objecti dropdown'a ulasmakmicin kullanabiliriz.
        //getFirstSelectedOption(); => dropdowndaki default value'yu verir
        String firstOption = options.getFirstSelectedOption().getText();
        System.out.println("FIRST SELECTED OPTION : "+firstOption);

        //Dropdown'da element belirlemenin 3 yolu vardir.
        //1. Index ile => selectByIndex();
        //2. Value ile => selectByValue("");
        //3. Visible Text ile => selectByVisibleText("");


        //1.Index kullanarak Seçenek 1’i (Option 1) seçin.
        //=======SELECT BY INDEX=======
        options.selectByIndex(1);


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin
        //===========SELECT BY VALUE=============
        options.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
        //=========SELECT BY VISIBLE TEXT===========
        options.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = options.getOptions();
        for(WebElement element : allOptions){
            System.out.println(element.getText());
        }

        //5. Dropdown’un boyutunu(size) bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int size = allOptions.size();
        if(size==4){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }

        //VEYA
        //assertion kullanarak
        //Assert.assertTrue(size==4);  //fail
        Assert.assertFalse(size==4);  //pass

        //VEYA

        System.out.println((allOptions.size()==4 ) ? "True" : "False");



    }
    @After
    public void tearDown(){
        driver.close();
    }
}