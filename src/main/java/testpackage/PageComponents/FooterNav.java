package testpackage.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent {
    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); // when you inherit parent class - you should invoke parent class constructor
//        in your own child constructor

    }

    //    method to handle flights
//    when selenium executes any method in this class scopw od selenium
//    should be in th footer only
    public void getFlightAttribute(){
        System.out.println(findElement(flights).getAttribute("class"));
    }

    public void getLinkCount(){
        System.out.println(findElements(links).size());
    }
}
