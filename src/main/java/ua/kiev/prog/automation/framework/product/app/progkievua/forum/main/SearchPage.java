package ua.kiev.prog.automation.framework.product.app.progkievua.forum.main;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.MainMenuBlock;

public class SearchPage extends PageObject{

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='Поиск']");
    }

    final public MainMenuBlock mainMenu(){
        return new MainMenuBlock();
    }

}
