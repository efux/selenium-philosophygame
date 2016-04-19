package ch.efux.philosophygame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by efux on 19.04.2016.
 */
public class LinkFinderTest {

    private LinkFinder linkFinder;

    @Before
    public void before() {
        linkFinder = new LinkFinder("/wiki/Tee", "Philosophie");
    }

    @After
    public void after() {
        linkFinder.close();
    }

    @Test
    public void testNormalCase(){
        assertEquals("/wiki/Aufguss_(Zubereitung)", linkFinder.next());
    }

}
