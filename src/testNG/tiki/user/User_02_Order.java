package testNG.tiki.user;

import org.testng.annotations.Test;

public class User_02_Order {

    @Test(groups = {"user", "order"})
    public void Order_01_View_Order() {
        System.out.println("User View Order");
    }

    @Test(groups = {"user", "order"})
    public void Order_02_Edit_Order() {
        System.out.println("User Edit Order");
    }

    @Test(groups = {"user", "order"})
    public void Order_03_Edit_Shipping_Address() {
        System.out.println("User Edit Order");
    }

    @Test(groups = {"user", "order"})
    public void Order_04_Edit_Payment_Info() {
        System.out.println("User Edit Payment Info");
    }
}
