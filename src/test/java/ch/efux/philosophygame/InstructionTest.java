package ch.efux.philosophygame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by efux on 02.05.2016.
 */
public class InstructionTest {

    @Test
    public void testToStringWithNoCalls() {
        Instruction instruction = new Instruction("Tee", "Philosophie");
        assertEquals("Tee;Philosophie;0", instruction.toString());
    }

    @Test
    public void testToString() {
        Instruction instruction = new Instruction("Tee", "Philosophie");
        instruction.setNumberAccessesNeeded(7);
        assertEquals("Tee;Philosophie;7", instruction.toString());
    }

}
