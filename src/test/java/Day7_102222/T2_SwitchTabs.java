package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web-driver-manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome window
        //headless-runs in the code in the background
        options.addArguments("start-maximized","incognito");
        //for mac use "start-fullscreen"
//        options.addArguments("start-fullscreen");
        //define the web-driver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to fidelis page
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);

        //click on shop  for a plan
        driver.findElement(By.xpath("//*[text()= 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);

        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text()= 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);

        //click on a doctor search icon(which will launch a new tab)
        driver.findElement(By.xpath("//*[@class='btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);

        //store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to the new tab
        driver.switchTo().window(tabs.get(1));

        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);

        //close the find a doctor tab
        driver.close();

        //click to the initial tab(parent tab)
        driver.switchTo().window(tabs.get(0));

        //go to the home page again
        driver.navigate().back();
        //driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);

        //click on get coverage, first match is index 0
        // driver.findElements(By.xpath("//*[@class= 'btn ng-binding btn-primary']")).get(0).click();
        driver.findElement(By.xpath("//*[@class= 'btn ng-binding btn-primary']")).click();
        Thread.sleep(2000);

    }//end of main

}//end of class
