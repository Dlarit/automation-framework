package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class LoginPage extends PageObject
{
    private By _username = By.xpath("//form[@id='frmLogin']//input[@name='user']");
    private By _password = By.xpath("//form[@id='frmLogin']//input[@name='passwrd']");
    private By _loginBtn = By.xpath("//form[@id='frmLogin']//input[@type='submit']");

    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class; // Привязываем к компоненту Forum
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//form[@id='frmLogin']"); // Локатор готовности страницы
    }

    final public MainPageLoggedIn login (String username, String password)
    {
        this.component().session().driver().findElement(_username).sendKeys(username);
        this.component().session().driver().findElement(_password).sendKeys(password);
        this.component().session().driver().findElement(_loginBtn).click();

        return new MainPageLoggedIn();
    }
}
