package ch.efux.philosophygame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the PhilosophyGame class.
 *
 * Created by efux on 19.04.2016.
 */
public class PhilosophyGameTest {

    private PhilosophyGame pGame;

    @Before
    public void before() {
        pGame = new PhilosophyGame();
        pGame.setMaximalTries(20);
    }

    @Test
    public void testTeeToPhilosophie() {
        assertEquals(8, pGame.run("Tee", "Philosophie"));
    }

    @Test
    public void testPhilosophieToPhilosophie() {
        assertEquals(1, pGame.run("Philosophie", "Philosophie"));
    }

    @Test
    public void testPhilosophieLoop() {
        assertEquals(20, pGame.run("Philosophie", "Tee"));
    }

    @Test
    public void testHausToPhilosophie() {
        assertEquals(16, pGame.run("Haus", "Philosophie"));
    }

}
