package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.PaginaCheckOut;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosTestingPage = new PaginaFundamentosTesting();
    PaginaCheckOut checkoutPage = new PaginaCheckOut();

    @Given("I navigate to www.freerangertesters.com")
    public void iNavigateToFRT() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.navigateToFreeRengeTesters();
    }

    @When("I go to {string} using the navigation bar")
    public void iGoToASectionUsingTheNavigationBar( String section ) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("I select Elegir plan")
    public void goToSelectPlan() {
        cursosPage.clickOnElegirPlanLink();
    }

    @And("select Introduccion al Testing de Software")
    public void navigateToIntro() {
        cursosPage.clickFundamentosTestingLink();
    }

    @And("select Comprar ahora")
    public void validateCheckout() {
        fundamentosTestingPage.clickComprarAhora();
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = checkoutPage.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("El Dojo - Prácticas intensivas de Testing y Automation: $30 / mes • 9 productos", "El Dojo - Prácticas intensivas de Testing y Automation: $240 / año • 9 productos", "Academia: $16.99 / mes • 13 productos", "Academia: $176 / año • 13 productos", "Free: Gratis • 3 productos");

        Assert.assertEquals(listaEsperada, lista);

    }
}
