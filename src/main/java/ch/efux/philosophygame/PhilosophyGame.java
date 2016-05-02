package ch.efux.philosophygame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by efux on 18.04.2016.
 */
public class PhilosophyGame {

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
