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
        
        
        mainPage.compInicio.click();
        mainPage.tarjetaCross.isDisplayed();
    }

    @Test
    public void VerÁreaDeportiva7B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        mainPage.compInicio.click();
        
        boolean si = mainPage.tarjetaCrossBtn.isEnabled();
        if(si){
            Assert.fail("Area abierta");
        }
        
    }

    @Test
    public void VerHorariosÁreaDeportiva8A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        
        mainPage.compInicio.click();
        mainPage.linkEsports.click();
        mainPage.horario.isDisplayed();
    }

    @Test
    public void VerHorariosÁreaDeportiva8B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        mainPage.compInicio.click();
        mainPage.linkEsports.click();
        
         boolean si = mainPage.horarioDis.isEnabled();
        if(si){
            Assert.fail("Boton habilitado");
        }
        
    }

    @Test
    public void ReservaÁreaDeportiva9A() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        mainPage.compInicio.click();
        mainPage.linkEsports.click();
        
        mainPage.horarioVisible.click();
        mainPage.resumenReserva.isDisplayed();
    }

    @Test
    public void ReservaÁreaDeportiva9B() {
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();
        
        
        mainPage.compInicio.click();
        mainPage.linkEsports.click();
        mainPage.horarioVisible.click();
        mainPage.confirmarReserva.click();
        mainPage.modalReserva.isDisplayed();
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
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();

        mainPage.linkReservas.click();
        Assert.assertEquals(mainPage.TarjetasReservasVacias.getText(), "No cuenta con ninguna reservación activa");
        
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
    public void RegistroEntrada5A(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();


        mainPage.idLink.click();
        mainPage.codigoBarras5.isDisplayed();
    }

    @Test
    public void RegistroEntrada6A(){
        mainPage.inputEcomUser.sendKeys("A00009582");
        mainPage.inputEcomPassword.sendKeys("5_sh5BTt^H");
        mainPage.buttonLogin.click();


        mainPage.idLink.click();
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
        mainPage.calendarioInicio.click();
        mainPage.calendarioFinal.click();
        mainPage.cuadroTextoMotivoCierre.sendKeys("Mantenimiento");
        mainPage.getBtnCerrarArea.click();
        Assert.assertEquals(mainPage.ModalConfirmarCerrarArea.getText(),"Area cerrada correctamente!");
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
        mainPage.calendarioInicio.click();
        mainPage.calendarioFinal.click();
        mainPage.cuadroTextoMotivoCierre.sendKeys("Mantenimiento");
        mainPage.getBtnCerrarArea.click();
        Assert.assertEquals(mainPage.ModalConfirmarCerrarArea.getText(),"Area cerrada correctamente!");

        mainPage.okModal.click();
        mainPage.cerrarSession.click();

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

        mainPage.TarjetaAreaCerrada.isDisplayed();

        Assert.assertEquals(mainPage.btnCerrado.getText(),"Cerrado");

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

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

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
        mainPage.cerrarSession.click();

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
        mainPage.btnArena.isEnabled();

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

        mainPage.SessionEntrenador.click();
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
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.SessionEntrenador.click();
        mainPage.ReservarEntrenador.click();

        boolean si =  mainPage.btndis.isEnabled();
        if(si){
            Assert.fail("Boton habilitado");
        }

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

        mainPage.SessionEntrenador.click();
        mainPage.ReservarEntrenador.click();

        synchronized (this){
            try{
                wait(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        mainPage.btnReservarEnt.click();
       // mainPage.btnReservarEntM.click();
       // Assert.assertEquals(mainPage.ConfReservar.getText(), "Tu reservación ha sido exitosa!");

    }

    @Test
    public void reservarCitaEntrenador17B() {
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

        mainPage.SessionEntrenador.click();
        mainPage.ReservarEntrenador.click();
        mainPage.Especialidad.isDisplayed();
        mainPage.Resenas.isDisplayed();
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
        mainPage.inputSemana.sendKeys("232023");
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
        mainPage.ReseñasNutri.isDisplayed();
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

        mainPage.cancelarReserva.click();
        mainPage.okCancelacion.click();

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

        mainPage.linkCasilleros.click();
        mainPage.infoCasilleroReservado.isDisplayed();
        mainPage.btnSubirComprobante.isEnabled();
    }

    @Test
    public void ComprobantePago26B() {
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
        mainPage.linkCasilleros.click();
        mainPage.btnSubirComprobante.click();
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















































}





   
