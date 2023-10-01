package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Hooks {
    static WebDriver driver = null;
    @Before
    public void beforeMethod() {
        String myProjectLoc= System.getProperty("user.dir");
        File file = new File(myProjectLoc+"\\application.properties");
        FileReader reader = null;
        Properties properties = null;
        try {
             reader = new FileReader(file);
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {

        }

        String browserName = properties.getProperty("browser.name");

        switch (browserName) {
            case "edge":
                System.setProperty("webdriver.edge.driver", myProjectLoc+"\\msedgedriver.exe");
                 driver = new EdgeDriver();
                 break;
            case "chrome":
                System.setProperty("webdriver.edge.driver", myProjectLoc+"\\crhomedriver.exe");
                 driver = new ChromeDriver();
                 break;
            default:
                throw new IllegalArgumentException("Hee pls provide either chrom / edge / any valid browser name which is supported by selenium");
        }
        driver.manage().window().maximize();
        String url = properties.getProperty("applicaiton.url");
        driver.get(url);

    }

    @After
    public void afterMethod() {
        //takescreent
        driver.quit();
    }



}
