/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OpenLibraryApiExample {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        // Replace "SEARCH_QUERY" with the query you want to search for
        String searchQuery = "The Great Gatsby";

        // Build the URL for the Open Library Search API
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("openlibrary.org")
                .addPathSegment("search.json")
                .addQueryParameter("q", searchQuery)
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
                OpenLibrarySearchResult searchResult = gson.fromJson(response.body().string(), OpenLibrarySearchResult.class);

                // Print information about the first result (if available)
                if (searchResult != null && searchResult.docs != null && searchResult.docs.length > 0) {
                    OpenLibraryBook book = searchResult.docs[0];
                    System.out.println("Title: " + book.title);
                    System.out.println("Author(s): " + String.join(", ", book.author_name));
                    System.out.println("First Published: " + book.first_publish_year);
                    System.out.println("Number of Pages: " + book.number_of_pages);
                } else {
                    System.out.println("No results found.");
                }
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define classes to represent the structure of the JSON response
    static class OpenLibrarySearchResult {
        OpenLibraryBook[] docs;
    }

    static class OpenLibraryBook {
        String title;
        String[] author_name;
        int first_publish_year;
        int number_of_pages;
    }
}

