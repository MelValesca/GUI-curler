package controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {

    public static String getSimple(String urlString, boolean withHeader, String addedHeaders) {
        String headers = "";
        String pageContent = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


            List<String> headersList = parseHeaders(addedHeaders);
            for (String header : headersList) {
                connection.addRequestProperty(header.split(":")[0], header.split(":")[1]);
            }

            if(withHeader) headers = getHeadersAsString(connection);

            pageContent = getPageContentAsString(connection);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headers + pageContent;
    }

    public static String getPageContentAsString(HttpURLConnection connection) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static String getHeadersAsString(HttpURLConnection connection) {
        StringBuilder headersBuilder = new StringBuilder();
        headersBuilder.append("Response Headers:\n");
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            headersBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return headersBuilder.toString();
    }

    public static List<String> parseHeaders(String addedHeaders) {
        List<String> headersList = new ArrayList<>();
        if (addedHeaders != null && !addedHeaders.isEmpty()) {
            String[] headersArray = addedHeaders.split("\n");
            headersList.addAll(Arrays.asList(headersArray));
        }
        return headersList;
    }

    public static void checkURLs(String url, String filePath, JTextArea textArea) throws IOException {
        filePath = "src/main/resources/filenames.txt";
        String absolutePath = Paths.get("").toAbsolutePath() + "/" + filePath;
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
            List<String> linesToCheck = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                linesToCheck.add(line);
            }

            AtomicInteger completedTasks = new AtomicInteger(0);
            long startTime = System.currentTimeMillis();
            ExecutorService executor = Executors.newFixedThreadPool(60);
            for (String lineToCheck : linesToCheck) {
                executor.submit(() -> {
                    try {
                        String targetUrl = url + "/" + lineToCheck;
                        HttpURLConnection connection = (HttpURLConnection) new URL(targetUrl).openConnection();
                        connection.setRequestMethod("GET");
                        int responseCode = connection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            SwingUtilities.invokeLater(() -> textArea.append(lineToCheck + "\n"));
                        }
                        connection.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        int count = completedTasks.incrementAndGet();
                        if (count == linesToCheck.size()) {
                            SwingUtilities.invokeLater(() -> textArea.append("\nDone! in " +
                                    ((System.currentTimeMillis() - startTime) /1000.0f)
                                    + "s\n"));
                        }
                    }
                });
            }
            executor.shutdown();
        }

    }

}
