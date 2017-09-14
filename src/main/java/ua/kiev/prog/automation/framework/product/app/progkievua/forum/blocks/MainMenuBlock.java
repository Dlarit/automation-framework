package ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.BlockObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.HelpPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.ProfilePage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.SearchPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.UsersPage;

public class MainMenuBlock extends BlockObject {


    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='main_menu']");
    }

    private By _goToHelpPage = By.xpath("//li[@id='button_help']/a");
    private By _goToProfilePage = By.xpath("//li[@id='button_profile']/a");
    private By _goToUsersPage = By.xpath("//li[@id='button_mlist']/a");
    private By _goToSearchPage = By.xpath("//li[@id='button_search']/a");

    public HelpPage openHelpPage(){
        this.component().session().driver().findElement(_goToHelpPage).click();
        return new HelpPage();
    }

    public ProfilePage openProfilePage(){
        this.component().session().driver().findElement(_goToProfilePage).click();
        return new ProfilePage();
    }

    public UsersPage openUsersPage (){
        this.component().session().driver().findElement(_goToUsersPage).click();
        return new UsersPage();
    }

    public SearchPage openSearchPage(){
        this.component().session().driver().findElement(_goToSearchPage).click();
        return new SearchPage();
    }
}
