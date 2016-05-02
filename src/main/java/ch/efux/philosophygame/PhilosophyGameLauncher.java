package ch.efux.philosophygame;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by efux on 02.05.2016.
 */
public class PhilosophyGameLauncher {

    private Set<Instruction> instructions;
    private InstructionReader instructionReader;

    public PhilosophyGameLauncher(String pathToCSV) {
        instructionReader = new CSVInstructionReader(pathToCSV);
    }

    /**
     * Constructor only for test purposes.
     * @param iReader Implementation of the InstructionReader
     */
    protected PhilosophyGameLauncher(InstructionReader iReader) {
        instructionReader = iReader;
    }

    public void start() {
        instructions = new HashSet<>(instructionReader.getInstructions());

        PhilosophyGame pGame = new PhilosophyGame();

        for(Instruction instruction : instructions){
            instructionReader.submitNumberForInstruction(instruction, pGame.run(instruction.getStart(), instruction.getEnd()));
        }

        instructionReader.save();
    }

    public static void main(String[] args) {
        PhilosophyGameLauncher pGameLauncher = new PhilosophyGameLauncher("C:\\xray-images\\test\\test.csv");
        pGameLauncher.start();
    }

}
