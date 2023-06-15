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


    // Pruebas correspondientes al Sprint 5

    @Test
    public void login_1A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
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
        mainPage.linkGimnasio.click();
        mainPage.Contador.isDisplayed();
    }

    @Test
    public void CódigoDeBarras4A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        mainPage.compID.click();
        mainPage.codigoBarras.isDisplayed();
    }

    @Test
    public void VerÁreaDeportiva7A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        mainPage.tarjetaCross.isDisplayed();
    }

    @Test
    public void VerÁreaDeportiva7B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        boolean si = mainPage.tarjetaCrossBtn.isEnabled();
        if(!si){
            Assert.fail("Area abierta");
        }
    }

    @Test
    public void VerHorariosÁreaDeportiva8A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        mainPage.linkEsports.click();
        mainPage.horario.isDisplayed();
    }


    @Test
    public void VerHorariosÁreaDeportiva8B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

       driver.get("http://localhost:4200/areaDeportiva/esport%20arena");
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
         boolean si = mainPage.horarioDis.isDisplayed();
    }

    @Test
    public void ReservaÁreaDeportiva9A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.linkEsports.click();
        mainPage.seleSemana.sendKeys("242023");
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        mainPage.horarioVisible.isDisplayed();
        mainPage.resumenReserva.isDisplayed();
    }

    @Test
    public void ReservaÁreaDeportiva9B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.linkEsports.click();
        mainPage.seleSemana.sendKeys("242023");

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.horarioVisible.isDisplayed();
        mainPage.resumenReserva.isDisplayed();
    }

    @Test
    public void VerReservaciones10A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        mainPage.linkReservas.click();
        mainPage.TarjetasReservas.isDisplayed();

    }

    @Test
    public void VerReservaciones10B() {
        mainPage.inputEcomUser.sendKeys("A00581348");
        mainPage.inputEcomPassword.sendKeys("(flOQ9zbF1");
        mainPage.buttonLogin.click();

        mainPage.linkReservas.click();

        Assert.assertEquals(mainPage.mensaje.getText(), "No cuentas con ninguna reservación activa");
    }


    // Pruebas correspondientes al Sprint 6
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

        mainPage.buttonMarcarLlegada.click();
        mainPage.buttonMarcarSalida.click();

    }

    @Test
    public void Contador3C(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        mainPage.linkGimnasio.click();

        synchronized (this){
            try{
                wait(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.buttonMarcarLlegada.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.buttonMarcarSalida.click();

    }


    @Test
    public void RegistroEntrada5A(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        synchronized (this){
            try{
                wait(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/idDigital");
        synchronized (this){
            try{
                wait(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.codigoBarras5.isDisplayed();
    }

    @Test
    public void RegistroEntrada6A(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.idLink.click();
        synchronized (this){
            try{
                wait(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.codigoBarras5.isDisplayed();
    }


    @Test
    public void cerrarAreaDeportiva12A() {

        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnCerrarArea.click();
        mainPage.calendarioInicio.sendKeys("30122023");
        mainPage.calendarioFinal.sendKeys("31122023");
        mainPage.cuadroTextoMotivoCierre.sendKeys("Mantenimiento");
        mainPage.getBtnCerrarArea.click();
        Assert.assertEquals(mainPage.ModalConfirmarCerrarArea.getText(),"El cierre se ha programado correctamente!");
    }

    @Test
    public void cerrarAreaDeportiva12B() {

        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnCerrarArea.click();
        mainPage.calendarioInicio.sendKeys("30122023");
        mainPage.calendarioFinal.sendKeys("31122023");
        mainPage.cuadroTextoMotivoCierre.sendKeys("Mantenimiento");
        mainPage.getBtnCerrarArea.click();
        Assert.assertEquals(mainPage.ModalConfirmarCerrarArea.getText(),"El cierre se ha programado correctamente!");

    }


    @Test
    public void abrirAreaDeportiva13A() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnAbrirArea.click();
        Assert.assertEquals(mainPage.modalConfirmacionAbrir.getText(),"Área abierta correctamente!");

    }

    @Test
    public void abrirAreaDeportiva13B() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();


        mainPage.btnAbrirArea.click();
        synchronized (this){
            try{
                wait(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        Assert.assertEquals(mainPage.modalConfirmacionAbrir.getText(),"Área abierta correctamente!");
        mainPage.okModal.click();
    }

    @Test
    public void verDisponibilidadEntrenador16A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/entrenadores");
        mainPage.ReservarEntrenador.click();
        mainPage.DisponibilidadEntrenador.isDisplayed();

    }


    @Test
    public void verDisponibilidadEntrenador16B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(10000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/entrenadores");
        synchronized (this){
            try{
                wait(10000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.ReservarEntrenador.isDisplayed();

    }

    @Test
    public void reservarCitaEntrenador17A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/entrenadores");
        mainPage.ReservarEntrenador.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnReservarEnt.isDisplayed();
        mainPage.btnReservarEntM.isDisplayed();

    }

    @Test
    public void reservarCitaEntrenador17B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/entrenadores");
        mainPage.ReservarEntrenador.click();

        mainPage.Especialidad.isDisplayed();

    }

    //Sprint 7

    @Test
    public void citaNutriologo20A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/nutriologos");


        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.nutriologoSeleccionado.click();
        mainPage.inputSemana.sendKeys("252023");
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.horarioSeleccionado.click();
    }


    @Test
    public void citaNutriologo20B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/nutriologos");


        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.nutriologoSeleccionado.click();
        mainPage.EspecialidadNutri.isDisplayed();
    }

    @Test
    public void cancelarReserva21A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.ReservacionesLink.click();


        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.cancelarReserva.isDisplayed();

    }


    @Test
    public void cancelarReserva21B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.ReservacionesLink.click();


        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        Assert.assertEquals(mainPage.estadoLabel.getText(),"Cancelada");

    }


    @Test
    public void cancelarReservaAutomatica22A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.ReservacionesLink.click();


        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        Assert.assertEquals(mainPage.estadoLabel.getText(),"Cancelada");

    }

    @Test
    public void ExportarEstadisticas23A() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.exportarAforo.click();

        mainPage.escogerSemana.isDisplayed();

    }


    @Test
    public void ExportarEstadisticas23B() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.exportarAforo.click();

        mainPage.escogerSemana.sendKeys("232023");

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.descargarDataGym.isDisplayed();
    }


    @Test
    public void ExportarEstadisticas23C() {
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.exportarAforo.click();

        mainPage.escogerSemana.sendKeys("232023");

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.descargarDataGym.isDisplayed();
        mainPage.descargarDataGymBtn.click();
    }

    @Test
    public void RentaCasillero25A() {
        mainPage.inputEcomUser.sendKeys("A00126458");
        mainPage.inputEcomPassword.sendKeys("8R1tVy5ID^");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.linkCasilleros.click();
        mainPage.infoCasilleros.isDisplayed();
    }


    @Test
    public void ComprobantePago26A() {
        mainPage.inputEcomUser.sendKeys("A00092163");
        mainPage.inputEcomPassword.sendKeys("!L0(UXzvBk");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/lockers");
        mainPage.infoCasilleroReservado.isDisplayed();
        mainPage.btnSubirComprobante.isDisplayed();
    }

    @Test
    public void ComprobantePago26B() {
        mainPage.inputEcomUser.sendKeys("A00092163");
        mainPage.inputEcomPassword.sendKeys("!L0(UXzvBk");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.linkCasilleros.click();
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnSubirComprobante.isDisplayed();
    }

    @Test
    public void GraficaAsistenciasGym27A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnStatsGym.click();
        mainPage.inputSemanaGym.sendKeys("232023");

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.graficaGymSemanal.isDisplayed();

    }

    @Test
    public void GraficaAsistenciasGym27B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnStatsGym.click();
        mainPage.inputSemanaGym.isDisplayed();
    }


    @Test
    public void GraficaLineas28A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnStatsCrossfit.click();
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.inputDiaGym.sendKeys("05062023");
        mainPage.graficaGymLineaSemanal.isDisplayed();

    }

    @Test
    public void GraficaLineasGimnasio29A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnStatsGym.click();
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.inputDiaGym.sendKeys("05062023");
        mainPage.graficaGymLineaSemanal.isDisplayed();

    }


    @Test
    public void GraficaBarrasAreas30A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.btnStatsCrossfit.click();
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.inputSemanaGym.sendKeys("232023");
        mainPage.graficaGymSemanal.isDisplayed();

    }


    @Test
    public void GraficaBarrasAreas30B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnStatsCrossfit.click();
        mainPage.inputSemanaGym.isDisplayed();
    }


    @Test
    public void TendenciasAforo31A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/tendencias");
        mainPage.segmento.sendKeys("1");
        mainPage.bloque.sendKeys("B");
        mainPage.semana.sendKeys("s");
        mainPage.graficaTendencias.isDisplayed();
    }

    @Test
    public void CrearAnuncio32A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.tituloInput.sendKeys("Prueba1");
        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06062023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        mainPage.imgSelect.click();
        mainPage.inputDesc.sendKeys("Wellness Center");
        mainPage.inputInicioA.sendKeys("05062023");
        mainPage.inputFinalA.sendKeys("09062023");
        mainPage.btnGuardarAnuncio.isEnabled();

    }

    @Test
    public void CrearAnuncio32B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06062023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        boolean si =  mainPage.btnGuardarAnuncio.isEnabled();
        if(!si){
            Assert.fail("Boton habilitado");
        }
    }

    @Test
    public void EstablecerLimites33A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06062023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        mainPage.inputInicioA.sendKeys("05062023");
        mainPage.inputFinalA.sendKeys("07062023");
        mainPage.btnGuardarAnuncio.isEnabled();

    }

    @Test
    public void EstablecerLimites33B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06062023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        mainPage.inputInicioA.sendKeys("05062023");
        mainPage.inputFinalA.sendKeys("3062023");
        boolean si =  mainPage.btnGuardarAnuncio.isEnabled();
        if(!si){
            Assert.fail("Boton habilitado");
        }

    }


    @Test
    public void ProgramaciónDeAnuncios34A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06062023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        mainPage.inputInicioA.sendKeys("05062023");
        mainPage.inputFinalA.sendKeys("07062023");
        mainPage.btnGuardarAnuncio.isEnabled();
    }

    @Test
    public void ProgramaciónDeAnuncios34B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearAnuncio");

        mainPage.fechaInicioEInput.sendKeys("05062023");
        mainPage.fechaFinalEInput.sendKeys("06042023");
        mainPage.inputUbicacion.sendKeys("Wellness Center");
        mainPage.inputInicioA.sendKeys("05062023");
        mainPage.inputFinalA.sendKeys("0762023");
        boolean si =  mainPage.btnGuardarAnuncio.isEnabled();
        if(!si){
            Assert.fail("Boton habilitado");
        }
    }

    @Test
    public void MonitorReservas35A() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/monitorReservas");
        mainPage.seleDia.sendKeys("12062023");
        mainPage.tablaReservas.isDisplayed();
    }

    @Test
    public void MonitorReservas35B() {
        mainPage.inputEcomUser.sendKeys("A00099123");
        mainPage.inputEcomPassword.sendKeys("!B7OdKtOqG");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/monitorReservas");
        mainPage.seleDia.sendKeys("11062023");
        mainPage.tablaReservas.isDisplayed();
    }


    @Test
    public void CrearNuevasAreasDeportivas36A(){
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearArea");
        mainPage.nombreArea.sendKeys("Área de prueba 1");
        mainPage.aforoArea.sendKeys("200");
        mainPage.horaApertura.sendKeys("11111");
        mainPage.horaCierre.sendKeys("11111");
        mainPage.ubicacion.sendKeys("Wellness");
        mainPage.material.sendKeys("Pesas");
        mainPage.btnCrearArea.isEnabled();

    }


    @Test
    public void CrearNuevasAreasDeportivas36B(){
        mainPage.inputEcomUser.sendKeys("A00939520");
        mainPage.inputEcomPassword.sendKeys("_8mIDDFxPU");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/crearArea");
        mainPage.nombreArea.sendKeys("Área de prueba 1");
        mainPage.aforoArea.sendKeys("200");
        mainPage.horaApertura.sendKeys("11111");

        boolean si =  mainPage.btnCrearArea.isEnabled();
        if(si){
            Assert.fail("Boton habilitado");
        }

    }


    @Test
    public void EncuestasSatisfacción37A(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.get("http://localhost:4200/gimnasio");
        synchronized (this){
            try{
                wait(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        mainPage.calificarAreaBtn.isDisplayed();

    }


















































}





   
