package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage {
    public WebDriver driver;

    private By pdfInvoiceLink = By.cssSelector("a.button-2.pdf-invoice-button");
    private By printInvoiceLnk = By.cssSelector("a.button-2.print-order-button");

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void PrintOrderDetails() {
        driver.findElement(printInvoiceLnk).click();
    }

    public void DownloadPDFInvoice() throws InterruptedException {
        driver.findElement(pdfInvoiceLink).click();
        Thread.sleep(2000);
    }
}
