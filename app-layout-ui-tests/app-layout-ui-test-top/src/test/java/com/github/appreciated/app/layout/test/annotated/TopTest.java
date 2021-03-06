package com.github.appreciated.app.layout.test.annotated;

import com.github.appreciated.app.layout.test.test.BaseTest;
import com.github.appreciated.app.layout.test.top.TopMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopMain.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopTest extends BaseTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testMenu() {
        WebElement root = getShadowRootElement("app-layout-top");
        clickByCssSelector("paper-tab", 0);
        clickByCssSelector("paper-tab", 1);
        clickByCssSelector("paper-tab", 2);
    }

    @Override
    public int getServerPort() {
        return randomServerPort;
    }
}
