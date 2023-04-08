package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ExpiredDomains {

    public ExpiredDomains(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(xpath ="/html/body/div[1]/ul/li[3]/a")
    public WebElement loginButonu;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/form/div[1]/div/input")
    public WebElement userNameTextBox;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/form/div[2]/div/input")
    public WebElement userPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/form/div[4]/div/button")
    public WebElement loginSubmitButonu;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div[1]/ul/li[22]/a")
    public WebElement pendingDeleteButonu;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div[2]/div[1]/span[1]/a")
    public WebElement filterButonu;


    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/input")
    public WebElement minDay;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]/div[2]/input")
    public WebElement maxDay;

    @FindBy(id = "flimit" )
    public WebElement perPage;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[1]/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div[5]/div[2]/select")
    public WebElement wbyMin;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[1]/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div[6]/div[2]/select")
    public WebElement wbyMax;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/ul/li[2]/a")
    public WebElement additionalButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[2]/label/input")
    public WebElement netIconu;


    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/form/div[2]/div/input")
    public WebElement applyFilterButonu;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/table/thead/tr/th[12]/a")
    public WebElement regIconu;


}
