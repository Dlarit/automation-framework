package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

import java.util.List;
import java.util.SortedMap;

public class MessagesPage extends PageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//*[@class='navigate_section roundframe']//*[@class='last']//*[span='Сообщения']");
    }

    private By _posts = By.xpath("//div[@class='list_posts']");

    final public void PrintMessages(){
        List<WebElement> postsList = this.component().session().driver().findElements(_posts);
        int num = 1;
        for (WebElement post: postsList){
            System.out.println(num + " message: ");
            System.out.println(post.getText());
            num++;
        }
    }

}
