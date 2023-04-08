package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ExpiredDomains;
import pages.NameJet;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EndingNets {

    ExpiredDomains expiredDomains = new ExpiredDomains();
    NameJet nameJet = new NameJet();

    @Test
    public void endingNets() {
        for (int i = 1; i <= 3; i++) {


            Driver.getDriver().get(ConfigReader.getProperty("expiredUrl"));
            expiredDomains.loginButonu.click();
            expiredDomains.userNameTextBox.sendKeys(ConfigReader.getProperty("userName"));
            expiredDomains.userPassword.sendKeys(ConfigReader.getProperty("password"));
            expiredDomains.loginSubmitButonu.click();
            expiredDomains.pendingDeleteButonu.click();
            expiredDomains.filterButonu.click();

            expiredDomains.minDay.sendKeys("1");
            expiredDomains.maxDay.sendKeys("1");
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
            System.out.println(domainName);

            Driver.getDriver().get(ConfigReader.getProperty("nameJetUrl"));
            ReusableMethods.bekle(2);
            nameJet.searchBox.sendKeys(uzantisizDomain);
            ReusableMethods.bekle(2);
            nameJet.searchBox.sendKeys(Keys.ENTER);


            Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/button")).click();



        }

    }
}