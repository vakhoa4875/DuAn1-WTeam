/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleBooksPreviewViewerabc extends JFrame {

    private JEditorPane editorPane;

    public GoogleBooksPreviewViewerabc(String previewLink) {
        super("Google Books Preview Viewer");

        // Create a JEditorPane to display HTML content
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);

        // Load the preview link
        try {
            editorPane.setPage(previewLink);
        } catch (IOException e) {
            e.printStackTrace();
            editorPane.setText("Error loading preview link.");
        }

        // Add the JEditorPane to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(editorPane);

        // Set up the layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        // Set up the JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Replace "YOUR_PREVIEW_LINK" with the actual preview link obtained from the Google Books API
        String previewLink = "http://books.google.com.vn/books?id=e3tuAAAAMAAJ&printsec=frontcover&dq=java&hl=&as_brr=7&cd=1&source=gbs_api";

        SwingUtilities.invokeLater(() -> new GoogleBooksPreviewViewer(previewLink));
    }
}

