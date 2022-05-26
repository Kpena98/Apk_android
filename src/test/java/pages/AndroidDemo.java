package pages;

import driver.DriverManager;
import exceptions.ElementoNoVisibleException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logger;

import java.io.IOException;
import java.net.URISyntaxException;

public class AndroidDemo {

    public AndroidDemo() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Chile']")
    private WebElement country;

    /*AndroidElement country = (AndroidElement) new WebDriverWait(DriverManager.getDriver(), 30).until(
            ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Chile']")));*/

    @FindBy(id = "username")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//button")
    private WebElement botonLogin;

    @FindBy(xpath = "//*[contains(@class,'flash success')]")
    private WebElement alertaExito;

    @FindBy(xpath = "//*[contains(@class,'flash error')]")
    private WebElement alertaError;

    private static final String nombreUsuario = "tomsmith";
    private static final String claveUsuario = "SuperSecretPassword!";

    public void selectCountry() throws ElementoNoVisibleException, InterruptedException {
        Thread.sleep(5000);
        if (country.isEnabled()) {
            country.click();
        } else {
            throw new ElementoNoVisibleException("País Chile no encontrado");
        }
    }

    private void completarFormulario(String usuario, String password) {
        inputUsername.sendKeys(usuario);
        inputPassword.sendKeys(password);
        botonLogin.click();
    }

    public void iniciarSesion() throws ElementoNoVisibleException, InterruptedException {
        if (inputUsername.isDisplayed()) {
            Logger.pass("Se muestra formulario de login");
            completarFormulario(nombreUsuario, claveUsuario);
            Thread.sleep(1000);
        } else {
            throw new ElementoNoVisibleException("No se encontró input de nombre de usuario");
        }
    }

    public void mensajeExitoVisible() throws URISyntaxException, IOException {
        if (alertaExito.isDisplayed()) {
            Logger.pass("Mensaje de exito en login correcto");
        } else {
            Logger.error("No se muestra mensaje de exito al logear");
        }
    }

    public void iniciarSesionDatosIncorrectos() throws ElementoNoVisibleException, InterruptedException {
        if (inputUsername.isDisplayed()) {
            completarFormulario(nombreUsuario, "ClaveFalsa");
            Thread.sleep(1000);
        } else {
            Logger.error("No se encontró input de nombre de usuario");
            throw new ElementoNoVisibleException("No se encontró input de nombre de usuario");
        }
    }

    public void alertaErrorVisible() {
        if (alertaError.isDisplayed()) {
            Logger.pass("Alerta de error en login se muestra en pantalla");
        } else {
            Logger.error("No se muestra alerta de error");
        }
    }

    public void esperar() {
        try {
            Logger.info("Finalizando prueba");
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Error en timeout");
        }
    }
}
