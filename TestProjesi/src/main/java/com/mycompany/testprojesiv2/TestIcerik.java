/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprojesiv2;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebElement;

public class TestIcerik {
    
    private static WebDriver driver=null;
    //public static void main(String[] args) {
    
        @Before
        public void Setup()throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        }
        
        @Test
        public void Test()throws Exception {
        driver.get("https://www.n11.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.n11.com/"); //Anasayfa Test
        
        
        driver.get("https://www.n11.com/giris-yap");
        driver.findElement(By.id("email")).sendKeys("fuat@gmail.com");     
        driver.findElement(By.name("password")).sendKeys("2132645596"); 
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();        
        System.out.println(driver.findElement(By.className("errorText")).getText());//Giriş Yap Test
                
        driver.findElement(By.id("searchData")).sendKeys("bilgisayar");        
        driver.findElement(By.className("searchBtn")).click();
       
        driver.get("https://www.n11.com/arama?q=bilgisayar&pg=2/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.n11.com/arama?q=bilgisayar&pg=2/"); //2.Sayfa Test
        
        driver.findElement(By.className("proSubTitle")).click();//rastgele ürüne tıkla
        driver.findElement(By.className("btnAddBasket")).click();//sepete ekle
       
        driver.get("https://www.n11.com/sepetim/");
        driver.findElement(By.className("spinnerArrow")).click();//Sepetteki ürünü 1 arttır
       
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
 
        driver.findElement(By.className("svgIcon_trash")).click();//Sepeti Sil
        Assert.assertEquals(driver.findElement(By.className("title")).getText(),"Sepetiniz Boş");//Boş sepet kontorlü
        
        
        
        }
        
        @After
        public void TearDown()throws Exception{
            
        driver.quit();
        
        }
        
    //}
}
