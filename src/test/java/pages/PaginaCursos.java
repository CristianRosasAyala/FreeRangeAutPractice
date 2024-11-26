package pages;

public class PaginaCursos extends BasePage{
    public PaginaCursos() {
        super(driver);
    }
    
    private String sectionLink = "//a[h3[normalize-space()='Introducción al Testing de Software']]";
    private String planSelectionlink = "//a[normalize-space()='Elegir este plan']";
    


    public void clickFundamentosTestingLink() {
        clickElement(sectionLink);
    }

    public void clickOnElegirPlanLink() {
        clickElement(planSelectionlink);
    }
}

