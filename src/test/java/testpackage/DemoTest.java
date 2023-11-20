package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import testpackage.PageComponents.MultiTrip;
import testpackage.PageComponents.RoundTrip;
import testpackage.PageObjects.TestHomePage;

import java.io.IOException;
import java.sql.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DemoTest extends BastTest{
    WebDriver driver;
    TestHomePage travel;
    By sectionElement = By.id("flightSearchContainer");
    /*
    ---> SRP Design Pattern:
    * The single-responsibility principal (SRP) is one of the Design Pattern
    * that states that every module, class should have responsibility over a
    * single part of that program's functionality.
    *
    * Why SRP? Real Life Example-
    *
    * 1. When a class is highly coupled with more responsibilities,
    * any small change to requirement could easily lead to many changes in
    * other parts of code which is harder to maintain.
    *
    * 2. SRP helps developers write code that are decoupled, where each
    * class has its own job snd encapsulate responsibilities to other classes.
    * If specification of this job changes, developer makes changes on that specific
    * class only.
    *
    * 3. The changes is less likely to break the entire application as other
    * classes should still be doing their job as before, unless of course they
    * were broken in the first place.
    *
    * */
    @BeforeTest
    public void setup(){
        driver = InitializeDriver();
        travel = new TestHomePage(driver);

    }
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> dataProvider){
        travel.goTo();
        travel.getFooterNav().getFlightAttribute();
        travel.getNavigationBar().getFlightAttribute();
        travel.getFooterNav().getLinkCount();
        travel.getNavigationBar().getLinkCount();

//      [+]Check availability with SDP without breaking SRP
        /*
        ---> Strategy Design Pattern:

        The strategy design pattern (also known as the policy design pattern)
        is a behavioral design pattern that allows us to select an algorithm
        at runtime.

        In this pattern, the code receives run-time instructions to decide
        which group of the algorithms to use.

        Strategy design patterns make the algorithm very independently
        of the context, clients, and codes that use it.

        Use the Strategy when you have a lot of similar classes
        that only differ in the way they execute some behaviour.

        */
//        travel.setBookingStrategy(new MultiTrip(driver,sectionElement));
//        travel.setBookingStrategy(new RoundTrip(driver, sectionElement));
//        travel.checkAvail("MAA","HYD");

        /*
        ---> Factory Design Pattern
        The factory design pattern is creational design pattern,
        which provides one of the best ways to create objects.

        This pattern uses factory methods to deal with the problem
        of creation objects without specifying the exact class of
        the object that it has to create.

        * In factory patterns, we create objects by calling a factory
        calling method rather than by calling a constructor.

        *So, in short, the factory pattern gives the applicable object
        from the family of classes that we  can use. This object represents
        an algorithm as well as lots of other functionalities.
        */

        travel.setBookingStrategy("multitrip");
        travel.checkAvail(dataProvider);

//        driver.quit();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> l = getJsonData(System.getProperty("user.dir")+"//src//test//DataLoad//testData.json");
        return new Object[][]{
                {l.get(0)},{l.get(1)}
        };
    }

    /*
    * What is Jfrog
    --> Artifactory Management Tools
    * Why do we need jfrog in Automation Projects?
    --> It store core automation framework snap shot or jar inted of storing in locally on m2.
    --> So it can be accessible to other teams.
    Create Jfrog account?
    Create Repository for Maven Packages in Jfrog.
    --> Choose create repo then choose maven.
    * Provide Jfrog Repository management details in Maven POM.xml file
    --> Go to repo in Jfrog --> Set Up -> Copy following like data and put it in core framework
     and pom.xml eg. paste below dependency
    <distributionManagement>
    <snapshotRepository>
      <id>snapshots</id>
      <name>a0v5zshrc4nb0-artifactory-primary-0-snapshots</name>
      <url>https://zakron.jfrog.io/artifactory/rahulshettydemo-libs-snapshot-local</url>
    </snapshotRepository>
  </distributionManagement>
    It will be loaded ${name}-libs-snapshot-local

    --> Update snapshot number after updating setting xml in m2 use "mvn deploy"
    command to push the artifact

    * Update Maven Setting.xml so that Maven Project knows to pull artifacts from Jfrog

    --> Download setting from Jfrog you will get the encrypted password in user profile section
    update setting.xml in .m2
    --> Update child framework pom .xml with "distributionManagement" and latest snapshot pushed
    to jfrog repo.
    Deploy Snapshot Jar to Jfrog Artifactory with mvn deploy command

    */

}
