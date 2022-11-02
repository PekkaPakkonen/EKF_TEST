import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class CartTest {

    private WebDriver driver;
    private CartPage cartP;


    @BeforeSuite
    public void preps() {
        driver = new FirefoxDriver();
        cartP = new CartPage(driver);
        driver.manage().window().maximize();
    }


    @BeforeMethod
    public void updatePage() {
        driver.get("https://ekfgroup.com/cart");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getFindButton()));
    }


    @Test
    public void addNewItem() {
        cartP.textFieldFill("mcb6-1-10C-av");
        cartP.findButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getDescription()));
        cartP.removeItemButtonClick();
    }

    @Test
    public void addNewWrongItem() {
        cartP.textFieldFill("mcb6-1-100C-av");
        cartP.findButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getProductNotExist()));
        cartP.removeItemButtonClick();
    }

    @Test
    public void transferToEb() {
        cartP.textFieldFill("mcb6-1-10C-av");
        cartP.findButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getDescription()));
        cartP.orderButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.urlContains("electrobaza"));
    }

    @AfterSuite
    public void finish() {
        driver.quit();
    }

}
