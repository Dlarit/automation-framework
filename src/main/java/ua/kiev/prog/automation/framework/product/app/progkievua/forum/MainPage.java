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
public class MainPage extends PageObject
{
    private By _goToLoginPage = By.xpath("//div[@class='user_block']//a[contains(@href,'action=login')]");

    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class; // Привязываем к компоненту Forum
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='boardindex_table']");  // Локатор готовности страницы
    }

    /**
     * Этот метод переходит на страницу логина
     *
     * @return LoginPage
     */
    final public LoginPage getLoginPage()
    {
        // Нажимаем ссылку "войдите", локатор определён в приватном свойстве _goToLoginPage
        this.component().session().driver().findElement(_goToLoginPage).click();
        // Возвращаем объект страницы входа
        return new LoginPage();
    }

}

