package testAPI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.awt.Desktop;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URI;

public class GoogleBooksApiExample02 {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        // Replace "YOUR_API_KEY" with your actual Google Books API key
        String apiKey = "AIzaSyDPDe8uFH3M3Sp8x-iW_s-D0o3dmqzMHQw";

        // Replace "SEARCH_QUERY" with your search query, for example, "free ebooks"
        String query = "java";

        String searchQuery = "free-ebooks";

        // Build the URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("www.googleapis.com")
                .addPathSegment("books")
                .addPathSegment("v1")
                .addPathSegment("volumes")
                .addQueryParameter("q", query)
                .addQueryParameter("filter", searchQuery)
                .addQueryParameter("key", apiKey)
                .build();

        // Create the request
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            // Execute the request
            Response response = client.newCall(request).execute();

            // Check if the request was successful (HTTP code 200)
            if (response.isSuccessful()) {
                // Parse the JSON response
                JsonObject jsonResponse = gson.fromJson(response.body().string(), JsonObject.class);

                // Extract information about the books
                JsonArray items = jsonResponse.getAsJsonArray("items");
                if (items != null && items.size() > 0) {
//                    for (int i = 0; i < items.size(); i++) {
                    JsonObject volumeInfo = items.get(0).getAsJsonObject().getAsJsonObject("volumeInfo");
                    String title = volumeInfo.get("title").getAsString();
                    String previewLink = volumeInfo.get("previewLink").toString();
                    String authors = "";
                    if (volumeInfo.getAsJsonArray("authors") != null) {
                        authors = volumeInfo.getAsJsonArray("authors").toString();
                    }

                    System.out.println(items.toString());

                    System.out.println("Title: " + title);
                    System.out.println("Link pdf: " + previewLink);
                    System.out.println("Authors: " + authors);
                    System.out.println("------");
                        String urlToOpen = previewLink.substring(1, previewLink.length() - 2);
                        
//                        openURL(urlToOpen);
//                    }
                } else {
                    System.out.println("No books found.");
                }
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void openURL(String link) {
        try {
            // Replace "https://www.example.com" with the URL you want to open

            // Check if the Desktop API is supported on the current platform
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                // Create a URI object from the URL
                URI uri = new URI(link);

                // Open the default web browser to the specified URL
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop API is not supported on this platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
