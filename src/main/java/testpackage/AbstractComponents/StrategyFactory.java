package testpackage.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.PageComponents.MultiTrip;
import testpackage.PageComponents.RoundTrip;

public class StrategyFactory {
    WebDriver driver;

    public StrategyFactory(WebDriver driver){
        this.driver = driver;
    }
    By sectionElement = By.id("flightSearchContainer");
    public SearchFileAvail createStrategy(String strategyType){
        if(strategyType.equalsIgnoreCase("multitrip")){
           return new MultiTrip(driver,sectionElement);
        }
        if(strategyType.equalsIgnoreCase("roundtrip")){
            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
