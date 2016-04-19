package ch.efux.philosophygame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by efux on 18.04.2016.
 */
public class LinkFinder {

    private String position, end;
    private static String link = "http://de.wikipedia.org";
    private WebDriver driver;

    public LinkFinder(String start, String end) {
        this.position = start;
        this.end = end;
        driver = new FirefoxDriver();
    }

    public String next() {
        driver.get(link + position);
        WebElement pElement = driver.findElement(By.cssSelector("#mw-content-text > p"));
        position = findSuitableLink(pElement.getAttribute("innerHTML"));
        return position;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void close() {
        driver.close();
    }

    /**
     * Searches for a suitable link in the innerHTML.
     *
     * A link is suitable if the following criteria are met:
     * - the link is not in brackets
     * - the link is not cursive
     *
     * @param innerHTML html code as String
     * @return link to the next page to visit
     */
    private String findSuitableLink(String innerHTML) {
        String searchString = "<a href=\"";

        Pattern pattern = Pattern.compile("\"(.+?)\"");
        Matcher matcher;

        int countOfBrackets = 0;
        int countOfCursive = 0;
        while(innerHTML.length() > searchString.length()) {
            if(countOfBrackets == 0 && countOfCursive == 0 && innerHTML.startsWith(searchString)) {
                matcher = pattern.matcher(innerHTML);
                if (matcher.find()) {
                    return innerHTML.substring(matcher.start() + 1, matcher.end() - 1);
                }
            } else {
                if (innerHTML.startsWith("(")) {
                    countOfBrackets++;
                }
                if(innerHTML.startsWith("<i>")) {
                    countOfCursive++;
                }
                if (innerHTML.startsWith(")")) {
                    countOfBrackets--;
                }
                if(innerHTML.startsWith("</i>")) {
                    countOfCursive--;
                }
            }
            innerHTML = innerHTML.substring(1);
        }
        return "";
    }
}
