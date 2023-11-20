package testpackage.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.AbstractComponents.AbstractComponent;
import testpackage.AbstractComponents.SearchFileAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFileAvail {

    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");
    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
//  Execute around pattern
    @Override
    public void checkAvail(HashMap<String,String> dataProvided) {
//      Execute around pattern
        makeStateReady(s -> selectOriginCity(dataProvided.get("origin")));
//        selectOriginCity(origin);
        selectDestinationCity(dataProvided.get("destination"));
        selectDestinationCity2(dataProvided.get("destination_2"));
    }
  /*  public void getCaladerDetails(String origin, String destination) {
//      Execute around pattern
        makeStateReady(s -> selectCalander(origin));
//        selectOriginCity(origin);
        selectDestinationCity(destination);
        selectDestinationCity2("BLR");
    }*/
    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination){
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
//     common prerequisites code
//     execute actual function
//     teardown method
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("I'm done");

    }


}
