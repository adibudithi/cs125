import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("number of words:" + wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println("instances of 'Hamlet':" + specificWordCount("hamlet",urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    public static int specificWordCount(String term, String text) {
        int count = 0;
        String[] words = text.split(" ");
        for (String word: words) {
            if (word.toLowerCase().equals(term.toLowerCase())) {
                count += 1;
            }
        }
        return count;
    }
}
