package ua.kiev.prog.automation.framework.product.app.progkievua.forum.main;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MessagesPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.ProfileSettingsPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;

public class ProfilePage extends PageObject {

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='Основная информация']");
    }

    private By _userName = By.xpath("//div[@class='content']/dl[1]/dd[1]");
    //div[@class='content']/dl/dt[. = 'Имя пользователя: ']"
    private By _messageNumber = By.xpath("//div[@class='content']/dl[1]/dd[2]");
    private By _age = By.xpath("//div[@class='content']/dl[1]/dd[3]");
    private By _changeProfile = By.xpath("//../span[.='Изменить профиль']");
    private By _profileSettings = By.xpath("//div[@id='admin_menu']//span[.='Настройки профиля']");
    private By _messages = By.xpath("//p[@id='infolinks']/a[1][.='Просмотр сообщений']");

    final public String getUserName() {
        return this.component().session().driver().findElement(_userName).getText();
    }

    final public String getMessageNumber(){
        return this.component().session().driver().findElement(_messageNumber).getText();
    }

    final public String getUserAge(){
        return this.component().session().driver().findElement(_age).getText();
    }

    final public ProfileSettingsPage getProfileSettingsPage(){
        this.component().session().driver().findElement(_changeProfile).click();
        this.component().session().driver().findElement(_profileSettings).click();
        return new ProfileSettingsPage();
    }

    final public MessagesPage getMessagesPage(){
        this.component().session().driver().findElement(_messages).click();
        return new MessagesPage();
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
