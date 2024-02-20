package testNG.tiki.admin;

import org.testng.annotations.Test;

public class Shopper_01_Manage_Products {

    @Test(groups = {"admin","product"})
    public void Product_01_Create_Product() {
        System.out.println("Admin Create Product");
    }

    @Test(groups = {"admin","product"})
    public void Product_02_View_Product() {
        System.out.println("Admin View Product");
    }

    @Test(groups = {"admin","product"})
    public void Product_03_Update_Product() {
        System.out.println("Admin Update Product");
    }

    @Test(groups = {"admin","product"})
    public void Product_04_Delete_Product() {
        System.out.println("Admin Delete Product");
    }
}
