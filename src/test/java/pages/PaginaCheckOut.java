package pages;

import java.util.List;

public class PaginaCheckOut extends BasePage {

    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";
    
    public PaginaCheckOut() {
        super(driver);
    }

    public List<String> returnPlanDropdownValues(){
        return getDropdownValues(planDropdown);
    }
    
}
