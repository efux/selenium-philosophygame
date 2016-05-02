package ch.efux.philosophygame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testWithBrackets() {
        linkFinder.setPosition("/wiki/Justus_Heinrich_Dresler");
        assertEquals("/wiki/Mathematiker", linkFinder.next());
    }

    @Test
    public void testPageWithList() {
        linkFinder.setPosition("/wiki/Maus");
        assertEquals("/wiki/Kleins%C3%A4uger", linkFinder.next());
    }

}
