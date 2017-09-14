package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.BoardPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.TopicPage;

public class ForumTest extends Test {
    @Override
    public String name() {
        return "Forum navigation";
    }

    @Override
    public void beforeTest() {
        System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");
    }

    @Override
    public void test() {
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        MainPageLoggedIn dashboard = Component.getSingleton(Forum.class).mainPageLoggedIn();
        //переходим на страницу BoardPage
        BoardPage boardPage = dashboard.getBoardPage();
        //переходим на TopicPage
        TopicPage topicPage = boardPage.getTopicPage();
        System.out.println("TEST: Names of topic authors: ");
        //выводим авторов сообщений
        topicPage.printAuthorsName();
        //  или
        //dashboard.getBoardPage().getTopicPage().printAuthorsName();

        System.out.println("TEST: Names of forum users: ");
        topicPage.openUsers().printUsersList();

        // Ждём 10 сек, с перехватом исключения на прерывание выполнения потока и игнорируем его
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { /* Игнорируем */ }

    }

    @Override
    public void afterTest() {
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
    }
}
