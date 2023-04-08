package tests;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ExpiredDomains;
import pages.NameJet;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EndingNets {

    ExpiredDomains expiredDomains = new ExpiredDomains();
    NameJet nameJet = new NameJet();

    @Test
    public void endingNets() throws IOException, InterruptedException {
        for (int i = 1; i <= 1; i++) {


            Driver.getDriver().get(ConfigReader.getProperty("expiredUrl"));
            expiredDomains.loginButonu.click();
            expiredDomains.userNameTextBox.sendKeys(ConfigReader.getProperty("userName"));
            expiredDomains.userPassword.sendKeys(ConfigReader.getProperty("password"));
            expiredDomains.loginSubmitButonu.click();
            expiredDomains.pendingDeleteButonu.click();
            expiredDomains.filterButonu.click();

            expiredDomains.minDay.sendKeys("2");
            expiredDomains.maxDay.sendKeys("");
            expiredDomains.perPage.sendKeys("100");

            expiredDomains.wbyMin.sendKeys("2019");
            expiredDomains.wbyMax.sendKeys("2023");
            expiredDomains.additionalButton.click();
            expiredDomains.netIconu.click();

            expiredDomains.applyFilterButonu.click();
            expiredDomains.regIconu.click();


            String str = Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[1]/a")).getText();
            int noktaIndex = str.indexOf(".");
            String uzantisizDomain = str.substring(0, noktaIndex);

            String domainName =Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[1]/a")).getText();

            String link= "https://www.namejet.com/Pages/Auctions/BackorderDetails.aspx?domainname="+domainName+"&cat=";
            Driver.getDriver().get(link);
            ReusableMethods.bekle(2);
            String bidYazisi =Driver.getDriver().findElement(By.xpath("/html/body/form/div[3]/div/div[9]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[6]/span[2]")).getText();
            System.out.println(domainName + bidYazisi);
            //Driver.getDriver().get(ConfigReader.getProperty("nameJetUrl"));
            //ReusableMethods.bekle(2);
            //nameJet.searchBox.sendKeys(uzantisizDomain);
            //ReusableMethods.bekle(2);
            //nameJet.searchBox.sendKeys(Keys.ENTER);
//
            //Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/button")).click();




            String dosyaYolu= "src/test/java/tests/DomainList.xlsx";
            FileInputStream fis = new FileInputStream(dosyaYolu);
            Workbook workbook= WorkbookFactory.create(fis);
            Sheet sayfa1= workbook.getSheet("Sheet1");
            sayfa1.getRow(i).createCell(i).setCellValue(domainName);
            sayfa1.getRow(i).createCell(i+1).setCellValue(bidYazisi);



        }

    }
}