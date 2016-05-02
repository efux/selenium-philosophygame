package ch.efux.philosophygame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the LinkFinder class.
 *
 * There are several special cases tested:
 * - if the first link is after brackets
 * - if the wikipedia page contains a table on the side
 * - a normal case
 * - if the wikipedia page contains a list (multiple definitions of the same word)
 *
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

    @Test
    public void testExcludeTagFromSearch() {
        assertEquals(true, LinkFinder.excludeTagFromSearch("table"));
        assertEquals(true, LinkFinder.excludeTagFromSearch("div"));
        assertEquals(false, LinkFinder.excludeTagFromSearch("p"));
        assertEquals(false, LinkFinder.excludeTagFromSearch("ul"));
        assertEquals(false, LinkFinder.excludeTagFromSearch("a"));
    }

}
