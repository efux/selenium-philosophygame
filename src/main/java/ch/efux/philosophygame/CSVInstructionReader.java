package ch.efux.philosophygame;

import com.sun.javafx.collections.UnmodifiableListSet;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by efux on 02.05.2016.
 */
public class CSVInstructionReader implements InstructionReader {

    private String filePath;
    private final static String CSV_DELIMITER = ";";
    private Set<Instruction> instructionSet = new HashSet<>();

    public CSVInstructionReader(String filePath) {
        this.filePath = filePath;
    }

    private void load() {
        BufferedReader reader;
        String line;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] entries = line.split(this.CSV_DELIMITER);
                if(entries.length >= 2) {
                    Instruction instruction = new Instruction(entries[0], entries[1]);
                    instructionSet.add(instruction);
                }
            }

            reader.close();
        } catch(IOException exception) {
            System.err.println(exception);
        }
    }

    @Override
    public Set<Instruction> getInstructions() {
        load();
        return Collections.unmodifiableSet(instructionSet);
    }

    @Override
    public void submitNumberForInstruction(Instruction instruction, int run) {
        instruction.setNumberAccessesNeeded(run);
        instructionSet.remove(instruction);
        instructionSet.add(instruction);
    }

    protected void setInstructionSet(Set<Instruction> instructionSet) {
        this.instructionSet = instructionSet;
    }

    @Override
    public void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));

            for(Instruction instruction : instructionSet) {
                writer.write(instruction.toString());
                writer.newLine();
            }

            writer.close();
        } catch(IOException exception) {
            System.err.println(exception);
        }
    }

}
