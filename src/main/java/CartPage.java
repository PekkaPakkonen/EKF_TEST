import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By findButton = By.cssSelector(".mx-n4 .px-4.col-md-auto .btn-outline-primary");
    private By textField = By.cssSelector(".mb-64 .form-control");
    private By description = By.cssSelector(".cart-product .align-items-center");
    private By orderButton = By.cssSelector(".row .col-md-6.mb-8:first-child .btn");
    private By productNotExist = By.cssSelector(".b-toaster .b-toast-prepend .toast-body");
    private By removeItemButton = By.cssSelector(".text-center .btn-remove");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getFindButton() {
        return findButton;
    }

    public By getDescription() {
        return description;
    }

    public By getProductNotExist() {
        return productNotExist;
    }

    public void orderButtonClick() {
        driver.findElement(orderButton).click();
    }

    public void findButtonClick() {
        driver.findElement(findButton).click();
    }

    public void removeItemButtonClick() {
        driver.findElement(removeItemButton).click();
    }

    public void textFieldFill(String str) {
        driver.findElement(textField).clear();
        driver.findElement(textField).sendKeys(str);
    }




}
