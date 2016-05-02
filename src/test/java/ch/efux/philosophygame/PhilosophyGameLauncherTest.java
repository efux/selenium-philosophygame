package ch.efux.philosophygame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class tests the correct start behaviour of the PhilosophyGameLauncher.
 *
 * The start() method asks for all instructions and saves the right values again.
 *
 * Created by efux on 02.05.2016.
 */
public class PhilosophyGameLauncherTest {

    private PhilosophyGameLauncher launcher;
    private InstructionReader instructionReader;

    @Before
    public void before() {
        instructionReader = mock(InstructionReader.class);
        when(instructionReader.getInstructions()).thenReturn(new HashSet<>(
                Arrays.asList(
                        new Instruction("Tee", "Philosophie"),
                        new Instruction("Haus", "Philosophie"))
        ));
        launcher = new PhilosophyGameLauncher(instructionReader);
    }

    @Test
    public void testStart(){
        launcher.start();
        verify(instructionReader, atLeastOnce()).getInstructions();
        verify(instructionReader, times(1)).submitNumberForInstruction(new Instruction("Tee", "Philosophie"), 8);
        verify(instructionReader, times(1)).submitNumberForInstruction(new Instruction("Haus", "Philosophie"), 16);
        verify(instructionReader, times(1)).save();
    }

}
