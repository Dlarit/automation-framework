package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.ProfilePage;

public class ProfileSettingsPage extends PageObject {

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='Настройки профиля']");
    }

    private By _birthdayYear = By.xpath("//input[@name='bday3']");
    private By _birthdayMonth = By.xpath("//input[@name='bday1']");
    private By _birthdayDay = By.xpath("//input[@name='bday2']");
    private By _submitButton = By.xpath("//input[@class='button_submit']");
    private By _goToProfilePage = By.xpath("//li[@id='button_profile']/a");

    final public void setBirstdayDate(String year, String month, String day){
        this.component().session().driver().findElement(_birthdayYear).clear();
        this.component().session().driver().findElement(_birthdayYear).sendKeys(year);
        this.component().session().driver().findElement(_birthdayMonth).clear();
        this.component().session().driver().findElement(_birthdayMonth).sendKeys(month);
        this.component().session().driver().findElement(_birthdayDay).clear();
        this.component().session().driver().findElement(_birthdayDay).sendKeys(day);
        this.component().session().driver().findElement(_submitButton).click();
    }

    final public ProfilePage getProfilPage(){
        this.component().session().driver().findElement(_goToProfilePage).click();
        return new ProfilePage();
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
