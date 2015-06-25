package com.aconex.qa.tests;

import com.aconex.qa.pages.LoginPage;

/**
 * Created by satish on 17/6/15.
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login("poleary","ac0n3x72");
        loginPage.close();
    }

}
