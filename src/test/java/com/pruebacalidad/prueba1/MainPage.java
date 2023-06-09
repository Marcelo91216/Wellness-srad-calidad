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
    
    @FindBy(css = "a[ng-reflect-router-link='reservas']")
    public WebElement linkReservas;
    
    @FindBy(css = "div[class*='col-md-8']")
    public WebElement TarjetasReservas;
    
     @FindBy(css = "h4[class='text-center']")
    public WebElement TarjetasReservasVacias;

    @FindBy(css = "html > body > app-root > app-inicio-admin > div:nth-of-type(3) > div > div > div > div:nth-of-type(6) > button")

    public WebElement btnCerrarArea;

    @FindBy(css = "div[class^='col-md-6'] input[id='start']")
    public WebElement calendarioInicio;

    @FindBy(css = "div[class^='col-md-5'] input[id='start']")
    public WebElement calendarioFinal;

    @FindBy(css = "input[class^='mt-4']")
    public WebElement cuadroTextoMotivoCierre;

    @FindBy(css = "button[class*='btn-success']")
    public WebElement getBtnCerrarArea;

    @FindBy(css = "div[class='modal-body']")
    public WebElement ModalConfirmarCerrarArea;

    @FindBy(css = "div[class$='img-bannerCerrado'] div[class='card-img-overlay']")
    public WebElement TarjetaAreaCerrada;

    @FindBy(css = "html > body > app-root > app-lista-areas > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div > div > button")
    public WebElement btnCerrado;

    @FindBy(css = "html > body > app-root > app-inicio-admin > div:nth-of-type(6) > div > div > div > div:nth-of-type(6) > button")
    public WebElement btnAbrirArea;

    @FindBy(css = "div[class='modal-body']")
    public WebElement modalConfirmacionAbrir;

    @FindBy(css = "button[routerlink='/arena']")
    public WebElement btnArena;


    @FindBy(css = "button[class$='btn-primary']")
    public WebElement okModal;

    @FindBy(css = "button[id='btn']")
    public WebElement cerrarSession;


    @FindBy(css = "button[routerlink='/entrenadores']")
    public WebElement SessionEntrenador;

    @FindBy(css = "html > body > app-root > app-citasentrenador > div > div:nth-of-type(1) > div > div > div > div:nth-of-type(3) > button")
    public WebElement ReservarEntrenador;

    @FindBy(css = "div[class*='border-gray']")
    public WebElement DisponibilidadEntrenador;
    @FindBy(css = "html > body > app-root > app-horario-asesor > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > button")
    public WebElement btndis;

    @FindBy(css = "html > body > app-root > app-horario-asesor > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > button")
    public WebElement btnReservarEnt;

    @FindBy(css = "button[id='btn2']")
    public WebElement btnReservarEntM;

    @FindBy(css = "div[class='modal-body']")
    public WebElement ConfReservar;

    @FindBy(css = "div[class^='col-md-5']")
    public WebElement Especialidad;

    @FindBy(css = "div[class^='col-md-7']")
    public WebElement Resenas;

    @FindBy(css = "a[ng-reflect-router-link='idDigital']")
    public WebElement idLink;

    @FindBy(css = "rect[width='222']")
    public WebElement codigoBarras5;

    @FindBy(css = "button[routerlink='/nutriologos']")
    public WebElement nutriologosSeccion;


    @FindBy(css = "html > body > app-root > app-citasnutriologo > div > div:nth-of-type(1) > div > div > div > div > div:nth-of-type(3) > button")
    public WebElement nutriologoSeleccionado;

    @FindBy(css = "input[id='weekPicker']")
    public WebElement inputSemana;

    @FindBy(css = "html > body > app-root > app-horario-asesor > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > button")
    public WebElement horarioSeleccionado;

    @FindBy(css = "button[class='btn']")
    public WebElement btnReservarNutri;

    @FindBy(css = "div[class^='col-md-5'] div[class*='border']")
    public WebElement EspecialidadNutri;

    @FindBy(css = "div[class^='col-md-7'] div[class*='border']")
    public WebElement ReseñasNutri;

    @FindBy(css = "a[ng-reflect-router-link='reservas']")
    public WebElement ReservacionesLink;

    @FindBy(css = "html > body > app-root > app-lista-reservas > div:nth-of-type(2) > div > div > div > div > div > div > div > div:nth-of-type(2) > button")
    public WebElement cancelarReserva;

    @FindBy(css = "div[class='modal-footer'] button[class$='btn-primary']")
    public WebElement okCancelacion;

    @FindBy(css = "small[id='estado-html']")
    public WebElement estadoLabel;

    @FindBy(css = "a[ng-reflect-router-link='exportarDatos']")
    public WebElement exportarAforo;

    @FindBy(css = "input[id='weekPicker']")
    public WebElement escogerSemana;

    @FindBy(css = "html > body > app-root > app-exportar-datos > div:nth-of-type(3) > div:nth-of-type(1) > div")
    public WebElement descargarDataGym;

    @FindBy(css = "html > body > app-root > app-exportar-datos > div:nth-of-type(3) > div:nth-of-type(1) > div > div > div:nth-of-type(2) > button")
    public WebElement descargarDataGymBtn;

    @FindBy(css = "a[ng-reflect-router-link='lockers']")
    public WebElement linkCasilleros;

    @FindBy(css = "html > body > app-root > app-lockers > div:nth-of-type(2) > div:nth-of-type(2) > div > div > div > div:nth-of-type(1) > div > div")
    public WebElement infoCasilleros;

    @FindBy(css = "div[style='margin-bottom: 2%;']")
    public WebElement infoCasilleroReservado;

    @FindBy(css = "button[class='btn btn-sm']")
    public WebElement btnSubirComprobante;

    @FindBy(css = "button[ng-reflect-router-link='/estadisticasGimnasio']")
    public WebElement btnStatsGym;

    @FindBy(css = "input[type='week']")
    public WebElement inputSemanaGym;

    @FindBy(css = "input[type='week']")
    public WebElement graficaGymSemanal;

    @FindBy(css = "input[type='date']")
    public WebElement inputDiaGym;

    @FindBy(css = "canvas[id='linea']")
    public WebElement graficaGymLineaSemanal;

    @FindBy(css = "button[ng-reflect-router-link='/estadisticas,crossfit']")
    public WebElement btnStatsCrossfit;

































    
    
    
    
    
    
    
    
    
































    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
}
