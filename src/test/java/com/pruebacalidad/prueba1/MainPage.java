package com.pruebacalidad.prueba1;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = http://localhost:4200/inicio
public class MainPage {
    @FindBy(xpath = "//*[@id='Ecom_Password']")
    public WebElement inputEcomPassword;



    @FindBy(xpath = "//*[@id='Ecom_User_ID']")
    public WebElement inputEcomUser;

    @FindBy(xpath = "//a[@href='/gimnasio']")
    public WebElement linkGimnasio;

    @FindBy(xpath = "//*[@id='MyChart']")
    public WebElement aforoChartGimnasio;

    @FindBy(xpath = "//a[contains(@href, 'id')]")
    public WebElement linkIdDigital;

    @FindBy(xpath = "//a[@href='http://localhost:4200/gimnasio']")
    public WebElement linkReservarGimnasio;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[contains(@style, '0.7%;')]")
    public WebElement marcarLlegada;

    @FindBy(xpath = "//h1[contains(@style, '18%;')]")
    public WebElement aforoDelGimnasio;



    @FindBy(xpath = "//*[@id='marcarSalida']")
    public WebElement buttonMarcarSalida;

    @FindBy(xpath = "//h1[contains(@style, '18%;')]")
    public WebElement aforoActualYTotal;

    @FindBy(css = "button[id='marcarLlegada']")
    public WebElement buttonMarcarLlegada;



    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
}
