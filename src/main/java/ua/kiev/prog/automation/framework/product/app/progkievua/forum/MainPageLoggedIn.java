package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.ProfilePage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.UsersPage;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class MainPageLoggedIn  extends PageObject
{

    // "//tr[@id='board_25']//a[@name='b25']"

    /**
     * Этот метод должен возвращать класс компонета для объекта страницы
     * Определяет к какому компоненту привязан этот объект страницы
     *
     * @return Class
     */
    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class;
    }

    /**
     * Этот метод должен возвращать локатор готовности страницы
     *
     * @return By - locator
     */
    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='boardindex_table']");
    }

    //локатор для логина пользователя
    private By _usernameText = By.xpath("//div[@class='user_block']//a[contains(@href,'?action=profile')]/span");
    //локатор для перехода на dasboard
    private By _goToBoardPage = By.xpath("//a[ .='QA Automation'][@name='b25']");
    //локатор дляпереход на страницу с пользователями
    private By _goToUsersPage = By.xpath("//li[@id='button_mlist']/a");
    //локатор для перехода на страницу профиля
    private By _goToProfilePage = By.xpath("//li[@id='button_profile']/a");

    final public String getUsername ()
    {
        return this.component().session().driver().findElement(_usernameText).getText();
    }

    //метод для перехода на BoardPage
    final public BoardPage getBoardPage() {
        this.component().session().driver().findElement(_goToBoardPage).click();
        return new BoardPage();
    }
    //метод для перехода на UsersPage
    final public UsersPage openUsers(){
        this.component().session().driver().findElement(_goToUsersPage).click();
        return new UsersPage();
    }
    //метод для перехода на ProfilePage
    final public ProfilePage getProfilePage(){
        this.component().session().driver().findElement(_goToProfilePage).click();
        return new ProfilePage();
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
