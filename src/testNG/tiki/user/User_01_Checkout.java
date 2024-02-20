package testNG.tiki.user;

import org.testng.annotations.Test;

public class User_01_Checkout {

    @Test(groups = "user")
    public void Checkout_01_Add_Product_To_Cart() {
        System.out.println("User Add Product");
    }

    @Test(groups = "user")
    public void Checkout_02_View_Cart() {
        System.out.println("User View Product");
    }

    @Test(groups = "user")
    public void Checkout_03_Add_Shipping_Address() {
        System.out.println("User Add Shipping Add");
    }

    @Test(groups = "user")
    public void Checkout_04_Add_Payment_Info() {
        System.out.println("User Add Payment Info");
    }
}
