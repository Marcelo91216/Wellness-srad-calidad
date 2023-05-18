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

    @FindBy(css = "html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(2)")
    public WebElement compGimnasio;

    @FindBy(css = "h1[class='text-body-secondary']")
    public WebElement Contador;
    
    @FindBy(css = "html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(7)")
    public WebElement compID;
    
    @FindBy(css = "svg[id='code128']")
    public WebElement codigoBarras;
    
    @FindBy(css = "svg[id='html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)']")
    public WebElement compInicio;
    
    @FindBy(css = "html > body > app-root > app-lista-areas > div:nth-of-type(2) > div > div:nth-of-type(1)")
    public WebElement tarjetaCross;
    
    @FindBy(css = "html > body > app-root > app-lista-areas > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div > div > button")
    public WebElement tarjetaCrossBtn;
    
    @FindBy(css = "button[routerlink='/esports']")
    public WebElement linkEsports;
    
    @FindBy(css = "html > body > app-root > app-esports > div:nth-of-type(3)")
    public WebElement horario;
    
    @FindBy(css = "html > body > app-root > app-esports > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > button")
    public WebElement horarioDis;
    
    @FindBy(css = "html > body > app-root > app-esports > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > button")
    public WebElement horarioVisible;
    
    
    @FindBy(css = "input[id='reserve']")
    public WebElement resumenReserva;
    
    
    @FindBy(css = "button[id='btn2']")
    public WebElement confirmarReserva;
    
 
    @FindBy(css = "div[class='modal-body']")
    public WebElement modalReserva;


    @FindBy(css = "button[routerlink='/entrenadores']")
    public WebElement buttonReservar;


    @FindBy(css = "button[routerlink='/editarAforo']")
    public WebElement buttonEditarAforo;


    @FindBy(css = "input[id='nuevoAforo']")
    public WebElement inputNuevoAforo;

    @FindBy(css = "div[class^='col-md-6'] input[id='start']")
    public WebElement inputStart;

    @FindBy(css = "div[class^='col-md-5'] input[id='start']")
    public WebElement inputStart2;

    @FindBy(css = "input[class^='mt-4']")
    public WebElement input;

    

    


    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
}
