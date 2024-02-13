package data;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static void scroll(WebDriver driver, int x, int y) {
        waitInSeconds(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("window.scrollBy(%d, %d)", x, y), "");
        waitInSeconds(1);
    }

    public static void waitInSeconds(long seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
