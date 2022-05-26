package cucumber.steps;

import exceptions.ElementoNoVisibleException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.AndroidDemo;

public class AndroidSteps {

    private AndroidDemo demo = new AndroidDemo();

    @Given("Buscar elemento Search Wikipedia")
    public void seleccionoPaginaDeLogin() throws ElementoNoVisibleException, InterruptedException {
        demo.selectCountry();
    }



}
