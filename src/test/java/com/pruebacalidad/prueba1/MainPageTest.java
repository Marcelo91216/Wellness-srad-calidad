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
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:4200/login");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {driver.quit();}

    @Test
    public void login_1A() {
        mainPage.inputEcomUser.sendKeys("A00495404");
        mainPage.inputEcomPassword.sendKeys("Z)2W&G+Lxc");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath(
                "//div[@class='container-fluid']")).size() == 0){
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void login_1B(){
        if (mainPage.buttonLogin.isEnabled()){
            Assert.fail("No debería poder entrar si no lleno nada");
        }
    }

    @Test
    public void login_1C(){
        mainPage.inputEcomUser.sendKeys("A00495404");
        mainPage.inputEcomPassword.sendKeys("suaje"); // Incorrecto
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("La contraseña está mal, debería dar mensaje de error");
        }
    }

    @Test
    public void login_1D(){
        mainPage.inputEcomUser.sendKeys("A01831137"); // Incorrecto
        mainPage.inputEcomPassword.sendKeys("Z)2W&G+Lxc");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("El nombre de usuario está mal y no debería entrar sino dar error");
        }
    }

    @Test
    public void login_1E(){
        // Ambas incorrectas
        mainPage.inputEcomUser.sendKeys("A01831137");
        mainPage.inputEcomPassword.sendKeys("secret2345");
        mainPage.buttonLogin.click();
        if(driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("Ambos datos usuario y contraseña están mal, no debería ingresar sino dar error");
        }
    }

    @Test
    public void loginAdmin_2A(){
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();
        // Cambiar a un elemento de la pantalla principal del admin
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() == 0){
            Assert.fail("El administrador debería haber entrado");
        }
    }

    @Test
    public void loginAdmin_2B(){
        if (mainPage.buttonLogin.isEnabled()){
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2C(){
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("1234");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2D(){
        mainPage.inputEcomUser.sendKeys("A90102030");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }

    @Test
    public void loginAdmin_2E(){
        mainPage.inputEcomUser.sendKeys("A90102030");
        mainPage.inputEcomPassword.sendKeys("1234");
        mainPage.buttonLogin.click();
        if (driver.findElements(By.xpath("//div[@class='container-fluid']")).size() != 0){
            Assert.fail("El usuario no pudo ingresar a la pantalla principal");
        }
    }


    @Test
    public void Contador_A3(){
        mainPage.inputEcomUser.sendKeys("A00831137");
        mainPage.inputEcomPassword.sendKeys("Secret");
        mainPage.buttonLogin.click();
        if(driver.findElements(By.xpath("//a[@href='/gimnasio']")).size() == 0){
            Assert.fail("No pudo ni encontrar la opcion de seleccionar el gimnasio");
        }
        mainPage.linkGimnasio.click();
        if(driver.findElements(By.xpath("//*[@id='MyChart']")).size() == 0){
            Assert.fail("No se pudo encontrar la gráfica del aforo del gimnasio");
        }
    }

    @Test
    public void Contador_3B(){
       mainPage.inputEcomUser.sendKeys("A00009582");
       mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
       mainPage.buttonLogin.click();
       if(driver.findElements(By.xpath("//a[@href='/gimnasio']")).size() == 0){
           Assert.fail("Se supone que debería haber entrado a la pantalla de inicio");
       }
       mainPage.linkGimnasio.click();
       if(driver.findElements(By.xpath("//*[@id='MyChart']")).size() == 0){
           Assert.fail("Deberá haber entrado a la pantalla del aforo del gimnasio");
       }
       String text = mainPage.aforoDelGimnasio.getText();

       // otro usuario alumno
       driver.findElement(By.xpath("//*[@id='MyChart']")).sendKeys(Keys.CONTROL+"t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://localhost:4200/login");
        mainPage.inputEcomUser.sendKeys("A00046687");
        mainPage.inputEcomPassword.sendKeys("L!O4Z)qlgx");
        mainPage.buttonLogin.click();
        if(driver.findElements(By.xpath("//a[@href='/gimnasio']")).size() == 0){
            Assert.fail("Debería haber entrado a la pantalla de inicio del otro usuario");
        }
        mainPage.linkGimnasio.click();
        if(driver.findElements(By.xpath("//a[contains(@style, '0.7%;')]")).size() == 0){
            Assert.fail("Porque no entro el segundo usuario?");
        }
        mainPage.marcarLlegada.click();
        driver.switchTo().window(tabs.get(0));

        // al momento de meterse al aparatdo del gimnasio, deberá poner
    }

    @Test
    public void Contador_3C(){
        mainPage.inputEcomUser.sendKeys("A00831137");
        mainPage.inputEcomPassword.sendKeys("Secret");
        mainPage.buttonLogin.click();
        // Falta seguir con el caso de prueba...
    }

    @Test
    public void codigo_de_barras_4A(){
        mainPage.inputEcomUser.sendKeys("A00831137");
        mainPage.inputEcomPassword.sendKeys("Secret");
        mainPage.buttonLogin.click();
        if(driver.findElements(By.xpath("//a[contains(@href, 'id')]")).size() == 0){
            Assert.fail("No pudo ni encontrar la opcion de 'ID digital'");
        }
        mainPage.linkIdDigital.click();
        if(driver.findElements(By.xpath("//*[@id='code128']")).size() == 0){
            Assert.fail("No pudo entrar a la pantalla del codigo de barras");
        }
    }

}
