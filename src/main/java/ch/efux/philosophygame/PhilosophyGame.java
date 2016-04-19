package ch.efux.philosophygame;

/**
 * Created by efux on 18.04.2016.
 */
public class PhilosophyGame {

    public static void main(String[] args) {


        String start = "/wiki/Tee";
        String end = "Philosophie";

        int n = 0;
        int maxN = 20;

        LinkFinder linkFinder = new LinkFinder(start, end);

        while(!linkFinder.getTitle().contains(end) && n < maxN) {
            // WebElement element = driver.findElement(By.id("mw-content-text"));
            linkFinder.next();
            n++;
        }

        linkFinder.close();
    }

}
