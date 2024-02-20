package testNG.tiki.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Shopper_02_Manage_Cart extends BaseTest{
    /*
        alwaysRun = true : default to be false => Not execute if running via the XML file
        => Must set to true as we will definitely manage execution of all TCs via the XML file

        priority = n : set priority for TCs to be executed in order.
        As default TestNG execute TCs in an order that follow their names alphanumerically
        => priority = useless => just naming TC name appropriately

        enabled = true/false : define which TCs to be executed

        description = "" : link to other TMS (test management system)
     */

    @BeforeTest(alwaysRun = true)
    public void initDataTest() {
        System.out.println("=== Generating Test Data...===");
    }

    @Test(groups = {"admin","cart"}, priority = 1, description = "JIRA-1357 - Create New Visa Card")
    public void Product_01_Create_VisaCard() {
        System.out.println("Admin Create Visa");
    }

    @Test(groups = {"admin","cart"}, enabled = true)
    public void Product_02_View_VisaCard() {
        System.out.println("Admin View Visa");
    }

    @Test(groups = {"admin","cart"})
    public void Product_03_Update_VisaCard() {
        System.out.println("Admin Update Visa");
    }

    @Test(groups = {"admin","cart"})
    public void Product_04_Delete_VisaCard() {
        System.out.println("Admin Delete Visa");
    }

    @AfterTest(alwaysRun = true)
    public void cleanUpDataTest() {
        System.out.println("=== Clean Visa Card Data ===");
    }
}
