package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.Assert;

import java.util.Objects;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DemoSpringBootAndThymeLeafApplicationTests {

    @LocalServerPort
    int port;

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\red07\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
//Soft Error notification test
    //1. Verify Employee page shows
    //2. Verify when selecting Add Employee button that error page is shown
    //3. Verify when clicking back to Home link user is navigated to the Employee page

    @Test
    void EmployeeApplicationTest() {
        driver.get("http://localhost:" + port);

        String[] titles = {"Employee", "Error", "Employee"};
        String[] buttons_Links = {"/html/body/div/a", "/html/body/div/p[2]/a"};

        for (int i = 0; i < titles.length; i++) {

            new WebDriverWait(driver, ofSeconds(20))
                    .until(titleIs(titles[i]));

            Assert.isTrue(true, String.valueOf(Objects.equals(driver.getTitle(), titles[i])));

            if (i < titles.length - 1) {
                driver.findElement(By.xpath(buttons_Links[i])).click();
            }
        }

    }

}
