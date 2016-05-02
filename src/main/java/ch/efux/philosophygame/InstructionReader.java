package ch.efux.philosophygame;

import java.util.Set;

/**
 * Created by efux on 02.05.2016.
 */
public interface InstructionReader {

    Set<Instruction> getInstructions();

    void submitNumberForInstruction(Instruction instruction, int run);

    void save();
}
