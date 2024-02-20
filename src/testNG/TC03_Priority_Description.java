package testNG;

import org.testng.annotations.Test;

public class TC03_Priority_Description {

    @Test(description = "JIRA-1357 Register New Employee", priority = 1)
    public void EndUser_01_Register() {

    }

    @Test
    public void EndUser_02_View() {

    }

    @Test(priority = 1)
    public void EndUser_03_Edit() {

    }

    @Test
    public void EndUser_04_Delete() {

    }
}
