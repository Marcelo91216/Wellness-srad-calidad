package com.pruebacalidad.prueba1;

//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.Console;
import java.security.spec.ECField;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://localhost:4200/login");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login_1A() {
        mainPage.inputEcomUser.sendKeys("A00495404");
        mainPage.inputEcomPassword.sendKeys("Z)2W&G+Lxc");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath(
                "//div[@class='container-fluid']")).size() == 0) {
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void login_1B() {
        if (mainPage.buttonLogin.isEnabled()) {
            Assert.fail("No debería poder entrar si no lleno nada");
        }
    }

    @Test
    public void login_1C() {
        mainPage.inputEcomUser.sendKeys("A00495404");
        mainPage.inputEcomPassword.sendKeys("suaje"); // Incorrecto
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("La contraseña está mal, debería dar mensaje de error");
        }
    }

    @Test
    public void login_1D() {
        mainPage.inputEcomUser.sendKeys("A01831137"); // Incorrecto
        mainPage.inputEcomPassword.sendKeys("Z)2W&G+Lxc");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("El nombre de usuario está mal y no debería entrar sino dar error");
        }
    }

    @Test
    public void login_1E() {
        // Ambas incorrectas
        mainPage.inputEcomUser.sendKeys("A01831137");
        mainPage.inputEcomPassword.sendKeys("secret2345");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("Ambos datos usuario y contraseña están mal, no debería ingresar sino dar error");
        }
    }

    @Test
    public void loginAdmin_2A() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();
        // Cambiar a un elemento de la pantalla principal del admin
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() == 0) {
            Assert.fail("El administrador debería haber entrado");
        }
    }

    @Test
    public void loginAdmin_2B() {
        if (mainPage.buttonLogin.isEnabled()) {
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2C() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("1234");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2D() {
        mainPage.inputEcomUser.sendKeys("A90102030");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2E() {
        mainPage.inputEcomUser.sendKeys("A90102030");
        mainPage.inputEcomPassword.sendKeys("1234");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0) {
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void Contador3A() {

        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        mainPage.compGimnasio.click();
        mainPage.Contador.isDisplayed();
    }

    @Test
    public void Contador4A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(7)").click();
        $("svg[id='code128']").shouldBe(visible);
    }

    @Test
    public void VerÁreaDeportiva7A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("html > body > app-root > app-lista-areas > div:nth-of-type(2) > div > div:nth-of-type(1)").shouldBe(visible);
    }

    @Test
    public void VerÁreaDeportiva7B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("html > body > app-root > app-lista-areas > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div > div > button").shouldBe(disabled);
    }

    @Test
    public void VerHorariosÁreaDeportiva8A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("button[routerlink='/esports']").click();
        $("html > body > app-root > app-esports > div:nth-of-type(3)").shouldBe(visible);
    }

    @Test
    public void VerHorariosÁreaDeportiva8B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("button[routerlink='/esports']").click();
        $("html > body > app-root > app-esports > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > button").shouldBe(disabled);
    }

    @Test
    public void ReservaÁreaDeportiva9A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("button[routerlink='/esports']").click();
        $("html > body > app-root > app-esports > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > button").click();
        $("input[id='reserve']").shouldBe(visible);
    }

    @Test
    public void ReservaÁreaDeportiva9B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("html > body > app-root > app-header > div > nav > div > ul > li:nth-of-type(1)").click();
        $("button[routerlink='/esports']").click();
        $("html > body > app-root > app-esports > div:nth-of-type(3) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > button").click();
        $("button[id='btn2']").click();
        $("div[class='modal-body']").shouldBe(visible);
    }

    @Test
    public void VerReservaciones10A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("a[ng-reflect-router-link='reservas']").click();
        $("div[class*='col-md-8']").shouldBe(visible);

    }

    @Test
    public void VerReservaciones10B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        $("a[ng-reflect-router-link='reservas']").click();
        $("h4[class='text-center']").shouldBe(visible);

    }

    // Sprint 2
    @Test
    public void Contador3B(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        mainPage.linkGimnasio.click();
        synchronized (this)
        {
            try
            {
                wait(1000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        int actual = Integer.parseInt(mainPage.aforoActualYTotal.getText().split("/", 2)[0]);
        mainPage.buttonMarcarLlegada.click();
        int nuevo = Integer.parseInt(mainPage.aforoActualYTotal.getText().split("/", 2)[0]);
        Assert.assertEquals(nuevo, actual+1, "Debería de dar el mismo valor en ambos");
        mainPage.buttonMarcarSalida.click();
    }

    @Test
    public void Contador3C(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        mainPage.linkGimnasio.click();
        mainPage.buttonMarcarLlegada.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        int ant = Integer.parseInt(mainPage.aforoActualYTotal.getText().split("/", 2)[0]);
        mainPage.buttonMarcarSalida.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        int nuevo = Integer.parseInt(mainPage.aforoActualYTotal.getText().split("/", 2)[0]);
        Assert.assertEquals(nuevo, ant-1, "Debería de dar el mismo valor en ambos");
    }

    @Test
    public void ajusteAreaDeportiva14A(){
        mainPage.inputEcomUser.sendKeys("A00021564");
        mainPage.inputEcomPassword.sendKeys("D&a#1Wqv^i");
        mainPage.buttonLogin.click();

        mainPage.buttonEstadSticas.click();

    }

    @Test
    public void ajusteAreaDeportiva14B(){
        mainPage.inputEcomUser.sendKeys("A00021564");
        mainPage.inputEcomPassword.sendKeys("D&a#1Wqv^i");
        mainPage.buttonLogin.click();

        mainPage.buttonEstadSticas.click();

        mainPage.inputNuevoAforo.sendKeys("190");
        mainPage.inputStart.sendKeys("17/05/23");
        mainPage.inputStart2.sendKeys("20/05/23");
        mainPage.buttonRazon.sendKeys("Mantenimiento");

        mainPage.guardarAforo.click();
    }

    @Test
    public void verEntrenadores15A(){
        mainPage.inputEcomUser.sendKeys("A00167441");
        mainPage.inputEcomPassword.sendKeys("b+7CEtti8u");
        mainPage.buttonLogin.click();

        mainPage.buttonReservar.click();

    }



    @Test
    public void verNutriologosDisponibles18A(){
        mainPage.inputEcomUser.sendKeys("A00167441");
        mainPage.inputEcomPassword.sendKeys("b+7CEtti8u");
        mainPage.buttonLogin.click();

        mainPage.buttonNutriologo.click();
        mainPage.buttonReservarNutriologo.click();


    }

}


   
