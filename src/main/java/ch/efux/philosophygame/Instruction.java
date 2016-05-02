package ch.efux.philosophygame;

/**
 * Created by efux on 02.05.2016.
 */
public class Instruction {

    private String start;
    private String end;
    private int numberAccessesNeeded = 0;

    public Instruction(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getNumberAccessesNeeded() {
        return numberAccessesNeeded;
    }

    public void setNumberAccessesNeeded(int numberAccessesNeeded) {
        this.numberAccessesNeeded = numberAccessesNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (!start.equals(that.start)) return false;
        return end.equals(that.end);

    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return start + ";" + end + ";" + numberAccessesNeeded;
    }
}
