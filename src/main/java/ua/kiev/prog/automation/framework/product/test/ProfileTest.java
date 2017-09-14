package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MessagesPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.main.ProfilePage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.ProfileSettingsPage;


public class ProfileTest extends Test{

    @Override
    public String name() {
        return "Check profile information";
    }

    @Override
    public void beforeTest() {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");
    }

    @Override
    public void test() {
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        MainPageLoggedIn dashboard = Component.getSingleton(Forum.class).mainPageLoggedIn();
        ProfilePage profile = dashboard.getProfilePage();

        System.out.println("User name is " + profile.getUserName());
        System.out.println("User wrote " + profile.getMessageNumber() + " messages");
        System.out.println("User age is " + profile.getUserAge());

        System.out.println("TEST: Changing users age");

        ProfileSettingsPage profileSettings = profile.getProfileSettingsPage();
        profileSettings.setBirstdayDate("1988", "10", "23");
        profileSettings.getProfilPage();

        System.out.println("User age is " + profile.getUserAge());

        System.out.println("TEST: Print all users messages");

        MessagesPage messagesPage = profile.getMessagesPage();
        messagesPage.PrintMessages();

        // Ждём 10 сек, с перехватом исключения на прерывание выполнения потока и игнорируем его
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { /* Игнорируем */ }

    }

    @Override
    public void afterTest() {
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
        MainPageLoggedIn dashboard = Component.getSingleton(Forum.class).mainPageLoggedIn();
        ProfilePage profile = dashboard.getProfilePage();
        ProfileSettingsPage profileSettings = profile.getProfileSettingsPage();
        profileSettings.setBirstdayDate("0000", "00", "00");
    }


}
