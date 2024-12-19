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
    // Obtener los valores del dropdown
    List<String> lista = checkoutPage.returnPlanDropdownValues();

    // Definir los valores esperados
    List<String> listaEsperada = Arrays.asList(
        "Academia 16.99 mes 13 productos",
        "Academia 176 año 13 productos",
        "Free Gratis 3 productos"
    );

    // Normalizar ambas listas
    List<String> listaNormalizada = normalizeListWithRegex(lista);
    List<String> listaEsperadaNormalizada = normalizeListWithRegex(listaEsperada);

    // Validar que las listas sean iguales
    Assert.assertEquals(listaEsperadaNormalizada, listaNormalizada);
}

/**
 * Normaliza una lista de cadenas usando una expresión regular.
 */
private List<String> normalizeListWithRegex(List<String> lista) {
    return lista.stream()
        .map(this::normalizeTextWithRegex) // Normalizar cada elemento
        .toList(); // Convertir de vuelta a lista
}

/**
 * Normaliza una cadena usando una expresión regular para eliminar caracteres no deseados.
 */
private String normalizeTextWithRegex(String texto) {
    // Extrae solo palabras, números y espacios relevantes
    return texto
        .replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ0-9. ]", "") // Eliminar caracteres no alfanuméricos excepto puntos y espacios
        .replaceAll("\\s+", " ") // Reducir múltiples espacios a uno solo
        .trim(); // Eliminar espacios al inicio y al final
}


    /* @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = checkoutPage.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos", "Academia: $176 / año • 13 productos", "Free: Gratis • 3 productos");

        Assert.assertEquals(listaEsperada, lista);

    } */
}
