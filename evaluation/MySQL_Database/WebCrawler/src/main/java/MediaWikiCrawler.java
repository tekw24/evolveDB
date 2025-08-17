import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MediaWikiCrawler {

    private static final String START_URL = "http://localhost/mediawiki40/index.php/StudiumPlus";
    private static final String OUTPUT_FILE = "/home/torben/IdeaProjects/WebCrawler/src/main/java/results40.csv";

    private ArrayList<String> visited = new ArrayList<>();

    public static void main(String[] args) {
        MediaWikiCrawler crawler = new MediaWikiCrawler();
        crawler.crawl(START_URL);
    }

    private void crawl(String url) {

        try {
            if(visited.contains(url) || url.contains("?"))
                return;
            visited.add(url);

            URL baseUrl = new URL(START_URL);
            URL currentUrl = new URL(url);

            // Ignore URLs from hosts other than the target host
            if (!currentUrl.getHost().equals(baseUrl.getHost())) {
                return;
            }
            System.out.println("Now Crawling: " + url );

            Document document = Jsoup.connect(url).get();
            HttpConnection connection = (HttpConnection) Jsoup.connect(url);
            connection.execute();
            int statusCode = connection.response().statusCode();

            writeResultToCSV(url, statusCode);

            //Version lower then 37
            //Elements links = document.select("div#bodyContent a[href]");
            //Version > 37
            Elements links = document.select("div#mw-content-text a[href]");
            for (Element link : links) {
                if (!link.hasClass("new")) {
                    String nextUrl = link.absUrl("href");
                    crawl(nextUrl);
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing URL: " + url);
            writeResultToCSV(url, 404);
            e.printStackTrace();
        }
    }

    private static void writeResultToCSV(String url, int statusCode) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE, true)) {
            String status = (statusCode == 200) ? "Accessible" : "Not Accessible";
            writer.append(url).append(',').append(String.valueOf(statusCode)).append(',').append(status).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}