package Helper;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestHelper {
    public static void waitElement(AndroidElement element, WebDriverWait webDriverWait){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitListElement(List<AndroidElement> element, WebDriverWait webDriverWait,int index){
        webDriverWait.until(ExpectedConditions.visibilityOf(element.get(index)));
    }
}
