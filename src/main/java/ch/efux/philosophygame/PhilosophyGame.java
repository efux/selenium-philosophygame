package ch.efux.philosophygame;

/**
 * Created by efux on 18.04.2016.
 */
public class PhilosophyGame {

    public static void main(String[] args) {
        PhilosophyGame pGame = new PhilosophyGame();
        pGame.run("Tee", "Philosophie");
    }

    private int maxN = 20;

    public void setMaximalTries(int maxN) {
        this.maxN = maxN;
    }

    public int run(String start, String end) {
        String begin = "/wiki/" + start;

        int n = 0;

        LinkFinder linkFinder = new LinkFinder(begin, end);

        while(!linkFinder.getTitle().contains(end) && n < maxN) {
            linkFinder.next();
            n++;
        }

        linkFinder.close();

        return n;
    }

}
