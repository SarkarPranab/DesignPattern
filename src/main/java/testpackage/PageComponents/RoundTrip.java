package testpackage.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.AbstractComponents.AbstractComponent;
import testpackage.AbstractComponents.SearchFileAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFileAvail {
    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");



    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> dataProvided) {
        System.out.println("[+] Round trip test.");
        findElement(rdo).click();
        selectOriginCity(dataProvided.get("origin"));
        selectDestinationCity(dataProvided.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
