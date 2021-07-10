package nopcommerce.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoTestNG {
    @BeforeMethod
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @Test
    public void TC_01(){
        System.out.println("TC_01");
    }

    @Test
    public void TC_02(){
        System.out.println("TC_02");
    }
    @Test
    public void TC_03(){
        System.out.println("TC_03");
    }

}
