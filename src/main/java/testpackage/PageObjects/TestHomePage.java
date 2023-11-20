package testpackage.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.AbstractComponents.SearchFileAvail;
import testpackage.AbstractComponents.StrategyFactory;
import testpackage.PageComponents.FooterNav;
import testpackage.PageComponents.NavigationBar;

import java.util.HashMap;

public class TestHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFileAvail searchFileAvail;
    public TestHomePage(WebDriver driver) {
        this.driver= driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver,footerNavSectionElement);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver, sectionElement);
    }
//    SDP Design Pattern
    /*public void setBookingStrategy(SearchFileAvail searchFileAvail){
        this.searchFileAvail = searchFileAvail;
    }*/
// Strategy Factory pattern
public void setBookingStrategy(String strategyType){
    StrategyFactory strategyFactory = new StrategyFactory(driver);
    searchFileAvail = strategyFactory.createStrategy(strategyType);
    this.searchFileAvail = searchFileAvail;
}
    public void checkAvail(HashMap<String,String> dataProvider){
        searchFileAvail.checkAvail(dataProvider);
    }
}
