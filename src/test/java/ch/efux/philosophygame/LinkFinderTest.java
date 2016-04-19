package ch.efux.philosophygame;

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

    @Test
    public void testNormalCase(){
        LinkFinder linkFinder = new LinkFinder("/wiki/Tee", "Philosophie");
        assertEquals("/wiki/Aufguss_(Zubereitung)", linkFinder.next());
        linkFinder.close();
    }

}
