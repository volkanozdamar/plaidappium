package Base;


import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    protected AndroidDriver driver;
    public TestBase(AndroidDriver driver){
        this.driver = driver;
    }


    public TestBase() {
    }
}
