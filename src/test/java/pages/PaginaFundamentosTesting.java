package pages;

public class PaginaFundamentosTesting extends BasePage {

    private String buyButton = "//a[normalize-space()='Comprar ahora']";
    
    public PaginaFundamentosTesting() {
        super(driver);
    }

    public void clickComprarAhora() {
        clickElement(buyButton);
    }


    

}
