package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;

public class BoardPage extends PageObject {

    //локатор для TopicPage
    private By _goToTopicPage = By.xpath("//*[@class='table_grid']//a[. = 'QA Automation (10.08.2017)']");

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='QA Automation']");
        // "//table[@class='table_grid']" подходит больше т.к. может использоваться для любого board
        // + лучше не использовать локаторы с поиском по тексту
    }

    //метод для вызова TopicPage
    final public TopicPage getTopicPage(){
        this.component().session().driver().findElement(_goToTopicPage).click();
        return new TopicPage();
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
