package pages;

public class PaginaPrincipal extends BasePage{
    public PaginaPrincipal(){
        super(driver);
    }
    
    private String sectionLink = "//a[normalize-space()='%s' and @href]";

    //Metodo para navegar a www.freerangertesters.com

    public void navigateToFreeRengeTesters() {
        navigateTo(" https://www.freerangetesters.com/");
        
    }

    public void clickOnSectionNavigationBar(String section) {
        //Reemplaza el marcardor de posicion en la sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section); 
        clickElement(xpathSection);
    }

    
}
