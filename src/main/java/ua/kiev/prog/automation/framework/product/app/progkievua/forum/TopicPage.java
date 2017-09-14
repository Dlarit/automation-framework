package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.UsersPage;

import java.util.List;

public class TopicPage extends PageObject{

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='QA Automation (10.08.2017)']");
        // "//li[@class='last']/a/span[text()='QA Automation']"
    }

    private By _authors = By.xpath("//h4/a");

    private By _goToUsersPage = By.xpath("//li[@id='button_mlist']/a");

    public void printAuthorsName(){
        List<WebElement> authorsList = this.component().session().driver().findElements(_authors); // Driver and xpath
        for (WebElement author: authorsList ) {
            System.out.println(author.getText());
        }
    }

    final public UsersPage openUsers(){
        this.component().session().driver().findElement(_goToUsersPage).click();
        return new UsersPage();
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }
}
