package SwagLabs.pageobject;

import net.thucydides.core.pages.PageObject;

public class AboutPage extends PageObject {
    public void goBack(){
        getDriver().navigate().back();
    }
}
