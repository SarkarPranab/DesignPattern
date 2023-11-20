package testpackage.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testpackage.AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");

    By links = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
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
