package ch.efux.philosophygame;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by efux on 02.05.2016.
 */
public class CSVInstructionReaderTest {

    /**
     * This test doesn't test, if the number of calls are correctly written.
     */
    @Test
    public void testEndToEnd(){
        CSVInstructionReader instructionReader = new CSVInstructionReader("EndToEndTest.csv");
        Set<Instruction> instructionSet = new HashSet<>(
                Arrays.asList(
                        new Instruction("Maus", "Raus"),
                        new Instruction("Saus", "Brause"))
        );

        instructionReader.setInstructionSet(instructionSet);
        instructionReader.save();
        assertEquals(instructionSet, instructionReader.getInstructions());
    }

}
