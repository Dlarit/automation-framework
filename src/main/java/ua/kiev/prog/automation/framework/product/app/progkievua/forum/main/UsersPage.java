package ua.kiev.prog.automation.framework.product.app.progkievua.forum.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;

import java.util.List;

public class UsersPage extends PageObject {

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//li/a/span[text()='Список пользователей']");
    }

    private By _users = By.xpath("//div[@id='mlist']/table[@class='table_grid']/tbody/tr/td[2]/a");

    public void printUsersList() {
        List<WebElement> usersList = this.component().session().driver().findElements(_users); // Driver and xpath
        for (WebElement element : usersList) {
            System.out.println(element.getText());
        }
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
